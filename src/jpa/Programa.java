package jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Date fechaNacimento = crearFechar(15, 1, 1970);
			Estudiante estudiante = new Estudiante(1, "Armando", fechaNacimento);
			em.persist(estudiante);
			// ************************************************************

			fechaNacimento = crearFechar(23, 6, 1971);
			estudiante = new Estudiante(2, "Laura", fechaNacimento);
			em.persist(estudiante);

			// ************************************************************

			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		//em.getTransaction().begin(); para consultas no són necesárias
		String qry = "SELECT e FROM Estudiante e";
		TypedQuery<Estudiante> res = em.createQuery(qry, Estudiante.class);
		List<Estudiante> lista = res.getResultList();
		lista.forEach(System.out::println);
		//em.getTransaction().commit();

		
		em.close();
		emf.close();

		System.out.println("Programa Finalizado");

	}

	private static Date crearFechar(int dia, int mes, int anyo) {
		Calendar cal = Calendar.getInstance();
		cal.set(anyo, mes - 1, dia);
		return cal.getTime();
	}

}
