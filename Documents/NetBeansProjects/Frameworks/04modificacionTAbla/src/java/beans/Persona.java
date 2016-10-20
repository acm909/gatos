package beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;


@ManagedBean (name="persona")
@RequestScoped

public class Persona {

    private String nombre;
    private String telefono;
    private String email;
    
    @ManagedProperty (value="#{lista}")
    private Lista listar;
    
       
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }
      
    public void setListar (Lista lista) {        
           this.listar = lista;  
        }
    
    public String guardar () {
    listar.agregar(this);  
    return null;
    }

    public void habilitar (ActionEvent ev) {
    UIComponent uic1 = ev.getComponent();
    UIComponent uic2 = uic1.findComponent("mt")  ;
    uic2.setRendered(true);
    }
    
}
