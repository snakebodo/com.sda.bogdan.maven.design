package singleton.ex3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int year;
    private String carBrand;
    private int kmCount;
    private double price;

}
