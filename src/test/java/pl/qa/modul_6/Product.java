package pl.qa.modul_6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Product {

    private String name;
    @Getter
    private double price;

}