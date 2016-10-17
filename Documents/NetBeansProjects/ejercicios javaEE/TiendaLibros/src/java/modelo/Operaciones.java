
package modelo;

import beans.Libro;
import beans.Tema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Operaciones {
    
    private Connection obtenerConexion(){
        Connection cn=null;
        try {
            //paso1 conexión con la base de datos
            //a: carga del driver
            Class.forName("com.mysql.jdbc.Driver");
            //b: establecer conexión con BD: jdbc:tipo://dir_ip:puerto/basedatos
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/tiendalibros", "root","sisisi123Talentum@");
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }
    
    private void cerrarConexion(Connection cn){
        try {
                //paso 4 cierre de la conexión
                if(cn!=null){
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    //Añade un tema
    public void addTema(String tema){
        Connection cn=null;
        try{
            cn=obtenerConexion();
            String sql="insert into temas(tema) ";
            sql+="values(?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,tema);            
            ps.execute();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            cerrarConexion(cn);
        }
    }
    //Mostar todos los temas
    public ArrayList<Tema> listarTemas(){
        ArrayList<Tema> temas=new ArrayList<>();
        Connection cn=null;        
        try{
           cn=obtenerConexion();
           String sql="select * from temas"; 
           Statement st=cn.createStatement();                    
           ResultSet rs=st.executeQuery(sql);
           while(rs.next()){
               Tema t=new Tema(rs.getInt("idtema"),rs.getString("tema"));
               temas.add(t);
           }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            cerrarConexion(cn);
        }
        return temas;
    }
        
    public void addLibro(String titulo,String autor,int tema,double precio){
        Connection cn=null;
        try{
            cn=obtenerConexion();
            String sql="insert into libros(titulo,autor,precio,tema) ";
            sql+="values(?,?,?,?);";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,titulo);
            ps.setString(2,autor);
            ps.setDouble(3,precio);
            ps.setInt(4,tema);
            ps.execute();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
                cerrarConexion(cn);
        }
    }
    //Si existe un cliente que tenga ese usuario y contraseña devuelve true 
    public boolean validar(String nombre,String clave){        
        boolean encontrados=false;
        Connection cn=null;        
        try{
           cn=obtenerConexion();
           String sql="select * from clientes where nombre='" +nombre +"' and password='" +clave +"';"; 
           Statement st=cn.createStatement();                    
           ResultSet rs=st.executeQuery(sql);
           while(rs.next()){
               encontrados=true;               
           }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            cerrarConexion(cn);
        }
        return encontrados;
    }
    //Muestra todos los libros 
    public ArrayList<Libro> buscarLibro(){
        ArrayList<Libro> buscados=new ArrayList<>();
        Connection cn=null;        
        try {
            cn=obtenerConexion();
            String sql="select * from libros";          
            PreparedStatement st=cn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Libro lib=new Libro(rs.getString("titulo"),
                        rs.getString("autor"), 
                        rs.getDouble("precio"), 
                        rs.getInt("tema"), rs.getInt("idlibro"));
                buscados.add(lib);
            }                        
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            cerrarConexion(cn);
        }       
        return buscados;
    }
    //Muestra los libros dependiendo del tema que eligajos en el jsp mostrarTema.jsp
    public ArrayList<Libro> buscarTema(String tema){
        ArrayList<Libro> buscados=new ArrayList<>();
        Connection cn=null;        
        try {
            cn=obtenerConexion();
            String sql="select * from libros where tema=? ";            
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, tema);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Libro lib=new Libro(rs.getString("titulo"),
                        rs.getString("autor"), 
                        rs.getDouble("precio"), 
                        rs.getInt("tema"),
                        rs.getInt("idlibro"));
                buscados.add(lib);
            }                        
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            cerrarConexion(cn);
        }       
        return buscados;
    }
    
    public Libro buscarId(String id){
        Libro lib=new Libro();
        
        Connection cn=null;        
        try {
            
            cn=obtenerConexion();
            String sql="select * from libros where idLibro=? ";            
            PreparedStatement st=cn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setPrecio(rs.getDouble("precio"));
                lib.setTema(rs.getInt("tema"));
                lib.setIdlibro(rs.getInt("idlibro"));
                
            }                        
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            cerrarConexion(cn);
        }       
        return lib;
    }
    
}
    
     