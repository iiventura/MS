package negocio.empleado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.departamento.Departamento;

public class SAEmpleadoImp implements SAEmpleado {

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int altaEmpleado(TEmpleado e) {
		int id = 0;
		EntityManagerFactory emf;
		EntityManager em;
		EntityTransaction tr;
		Query q;
		Collection<Empleado> listaAux = new ArrayList<Empleado>();
		
		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();

			tr.begin();
			Departamento dep = em.find(Departamento.class,  e.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			
			if(dep != null){
				if(dep.getActivo()){
					Empleado empleado = null;
					
					if (e instanceof TDirector) {
						empleado = new Director((TDirector) e, dep);
					}
					else if (e instanceof TAgenteInmobiliario) {
						empleado = new AgenteInmobiliario((TAgenteInmobiliario) e, dep);
					}
					
					q = em.createNamedQuery("buscarEmpleadoPorDni");
					q.setParameter("dni", empleado.getDni());
					listaAux = q.getResultList();
					Iterator it = listaAux.iterator();
					
					if (!it.hasNext()){
						dep.anadirEmpleados(empleado);
						em.persist(empleado);
						tr.commit();
						id = empleado.getIdEmpleado();
					} else {
						Empleado empAux = (Empleado) it.next();
						
						if(empleado instanceof Director && empAux instanceof AgenteInmobiliario){
							tr.rollback();
							return -3; // Estamos cambiando el tipo del empleado de AI a Director
						}
						else if (empleado instanceof AgenteInmobiliario && empAux instanceof Director) {
							tr.rollback();
							return -4; // Estamos cambiando el tipo del empleado de Director a AI
						}
						
						if(!empAux.getActivo()){//en caso de estar inactivo se le pone a activo con los valores nuevos
							
							if(empAux.getDepartamento().getIdDepartamento() != dep.getIdDepartamento()){//El departamento introducido no es el antiguo
								
								//Eliminamos al empleado del departamento anterior
								Departamento depAnterior = empAux.getDepartamento();
								depAnterior.eliminaEmpleado(empAux);
								
								//Le añadimos a su nuevo departamento
								empAux.getDepartamento().anadirEmpleados(empAux);
							}

							//modificamos el empleado
							empAux.setNombre(empleado.getNombre());
							empAux.setDomicilio(empleado.getDomicilio());
							empAux.setDepartamento(empleado.getDepartamento());
							empAux.setSueldo(empleado.getSueldo());
							empAux.setActivo(true);
							
							if(empleado instanceof Director) {
								((Director) empAux).setPoliticaEmpresarial(((Director) empleado).getPoliticaEmpresarial());
								((Director) empAux).setComision(((Director) empleado).getComision());
							}
							else if(empleado instanceof AgenteInmobiliario) {
								((AgenteInmobiliario) empAux).setAñosExperiencia(((AgenteInmobiliario) empleado).getAñosExperiencia());
							}
							
							tr.commit();
							
							id = empAux.getIdEmpleado();
						}else{
							tr.rollback();
							return -2; // Ya existe el empleado y esta activo
						}
					}	
					}else{
						tr.rollback();
						return -5; // El departamento introducido no esta activo
				}
			}else{
				tr.rollback();
				return -1; // El departamento introducido no existe
			}
		}	catch (OptimisticLockException excp) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		}	catch (Exception excp) {
			System.out.println(excp);
		}

		return id;
	}

	@Override
	public int bajaEmpleado(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		Empleado empleado = null;

		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();

			tr.begin();

			empleado = em.find(Empleado.class, id);

			if (empleado != null) {
				if (empleado.getActivo()) {
					em.lock(empleado.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
					empleado.getDepartamento().eliminaEmpleado(empleado);

					empleado.setActivo(false);

					tr.commit();
				} else {
					tr.rollback();
					return -2; // El empleado ya esta dado de baja
				}

			} else {
				tr.rollback();
				return -1; // No existe el empleado
			}

		}
		
		catch (OptimisticLockException e) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		}
		
		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			if(emf != null && emf.isOpen()){
				emf.close();
			}
				
			if(em != null && em.isOpen()){
				em.close();
			}
				
		}
		return id;
	}

	@Override
	public int modificarEmpleado(TEmpleado e) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		Empleado empleado = null;
		Departamento departamento = null;
		int id = e.getIdEmpleado();
		
		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();

			tr.begin();

			empleado = em.find(Empleado.class, id);

			if (empleado != null) {
				if (empleado.getActivo()) {
										
					departamento = em.find(Departamento.class, e.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
					
					if(departamento != null) {
						if(departamento.getActivo()) {
							if(empleado.getDni() == e.getDni()) {
								id = empleado.getIdEmpleado();
							} else {
								id = -3; // Se está intentando cambiar el DNI, se cambiarán el resto de datos
							}
							if(e instanceof TDirector){
								if(empleado instanceof Director) {
									((Director) empleado).setPoliticaEmpresarial(((TDirector) e).getPoliticaEmpresarial());
									((Director) empleado).setComision(((TDirector) e).getComision());
								} else if (empleado instanceof AgenteInmobiliario) {
									return -6; // El empleado especificado es de tipo AI, no Director. No aceptamos ascensos
								}
							} else if (e instanceof TAgenteInmobiliario) {
								if(empleado instanceof AgenteInmobiliario) {
									((AgenteInmobiliario) empleado).setAñosExperiencia(((TAgenteInmobiliario) e).getAñosExperiencia());
								} else if (empleado instanceof Director) {
									return -7; // El empleado especificado es de tipo Director, no AI. No aceptamos descensos
								}
							}
							
							if(empleado.getDepartamento().getIdDepartamento() != departamento.getIdDepartamento()){//El departamento introducido no es el antiguo
								
								//Eliminamos al empleado del departamento anterior
								Departamento depAnterior = empleado.getDepartamento();
								depAnterior.eliminaEmpleado(empleado);
								
								//Le añadimos a su nuevo departamento
								empleado.getDepartamento().anadirEmpleados(empleado);
							}
							
							empleado.setDepartamento(departamento);
							empleado.setDomicilio(e.getDomicilio());
							empleado.setNombre(e.getNombre());
							empleado.setSueldo(e.getSueldo());
							tr.commit();
						} else {
							tr.rollback();
							return -5; // El departamento está dado de baja
						}
					} else {
						tr.rollback();
						return -4; // El departamento no existe
					}
					
				} else {
					tr.rollback();
					return -2; // El empleado ya esta dado de baja
				}

			} else {
				tr.rollback();
				return -1; // No existe el empleado
			}

		}
		
		catch (OptimisticLockException exception) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		}
		catch (Exception exception) {
			System.out.println(exception);
		}

		finally {
			if(emf != null && emf.isOpen()){
				emf.close();
			}
				
			if(em != null && em.isOpen()){
				em.close();
			}
				
		}
		return id;
	}

	@Override
	public TEmpleado mostrarEmpleado(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		Empleado empleado = null;


		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();

			tr.begin();

			empleado = em.find(Empleado.class, id, LockModeType.OPTIMISTIC);

			tr.commit();

		} 
		catch (OptimisticLockException e) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		}
		catch (Exception e) {
			System.out.println(e);
		}

		finally {
			if (emf != null && emf.isOpen())
				emf.close();
			if (em != null && em.isOpen())
				em.close();
		}

		if (empleado == null) {
			return null;
		} 
		else {
			if(empleado instanceof Director){
				return ((Director)empleado).toTransfer();
			}
			else{
				return ((AgenteInmobiliario)empleado).toTransfer();
			}
				
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<TEmpleado> listaEmpleados() {
		//https://stackoverflow.com/questions/7960149/cannot-instantiate-the-type-listproduct
		Collection<Empleado> lista = new ArrayList<Empleado>();
		Collection<TEmpleado> tLista = new ArrayList<TEmpleado>();
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		Query q;

		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			tr.begin();
			
			q = em.createNamedQuery("listarEmpleados");
			q.setLockMode(LockModeType.OPTIMISTIC);
			
			lista = q.getResultList();
			
			tr.commit();
			
		}
		catch (OptimisticLockException e) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
		finally {
			if (emf != null && emf.isOpen()){
				emf.close();
			}
				
			if (em != null && em.isOpen()){
				em.close();
			}	
		}
		
		for (Empleado elem : lista) {
			if(elem.getActivo()){
				tLista.add(elem.toTransfer());
			}
		}
		
		return tLista;
	}

}
