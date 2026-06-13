package com.mba.order.app.adapters.converter;

import com.mba.order.app.adapters.input.dtos.OrderRequest;
import com.mba.order.app.adapters.input.dtos.OrderResponse;
import com.mba.order.app.adapters.output.entity.OrderEntity;
import com.mba.order.app.application.domain.OrderDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Converter {
    public OrderDomain ConvertRequestToDomain(OrderRequest request){
        return OrderDomain.builder()
                .cpf(request.getCpf())
                .salario(request.getSalario())
                .build();
    }

    public OrderEntity ConvertDomainToEntity(OrderDomain domain){
        return OrderEntity.builder()
                .cpf(domain.getCpf())
                .salario(domain.getSalario())
                .build();
    }

    public OrderDomain ConvertEntityToDomain(OrderEntity entity){
        return OrderDomain.builder()
                .id(entity.getId())
                .cpf(entity.getCpf())
                .salario(entity.getSalario())
                .build();
    }

    public OrderResponse ConvertDomainToResponse(OrderDomain domain) {
        return OrderResponse.builder()
                .id(domain.getId())
                .cpf(domain.getCpf())
                .salario(domain.getSalario())
                .build();
    }

    public List<OrderDomain> ConvertListEntityToListDomain(List<OrderEntity> entities){
        return entities.stream()
                .map(this::ConvertEntityToDomain).toList();
    }

    public List<OrderResponse> ConvertListDomainToListResponse(List<OrderDomain> domains){
        return domains.stream()
                .map(this::ConvertDomainToResponse).toList();
    }
}
