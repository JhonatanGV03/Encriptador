package com.uq.encriptador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class ControllerFx {

    //Variables
    String palabraClave, codigoEncriptado, nombreArchivo;

    //Identificadores de los elementos de la interfaz
    @FXML
    private Button btnDesencriptar, btnEncriptar2;
    @FXML
    private Pane inicio, encriptador, desencriptador;
    @FXML
    private TextField txtCodigoEncriptado, txtNomArchivo, txtPalabraClave;
    @FXML
    private Text txtpalabra, txtLetras, txtLetras1;


    //CONTENIDO DE LA PANTALLA INICIO

    //Método para mostrar la ventana de desencriptar al presionar el botón "Desencriptar"
    @FXML
    void onActionbtnDesencriptar() {
        desencriptador.setVisible(true);
        desencriptador.setDisable(false);
        inicio.setVisible(false);
        inicio.setDisable(true);
    }

    //Método para mostrar la ventana de encriptación una vez se presione el botón "Encriptar"
    @FXML
    void onActionbtnEncriptar() {
        encriptador.setVisible(true);
        encriptador.setDisable(false);
        inicio.setVisible(false);
        inicio.setDisable(true);
    }

    //Método para salir de la aplicación si el usuario lo desea
    @FXML
    void OnActionSalir() {
        System.exit(0);
    }

    //CONTENIDO DE LA PANTALLA ENCRIPTACIÓN

    //Método para guardar la palabra clave ingresada por el usuario y verificar que cumpla con las condiciones
    @FXML
    void onActionPalabraClave() {
        palabraClave = verificarPalabraClave(txtPalabraClave.getText(), txtLetras);
        System.out.println(palabraClave);
        if (palabraClave != null) {
            btnEncriptar2.requestFocus();
            txtLetras1.setVisible(false);
        }

    }

    //Método de acción que encripta la palabra clave y la convierte en un archivo txt llamando al método correspondiente
    @FXML
    void OnActionEncriptar2() throws IOException {
        if (palabraClave == null) {
            txtLetras1.setVisible(true);

        }else {
            String encriptacion= String.valueOf(Codificador.sumaCaracteres(palabraClave));
            Codificador.crearArchivo("Su código encriptado es: " + encriptacion);
            txtLetras1.setText("El archivo con el código encriptado\n"+"se ha creado en el escritorio");
            txtLetras1.setLayoutX(75);
            txtLetras1.setVisible(true);
        }

    }

    //CONTENIDO DE LA PANTALLA DESENCRIPTACIÓN

    //Método para guardar el nombre del archivo y verificar que cumpla con las condiciones
    @FXML
    void OnActionNomArchivo() {
        txtpalabra.setStyle("-fx-fill: RED");
        nombreArchivo = verificarCodigos(txtNomArchivo.getText(), txtpalabra);
        System.out.println(nombreArchivo);
        if (nombreArchivo != null) {
            txtCodigoEncriptado.requestFocus();
        }
    }

    //Método para guardar el código encriptado ingresado por el usuario y verificar que cumpla con las condiciones
    @FXML
    void onActionCodigoEncriptado() {
        codigoEncriptado = verificarCodigos(txtCodigoEncriptado.getText(), txtpalabra);
        System.out.println(codigoEncriptado);
        if (codigoEncriptado != null) {
            btnDesencriptar.requestFocus();
        }
    }

    //Método de acción que desencripta el código y lo muestra en pantalla una vez el usuario presiona el botón desencriptar
    @FXML
    void onActionDesencriptar() {
        if (nombreArchivo == null || codigoEncriptado == null) {
            txtpalabra.setStyle("-fx-fill: RED");
            txtpalabra.setText("¡Ingrese los datos correctamente!");
            txtpalabra.setVisible(true);
            txtpalabra.setLayoutX(72);
        }else {
            txtpalabra.setStyle("-fx-fill: BLACK");
            String mensajeDesencriptado= String.valueOf(Codificador.restaCaracteres(codigoEncriptado, nombreArchivo));
            txtpalabra.setText("La palabra clave desencriptada es:\n"+mensajeDesencriptado);
            txtpalabra.setVisible(true);
            txtpalabra.setLayoutX(75);
        }
    }

    //MÉTODOS DE VERIFICACIÓN
    /**
     * Verifica que el texto ingresado no contenga espacios ni números y sea de 14 caracteres
     * @param texto Texto ingresado por el usuario
     * @param aviso Texto que se muestra en la pantalla
     * @return El texto ingresado si es correcto, null si no lo es
     */
    public String verificarPalabraClave (String texto, Text aviso ){
        if (texto.length() == 14) {
            if (texto.contains(" ")) {
                aviso.setText("¡No puede contener espacios!");
                aviso.setVisible(true);
                aviso.setLayoutX(89);
            }else if (texto.contains("1") || texto.contains("2") || texto.contains("3")
                    || texto.contains("4") || texto.contains("5") || texto.contains("6")
                    || texto.contains("7") || texto.contains("8") || texto.contains("9")
                    || texto.contains("0")) {

                aviso.setText("¡No puede contener números!");
                aviso.setVisible(true);
                aviso.setLayoutX(89);
            }else {
                aviso.setVisible(false);
                return texto;
            }
        }else {
            aviso.setText("¡Debe tener 14 letras!");
            aviso.setVisible(true);
            aviso.setLayoutX(114);
        }
        return null;
    }

    /**
     * Verifica que el texto ingresado contenga exactamente 14 caracteres
     * @param texto Texto ingresado por el usuario
     * @param aviso Texto que se muestra en la pantalla
     * @return El texto ingresado si es correcto, null si no lo es
     */
    public String verificarCodigos (String texto, Text aviso ){
        if (texto.length() == 14) {
            aviso.setVisible(false);
            return texto;
        }else {
            aviso.setText("¡Debe tener 14 letras!");
            aviso.setVisible(true);
            aviso.setLayoutX(114);
        }
        return null;
    }
}