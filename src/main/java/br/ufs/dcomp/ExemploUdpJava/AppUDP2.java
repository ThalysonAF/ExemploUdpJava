//RECEPTOR
package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
            //Recebe nessa porta
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");
            
            //buffer vazio para recebimento
            byte[] buf = new byte[20];
            //Cria pacote vazio do tamanho do buffer
            DatagramPacket pack = new DatagramPacket(buf, buf.length);

            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            //Ação bloqueante
            socket.receive(pack);
            System.out.println("[OK] ]");
            
            //Recebe os dados em bytes
            byte[] received_data = pack.getData();
            //Transforma em um String
            String received_msg = new String(received_data); 
            //Pega os dados do emissor, IP e Porta
            InetAddress origin_address = pack.getAddress();
            int origin_port = pack.getPort();
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}