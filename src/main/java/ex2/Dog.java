package ex2;

import lombok.*;

@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    private String name;
    private int age;
    private String race;
}
