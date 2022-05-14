 
package edu.sena.controlador.gpr;

import com.csvreader.CsvReader;
import edu.sena.entity.gpr.CondicionEquipo;
import edu.sena.entity.gpr.Equipos;
import edu.sena.entity.gpr.EstadoEquipo;
import edu.sena.entity.gpr.Inventario;
import edu.sena.entity.gpr.Marca;
import edu.sena.entity.gpr.Tipopc;
import edu.sena.facade.gpr.CondicionEquipoFacadeLocal;
import edu.sena.facade.gpr.EquiposFacadeLocal;
import edu.sena.facade.gpr.EstadoEquipoFacadeLocal;
import edu.sena.facade.gpr.InventarioFacadeLocal;
import edu.sena.facade.gpr.MarcaFacadeLocal;
import edu.sena.facade.gpr.TipopcFacadeLocal;
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
    
    private CondicionEquipoFacadeLocal EJBtbl_condicion_equipo;
    private CondicionEquipoFacadeLocal condicionequi;
    private List<CondicionEquipo> listaCondicion;
    
    private MarcaFacadeLocal EJBtbl_marca;
    private Marca marca;
    private List<Marca> listaMarca;
    
    
    private EstadoEquipoFacadeLocal EJBtbl_estado_equipo;
    private EstadoEquipoFacadeLocal estadoequi;
    private List<EstadoEquipo> listaEstado;
    
    private TipopcFacadeLocal EJBtbltipopc;
    private Tipopc tipo;
    private List<Tipopc> listaTipo;
    
    
    private InventarioFacadeLocal EJBtbl_inventario;
    private Inventario inventario;
    private List<Inventario> listaInventario;
    
    private EquiposFacadeLocal EJBtbl_equipos;
    private Equipos equipos;
    private List<Equipos> listaEquipos;
    
    
    private UploadedFile file;
    
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
                    condicionequi = (CondicionEquipoFacadeLocal) new CondicionEquipo();
                    tipo = new Tipopc();
                    marca = new Marca();
                    estadoequi= (EstadoEquipoFacadeLocal) new EstadoEquipo();
                    equipos = new Equipos();
                    stringFecha = leerArchivos.get(2);
                    
                    Date convertido = fecha.parse(stringFecha);
                    inventario.setIdInventario(Integer.parseInt(leerArchivos.get(0)));
                    equipos.setIdEquipo(Integer.parseInt(leerArchivos.get(1)));
                    equipos.getSerial(leerArchivos.get(2));
                    equipos.getModelo(leerArchivos.get(3));
                    equipos.getSistemaOperativo(leerArchivos.get(4));
                    equipos.getSistemaOperativo(leerArchivos.get(5));
                    equipos.getMicrossoftOffice(leerArchivos.get(6));
                    equipos.getProcesador(leerArchivos.get(7));
                    equipos.getMemoriaRam(leerArchivos.get(8));
                    equipos.getCapacidadDiscoDuro(leerArchivos.get(9));
                    equipos.getComentarios(leerArchivos.get(10));
                    inventario.setFechaIngreso(convertido);
                    
                    //se allaman los metodos para agregar
                    EJBtbl_inventario.create(inventario);
                    EJBtbl_estado_equipo.create((EstadoEquipo) estadoequi);
                    EJBtbl_condicion_equipo.create((CondicionEquipo)condicionequi);
                    EJBtbl_marca.create((Marca)marca);
                    EJBtbltipopc.create((Tipopc)tipo);
                    EJBtbl_inventario.create(inventario);
                    
                }
                this.mensaje = "Cargado con Exito";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public CondicionEquipoFacadeLocal getEJBtbl_condicion_equipo() {
        return EJBtbl_condicion_equipo;
    }

    public void setEJBtbl_condicion_equipo(CondicionEquipoFacadeLocal EJBtbl_condicion_equipo) {
        this.EJBtbl_condicion_equipo = EJBtbl_condicion_equipo;
    }

    public MarcaFacadeLocal getEJBtbl_marca() {
        return EJBtbl_marca;
    }

    public void setEJBtbl_marca(MarcaFacadeLocal EJBtbl_marca) {
        this.EJBtbl_marca = EJBtbl_marca;
    }

    public TipopcFacadeLocal getEJBtbltipopc() {
        return EJBtbltipopc;
    }

    public void setEJBtbltipopc(TipopcFacadeLocal EJBtbltipopc) {
        this.EJBtbltipopc = EJBtbltipopc;
    }

    public CondicionEquipoFacadeLocal getCondicionequi() {
        return condicionequi;
    }

    public void setCondicionequi(CondicionEquipoFacadeLocal condicionequi) {
        this.condicionequi = condicionequi;
    }

    public List<CondicionEquipo> getListaCondicion() {
        return listaCondicion;
    }

    public void setListaCondicion(List<CondicionEquipo> listaCondicion) {
        this.listaCondicion = listaCondicion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public Tipopc getTipo() {
        return tipo;
    }

    public void setTipo(Tipopc tipo) {
        this.tipo = tipo;
    }

    public List<Tipopc> getListaTipo() {
        return listaTipo;
    }

    public void setListaTipo(List<Tipopc> listaTipo) {
        this.listaTipo = listaTipo;
    }
    
    
}
