package negocio.modeloOrdenador;

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
import negocio.departamento.Departamento;

public class SAModeloOrdenadorImp implements SAModeloOrdenador {

	public int altaModeloOrdenador(TModeloOrdenador tModOrd) {
		int id = 0;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		Query q;
		List<ModeloOrdenador> listaAux;

		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			tr.begin();

			// cargamos la query con la consulta
			q = em.createNamedQuery("buscarModeloOrdenadorPorModelo");
			q.setParameter("mod", tModOrd.getModelo());
			listaAux = q.getResultList();

			if (listaAux.isEmpty()) {
				ModeloOrdenador modOrd = new ModeloOrdenador(tModOrd);
				em.persist(modOrd);
				tr.commit();

				return modOrd.getModeloOrdenadorId();
			} else {
				if (listaAux.get(0).getActivo()) {
					tr.rollback();
					return -2;
				} else {
					listaAux.get(0).setActivo(true);
					listaAux.get(0).setAntiguedad(tModOrd.getAntiguedad());
					tr.commit();
					return listaAux.get(0).getModeloOrdenadorId();
				}
			}

		} catch (OptimisticLockException excp) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		} catch (Exception excp) {
			System.out.println(excp);
		} finally {
			if (emf != null && emf.isOpen()) {
				emf.close();
			}

			if (em != null && em.isOpen()) {
				em.close();
			}
		}

		return id;
	}

	@Override
	public int bajaModeloOrdenador(int id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		Collection<DepartamentoModeloOrdenador> listaAux = new ArrayList<DepartamentoModeloOrdenador>();
		Query q = null;

		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			tr.begin();

			ModeloOrdenador modOrd = em.find(ModeloOrdenador.class, id);

			if (modOrd != null) {
				if (modOrd.getActivo()) {
					q = em.createNamedQuery("buscarDepartamentoModeloOrdenadorPorIdModeloOrdenador");
					q.setParameter("idModeloOrdenador", modOrd);
					listaAux = q.getResultList();
					Iterator it = listaAux.iterator();
					if(!it.hasNext()) {
						modOrd.setActivo(false);
						tr.commit();
						return id;
					} else {
						tr.rollback();
						return -3; // El ModeloOrdenador tiene departamentos asociados
					}
				} else {
					tr.rollback();
					return -2; // El ModeloOrdenador ya está dado de baja
				}
			} else {
				tr.rollback();
				return -1; // El ModeloOrdenador no existe
			}
		} catch (OptimisticLockException excp) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		} catch (Exception excp) {
			System.out.println(excp);
		} finally {
			if (emf != null && emf.isOpen()) {
				emf.close();
			}

			if (em != null && em.isOpen()) {
				em.close();
			}
		}

		return id;
	}

	@Override
	public int asignarDepartamentoModeloOrdenador(TDepartamentoModeloOrdenador datos) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		Query q;
		Collection<DepartamentoModeloOrdenador> listaAux = new ArrayList<DepartamentoModeloOrdenador>();

		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			tr.begin();

			ModeloOrdenador modOrd = em.find(ModeloOrdenador.class, datos.getModeloOrdenadorID(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			Departamento dep = em.find(Departamento.class, datos.getDepartamentoID(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);

			if (modOrd != null && dep != null) {
				if (modOrd.getActivo() == true && dep.getActivo() == true) {
					DepartamentoModeloOrdenador depModOrd = new DepartamentoModeloOrdenador(modOrd, dep, datos.getGarantia());
				
					q = em.createNamedQuery("buscarDepartamentoModeloOrdenadorPorId");
					q.setParameter("idDepartamento", depModOrd.getDepartamento());
					q.setParameter("idModeloOrdenador", depModOrd.getmodeloOrdenador());
					listaAux = q.getResultList();
					Iterator it = listaAux.iterator();
					

					if (!it.hasNext()) {
						dep.anadirDepartamentoModeloOrdenador(depModOrd);
						// Se lo añadimos al modeloOrdenador
						modOrd.añadeDepartamentoModeloOrdenador(depModOrd);

						em.persist(depModOrd);
						tr.commit();

						return datos.getGarantia();
					} else {
						tr.rollback();
						return -3;
					}

				} else {
					tr.rollback();
					return -1;
				}
			} else {
				tr.rollback();
				return -2;
			}

		} catch (OptimisticLockException excp) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		} catch (Exception excp) {
			System.out.println(excp);
		} finally {
			if (emf != null && emf.isOpen()) {
				emf.close();
			}

			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return 1;
	}

	@Override
	public int removerDepartamentoModeloOrdenador(TDepartamentoModeloOrdenador datos) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tr = null;
		int id = 0;
		Query q;
		Collection<DepartamentoModeloOrdenador> listaAux = new ArrayList<DepartamentoModeloOrdenador>();

		try {
			emf = Persistence.createEntityManagerFactory("APPartamentos");
			em = emf.createEntityManager();
			tr = em.getTransaction();
			tr.begin();

			ModeloOrdenador modOrd = em.find(ModeloOrdenador.class, datos.getModeloOrdenadorID(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			Departamento dep = em.find(Departamento.class, datos.getDepartamentoID(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);

			if (modOrd != null && dep != null) {
				if (modOrd.getActivo() && dep.getActivo()) {
					DepartamentoModeloOrdenador dmo = new DepartamentoModeloOrdenador(modOrd, dep, 0);

					q = em.createNamedQuery("buscarDepartamentoModeloOrdenadorPorId");
					q.setParameter("idDepartamento", dmo.getDepartamento());
					q.setParameter("idModeloOrdenador", dmo.getmodeloOrdenador());
					listaAux = q.getResultList();
					Iterator it = listaAux.iterator();

					if (it.hasNext()) {
						DepartamentoModeloOrdenador dmoaux = (DepartamentoModeloOrdenador) it.next();
						modOrd.eliminaDepartamentoModeloOrdenador(dmoaux);
						dep.eliminaModeloOrdenadorDepartamento(dmoaux);
						em.remove(dmoaux);
						tr.commit();
						id = 1; // Modelo ordenador removido del departamento
								// con exito
					} else {
						tr.rollback();
						id = -3;// El modelo ordenador no esta asociado a ese
								// departamento
					}

				} else {
					tr.rollback();
					id = -1;// El modelo ordenador o el departamento esta dado
							// de baja
				}
			} else {
				tr.rollback();
				id = -2; // No existe el modelo ordenador o el departamento
			}

		} catch (OptimisticLockException excp) {
			System.out.println("Error, otra hebra ha modificado la entidad");
		} catch (Exception excp) {
			System.out.println(excp);
		} finally {
			if (emf != null && emf.isOpen()) {
				emf.close();
			}

			if (em != null && em.isOpen()) {
				em.close();
			}
		}

		return id;
	}
}
