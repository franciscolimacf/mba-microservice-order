package com.mba.order.app.adapters.input;

import com.mba.order.app.adapters.input.dtos.OrderRequest;
import com.mba.order.app.adapters.input.dtos.OrderResponse;
import com.mba.order.app.application.port.in.OrderServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private final OrderServicePort servicePort;

    @PostMapping("/order")
    public ResponseEntity<OrderResponse> order (@RequestBody OrderRequest request){

        return ResponseEntity.ok(null);
    }
}
