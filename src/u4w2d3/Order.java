package u4w2d3;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Order extends AbsClass {
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    // Costruttore
    public Order(int id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
            Customer customer) {
        super(id);
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    // Costruttore senza data ordine
    public Order(int id, String status, LocalDate deliveryDate, List<Product> products,
            Customer customer) {
        super(id);
        this.status = status;
        this.orderDate = LocalDate.now();
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public int getId() {
        return super.getId();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // toString, equals e hashCode
    @Override
    public String toString() {
        return "Order{" +
                "id=" + super.getId() +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }

}
