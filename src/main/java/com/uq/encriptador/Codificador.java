package com.uq.encriptador;

import java.io.FileWriter;
import java.io.IOException;

public class Codificador{

    //Se declara la clave que se usara para codificar y decodificar, también es el nombre del archivo
    private static final String clave= "rQPUHz18gC6X7$";
    private static final char[] caracteresClave= clave.toCharArray();

    /**
     * Método para sumar los valores en código Ascii de cada caracater y obtener un código encriptado
     * @param mensaje Es un String que ingresa el usuario y contiene la palabra que se codificara
     * @return un arreglo de caracteres que contiene a la suma de cada carácter entre el mensaje y la clave
     */
    public static char[] sumaCaracteres(String mensaje){
        char[] mensajeSeparado = mensaje.toCharArray();
        char[] mensajeEncriptado = new char[14];

        //Ciclo que permite sumar los caracteres del mensaje y de la clave para obtener un nuevo carácter
        for(int i=0; i<mensajeSeparado.length; i++){
            mensajeEncriptado[i]= (char)(mensajeSeparado[i] + caracteresClave[i]);
        }
        return mensajeEncriptado;
    }

    /**
     * Método para restar los valores en código Ascii de cada caracater y obtener la palabra clave
     * @param mensaje Es un String que ingresa el usuario y contiene un código encriptado
     * @param caracteresClave Es un arreglo de los caracteres de la clave usada para codificar (nombre del archivo)
     * @return un arreglo de caracteres que contiene a la resta de cada carácter entre el mensaje y la clave
    */
    public static char[] restaCaracteres(String mensaje, String caracteresClave){
        char[] mensajeSeparado = mensaje.toCharArray();
        char[] caracteresClaveSeparado = caracteresClave.toCharArray();
        char[] mensajeDesencriptado = new char[14];

        //Ciclo que permite restar los caracteres de la palabra y de la clave para obtener un nuevo carácter
        for(int i=0; i<mensajeSeparado.length; i++){
            mensajeDesencriptado[i]= (char)(mensajeSeparado[i] - caracteresClaveSeparado[i]);
        }
        return mensajeDesencriptado;
    }

    /**
     * Método para crear un archivo txt en el escritorio con el mensaje encriptado
     * @param mensaje Es un String que ingresa el usuario y contiene la palabra ya codificada
     * @throws IOException Se lanza una excepción si no se puede crear el archivo
     */
    public static void crearArchivo(String mensaje) throws IOException {
        String ruta = System.getProperty("user.home") + "\\Desktop\\";
        FileWriter archivo = new FileWriter((ruta)+(clave+".txt"));
        archivo.write(mensaje);
        archivo.close();
    }
}