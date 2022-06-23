package edu.sena.facade.gpr;

   

import edu.sena.entity.gpr.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoGrafica {

    public List<Producto> listar() throws SQLException{
        List<Producto> lista = null;
        Connection cn = null;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gpr?useSSL=false", "root", "1234$");
            
            PreparedStatement st = cn.prepareStatement("SELECT codigo, nombre, precio FROM producto");
            rs = st.executeQuery();
            lista = new ArrayList<>();
            
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                lista.add(pro);
            }
            rs.close();
        }catch(Exception e){

    }finally{
            if(cn != null){
            cn.close();
            }
                    
    }
    return lista;
    }
}
    

