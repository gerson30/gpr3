package edu.sena.controlador.gpr;


import edu.sena.entity.gpr.Producto;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.PieChartModel;


@ManagedBean
@RequestScoped
public class ProductoGrafica implements Serializable {
    
     private PieChartModel pieModel;

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

   

    public void listar() throws SQLException, ClassNotFoundException {
        edu.sena.facade.gpr.ProductoGrafica dao;
        List<Producto> lista;
        
        try {
        dao = new edu.sena.facade.gpr.ProductoGrafica();
        lista = dao.listar();
        graficar(lista);

        } catch (Exception e) {

        } finally {

        }

    }
    
    private void graficar(List<Producto> lista) {
     pieModel = new PieChartModel();
        
        for (Producto pro : lista) {
            pieModel.set(pro.getNombre(), pro.getPrecio());
        }
            pieModel.setLegendPosition("e");
            pieModel.setFill(false);
            pieModel.setShowDataLabels(true);
            pieModel.setDiameter(400);
        }
    }
    

