package Controladores;

import bbdd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controladores {
    Conexion basedatos = new Conexion();
    Connection cn = basedatos.getConnection();
    ResultSet rs;
    PreparedStatement ps;
    
    
    
    
    //Metodos Registro Socios
    public void InsertarUsuario(String Nombre, String Apellido, String Telefono, String Email)
    {
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO socios (Nombre, Apellido, Telefono, Email) Values(?,?,?,?)");
            pps.setString(1, Nombre);
            pps.setString(2, Apellido);
            pps.setString(3, Telefono);
            pps.setString(4, Email);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo ha salido mal");
        }
    }
    
    //Metodos Actualizar Socios
    
    public void updateSocios(String Nombre, String Apellido, String Telefono, String Email, String Codigo){
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE socios SET Nombre=?, Apellido=?, Telefono=?, Email=? WHERE num_socio = ?");
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, Telefono);
            ps.setString(4, Email);
            ps.setString(5,Codigo);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null,"Cliente Actualizado");
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar cliente");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error");
        }
    }
    
    public String[] mostrarSocio(String Codigo){
        String[] jtext = new String[4];
        try 
        {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM socios WHERE  num_socio = ?");
            ps.setString(1, Codigo);
            
            rs = ps.executeQuery();
           
            if(rs.next()){
                jtext[0] = rs.getString("Nombre");
                jtext[1] = rs.getString("Apellido");
                jtext[2]= rs.getString("Telefono");
                jtext[3] = rs.getString("Email");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo ha salido mal");
        }
        return jtext;
    }
    
    //Metodos Listar Socios
    public void listarSocios(DefaultTableModel model){
        String sql ="SELECT * From socios";
        Statement st;
        String[]socios = new String[5];
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                socios[0] = rs.getString(1);
                socios[1] = rs.getString(2);
                socios[2] = rs.getString(3);
                socios[3] = rs.getString(4);
                socios[4] = rs.getString(5);
                model.addRow(socios); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar");
        }
    }
    public void eliminarSocioLista(String codigo){
        
        try {
            ps = cn.prepareStatement("DELETE FROM socios WHERE num_socio = ?");
            ps.setString(1, codigo);
            ps.execute();
        
            JOptionPane.showMessageDialog(null, "Socio eliminado"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    //Metodos Registro Peliculas 
    
    public void InsertarPelicula(String Titulo, String Director, String Genero, String año)
    {
        try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO peliculas (Titulo, Director, Genero, año, alquilada) Values(?,?,?,?,?)");
            pps.setString(1, Titulo);
            pps.setString(2, Director);
            pps.setString(3, Genero);
            pps.setString(4, año);
            pps.setString(5, "0");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo ha salido mal");
        }
    }
   
    //Metodos Actualizar Peliculas
    
    public void updatePeliculas(String Titulo, String Director, String Genero, String Año, String Codigo){
        try {
            PreparedStatement ps = cn.prepareStatement("UPDATE peliculas SET Titulo=?, Director=?, Genero=?, año=? WHERE Titulo = ?");
            ps.setString(1, Titulo);
            ps.setString(2, Director);
            ps.setString(3, Genero);
            ps.setString(4, Año);
            ps.setString(5, Codigo);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null,"Pelicula Actualizada");
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar pelicula");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error");
        }
    }
    
    public String[] mostrarPelicula(String Codigo){
        String[] jtext = new String[4];
        try 
        {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM peliculas WHERE  Titulo = ?");
            ps.setString(1, Codigo);
            
            rs = ps.executeQuery();
           
            if(rs.next()){
                jtext[0] = rs.getString("Titulo");
                jtext[1] = rs.getString("Director");
                jtext[2]= rs.getString("Genero");
                jtext[3] = rs.getString("año");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo ha salido mal");
        }
        return jtext;
    }
    
    
    //Metodos Listar Peliculas
    
     public void listarPeliculas(DefaultTableModel model){
        String sql = "SELECT * From peliculas";
        Statement st;
        
        String[]peliculas = new String[4];
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                peliculas[0] = rs.getString(1);
                peliculas[1] = rs.getString(2);
                peliculas[2] = rs.getString(3);
                peliculas[3] = rs.getString(4);
                model.addRow(peliculas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar");
        }
    }
     
    //Eliminar Pelicula
    public void eliminarPeliculaLista(String codigo){
        try { 
            ps = cn.prepareStatement("DELETE FROM peliculas WHERE Titulo = " + "'" + codigo + "'");
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Película eliminada"); 
        } catch (Exception e)
        {
            e.getMessage();
        }
    }
     
     
     
     
     ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Metodos Alquiler
     
    public void listarpeliculasParaAlquilar(DefaultTableModel model1){
        String sql = "SELECT * From peliculas";
        Statement st;
        String[]peliculas = new String[5];
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                peliculas[0] = rs.getString(1);
                peliculas[1] = rs.getString(2);
                peliculas[2] = rs.getString(3);
                peliculas[3] = rs.getString(4);
                peliculas[4] = rs.getString(5);
                model1.addRow(peliculas);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar");
        }
    }
    
    public String[] mostrarsocioAlquiler(String Codigo){
        String jtextSocioAlquiler[] = new String[3];
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM socios WHERE  num_socio = ?");
            ps.setString(1, Codigo);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                jtextSocioAlquiler[0] = rs.getString("num_socio");
                jtextSocioAlquiler[1] = rs.getString("Nombre");
                jtextSocioAlquiler[2] = rs.getString("Apellido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo ha salido mal");
        } 
        return jtextSocioAlquiler;
    }
    
    
   public void AlquilarPelicula(String Num_socio, String Titulo, String Director, String Genero, String numero, String condicion){
       if(condicion.equals("0"))
       {
           try {
                PreparedStatement pps = cn.prepareStatement("INSERT INTO alquiler (num_socio, Titulo, Director, Genero) Values(?,?,?,?)");
                pps.setString(1, Num_socio);
                pps.setString(2, Titulo);
                pps.setString(3, Director);
                pps.setString(4,Genero);
                pps.executeUpdate();

                PreparedStatement ps = cn.prepareStatement("UPDATE peliculas SET Titulo=?, Director=?, Genero=?, alquilada=? WHERE Titulo = ?");
                ps.setString(1, Titulo);
                ps.setString(2, Director);
                ps.setString(3, Genero);
                ps.setString(4, numero);
                ps.setString(5,Titulo);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Alquiler Realizado");  
            }   catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Algo ha salido mal");
            }
       }else
       {
           JOptionPane.showMessageDialog(null, "Esta Pelicula ya esta alquilada");
       }
            
    } 
   
    public void RefrescarAlquilerYPeliculas(DefaultTableModel model2 ,String codigo, DefaultTableModel model1)
    {
        String sql = "SELECT * From alquiler Where num_socio = '" + codigo + "';";
        Statement st;
        String[]socios = new String[4];
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                socios[0] = rs.getString(1);
                socios[1] = rs.getString(2);
                socios[2] = rs.getString(3);
                socios[3] = rs.getString(4);
                model2.addRow(socios);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar");
        }
        String sql2 = "SELECT * From peliculas";
        String[]peliculas = new String[5];
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql2);
            
            while(rs.next()){
                peliculas[0] = rs.getString(1);
                peliculas[1] = rs.getString(2);
                peliculas[2] = rs.getString(3);
                peliculas[3] = rs.getString(4);
                peliculas[4] = rs.getString(5);
                model1.addRow(peliculas);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar");
        }
    }
    
    public void ListarPeliculasAlquiladas(String codigo, DefaultTableModel model2){
        String sql = "SELECT * From alquiler Where num_socio = '" + codigo + "';";
        Statement st;
        
        String[]PeliculasAlquiladas = new String[4];
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                PeliculasAlquiladas[0] = rs.getString(1);
                PeliculasAlquiladas[1] = rs.getString(2);
                PeliculasAlquiladas[2] = rs.getString(3);
                PeliculasAlquiladas[3] = rs.getString(4);
                model2.addRow(PeliculasAlquiladas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar");
        }
    }
    
    public void devolver(String Titulo, String Director, String Genero, String numero)
    {
        try {
                PreparedStatement pps = cn.prepareStatement("DELETE FROM alquiler WHERE Titulo = ?");
                pps.setString(1, Titulo);
                pps.execute();

                PreparedStatement ps = cn.prepareStatement("UPDATE peliculas SET Titulo=?, Director=?, Genero=?, alquilada=? WHERE Titulo = ?");
                ps.setString(1, Titulo);
                ps.setString(2, Director);
                ps.setString(3, Genero);
                ps.setString(4, numero);
                ps.setString(5,Titulo);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Devolucion Realizada");  
        }   catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo ha salido mal");
        }
    }
}
