
package com.gestion.productos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.productos.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
