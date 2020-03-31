package application;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import serialization.ObjectSerializer;
import tcp.Socketer;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    Socket server;
    Socketer socketer = new Socketer();
    ObjectSerializer serializer = new ObjectSerializer();

    @FXML
    private TextField tfPseudo;

    @FXML
    private TextField tfTamagName;

    @FXML
    private Label lbAge;

    @FXML
    private Label lbLieu;

    @FXML
    private Label lbSaciete;

    @FXML
    private Label lbEmotion;

    @FXML
    private Button btSelection;

    @FXML
    private Button btCreer;

    @FXML
    private Button btManger;

    @FXML
    private Button btJouer;

    @FXML
    private TextArea taLogs;

    @FXML
    private void onRefresh() {
        Map<String,String> ServRep = (HashMap<String,String>) serializer.fromData(socketer.read(server));
        taLogs.appendText(ServRep.get("log") + "\n");
        lbAge.setText(ServRep.get("log"));
        lbEmotion.setText(ServRep.get("log"));
        lbLieu.setText(ServRep.get("log"));
        lbSaciete.setText(ServRep.get("log"));

        if (ServRep.get("TamgHealth") == "DEAD") {
            btManger.setDisable(true);
            btJouer.setDisable(true);
        }
    }

    @FXML
    public void initialize() {
        boolean estConnecte = false;
        do {
            try {
                server = new Socket("127.0.0.1", 7654);
                estConnecte = true;
                System.out.println("Connecté\n");
            } catch (IOException e) {
                System.out.println("attente...\n");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e1) {
                }
            }
        } while (!estConnecte);
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {

                    onRefresh();
                }
            }
        });
        t.start();
    }

    @FXML
    public void selection() {

    }

}
