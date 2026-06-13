package com.mba.order.app.application.port.in;

import com.mba.order.app.application.domain.OrderDomain;

public interface OrderServicePort {
    OrderDomain order(OrderDomain domain);
}
