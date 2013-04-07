package at.irian.examples.get.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Michael Kurz
 */
public class Product {
    @Min(value = 1000)
    private int id;
    @NotNull
    @Length(min = 3)
    private String name;
    private String description;
    @NotNull
    @Min(value = 0)
    private int price;

    public Product(int id, String name, String description, int price) {
        this.description = description;
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}