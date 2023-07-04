package com.gestion.productos.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.productos.modelo.Producto;
import com.gestion.productos.repositorio.ProductoRepository;

import antlr.collections.List;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repositorio;
	
	public java.util.List<Producto> listarProducto(){
		return repositorio.findAll();	
	}

	public void guardarProducto(Producto producto) {
		repositorio.save(producto);

}
	public Producto obtenerProductoPorId(Integer id) {
		return repositorio.findById(id).get();
		
	}
	public void eliminarProducto (Integer id) {
		 repositorio.deleteById(id);
	}
	
}
	
	
	
	

