package SESSION02_03;

import java.util.Date;

public class Order {
    private int id;
    private String productName;
    private double totalAmount;
    private Date orderDate;

    public Order(int id, String productName, double totalAmount, Date orderDate) {
        this.id = id;
        this.productName = productName;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    // Getters thiết yếu để EL (${order.id}) có thể đọc được dữ liệu
    public int getId() { return id; }
    public String getProductName() { return productName; }
    public double getTotalAmount() { return totalAmount; }
    public Date getOrderDate() { return orderDate; }
}