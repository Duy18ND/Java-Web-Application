package SESSION04_01.service;

import SESSION04_01.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class OrderService {
    private final  OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String getAllOrders(Model model) {
        return orderRepository.getAllOrders(model);
    }

    public String getOrderById(Long id) {

        return orderRepository.getOrderById(id);

    }

}