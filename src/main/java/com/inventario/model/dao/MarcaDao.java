/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.model.dao;

import com.inventario.entities.Marca;
import java.util.List;

public interface MarcaDao {
    
    public List<Marca> listBrand();
    public void createBrand(Marca b);
     public void deleteBrand(Marca b);
    
    
}
