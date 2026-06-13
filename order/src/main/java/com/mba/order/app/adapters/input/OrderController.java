package com.mba.order.app.adapters.input;

import com.mba.order.app.adapters.converter.Converter;
import com.mba.order.app.adapters.input.dtos.OrderRequest;
import com.mba.order.app.adapters.input.dtos.OrderResponse;
import com.mba.order.app.application.port.in.OrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderServicePort servicePort;
    private final Converter converter;

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> order(@RequestBody OrderRequest request){
        var domain = servicePort.order(converter.ConvertRequestToDomain(request));
        return ResponseEntity.ok(converter.ConvertDomainToResponse(domain));
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderResponse>> list(){
        var domain = servicePort.list();
        return ResponseEntity.ok(converter.ConvertListDomainToListResponse(domain));
    }
}
