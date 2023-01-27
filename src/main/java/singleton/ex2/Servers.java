package singleton.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create a singleton Servers of lazy type. This singleton stores the list of servers (as String). Implement the following functionalities
 * adding a server to the list
 * a method adding the server to the list should return boolean (true if the server has been added to the list, false if it's otherwise)
 * adding is possible, if its name starts from http or https
 * adding a duplicated name is impossible.
 * downloading a list of servers, that names start from http.
 * downloading a list of servers, that names start from https.
 */

public class Servers {
    private static Servers instance = null;

    private List<String> serversList = new ArrayList<>();

    public static Servers getInstance() {
        if (instance == null) {
            instance = new Servers();
        }
        return instance;
    }

    public boolean addServer(String server) {
        if (!isHttp(server) && !server.startsWith("https")) {
            throw new IllegalArgumentException("Must contain http or https");
        }
        if(serversList.contains(server)){
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

        return  serversList.stream()
                .filter(server -> isHttps(server))
                .collect(Collectors.toList());
    }

    private static boolean isHttps(String server) {
        return server.startsWith("https://");
    }
    public void clearServerList(){
        serversList.clear();
    }
}
