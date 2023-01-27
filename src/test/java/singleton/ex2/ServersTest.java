package singleton.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
// putem folosi @BeforeEach pt a reseta lista de server. alte exemple AfterEach, ...All
class ServersTest {

    @Test
    void getServersList() {
        int size = Servers.getInstance()
                .getServersList()
                .size();

        Servers.getInstance()
                .addServer("http:// One server added");

        int sizeAfterAdd = Servers.getInstance()
                .getServersList()
                .size();
        //Assertions.assertEquals(sizeAfterAdd, size);
        Assertions.assertEquals(1, sizeAfterAdd - size);


    }
    @Test
    void testDuplicate(){
        Servers instance = Servers.getInstance();
        instance.clearServerList();
        int expectedSize = 3;// index care asteptam sa se gaaseasca

        instance.addServer("http://www.youtube.com");
        instance.addServer("http://www.youtube.com");
        instance.addServer("https://google.com");
        instance.addServer("https://chrome.com");
        //int size = instance.getHttpServersList().size(); //doar http
        int size = instance.getServersList().size();// toate

        Assertions.assertEquals(expectedSize, size);
    }

    @Test
    void getInstance() {
        Servers instance1 = Servers.getInstance();
        Servers instance2 = Servers.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    void invalidServer() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> Servers.getInstance()
                .addServer("One server added"));

    }
    @Test
    void getHttpServersList(){
        Servers instance = Servers.getInstance();
        instance.clearServerList();
        int expectedSize = 1;

        instance.addServer("http://www.youtube.com");
        instance.addServer("https://google.com");
        instance.addServer("https://chrome.com");
        int size = instance.getHttpServersList().size();

        Assertions.assertEquals(expectedSize, size);
    }
    @Test
    void getHttpsServersList(){
        Servers instance = Servers.getInstance();
        instance.clearServerList();
        int expectedSize = 1;

        instance.addServer("https://www.youtube.com");
        instance.addServer("http://google.com");
        instance.addServer("http://chrome.com");
        int size = instance.getHttpsServersList().size();

        Assertions.assertEquals(expectedSize, size);
    }
}