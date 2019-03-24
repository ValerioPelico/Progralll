
package Controlador;

import Modelo.empleado;
import Modelo.ver_empleado;
import Vista.frame_ingreso_usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Giancarlo
 */
public class cntrl_empleado implements ActionListener {
    
    private empleado emp;
    private ver_empleado veC;
    private frame_ingreso_usuario fiu;
    
    public cntrl_empleado(empleado emp,ver_empleado veC,frame_ingreso_usuario fiu){
        this.emp=emp;
        this.veC= veC;
        this.fiu= fiu;
        this.fiu.btn_guardar.addActionListener(this);
        this.fiu.btn_modificar.addActionListener(this);
        this.fiu.btn_eliminar.addActionListener(this);
        this.fiu.btn_buscar.addActionListener(this);
        this.fiu.btn_limpiar.addActionListener(this);
        
        
    }
    
    public void iniciar(){
        fiu.setTitle("ingreso de usuarios");
        fiu.setLocationRelativeTo(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==fiu.btn_guardar){
            emp.setDpi(fiu.txt_DPI.getText());
            emp.setNombre_empleado(fiu.txt_nombre_empleado.getText());
            emp.setSueldo_empleado((float) Double.parseDouble(fiu.txt_sueldo.getText()));
            emp.setCodigo_puesto( Integer.parseInt(fiu.cbx_puesto.getText()));
            emp.setCodigo_departamento(Integer.parseInt(fiu.cbx_departamento.getText()));
            
            if(veC.registrar(emp)){
                JOptionPane.showMessageDialog(null,"registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error al guardar");
                
            }
            
        }
        
        if(e.getSource()==fiu.btn_modificar){
            emp.setDpi(fiu.txt_DPI.getText());
            emp.setNombre_empleado(fiu.txt_nombre_empleado.getText());
            emp.setSueldo_empleado((float) Double.parseDouble(fiu.txt_sueldo.getText()));
            emp.setCodigo_puesto(Integer.parseInt(fiu.cbx_puesto.getText()));
            emp.setCodigo_departamento(Integer.parseInt(fiu.cbx_departamento.getText()));
            
            if(veC.modificar(emp)){
                JOptionPane.showMessageDialog(null,"registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error al modificar");
                
            }
            
        }
        
        if(e.getSource()==fiu.btn_eliminar){
            emp.setDpi(fiu.txt_DPI.getText());
            
            
            if(veC.eliminar(emp)){
                JOptionPane.showMessageDialog(null,"registro eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error al eliminar");
                
            }
            
        }
        
        if(e.getSource()==fiu.btn_buscar){
            emp.setDpi(fiu.txt_DPI.getText());
            
            
            if(veC.buscar(emp)){
                fiu.txt_DPI.setText(emp.getDpi());
                fiu.txt_nombre_empleado.setText(emp.getNombre_empleado());
                fiu.txt_sueldo.setText(String.valueOf(emp.getSueldo_empleado()));
                fiu.cbx_puesto.setText(String.valueOf(emp.getCodigo_puesto()));
                fiu.cbx_departamento.setText(String.valueOf(emp.getCodigo_departamento()));
              
            }else{
                JOptionPane.showMessageDialog(null, "no hay empleado registrado");
                
            }
            
        }
        
        if(e.getSource()==fiu.btn_limpiar){
            limpiar();
        }
        
    }
    
    public void limpiar(){
        fiu.cbx_departamento.setText(null);
        fiu.txt_nombre_empleado.setText(null);
        fiu.cbx_puesto.setText(null);
        fiu.txt_DPI.setText(null);
        fiu.txt_sueldo.setText(null);
        
    }
    
    
}
