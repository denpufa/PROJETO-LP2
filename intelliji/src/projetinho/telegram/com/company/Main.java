package projetinho.telegram.com.company;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        ApiContextInitializer.init();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
            try {
                telegramBotsApi.registerBot(new Bot());
                
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
    }
}



