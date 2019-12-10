/*package pe.org.pub.eess.poe;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import pe.org.pub.eess.poe.domain.Personareferencia;
import pe.org.pub.eess.poe.model.PersonaReferenciaModel;
import pe.org.pub.eess.poe.util.Utilitarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:pe/org/pub/eess/poe/resource/poe-core-tomcat.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class AbstractBaseUnitTest {

	Logger log = Logger.getLogger(getClass());
	@Autowired

	private PersonaReferenciaModel personaReferenciaModel;
	private Personareferencia pr;

	/*
	 * @Test public void savePersonaReferencia() {
	 * log.info("=======================GUARDANDO===========================");
	 * Personareferencia personareferencia = new Personareferencia();
	 * personareferencia.setIdpersonareferencia(115);
	 * personareferencia.setNombre("scanor");
	 * personareferencia.setApeMaterno("scanor");
	 * personareferencia.setApePaterno("scanor");
	 * personareferencia.setCodGenero("1");
	 * personareferencia.setCodtipParentesco("3");
	 * personareferencia.setDirReferencia("scanor");
	 * personareferencia.setTelefono("900111224");
	 * personareferencia.setDni("47200258");
	 * personareferencia.setFchresys(Utilitarios.castDate_UTIL_SQL(Utilitarios.
	 * getDateActuallSystem()));
	 * 
	 * this.personaReferenciaModel.savePersonaReferencia(personareferencia);
	 * log.info("========================GUARDO==========================");
	 * 
	 * }
	 */

	/*
	 * @Test public void updatePersonaReferencia() {
	 * log.info("=======================ACTUALIZANDO===========================");
	 * Personareferencia personareferencia = new Personareferencia();
	 * personareferencia.setIdpersonareferencia(115);
	 * personareferencia.setNombre("MIA"); personareferencia.setApeMaterno("MIA");
	 * personareferencia.setApePaterno("scanor");
	 * personareferencia.setCodGenero("1");
	 * personareferencia.setCodtipParentesco("3");
	 * personareferencia.setDirReferencia("scanor");
	 * personareferencia.setTelefono("900111224");
	 * personareferencia.setDni("47200258");
	 * personareferencia.setFchresys(Utilitarios.castDate_UTIL_SQL(Utilitarios.
	 * getDateActuallSystem()));
	 * 
	 * this.personaReferenciaModel.updatePersonaReferencia(personareferencia);
	 * log.info("========================ACTUALIZO==========================");
	 * 
	 * }
	 */

	/*@Test
	public void deletePersonReferencia() {
		log.info("=======================BORRANDO===========================");

		pr = personaReferenciaModel.getPersonaReferenciaById(113);
		log.info("================OBTENER PERSONA REF============="+pr);
		personaReferenciaModel.deletePersonaReferencia(pr);
		log.info("========================BORRO==========================");

	}
	@Test
	public void listPersonaReferencia() {
		log.info("=======================LISTANDO===========================");

		 List<Personareferencia> repuesta=personaReferenciaModel.listPersonaReferencia();
		System.out.println(repuesta.get(1).getApeMaterno());
		
		log.info("========================LISTO==========================");
	}

}*/
