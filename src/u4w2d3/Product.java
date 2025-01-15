package u4w2d3;

import java.util.List;
import java.util.Objects;

public class Product extends AbsClass implements Interfacename {
    private String name;
    private String category;
    private Double price;

    // Costruttore
    public Product(int id, String name, String category, Double price) {
        super(id);
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getter e Setter
    public int getId() {
        return super.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
