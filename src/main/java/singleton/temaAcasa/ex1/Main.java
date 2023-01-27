package singleton.temaAcasa.ex1;

import singleton.ex3.CarRepository;

import java.util.List;

/**
 * Creați o clasă Car cu câmpurile: year, carBrand, kmCount, price
 * Creați o  clasă CarRepository cu design pattern-ul Singleton -
 * aceasta va reprezenta accesul la "colecția de mașini"
 * Adăugați un câmp în CarRepository pentru a reprezenta lista de mașini - List<Car> cars
 * Adăugați o metodă pentru a inițializa colecția de mașini cu câteva obiecte
 * create de voi în interiorul metodei - modificați câmpul cars cu:
 * List<Car> cars = loadCars();
 */
public class Main {
    public static void main(String[] args) {

        CarRepository instance = CarRepository.getInstance();
        instance.getCars();
        System.out.println(instance);

    }
}
