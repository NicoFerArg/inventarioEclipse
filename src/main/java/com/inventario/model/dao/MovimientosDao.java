/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventario.model.dao;

import com.inventario.entities.Movimientos;
import java.util.List;

public interface MovimientosDao {
        
    public List<Movimientos> listMove();
    public void createMove(Movimientos m);
    public void deleteMove(Movimientos m);
    
}
