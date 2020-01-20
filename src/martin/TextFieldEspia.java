package martin;

import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TextFieldEspia extends TextField {

    private String ficheroLog = "src/ficheroLog.txt";
    FileWriter fichero = null;
    PrintWriter pw = null;
    private ArrayList<String> listaPalabras = new ArrayList<String>();

    public TextFieldEspia() {
    }

    public TextFieldEspia(String s, String ficheroLog) {
        super(s);
        this.ficheroLog = ficheroLog;

        textProperty().addListener((observable, oldValue, newValue) -> {
            if(listaPalabras.contains(newValue)){
                System.out.println("");
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
    }

    public void añadirPalabra(String nuevaPalabra){
        listaPalabras.add(nuevaPalabra);

        /*
        * DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
 Date date = new Date();
  System.out.println("Hora actual: " + dateFormat.format(date));*/
    }
}
