package com.webproject.foodservice.service;

import com.webproject.foodservice.dto.Purchase;
import com.webproject.foodservice.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
