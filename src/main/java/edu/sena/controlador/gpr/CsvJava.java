
package edu.sena.controlador.gpr;

import com.csvreader.CsvReader;
import edu.sena.entity.gpr.Equipos;
import edu.sena.entity.gpr.Inventario;
import edu.sena.facade.gpr.EquiposFacadeLocal;
import edu.sena.facade.gpr.InventarioFacadeLocal;
import java.io.InputStreamReader;
import java.io.Serializable;
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
    private InventarioFacadeLocal EJBtbl_inventario;
    private Inventario inventario;
    private List<Inventario> listaInventario;
    
    private EquiposFacadeLocal EJBtbl_equipos;
    private Equipos equipos;
    private List<Equipos> listaEquipos;
    
    private UploadedFile file;

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
    
    

    
    @PostConstruct
    public void construct(){
        Inventario inventario = new Inventario();
    }
    
    public void insertar(){
        try{
            
            if(file.getSize() > 0){
                CsvReader leerArchivos;
                leerArchivos = new CsvReader (new InputStreamReader(file.getInputStream()));
                leerArchivos.readHeaders();
                while(leerArchivos.readRecord()){
                    inventario = new Inventario();
                    equipos = new Equipos();
                    equipos.setSerial(leerArchivos.get(0));
                    equipos.setComentarios(leerArchivos.get(1));
                    equipos.setMicrossoftOffice(leerArchivos.get(2));
                    equipos.setModelo(leerArchivos.get(3));
                    equipos.setProcesador(leerArchivos.get(4));
                    equipos.setMemoriaRam(leerArchivos.get(5));
                    equipos.setSistemaOperativo(leerArchivos.get(6));
                    
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
