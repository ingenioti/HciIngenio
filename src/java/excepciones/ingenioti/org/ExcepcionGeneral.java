/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excepciones.ingenioti.org;

/**
 *
 * @author Alexys
 */
public class ExcepcionGeneral extends RuntimeException{
    public ExcepcionGeneral(){
        this("Se ha generado una excepcion general.");
    }
    
    public ExcepcionGeneral(String msg){
        super(msg);
    }
}
