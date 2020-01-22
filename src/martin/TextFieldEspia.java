package martin;

import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class TextFieldEspia extends TextField {

    private String ficheroLog = "src/ficheroPalabras.txt";
    FileWriter fichero = null;
    PrintWriter pw = null;
    private ArrayList<String> listaPalabras = new ArrayList<String>();
    private ArrayList<Accion> listaAccion = new ArrayList<Accion>();

    public TextFieldEspia() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            if (listaPalabras.size()>0) {
                for (int i=0; listaPalabras.size()>i; i++){
                    if (getText().equals(listaPalabras.get(i))) {
                        System.out.println("La palabra se encuentra en la lista, procedemos a guardarla en el fichero");
                        try {
                            fichero = new FileWriter(ficheroLog, true);
                            pw = new PrintWriter(fichero);
                            Date fecha = new Date();
                            pw.println(getText() + " " + fecha.toString());


                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("Error en la escritura del fichero");
                        } finally {
                            try {
                                if (fichero != null) {
                                    fichero.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                                System.out.println("Error al cerrar el fichero");
                            }
                        }
                        if(listaAccion!=null) {
                            for (int j = 0; j < listaAccion.size(); j++) {
                                listaAccion.get(j).ejecuta();
                            }
                        }
                    }
                }
            }
        });
    }

    public void escribirFichero(String palabra){
        //faltan la fecha y la hora
        LocalDateTime locaDate = LocalDateTime.now();
        int año = locaDate.getYear();
        int mes = locaDate.getMonthValue();
        int dia = locaDate.getDayOfMonth();
        int horas  = locaDate.getHour();
        int minutos = locaDate.getMinute();
        int segundos = locaDate.getSecond();
        String tiempo = " 'año'";
        /*
        * DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
 Date date = new Date();
  System.out.println("Hora actual: " + dateFormat.format(date));*/
    }

    public void añadirPalabra(String nuevaPalabra){
        listaPalabras.add(nuevaPalabra);
    }

    public String getFicheroLog() {
        return ficheroLog;
    }

    public void setFicheroLog(String ficheroLog) {
        this.ficheroLog = ficheroLog;
    }

    public ArrayList<String> getListaPalabras() {
        return listaPalabras;
    }

    public void setListaPalabras(ArrayList<String> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public void addAccion(Accion accion){//añadir a la lista
        listaAccion.add(accion);
    }
}
