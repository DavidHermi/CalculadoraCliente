import InterfazCliente.Interfaz;

import javax.swing.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;


public class Main {
    static Socket clienteSocket;

    public static void main(String[] args) throws IOException {
        conexion();
        recibimosMensajeS();
    }

    //Con este metodo creámosla con el socoket que tiene el mismo puerto que el servidor
    public static void conexion() {
        try {
            //Sout donde comenzamos el metodo guiando todo paso a paso
            System.out.println("Creando socket cliente");
            //Creamos el socket del cliente
            clienteSocket = new Socket();
            //Empezamos a establecer conexion
            System.out.println("Estableciendo la conexión");
            //Creamos objeto para conectarnos al puerto
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            //Nos conectamos
            clienteSocket.connect(addr);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo para enviar el mensaje al servidor, al crear el metodo creamos dos variables una para el menu
    // que será un int y otra que es un String para enviar el mensaje
    public static void enviamosMensajeS(int opcion, String mensaje) throws IOException {

        try {
            //Importante: Creamos objeto para enviar los datos, con la clase OutputStream
            OutputStream os = clienteSocket.getOutputStream();
            //IMPORTANTE:
            // El objeto creado lo metemos dentro del nuevo objeto para poder enviarlo y que sea un int
            //Y no un byte
            DataOutputStream sos = new DataOutputStream(os);


            //Creamos el menu
            switch (opcion) {
                //Primera opcion que hace
                case 1 -> {
                    //Informamos de lo que vamos a hacer con un print
                    System.out.println("Enviamos el primer mensaje ");
                    //Le indicamos que el mensaje que le vamos a enviar es el primerp
                    sos.writeInt(1);
                    //Enviamos el mensaje
                    sos.writeInt(Integer.parseInt(mensaje));

                }

                    /* APUNTE TECNICO ES UN MENSAJE POR METODO DEL SERVIDOR*/

                case 2 -> {
                    //Informamos de lo que vamos a hacer con un print
                    System.out.println("Enviamos el segundo mensaje ");
                    //Le indicamos que el mensaje que le vamos a enviar es el primerp
                    sos.writeInt(2);
                    //Enviamos el mensaje
                    sos.writeInt(Integer.parseInt(mensaje));

                }
                case 3 -> {
                    //Informamos de lo que vamos a hacer con un print
                    System.out.println("Enviamos el tercer mensaje ");
                    //Le indicamos que el mensaje que le vamos a enviar es el primerp
                    sos.writeInt(3);
                    //Enviamos el mensaje
                    sos.writeInt(Integer.parseInt(mensaje));
                }
                case 4 -> {
                    //Informamos de lo que vamos a hacer con un print
                    System.out.println("Enviamos el cuarto mensaje ");
                    //Le indicamos que el mensaje que le vamos a enviar es el primerp
                    sos.writeInt(4);
                    //Enviamos el mensaje
                    sos.writeInt(Integer.parseInt(mensaje));
                }
                case 5 -> {
                    //Nos disponemos a cerrar el Socket lo anunciamos con un print
                    System.out.println("Cerramos el socket cliente");
                    //Cerramos el socket
                    clienteSocket.close();
                    // Metodo enviar acabado
                    System.out.println("Acabado");

                }


            }


        } catch (IOException e) {
            throw new RuntimeException(e);


        }

        //Creamos el metodo para recibir el resultado del servidor






            }
    public static void recibimosMensajeS() throws IOException {
        //Delcaramos el objeto is para poder recoger el dato que nos envia el servidor, gracias a la clase InputStream
        InputStream is = clienteSocket.getInputStream();
        //Creamos el objeto es de la clase Data, para poder recibir más variables que el byte
        DataInputStream eis = new DataInputStream(is);
        while(true){
            // recibimos el mensaje devuelto del servidor y lo enseñamos por pantalla
            JOptionPane.showMessageDialog(null, eis.readUTF());

        }

    }

}
