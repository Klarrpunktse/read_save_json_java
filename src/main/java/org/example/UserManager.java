package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class UserManager {

    private Map<String, User> userList;
    // vi har Map stället för List
    // här säger vi att vår key ska vara av datatypen String => Map<String, >
    // sen säger vi att värdet ska vara vår User klass => Map<String, User>
    // alla värden kommer sparas som key value pairs, alltså en nyckel och ett värde för den nyckeln
    private String fileName = "src/main/user.json";
    // se till att sätta rätt file path så att det stämmer överens med där du skapade den
    // i det här fallet ligger min i main foldern och jag har döpt den till user.json
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    // skapa instans av Gson så här istället

    // tom konstruktor, får skapa ett objekt utan några fält i Main
    public UserManager() {
    }

    // METOD FÖR ATT LÄSA IN FRÅN FIL
    // OBS! se till att göra readFile FÖRST innan ni skapara till fil, den behöver typa listan med TypeToken annars funkar det inte
    // lägg också in nån data innan, tex en income eller expense med endast ett fält där ni säätter amount = 0
    // annars kastar den fel. Ni får självklart försöka lösa det men jag REKOMMENDERAR ATT NI INTE GÖR DET, det kommer
    // ta en massa onödig tid.
    // en income i json filen kan tex se ut så här:
    /*
    {
        "1": {
            "amount": 0
            }
     }
    */
    public void readFile() throws IOException {
        Type type = new TypeToken<Map<String, User>>(){}.getType();
        // vi typar om vår map för att det ska bli lättare mellan java och json
        // det här behöver ske först i applikationen, så läs in det första ni gör
        Reader reader = new FileReader(new File(fileName));
        // skapar en file reader coh sätter vår file path
        userList = gson.fromJson(reader, type);
        // läser in json filen och sparar ner objekten i userList
        // notera att vi skickar med vår reader och vår type = TypeToken

        // loopar bara igenom listan vi precis läst in
        System.out.println("User List:");
        for(String name : userList.keySet()) {
            System.out.println("Key: " + name);
            // här satte jag Key för att det ska vara tydligt att det är keyn + värdet
            // hade vart bättre med "Name" eftersom det är namn i det här fallet.
            // Hade vi haft id hade vi skrivit "Id:"
        }
    }

    public void listUsername(){
        for(User user: userList.values()) {
            System.out.println("user: " + user.getUsername());
        }
    }

    // METOD FÖR ATT SPARA TILL FIL
    // se till att skicka en Income income eller Expense expense in i metoder
    // jag har ju en User user
    public void saveFile() throws IOException {
        //userList.put(user.getUsername(), user);
        // OBS! I den här metoden lägger jag både till en user i listan och sparar listan till fil
        // i er uppgift är det bättre att göra en separat metod för att lägga till i listan
        // och bara låta den här metoden spara till fil
        // på så sätt kan ni spara efter att man tex tagit bort eller uppdaterat något
        // ni blir inte bundna till att alltid lägga till i listan när ni sparar
        // se exempel metoden i den här klassen: addUserToArray()
        FileWriter fw = new FileWriter(new File(fileName));
        // skapar en ny file writer
        gson.toJson(userList, fw);
        // sparar till fil
        fw.close();
        // stänger file writer men ska no fortsätta med nåt kan ni istället ha
        // fw.flush()
    }

    // EXEMPEL PÅ METOD FÖR ATT LÄGGA TILL I LISTAN
    // Så här kan metoden se ut för att lägga till i listan
    // det här är bättre än att lägga till i listan + spara till fil
    // som vi gör nu i saveFile
    // OBS! rad 66 ska tas bort om ni har det så här
    public void addUserToArray(User user) {
        userList.put(user.getUsername(), user);
        System.out.println("User saved!");
    }

    public void getUser(String name) {
        User user = userList.get(name);
        System.out.println("User id of user " + name + " " +user.getId());

    }

    public void removeUser(String name) {
        userList.remove(name);
        System.out.println("User removed!");
        System.out.println("User List:");
    }
}


