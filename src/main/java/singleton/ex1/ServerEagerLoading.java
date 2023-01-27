package singleton.ex1;

public class ServerEagerLoading {
    private static ServerEagerLoading instance = new ServerEagerLoading();

    private ServerEagerLoading() {

    }

    public static ServerEagerLoading getInstance(){
        /*//use yhe if method if it has to be Lazy
        if(instance == null){
            instance = new ServerEagerLoading();
        }*/
        return instance;
    }
}