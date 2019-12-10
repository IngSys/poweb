package pe.org.pub.eess.poe.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pe.org.pub.eess.poe.domain.Personareferencia;
import pe.org.pub.eess.poe.service.PersonaReferenciaService;

@Controller
public class PersonaReferenciaController {

	 @Autowired
	 private PersonaReferenciaService peReferenciaService;

	// @Autowired
	// private PersonaReferenciaService personaReferenciaService;
	//// private Personareferencia personareferencia;
	//


	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {
//		Logger log = Logger.getLogger("===ENTRO AL COTROLADOR===" + getClass());

		// model.addAttribute("messageFormulario", "Hello formulario!");
		return "formulario";
	}

	@RequestMapping("/muestraFormulario2")
	public String muestraFormulario2() {

		// model.addAttribute("messageFormulario", "Hello formulario!");
		return "formulario2";
	}

	

	// @Autowired
	// private PersonaReferenciaService personaReferenciaService;
	//
	//
	// @GetMapping("/getPersonRef")
	// public List<Personareferencia> getPersonRef() {
	// return;
	// }

	// public void listPersonaReferencia() {
	// log.info("=======================LISTANDO===========================");
	//
	// List<Personareferencia> repuesta =
	// personaReferenciaService.listPersonaReferencia();
	// System.out.println(repuesta.get(1).getApeMaterno());
	//
	// log.info("========================LISTO==========================");
	// }

	// @RequestMapping("/index")
	// public String procesaFormulario() {
	// // model.addAttribute("messageFormulario2", "Hello formulario2!");
	// return "index";
	// }

	// private PersonaReferenciaService personaReferenciaService;
	// private Personareferencia personareferencia;
	// int id=3;

	// @RequestMapping("/empform")
	// public ModelAndView showform() {
	// return new ModelAndView("empform", "command", new Emp());
	// }
	//
	// @RequestMapping(value = "/save", method = RequestMethod.POST)
	// public ModelAndView save(@ModelAttribute("emp") Emp emp) {
	// dao.save(emp);
	// return new ModelAndView("redirect:/viewemp");
	// }
	//
	// @Controller
	// public class VentasController {
	//
	// @RequestMapping("/ventas")
	// public String porVendedor(
	// @RequestParam("nombre") String nombre,
	// @RequestParam("mes") Integer mes,
	// Model model) {
	//
	// model.addAttribute("vendedor", nombre);
	// model.addAttribute("ventas", "Listado de ventas para el mes: " + mes);
	//
	// return "ventas";
	// }
	// }

	// @RequestMapping("/buscarxid")
	// public ModelAndView buscarXId(Integer id) {
	// Logger.getLogger("===ENTRO AL COTROLADOR===" + getClass());
	// personareferencia = personaReferenciaService.getPersonaReferenciaById(id);
	// System.out.println("======entro al controlador=====" +
	// personareferencia.getDni());
	// return new ModelAndView("formulario", "buscarxid",
	// personareferencia.getApePaterno());
//	// }
	 @RequestMapping("/listPerson")
	 public ModelAndView listPerson() {
	 List<Personareferencia> list = peReferenciaService.listPersonaReferencia();
	 System.out.println(list.get(1).getApeMaterno());
	 return new ModelAndView("formulario", "list", list.get(1).getApeMaterno());
	 }
	
	// @RequestMapping(value = "/editemp/{id}")
	// public ModelAndView edit(@PathVariable int id) {
	// Emp emp = dao.getEmpById(id);
	// return new ModelAndView("empeditform", "command", emp);
	// }
	//
	// @RequestMapping(value = "/editsave", method = RequestMethod.POST)
	// public ModelAndView editsave(@ModelAttribute("emp") Emp emp) {
	// dao.update(emp);
	// return new ModelAndView("redirect:/viewemp");
	// }
	//
	// @RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
	// public ModelAndView delete(@PathVariable int id) {
	// dao.delete(id);
	// return new ModelAndView("redirect:/viewemp");
	// }

}
