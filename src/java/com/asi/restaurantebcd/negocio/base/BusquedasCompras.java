/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asi.restaurantebcd.negocio.base;

import com.asi.restaurantbcd.modelo.Compra;
import com.asi.restaurantbcd.modelo.Proveedor;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Samael lopez
 */
@Stateless
public class BusquedasCompras implements BusquedasComprasLocal {

    @PersistenceContext(unitName = "RestaurantBDC-WebPU")
    private EntityManager em; 
    
    /**
     * Obtener el ultimovalor de la compra.
     * @param codsuc codigo de sucursal.
     * @param clase Clase que se quiere obtenerel correlativo.
     * @param identificador Identificados 
     * @param llave 
     * @return Integrt.
     * @throws Exception  Error gnerico.
     */
   
    @Override
    public Integer obtenerCorreltivoCompra(Integer codsuc, Class clase,
            String identificador, String llave) throws Exception {
        Integer valor;
        StringBuilder slq = new StringBuilder();
        slq.append("SELECT ").append("MAX(").append(llave).append(") FROM ");
        slq.append(clase.getSimpleName().toLowerCase());
        slq.append(" where 1 = 1 and ");
        if (identificador !=null) {
         slq.append(identificador);
         slq.append(" = ?1");
        }
        Query query = em.createNativeQuery(slq.toString());
         if (identificador !=null) {
              query.setParameter(1, codsuc);
         }
       
        valor = (Integer) query.getSingleResult();
        if (valor == null) {
            valor = Integer.parseInt("1");
        }
        valor   =  valor + 1;
        return valor;
    }
    
    
    /**
     * 
     * @param map
     * @return
     * @throws Exception 
     */
    public List <Compra> buscarCompras(Map map) throws Exception {
        if (map == null || map.isEmpty()){
            return null;
        }
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT a FROM Compra a ");
          jpql.append(" WHERE 1 = 1 ");
        if (map.containsKey("idcompra") && map.get("idcompra") != null) {
            jpql.append(" AND a.idcompra = :idcompra ");
        }
        if (map.containsKey("fechaInicial")
                && map.get("fechaInicial") != null
                && map.containsKey("fechaFinal")
                && map.get("fechaFinal") != null) {
            jpql.append(" AND o.fechacompra between :fechaInicial and :fechaFinal ");
        }
        Query query = em.createQuery(jpql.toString());
        if (map.containsKey("idcompra") && map.get("idcompra") != null) {
            query.setParameter("idcompra", Integer.parseInt(map.get("idcompra")
                    .toString().trim()));
        }
        if (map.containsKey("fechaInicial")
                && map.get("fechaInicial") != null
                && map.containsKey("fechaFinal")
                && map.get("fechaFinal") != null) {
            query.setParameter("fechaInicial", (Date) map.get("fechaInicial"));
            query.setParameter("fechaFinal", (Date) map.get("fechaFinal"));
        }
        return query.getResultList();
    }
}


