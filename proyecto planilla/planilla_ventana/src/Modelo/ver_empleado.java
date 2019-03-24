package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Valerio Pelicó
 */
public class ver_empleado extends Conexion {
     
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public boolean registrar(empleado emp){
        
        Connection con=getConexion();
        String sql="INSERT INTO empleado (dpi,nombre_empleado,sueldo_empleado,codigo_puesto1,codigo_departamento1) VALUES(?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, emp.getDpi());
            ps.setString(2, emp.getNombre_empleado());
            ps.setDouble(3, emp.getSueldo_empleado());
            ps.setInt(4, emp.getCodigo_puesto());
            ps.setInt(5, emp.getCodigo_departamento());
            ps.execute();
            return true;
            
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    
    public boolean modificar(empleado emp){
        
        Connection con=getConexion();
        String sql="UPDATE SET empleado nombre_empleado=?,sueldo_empleado=?,codigo_puesto1=?,codigo_departamento1=? WHERE dpi=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, emp.getNombre_empleado());
            ps.setDouble(2, emp.getSueldo_empleado());
            ps.setInt(3, emp.getCodigo_puesto());
            ps.setInt(4, emp.getCodigo_departamento());
            ps.setString(5, emp.getDpi());
            ps.execute();
            return true;
            
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    
    public boolean eliminar(empleado emp){
        
        Connection con=getConexion();
        String sql="DELETE SET FROM empleado WHERE dpi=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, emp.getDpi());
            ps.execute();
            return true;
            
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    
    public boolean buscar(empleado emp){
        
        Connection con=getConexion();
        String sql="SELECT * FROM empleado WHERE dpi=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, emp.getDpi());
            rs= ps.executeQuery();
            
            if(rs.next()){
                emp.setNombre_empleado(rs.getString("nombre_empleado"));
                emp.setSueldo_empleado(rs.getFloat("sueldo_empleado"));
                emp.setCodigo_puesto( rs.getInt("codigo_puesto"));
                emp.setCodigo_departamento( rs.getInt("codigo_departamento"));
                return true;
            }
            
            return false;
            
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    
}
