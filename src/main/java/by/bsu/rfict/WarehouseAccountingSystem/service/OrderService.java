package by.bsu.rfict.WarehouseAccountingSystem.service;

import by.bsu.rfict.WarehouseAccountingSystem.dto.OrderDto;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Item;
import by.bsu.rfict.WarehouseAccountingSystem.entity.Order;
import by.bsu.rfict.WarehouseAccountingSystem.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order findById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);

        if (order == null) {
            log.warn("findById - order : didn't found");
        }
        log.info("findById - order : {} successfully found", order);

        return order;
    }

    public List<Order> findAll() {
        List<Order> orderList = orderRepository.findAll();
        log.info("findAll - found {} orders", orderList.size());

        return orderList;
    }

    public Order addOrder(Order order) {
        Order newOrder = orderRepository.save(order);
        log.info("addOrder - order : {} successfully saved");

        return newOrder;
    }

    public void deleteOrder(Order order) {
        if (order == null) {
            log.info("deleteOrder - item doesn't exist");
        }

        orderRepository.delete(order);
        log.info("deleteOrder - order : {} successfully deleted", order);
    }

    public Order updateOrder(Order order, Order updatedOrder) {
        BeanUtils.copyProperties(updatedOrder, order, "id");
        orderRepository.save(order);
        log.info("updateOrder - order : {} successfully updated", order);

        return order;
    }

    public double calcWeight(OrderDto orderDto) {
        List<Item> itemList = orderDto.getItemList();
        double orderWeight = 0;
        for (Item item : itemList) {
            orderWeight += item.getWeight();
        }
        return orderWeight;
    }

    public double calcCost(OrderDto orderDto) {
        List<Item> itemList = orderDto.getItemList();
        int orderCost = 0;
        for (Item item : itemList) {
            orderCost += item.getCost();
        }
        return orderCost;
    }
}
