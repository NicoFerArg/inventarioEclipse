package com.inventario.model.service;

import com.inventario.entities.Marca;
import com.inventario.entities.Cliente;
import com.inventario.entities.Movimientos;
import com.inventario.entities.Repuesto;
import com.inventario.entities.TipoMovimientos;
import java.util.List;

public interface AutosService {
  
    //Brands
    public void createBrand(Marca b);
    public void deleteBrand(Marca b);
    public List<Marca> listBrand();
    
   //Parts
    public void createPart(Repuesto p);
    public void deletePart(Repuesto p);
    public List<Repuesto> listPart();
    public List<Repuesto> listByBrand(int id_brand);
    
    //Moves
    public void createMove(Movimientos m);
    public void deleteMove(Movimientos m);
    public List<Movimientos> listMove();
    
    //Clients
    
    public List<Cliente> listClient();
    
    //TypeMoves
    
    public List<TipoMovimientos> listTypeMove();
    
    
}