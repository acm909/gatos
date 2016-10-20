
package beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name="lista")
@SessionScoped

public class Lista {

     private ArrayList<Persona> listado = new ArrayList<>();     
    
    public ArrayList<Persona> getListado() {
        return listado;
    }
 
    public void setListado(ArrayList<Persona> listado) {
        this.listado = listado;
    }
      
    public Lista() {
    }
    
    public void agregar (Persona persona) {
    listado.add(persona);
    }
    
}
