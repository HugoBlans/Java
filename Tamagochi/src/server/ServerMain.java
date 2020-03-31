package server;


import model.Joueur;
import model.Location;
import model.TamagUpdater;
import model.Tamagochi;
import serialization.ObjectSerializer;
import tcp.Socketer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerMain {
    public static void main(String[] args) {
        ServerSocket socket = null;
        List<Socket> clients = new ArrayList<>();
        Map<String, Joueur> joueurs = new HashMap<>();
        try {

            socket = new ServerSocket(7654);
            while (true) {
                System.out.println("attente d'un nouveau client...");
                Socket client = socket.accept();
                clients.add(client);
                Thread t = new Thread(new Runnable() {

                    Socket myClient = client;

                    @Override
                    public void run() {

                        System.out.println("connection d'un client!");
                        Socketer socketer = new Socketer();
                        ObjectSerializer serializer = new ObjectSerializer();

                        while (myClient.isBound()) {
                            Map<String,String> clientRqt = (HashMap) serializer.fromData(socketer.read(myClient));
                            if (!joueurs.containsKey(clientRqt.get("Pseudo"))) {
                                joueurs.put(clientRqt.get("Pseudo"),new Joueur(clientRqt.get("Pseudo")));
                            } else {
                                Joueur j = joueurs.get(clientRqt.get("Pseudo"));
                                switch (clientRqt.get("command")) {
                                    case "créer" :
                                        j.addTamag(clientRqt.get("TamagName"));
                                        break;
                                    case "jouer" :
                                        Tamagochi jt = j.getTamagochiList().get("TamagName");
                                        TamagUpdater jtu = j.getTamagUpdaters().get(jt.getId());
                                        jtu.moveTo(Location.PLAYING_ROOM);
                                        break;
                                    case  "manger" :
                                        Tamagochi mt = j.getTamagochiList().get("TamagName");
                                        TamagUpdater mtu = j.getTamagUpdaters().get(mt.getId());
                                        mtu.moveTo(Location.DINING_ROOM);
                                        break;
                                }
                            }

                        }
                    }
                });
                t.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
