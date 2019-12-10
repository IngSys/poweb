package pe.org.pub.eess.poe.service;

import java.util.List;

import pe.org.pub.eess.poe.domain.Personareferencia;

public interface PersonaReferenciaService {
	public void savePersonaReferencia(Personareferencia personareferencia);

	public void updatePersonaReferencia(Personareferencia personareferencia);

	public List<Personareferencia> listPersonaReferencia();

	public Personareferencia getPersonaReferenciaById(Integer id);

	/* public void deletePersonaReferencia(Integer id); */

	public void deletePersonaReferencia(Personareferencia personareferencia);

}
