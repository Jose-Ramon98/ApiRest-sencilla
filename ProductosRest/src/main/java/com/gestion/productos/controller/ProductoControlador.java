package com.gestion.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gestion.productos.modelo.Producto;
import com.gestion.productos.servicio.ProductoService;

@RestController
public class ProductoControlador {
	
	@Autowired
	private ProductoService servicio;

	@GetMapping("/productos")
	public List<Producto> listarProducto(){
		return servicio.listarProducto();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto>  obtenerProducto(@PathVariable Integer id) {
		 
		try {
			Producto producto = servicio.obtenerProductoPorId(id);
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}catch (Exception exception){
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping("/productos")
	public void guardarProducto(@RequestBody Producto producto) {
		servicio.guardarProducto(producto);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
		try {
			Producto productoExistente = servicio.obtenerProductoPorId(id);
			
		
			servicio.guardarProducto(producto);
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}catch (Exception exception) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/producto/{id}")
		public void eliminarPRoducto(@PathVariable Integer id) {
			servicio.eliminarProducto(id);
		}
	}
	
	
	
	








