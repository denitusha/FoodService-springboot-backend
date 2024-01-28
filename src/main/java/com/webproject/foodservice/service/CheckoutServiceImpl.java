package com.webproject.foodservice.service;

import com.webproject.foodservice.DAO.CustomerRepository;
import com.webproject.foodservice.DAO.OrderRepository;
import com.webproject.foodservice.dto.Purchase;
import com.webproject.foodservice.dto.PurchaseResponse;
import com.webproject.foodservice.entity.Order;
import com.webproject.foodservice.entity.Customer;
import com.webproject.foodservice.entity.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements  CheckoutService{

    private CustomerRepository customerRepository;

    private OrderRepository orderRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with shippingAddress



        // populate customer with order

        Customer customer = purchase.getCustomer();
        Customer existingCustomer = customerRepository.findByEmail(customer.getEmail());
        //Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);


        if (existingCustomer != null) {
            // Update existing customer details if needed
            order.setCustomer(existingCustomer);
            orderRepository.save(order);
        } else {
            // If the customer doesn't exist, associate the order and save it
            customer.add(order);
            customerRepository.save(customer);
        }

        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}
