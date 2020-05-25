package com.uca.capas.parcial2.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.parcial2.domain.Contribuyente;
import com.uca.capas.parcial2.domain.Importancia;
import com.uca.capas.parcial2.service.ContribuyenteService;
import com.uca.capas.parcial2.service.ImportanciaService;

@Controller
public class MainController {

	@Autowired
	ContribuyenteService contribuyenteService;

	@Autowired
	ImportanciaService importanciaService;

	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		
		List<Importancia> importancias = importanciaService.findAll();
		mav.addObject("importancias", importancias);
		
		mav.addObject("contribuyente", new Contribuyente());
		
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/contribuyentes")
	public ModelAndView contribuyentes() {
		ModelAndView mav = new ModelAndView();
		
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteService.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("contribuyentes");
		return mav;
	}

	@RequestMapping("/guardar")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			System.out.println("tengo errores");
			List<Importancia> importancias = importanciaService.findAll();
			mav.addObject("importancias", importancias);
			mav.setViewName("index");
		}else {
			Date fechaIngreso = new Date();
			contribuyente.setFechaIngreso(fechaIngreso);
			contribuyente.setImportancia(importanciaService.findOne(contribuyente.getcImportancia()));
			try {
				contribuyenteService.insert(contribuyente);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("exito");
		}
		return mav;
	}

}
