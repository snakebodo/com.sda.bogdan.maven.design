package singleton.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pentru temă, exerciții pentru toată lumea:


 * https://java.en.sdacademy.pro/exercises/design_pattern_and_good_practices/exercises/#exercise-5-builder
 */
public class ServersMultiThread {
    public static class Servers {
        private static Servers instance = null;

        private List<String> serversList = new ArrayList<>();

        public static Servers getInstance() {

            if (instance == null) {
                safelyCreateInstanceIfMissing();
            }
            return instance;
        }

        private static synchronized void safelyCreateInstanceIfMissing() {
            if (instance == null) {
                instance = new Servers();
            }else{
                System.out.println("I was late.");
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
}
