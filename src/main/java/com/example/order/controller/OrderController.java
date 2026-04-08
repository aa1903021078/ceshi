package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.model.PageResult;
import com.example.order.model.Result;
import com.example.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

/**
 * 订单控制器
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 获取订单分页列表
     *
     * @param page   页码，默认第1页
     * @param size   每页大小，默认10条
     * @param status 订单状态过滤（可选）：PENDING/PAID/SHIPPED/DELIVERED/CANCELLED
     * @return 分页订单数据
     */
    @GetMapping
    public Result<PageResult<Order>> getOrderPage(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String status) {

        if (page < 1) {
            return Result.error("页码不能小于1");
        }
        if (size < 1 || size > 100) {
            return Result.error("每页大小须在1~100之间");
        }

        PageResult<Order> result = orderService.getOrderPage(page, size, status);
        return Result.success(result);
    }

    /**
     * 根据ID获取订单详情
     *
     * @param id 订单ID
     * @return 订单详情
     */
    @GetMapping("/{id}")
    public Result<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return Result.error("订单不存在，id=" + id);
        }
        return Result.success(order);
    }
}
