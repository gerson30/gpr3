/*
En esta entoidad se crea la clase servertime donde se declara public string time, y se traen ls gett and setter
de igual forma el updatetime para que actualice el formato de la fecha en el formulario principal
 */
package edu.sena.controlador.gpr;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gerson Jimenez
 */
@ManagedBean
@RequestScoped

public class ServerTimeBean {


        public String time;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void updateTime() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.time = sdf.format(new Date());
        }

    }
