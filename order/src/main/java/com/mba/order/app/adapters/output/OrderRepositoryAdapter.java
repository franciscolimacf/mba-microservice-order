package com.mba.order.app.adapters.output;

import com.mba.order.app.adapters.converter.Converter;
import com.mba.order.app.application.domain.OrderDomain;
import com.mba.order.app.application.port.out.OrderRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRepositoryAdapter implements OrderRepositoryPort {

    private final OrderRepository repository;
    private final Converter converter;

    @Override
    public OrderDomain order(OrderDomain domain) {
        var entity = repository.save(converter.ConvertDomainToEntity(domain));
        return converter.ConvertEntityToDomain(entity);
    }
}
