package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        // skapar första income
        Income income = new Income("1", "20231024", 5000);
        // skapar andra income
        Income income2 = new Income("2", "20231027", 1000);
        // skapa user
        User user = new User(11, "Hejsan", "Java");

        UserManager userManager = new UserManager();
        // skapar en instans av UserManager så vi kan komma åt save och read metoderna

        userManager.readFile();

        // la till min user i listan
        userManager.addUserToArray(user);
        // sparar första income på usern, detta blir user med id 11 då
        user.addIncome(income);
        // sparar andra income på samma user
        user.addIncome(income2);
        userManager.saveFile();





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
       // User user = new User();
        // skapa en ny user
        // hade gått likabra så här om jag haft en annan kosntruktor:
        // User user = new User(8, "Bengt"");
      // user.setId(10);
        // sätter värde på id
       // user.setUsername("GunBritt");
        // sätter värde på username
        // via userManager kallar jag på saveFile metoden och skickar med min user
       /* userManager.addUserToArray(user);
        userManager.removeUser("Test User");
        userManager.saveFile();
        userManager.listUsername();*/

        //ENUM



        //User user2 = new User(13, "Janne");
       // user2.setSubject("Java");

     //   User user2 = new User(22, "Test", "Java");
     //   System.out.println(user2);





        //userManager.addUserToArray(user2);
       // userManager.saveFile();




        //userManager.getUser("NisseJanne");




    }
}