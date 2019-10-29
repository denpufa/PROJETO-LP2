package projetinho.telegram.com.company;

import java.util.ArrayList;
import java.util.Scanner;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        TelegramBot tb = new TelegramBot("1001978429:AAHB97aihuye-wDwX09_yW_77jJ6kMPtmfY");
        try {
            tb.run();
        } catch (UnirestException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}


