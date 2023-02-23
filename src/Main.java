import javax.swing.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class Main {
    static Socket clienteSocket;
   static int opcion = -1 ;

    public static void main(String[] args) throws IOException {
        conexion();
        enviamosMensajeS();
    }

    //Con este metodo creámosla con el socoket que tiene el mismo puerto que el servidor
    public static void conexion() {
        try {
            //Println donde comenzamos el metodo guiando todo paso a paso
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
    public static void enviamosMensajeS( ) throws IOException {

        while (opcion != 0) {


            try {


                //Importante: Creamos objeto para enviar los datos, con la clase OutputStream
                OutputStream os = clienteSocket.getOutputStream();
                //IMPORTANTE:
                // El objeto creado lo metemos dentro del nuevo objeto para poder enviarlo y que sea un int
                //Y no un byte
                DataOutputStream sos = new DataOutputStream(os);
                InputStream is = clienteSocket.getInputStream();
                //Creamos el objeto es de la clase Data, para poder recibir más variables que el byte
                DataInputStream eis = new DataInputStream(is);


                String lectura = JOptionPane.showInputDialog(null,"************************" +
                        "\n Elige opción: \n" +
                        " 1.- CampoFutbol\n" +
                        " 2.- Jubilacion \n" +
                        " 3.- Arturito\n" +
                        " 4.- gasolina \n************************");
                opcion = Integer.parseInt(lectura);

                //Creamos el menu
                switch (opcion) {
                    //Primera opcion que hace
                    case 1 -> {
                        //Pedimos la opcion nº1
                        String uno = JOptionPane.showInputDialog("CampoFutbol");
                        //Informamos de lo que vamos a hacer con un print
                        System.out.println("Enviamos el primer mensaje ");
                        //Le indicamos que el mensaje que le vamos a enviar es el primerp
                        sos.writeInt(1);
                        //Enviamos el mensaje
                        sos.writeDouble(Double.parseDouble(uno));
                        //Recibimos el mensaje de vuelta
                        JOptionPane.showMessageDialog(null, eis.readUTF());

                    }

                    /* APUNTE TECNICO ES UN MENSAJE POR METODO DEL SERVIDOR*/

                    case 2 -> {
                        //Pedimos la opcion nº2
                        String dos = JOptionPane.showInputDialog("Jubilacion");

                        //Informamos de lo que vamos a hacer con un print
                        System.out.println("Enviamos el segundo mensaje ");
                        //Le indicamos que el mensaje que le vamos a enviar es el primerp
                        sos.writeInt(2);
                        //Enviamos el mensaje
                        sos.writeDouble(Double.parseDouble(dos));
                        //Recibimos el mensaje de vuelta
                        JOptionPane.showMessageDialog(null, eis.readUTF());

                    }
                    case 3 -> {
                        //Pedimos la opcion nº3
                        String tres = JOptionPane.showInputDialog("Arturito");
                        //Informamos de lo que vamos a hacer con un print
                        System.out.println("Enviamos el tercer mensaje ");
                        //Le indicamos que el mensaje que le vamos a enviar es el primerp
                        sos.writeInt(3);
                        //Enviamos el mensaje
                        sos.writeDouble(Double.parseDouble(tres));
                        //Recibimos el mensaje de vuelta
                        JOptionPane.showMessageDialog(null, eis.readUTF());
                    }
                    case 4 -> {
                        //Pedimos la opcion nº4
                        String cuatro = JOptionPane.showInputDialog("Arturito");
                        //Informamos de lo que vamos a hacer con un print
                        System.out.println("Enviamos el cuarto mensaje ");
                        //Le indicamos que el mensaje que le vamos a enviar es el primerp
                        sos.writeInt(4);
                        //Enviamos el mensaje
                        sos.writeDouble(Double.parseDouble(cuatro));
                        //Recibimos el mensaje de vuelta
                        JOptionPane.showMessageDialog(null, eis.readUTF());
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


        }

    }
}
