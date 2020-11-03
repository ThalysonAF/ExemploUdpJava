//EMISSOR
package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
            //Criando o socket (Origem)
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            
            String msg = "Olá!!!";
            
            //Mensagem
            byte[] msg_buf = msg.getBytes();
            //Tamanho da mensagem
            int msg_size = msg_buf.length;
            //IP e Porta de destino (Máquina de origem e destino é a mesma "local")
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 20000; 

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
            System.out.println("[OK] ]");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}