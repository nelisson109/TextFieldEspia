package com.martin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import martin.TextFieldEspia;

import java.net.URL;
import java.util.ResourceBundle;

public class VentanaEspiaController implements Initializable {

    @FXML
    private TextFieldEspia textFieldEspia;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textFieldEspia.añadirPalabra("perro");
        textFieldEspia.añadirPalabra("gato");

    }
}
