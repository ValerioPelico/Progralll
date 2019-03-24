
package planilla_ventana;

import Controlador.cntrl_empleado;
import Modelo.empleado;
import Modelo.ver_empleado;
import Vista.frame_ingreso_usuario;

/**
 *
 * @author Valerio Pelicó
 * 
 *  todavia hace falta cambiar el diseño, agregar mas registros a las otras tablas y arreglar la funcion buscar y eliminar
 *  se hara dentro de unos dias
 * 
 */
public class Planilla_ventana {

    
    public static void main(String[] args) {

        empleado emp = new empleado();
        ver_empleado veC=new ver_empleado();
        frame_ingreso_usuario fiu=new frame_ingreso_usuario();
        
        cntrl_empleado ctrl=new cntrl_empleado(emp,veC,fiu);
        ctrl.iniciar();
        fiu.setVisible(true);
        
    }
    
}
