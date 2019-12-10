package pe.org.pub.eess.poe.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import pe.org.pub.eess.poe.domain.Personareferencia;
import pe.org.pub.eess.poe.model.PersonaReferenciaModel;

@Repository

public class PersonaReferenciaModelImpl implements PersonaReferenciaModel {

	Logger log = Logger.getLogger(getClass());
	@PersistenceContext(unitName = "poeJpa")
	private EntityManager em;

	@Override
	public void savePersonaReferencia(Personareferencia personareferencia) {
		// TODO Auto-generated method stub
		try {

			this.em.persist(personareferencia);

		} catch (Exception e) {
			log.info("===============ERROR=AL=GUARDAR M SAVE===============" + e);

		}

	}

	@Override
	public void updatePersonaReferencia(Personareferencia personareferencia) {
		// TODO Auto-generated method stub

		try {
			this.em.merge(personareferencia);

		} catch (Exception e) {
			log.info("ERROR ALA CTUALIZAR CAPA DAO IMPLEMENTES");

		}

	}

	@Override
	public List<Personareferencia> listPersonaReferencia() {
	@SuppressWarnings("unchecked")
	
	List<Personareferencia> pf=(List<Personareferencia>) em.createQuery("FROM Personareferencia").getResultList();
		return pf;
	}

	@Override
	public Personareferencia getPersonaReferenciaById(Integer id) {
		Personareferencia personareferencia = null;
		try {
			personareferencia = this.em.find(Personareferencia.class, id);

		} catch (Exception e) {
			log.info("================ERROR AL BUSCAR PERSONA REFERENCIA POR ID================================");
		}

		return personareferencia;
	}

	@Override
	public void deletePersonaReferencia(Integer id) {
		// TODO Auto-generated method stub

		try {
			this.em.remove(id);
			em.getTransaction().commit();

		} catch (Exception e) {
			log.info("ERROR AL ELIMINAR CAPA DAO IMPLEMENTES");
			em.close();
		}

	}

	@Override
	public void deletePersonaReferencia(Personareferencia personareferencia) {

		try {
			this.em.remove(personareferencia);
			em.getTransaction().commit();

		} catch (Exception e) {
			log.info("ERROR AL ELIMINAR CAPA DAO IMPLEMENTES");
			em.close();
		}

	}

}
