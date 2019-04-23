package com.inventario.model.service;

import com.inventario.entities.Marca;
import com.inventario.entities.Cliente;
import com.inventario.entities.Movimientos;
import com.inventario.entities.Repuesto;
import com.inventario.entities.TipoMovimientos;
import java.util.List;
import com.inventario.model.dao.MarcaDao;
import com.inventario.model.dao.ClienteDao;
import com.inventario.model.dao.MovimientosDao;
import com.inventario.model.dao.RepuestoDao;
import com.inventario.model.dao.TipoMovimientosDao;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service("autosService")
@Transactional
public class AutosServiceImpl implements AutosService, Serializable{
    
    private static final long serialVersionUID = 1L;

   @Autowired
    private MarcaDao brandDao;
   
   @Autowired
    private RepuestoDao partDao;
   
    @Autowired
    private MovimientosDao moveDao;
   
    @Autowired
    private ClienteDao clientDao;
    
    @Autowired
    private TipoMovimientosDao typemoveDao;
    
    
    public MarcaDao getBrandDao() {
        return brandDao;
    }

    public void setBrandDao(MarcaDao brandDao) {
        this.brandDao = brandDao;
    }

    public RepuestoDao getPartDao() {
        return partDao;
    }

    public void setPartDao(RepuestoDao partDao) {
        this.partDao = partDao;
    }

    public MovimientosDao getMoveDao() {
        return moveDao;
    }

    public void setMoveDao(MovimientosDao moveDao) {
        this.moveDao = moveDao;
    }

    public ClienteDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClienteDao clientDao) {
        this.clientDao = clientDao;
    }

    public TipoMovimientosDao getTypemoveDao() {
        return typemoveDao;
    }

    public void setTypemoveDao(TipoMovimientosDao typemoveDao) {
        this.typemoveDao = typemoveDao;
    }
    
    
    
    
    
    
    
    
    
    //brands
    @Override
    public List<Marca> listBrand(){
    
        return brandDao.listBrand();
    }
    
    @Override
    public void createBrand(Marca b){
    
        brandDao.createBrand(b);
    }
    
    @Override
    public void deleteBrand(Marca b){
    
        brandDao.deleteBrand(b);
    }
    
    
    //Parts
    @Override
    public List<Repuesto> listPart(){
    
        return partDao.listPart();
    }
    
    @Override
    public void createPart(Repuesto p){
    
        partDao.createPart(p);
    }
    
    @Override
    public void deletePart(Repuesto p){
    
        partDao.deletePart(p);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Repuesto> listByBrand(int id_brand){
    
        return partDao.listByBrand(id_brand);
    }
    
        //Moves
    
    @Override
    @Transactional(readOnly = true)
    public List<Movimientos> listMove(){
    
        return moveDao.listMove();
    }
    
    @Override
    public void createMove(Movimientos m){
    
        moveDao.createMove(m);
    }
    
    @Override
    public void deleteMove(Movimientos m){
    
        moveDao.deleteMove(m);
    }
    
    //Clients
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listClient(){
    
        return clientDao.listClient() ;
    }
    
    
    //TypeMoves
    
    @Override
    @Transactional(readOnly = true)
    public List<TipoMovimientos> listTypeMove(){
    
        return typemoveDao.listTypeMove() ;
    }
    
    


}

