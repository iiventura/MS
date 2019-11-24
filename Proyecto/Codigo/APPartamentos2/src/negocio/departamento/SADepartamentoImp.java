package negocio.departamento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.persistence.Query;


import negocio.empleado.Empleado;

public class SADepartamentoImp implements SADepartamento{

	@SuppressWarnings("unchecked")
	@Override
	public int altaDepartamento(TDepartamento d) {
		int res = -1;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr=null;
		Query q = null; 
		List<Departamento> departamentoAux = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			
			tr.begin();
			
			//cargamos la query con la consulta
			q = em.createNamedQuery("buscarDepartamentoPorNombre");
			q.setParameter("nombre", d.getNombre());
			departamentoAux= q.getResultList();
			
			//Departamento no existe
			if(departamentoAux.isEmpty()){
				Departamento dpto =new Departamento(d);
				em.persist(dpto);				
				tr.commit();

				res = dpto.getIdDepartamento();	
			}
			else{
				if(!departamentoAux.get(0).getActivo()){
					departamentoAux.get(0).setActivo(true);
					departamentoAux.get(0).setCategoria(d.getCategoria());			
					tr.commit();
					res = departamentoAux.get(0).getIdDepartamento();
					
				}else{
					tr.rollback();
					res = -2;
				}
			}		
		}
		catch (OptimisticLockException e) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		finally {
			if (emf != null && emf.isOpen())
				emf.close();
			if (em != null && em.isOpen())
				em.close();
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int bajaDepartamento(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		Departamento dep = null;
		Query q = null;
		Collection<Departamento> listaAux = new ArrayList<Departamento>();
		int res = -1;

		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			tr.begin();

			dep = em.find(Departamento.class, id);

			if (dep != null) {
				if (dep.getActivo()) {
					boolean hayEmpleadosActivos = false;
					//Tenemos que comprobar que no haya ningún empleado dado de alta en el departamento o no podremos darlo de baja
					
					for (Empleado elem : dep.getEmpleados()) {
						if(elem.getActivo()){
							hayEmpleadosActivos = true;
						}
					}
					
					//Si existe al menos un empleado activo
					if(hayEmpleadosActivos){
						tr.rollback();
						res = -4; // Existen empleados en el departamento
					}
					else{
						q = em.createNamedQuery("buscarDepartamentoModeloOrdenadorPorIdDepartamento");
						q.setParameter("idDepartamento", dep);
						listaAux = q.getResultList();
						Iterator it = listaAux.iterator();
						if(!it.hasNext()) {
							dep.setActivo(false);
							res = dep.getIdDepartamento();
							tr.commit();
						}
						else {
							tr.rollback();
							res = -5; // El departamento tiene ordenadores
						}
					}
				} else {
					tr.rollback();
					res = -3; // El departamento ya esta dado de baja
				}
			} else {
				tr.rollback();
				res = -2; // No existe el departamento
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
		
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int modificarDepartamento(TDepartamento d) {
		int res = -1;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr;
		List<Departamento> listaDepartamento = null;
		Query q; 
		
		try{
			
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			tr.begin();
			
			q = em.createNamedQuery("buscarDepartamentoPorNombre");
			q.setParameter("nombre", d.getNombre());
			
			listaDepartamento = q.getResultList();
			
			if(!listaDepartamento.isEmpty()){
				if(listaDepartamento.get(0).isActivo()){
					listaDepartamento.get(0).setCategoria(d.getCategoria());
					res = listaDepartamento.get(0).getIdDepartamento();
					tr.commit();
				}else{
					tr.rollback();
					res = -3; // El departamento introducido esta dado de baja
				}
			}
			else{
				tr.rollback();
				res = -2; // El departamento introducido no existe
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
		
		return res;
	}

	@Override
	public TDepartamento mostrarDepartamento(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr;
		Departamento d = null;
		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			
			tr.begin();
			
			d = em.find(Departamento.class, id, LockModeType.OPTIMISTIC);
			
			if(d != null)
				tr.commit();
			else
				tr.rollback();	
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
		
		if(d == null){
			return null;
		}
		return d.ToTransfer();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<TDepartamento> listaDepartamento() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr;
		List<Departamento> lista = null;
		List<TDepartamento> tlista = new ArrayList<TDepartamento>();
		Query q;
		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			
			tr.begin();
			
			q = em.createNamedQuery("listarDepartamentos", Departamento.class);
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
			if(em != null && em.isOpen())
				em.close();
			if(emf != null && emf.isOpen())
				emf.close();
		}
		
		for(Departamento d: lista) {
			if (d.getActivo())
				tlista.add(d.ToTransfer());
		}
		
		return tlista;
	}

	@Override
	public TDepartamento sueldoTotalDepartamento(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr;
		Departamento dpto=null;
		double total=0;
		Collection<Empleado> empleados=new ArrayList<Empleado>();
		TDepartamento tdpto=null;
		
		try{
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();	
			tr.begin();
			
			dpto=em.find(Departamento.class, id, LockModeType.OPTIMISTIC);
			
			//Si existe y esta activo
			if(dpto!=null && dpto.getActivo()){
				empleados= dpto.getEmpleados();
				
				for(Empleado empleado: empleados){
					em.lock(empleado, LockModeType.OPTIMISTIC);
					if(empleado.getActivo()){
						total+= empleado.totalSueldo();
					}
				}
				
				tdpto=dpto.ToTransfer();
				tdpto.setTotalSueldos(total);
				
				tr.commit();				
			}else{
				tr.rollback();
			}
		}
		catch (OptimisticLockException e) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		}
		catch(Exception e){
			System.out.println(e);	
		}finally{
			if (emf != null && emf.isOpen())
				emf.close();
			if (em != null && em.isOpen())
				em.close();			
		}
		
		return tdpto;
	}
}
