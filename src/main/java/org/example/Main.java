package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserManager userManager = new UserManager();
        // skapar en instans av UserManager så vi kan komma åt save och read metoderna

        userManager.readFile();
        // OBS OBS OBS!
        // se till att köra readFile FÖRST innan ni gör nåt annat
        // ni behöver ha nåt i listan så den inte är tom, kopiera det här:
        /*
         {
        "1": {
            "amount": 0
            }
     }
        */
        // klistra in i er json fil

        // skapa en ny user
        User user = new User();
        // skapa en ny user
        // hade gått likabra så här om jag haft en annan kosntruktor:
        // User user = new User(8, "Bengt"");
        user.setId(6);
        // sätter värde på id
        user.setUsername("Test User");
        // sätter värde på username
        userManager.saveFile(user);
        // via userManager kallar jag på saveFile metoden och skickar med min user

    }
}