
package edu.sena.controlador.gpr;

import com.csvreader.CsvReader;
import edu.sena.entity.gpr.Equipos;
import edu.sena.entity.gpr.EstadoEquipo;
import edu.sena.entity.gpr.Inventario;
import edu.sena.facade.gpr.EquiposFacadeLocal;
import edu.sena.facade.gpr.EstadoEquipoFacadeLocal;
import edu.sena.facade.gpr.InventarioFacadeLocal;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.file.UploadedFile;

@Named
@ViewScoped
public class CsvJava implements Serializable {
    @EJB
    
    String mensaje = "";
    private EstadoEquipoFacadeLocal EJBtbl_estado_equipo;
    private InventarioFacadeLocal EJBtbl_inventario;
    
    private EstadoEquipo estadoequi;
    private List<EstadoEquipo> listaEstado;
    
    private Inventario inventario;
    private List<Inventario> listaInventario;
    
    private EquiposFacadeLocal EJBtbl_equipos;
    private Equipos equipos;
    private List<Equipos> listaEquipos;
    
    
    private UploadedFile file;

    public EstadoEquipo getEstadoequi() {
        return estadoequi;
    }

    public void setEstadoequi(EstadoEquipo estadoequi) {
        this.estadoequi = estadoequi;
    }

    public List<EstadoEquipo> getListaEstado() {
        return listaEstado;
    }

    public void setListaEstado(List<EstadoEquipo> listaEstado) {
        this.listaEstado = listaEstado;
    }
    
     public EstadoEquipoFacadeLocal getEJBtbl_estado_equipo() {
        return EJBtbl_estado_equipo;
    }

    public void setEJBtbl_estado_equipo(EstadoEquipoFacadeLocal EJBtbl_estado_equipo) {
        this.EJBtbl_estado_equipo = EJBtbl_estado_equipo;
    }

    public InventarioFacadeLocal getEJBtbl_inventario() {
        return EJBtbl_inventario;
    }

    public void setEJBtbl_inventario(InventarioFacadeLocal EJBtbl_inventario) {
        this.EJBtbl_inventario = EJBtbl_inventario;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    
    public List<Inventario> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<Inventario> listaInventario) {
        this.listaInventario = listaInventario;
    }
    
    
     public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    

    public EquiposFacadeLocal getEJBtbl_equipos() {
        return EJBtbl_equipos;
    }

    public void setEJBtbl_equipos(EquiposFacadeLocal EJBtbl_equipos) {
        this.EJBtbl_equipos = EJBtbl_equipos;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public List<Equipos> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipos> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    
   
    
    @PostConstruct
    public void construct(){
        Inventario inventario = new Inventario();
    }
    
    public void insertar(){
        try{
            String stringFecha =  "14-02-2022";
            DateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
            
            if(file.getSize() > 0){
                CsvReader leerArchivos;
                leerArchivos = new CsvReader (new InputStreamReader(file.getInputStream()));
                leerArchivos.readHeaders();
                
                while(leerArchivos.readRecord()){
                    inventario = new Inventario();
                    estadoequi = new EstadoEquipo();
                    equipos = new Equipos();
                    stringFecha = leerArchivos.get(2);
                    
                    Date convertido = fecha.parse(stringFecha);
                    inventario.setIdInventario(Integer.parseInt(leerArchivos.get(0)));
                    equipos.setIdEquipo(Integer.parseInt(leerArchivos.get(1)));
                    inventario.setFechaIngreso(convertido);
                    estadoequi.setIdEstadoEquipo(Integer.parseInt(leerArchivos.get(3)));
                    //se allaman los metodos para agregar
                    EJBtbl_inventario.create(inventario);
                    EJBtbl_estado_equipo.create(estadoequi);
                    EJBtbl_inventario.create(inventario);
                    
                }
                this.mensaje = "Cargado con Exito";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
