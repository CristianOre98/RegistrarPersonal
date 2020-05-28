
package modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona {
    private String dui;
    private String apellido;
    private String nombres;

    
    Connection cnn;
    Statement state;
    ResultSet result;
    
    public Persona() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_recurso_humano?zeroDateTimeBehavior=convertToNull [root on Default schema]","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertarDatos(){
        try {
            String miQuery = "insert into tb_persona values('" + dui + "', '" + apellido + "', '" + nombres + "');";
            int estado = 0;
            state = cnn.createStatement();
            estado = state.executeUpdate(miQuery);
            if(estado == 1){
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }     
    return false;
    }
    
    

    /**
     * @return the dui
     */
    public String getDui() {
        return dui;
    }

    /**
     * @param dui the dui to set
     */
    public void setDui(String dui) {
        this.dui = dui;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }
    
     /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
}

