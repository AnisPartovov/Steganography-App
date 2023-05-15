package com.example.demo.Contact;

import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;

public class WhatsApp {


    public void start(Stage stage) {
        String phoneNumber = "+992935200903";
        try {
            URL url = new URL("https://web.whatsapp.com//" + phoneNumber);
            Desktop.getDesktop().browse(url.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
