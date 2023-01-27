package singleton.ex3;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Data
public class CarRepository {
    private static CarRepository instance = null;

    private List<Car> cars = loadCars();

    private CarRepository() {

    }

    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }

    private List<Car> loadCars() {

        return Arrays.asList(
        //return List.of(
                        new Car.CarBuilder()
                                .year(2018)
                                .carBrand("Ford")
                                .kmCount(58000)
                                .price(15000)
                                .build(),

                        new Car.CarBuilder()
                                .year(2015)
                                .carBrand("Audi")
                                .kmCount(25000)
                                .price(30000)
                                .build()
                );
    }
}
