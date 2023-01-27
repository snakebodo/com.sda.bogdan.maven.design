package singleton.ex3;

/**
 * Propunere de exercițiu pentru scenariul cu aplicația de mașini:
 * studiați pattern-ul Proxy - adăugați un Proxy pentru CarRepository (o altă clasă care implementează aceeași interfață - aceleași metode), clasa se va numi FileStorageCarRepository -
 *  în plus față de implementarea originală, Proxy-ul va citi colecția de mașini dintr-un fișier la începutul programului și va actualiza fișierul la fiecare modificare (e.g.: la fiecare apel de addCar se rescrie fișierul)
 * pentru opțiuni de scriere în fișier, aveți 2 opțiuni recomandate de serializare/deserializare - Java native Serializable  sau pachetul Jackson
 * testați întâi scrierea și citirea din fișier pentru un singur obiect (Car car), apoi treceți la colecție dacă merge bine (List<Car> cars)
 * Pentru Java object serialization - https://www.baeldung.com/java-serialization
 * Pentru Jackson - https://www.baeldung.com/jackson-object-mapper-tutorial
 */
public class CarRepository2 {
}
