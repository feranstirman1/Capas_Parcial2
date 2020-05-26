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

import com.uca.capas.parcial2.domain.Categoria;
import com.uca.capas.parcial2.domain.Libro;
import com.uca.capas.parcial2.service.CategoriaService;
import com.uca.capas.parcial2.service.LibroService;


@Controller
public class MainController {

	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	LibroService libroService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("mensaje", new String(""));
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView ingresarCategoria() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria", new Categoria());
		mav.setViewName("ingresarCategoria");
		return mav;
	}
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView ingresarLibro() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("libro", new Libro());
		mav.addObject("categorias", categoriaService.findAll());
		mav.setViewName("ingresarLibro");
		return mav;
	}
	
	@RequestMapping("/guardarCategoria")
	public ModelAndView guardarCategoria(@Valid @ModelAttribute Categoria categoria,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("ingresarCategoria");
		}else {
			try {
				categoriaService.insert(categoria);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			mav.addObject("mensaje", new String("Categoria guardada con exito"));
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/guardarLibro")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.addObject("categorias", categoriaService.findAll());
			mav.setViewName("ingresarLibro");
		}else {
			libro.setFechaIngreso(new Date());
			libro.setCategoria(categoriaService.findOne(libro.getcCategoria()));
			try {
				libroService.insert(libro);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			mav.addObject("mensaje", new String("Libro guardado con exito"));
			mav.setViewName("index");
		}
		return mav;
	}
	
	@RequestMapping("/verLibros")
	public ModelAndView verLibros() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("libros", libroService.findAll());
		mav.setViewName("verLibros");
		return mav;
	}
	

}
