package pe.org.pub.eess.poe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.org.pub.eess.poe.domain.Personareferencia;
import pe.org.pub.eess.poe.service.PersonaReferenciaService;
import pe.org.pub.eess.poe.model.PersonaReferenciaModel;

@Service
public class PersonaReferenciaServiceImpl implements PersonaReferenciaService {
	@Autowired
	PersonaReferenciaModel personaReferenciaModel;

	@Override
	public void savePersonaReferencia(Personareferencia personareferencia) {
		// TODO Auto-generated method stub
		personaReferenciaModel.savePersonaReferencia(personareferencia);

	}

	@Override
	public void updatePersonaReferencia(Personareferencia personareferencia) {
		// TODO Auto-generated method stub
		personaReferenciaModel.updatePersonaReferencia(personareferencia);

	}

	@Override
	public List<Personareferencia> listPersonaReferencia() {
		// TODO Auto-generated method stub
		return personaReferenciaModel.listPersonaReferencia();
	}

	@Override
	public Personareferencia getPersonaReferenciaById(Integer id) {
		// TODO Auto-generated method stub
		return personaReferenciaModel.getPersonaReferenciaById(id);
	}

	@Override
	public void deletePersonaReferencia(Personareferencia personareferencia) {
		// TODO Auto-generated method stub
		personaReferenciaModel.deletePersonaReferencia(personareferencia);
	}

}
