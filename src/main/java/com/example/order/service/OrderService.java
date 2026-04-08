package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.model.PageResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单服务（使用假数据）
 */
@Service
public class OrderService {

    /** 模拟数据库中的订单数据 */
    private static final List<Order> FAKE_ORDERS = new ArrayList<>(Arrays.asList(
        new Order(1L, "ORD20240101001", "Apple iPhone 15 Pro Max 256G", new BigDecimal("9999.00"),
                "PAID", "张三", "北京市朝阳区建国路88号", LocalDateTime.of(2024, 1, 1, 10, 30, 0)),
        new Order(2L, "ORD20240102002", "华为 Mate 60 Pro 512G", new BigDecimal("7999.00"),
                "SHIPPED", "李四", "上海市浦东新区张江高科技园区", LocalDateTime.of(2024, 1, 2, 14, 20, 0)),
        new Order(3L, "ORD20240103003", "小米14 Ultra 16G+512G", new BigDecimal("5999.00"),
                "DELIVERED", "王五", "广州市天河区珠江新城华夏路", LocalDateTime.of(2024, 1, 3, 9, 15, 0)),
        new Order(4L, "ORD20240104004", "MacBook Pro 14寸 M3 Pro", new BigDecimal("16999.00"),
                "PENDING", "赵六", "深圳市南山区科技园南区", LocalDateTime.of(2024, 1, 4, 16, 45, 0)),
        new Order(5L, "ORD20240105005", "Sony WH-1000XM5 耳机", new BigDecimal("2499.00"),
                "PAID", "孙七", "杭州市西湖区文三路478号", LocalDateTime.of(2024, 1, 5, 11, 0, 0)),
        new Order(6L, "ORD20240106006", "iPad Pro 12.9寸 M2 WiFi 256G", new BigDecimal("8999.00"),
                "CANCELLED", "周八", "成都市武侯区天府大道北段1700号", LocalDateTime.of(2024, 1, 6, 8, 30, 0)),
        new Order(7L, "ORD20240107007", "戴尔 XPS 15 4K触控屏笔记本", new BigDecimal("12999.00"),
                "SHIPPED", "吴九", "武汉市洪山区光谷软件园", LocalDateTime.of(2024, 1, 7, 13, 10, 0)),
        new Order(8L, "ORD20240108008", "罗技 MX Master 3S 鼠标", new BigDecimal("699.00"),
                "DELIVERED", "郑十", "南京市鼓楼区中山路321号", LocalDateTime.of(2024, 1, 8, 17, 55, 0)),
        new Order(9L, "ORD20240109009", "Samsung Galaxy S24 Ultra 1TB", new BigDecimal("11999.00"),
                "PAID", "钱一一", "西安市雁塔区高新六路", LocalDateTime.of(2024, 1, 9, 10, 20, 0)),
        new Order(10L, "ORD20240110010", "DJI Mini 4 Pro 无人机", new BigDecimal("4799.00"),
                "PENDING", "陈一二", "重庆市渝北区回兴街道", LocalDateTime.of(2024, 1, 10, 15, 35, 0)),
        new Order(11L, "ORD20240111011", "宁德时代 充电宝 20000mAh", new BigDecimal("299.00"),
                "DELIVERED", "褚一三", "天津市南开区水上公园路", LocalDateTime.of(2024, 1, 11, 12, 0, 0)),
        new Order(12L, "ORD20240112012", "安克 氮化镓充电器 140W", new BigDecimal("399.00"),
                "SHIPPED", "卫一四", "苏州市工业园区星湖街328号", LocalDateTime.of(2024, 1, 12, 9, 40, 0))
    ));

    /**
     * 分页获取订单列表
     *
     * @param page   页码（从1开始）
     * @param size   每页大小
     * @param status 订单状态过滤（可为空）
     * @return 分页结果
     */
    public PageResult<Order> getOrderPage(int page, int size, String status) {
        List<Order> filtered = FAKE_ORDERS.stream()
                .filter(order -> status == null || status.isEmpty() || status.equalsIgnoreCase(order.getStatus()))
                .collect(Collectors.toList());

        long total = filtered.size();
        int fromIndex = (page - 1) * size;
        int toIndex = Math.min(fromIndex + size, (int) total);

        List<Order> pageData = (fromIndex >= total)
                ? new ArrayList<>()
                : filtered.subList(fromIndex, toIndex);

        return new PageResult<>(page, size, total, pageData);
    }

    /**
     * 根据ID获取订单详情
     *
     * @param id 订单ID
     * @return 订单，不存在返回null
     */
    public Order getOrderById(Long id) {
        return FAKE_ORDERS.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
