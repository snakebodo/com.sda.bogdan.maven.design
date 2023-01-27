package singleton.temaAcasa.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ex 2 - modificați clasa Servers pentru cazul multithreading
 */
public class Servers {
    private static Servers instance = null; // varianta 5 inlocuim varianta4 cu inlocuirea lui null cu (new numeClasa)

    private List<String> serversList = new ArrayList<>();

    /*public static synchronized Servers getInstance() {   // varianta 1
        if (instance == null) {
            instance = new Servers();
        }
        return instance;
    }*/

    /*public static Servers getInstance() {   // varianta 2. aceasta varianta e pe clasa  Ex: syncronized(numeClasa.class){cod scris in bloc}
        synchronized (Servers.class) {
            if (instance == null) {
                instance = new Servers();
            }
            return instance;
        }
    }*/

    /*public static Servers getInstance() {   // varianta3 aceasta se aplica doar la if(), threads lucreaza pe rand dar nu rezolva problema doar daca adaugam a 2a linie de if().
        if (instance == null) {
            synchronized (Servers.class) {
                if (instance == null) {
                    instance = new Servers();
                }
            }
        }
        return instance;
    }*/

    public static Servers getInstance() {   // varianta4 selectezi toata metoda de syncronize de la varianta3 si dai extract method si redenumesti metoda
        if (instance == null) {
            safelyCreateInstanceIfMissing();
        }
        return instance;
    }

    private static void safelyCreateInstanceIfMissing() { //aici mai adugam si un else
        synchronized (Servers.class) {
            if (instance == null) {
                instance = new Servers();
            }else{
                System.out.println("To late");
            }
        }
    }

    public boolean addServer(String server) {
        if (!isHttp(server) && !server.startsWith("https")) {
            throw new IllegalArgumentException("Must contain http or https");
        }
        if (serversList.contains(server)) {
            return false;
        }
        return serversList.add(server);
    }

    public List<String> getServersList() {
        return serversList;
    }

    public List<String> getHttpServersList() {

        return serversList.stream()
                .filter(server -> isHttp(server))
                .collect(Collectors.toList());
    }

    private static boolean isHttp(String server) {
        return server.startsWith("http://");
    }

    public List<String> getHttpsServersList() {

        return serversList.stream()
                .filter(server -> isHttps(server))
                .collect(Collectors.toList());
    }

    private static boolean isHttps(String server) {
        return server.startsWith("https://");
    }

    public void clearServerList() {
        serversList.clear();
    }
}
