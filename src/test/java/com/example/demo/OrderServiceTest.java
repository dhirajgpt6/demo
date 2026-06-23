//package com.example.demo;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
///**
// * This test class verifies ONLY business logic of OrderService.
// * Database layer (OrderDao) is mocked.
// */
//@ExtendWith(MockitoExtension.class) // Enables Mockito for JUnit 5
//class OrderServiceTest {
//
//    @Mock
//    private OrderDao orderDao; // Fake DAO (no DB hit)
//
//    @InjectMocks
//    private OrderService orderService;
//    // Injects mocked DAO into OrderService
//
//    private Order order;
//
//    @BeforeEach
//    void setUp() {
//        // Test data used across test cases
//        order = new Order(
//                1L,
//                "Laptop Order",
//                new BigDecimal("50000.00")
//        );
//    }
//
//    // ---------------- ADD ORDER TEST ----------------
//    @Test
//    void testAddOrder_success() {
//
//        // Arrange: define DAO behavior
//        when(orderDao.save(order)).thenReturn(order);
//
//        // Act: call service method
//        Order savedOrder = orderService.addOrder(order);
//
//        // Assert: verify result
//        assertNotNull(savedOrder);
//        assertEquals(1L, savedOrder.getId());
//        assertEquals("Laptop Order", savedOrder.getName());
//        assertEquals(0, savedOrder.getAmount().compareTo(new BigDecimal("50000.00")));
//
//        // Verify: DAO method was called exactly once
//        verify(orderDao, times(1)).save(order);
//        verify(orderDao, atLeast(1)).save(order);
//    }
//
//    // ---------------- ADD ORDER FAILURE ----------------
//    @Test
//    void testAddOrder_nullOrder_shouldThrowException() {
//
//        // Assert + Act combined
//        assertThrows(IllegalArgumentException.class, () -> {
//            orderService.addOrder(null);
//        });
//
//        // DAO should never be called
//        verify(orderDao, never()).save(any());
//    }
//
//    // ---------------- GET ORDER TEST ----------------
//    @Test
//    void testGetOrderById() {
//
//        when(orderDao.findById(1L)).thenReturn(order);
//
//        Order fetchedOrder = orderService.getOrder(1L);
//
//        assertNotNull(fetchedOrder);
//        assertEquals("Laptop Order", fetchedOrder.getName());
//
//        verify(orderDao).findById(1L);
//    }
//
//    // ---------------- UPDATE ORDER TEST ----------------
//    @Test
//    void testUpdateOrder() {
//
//        when(orderDao.update(order)).thenReturn(order);
//
//        Order updatedOrder = orderService.updateOrder(order);
//
//        assertNotNull(updatedOrder);
//        assertEquals(order.getId(), updatedOrder.getId());
//
//        verify(orderDao).update(order);
//    }
//}
//
//
