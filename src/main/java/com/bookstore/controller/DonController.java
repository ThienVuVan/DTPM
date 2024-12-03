//package com.bookstore.controller;
//
//import com.bookstore.service.DonService;
//import com.bookstore.service.SachService;
//import com.bookstore.service.TaiKhoanService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//public class DonController {
//    private final DonService donService;
//    private final SachService sachService;
//    private final TaiKhoanService taiKhoanService;
//    private final DonService donService;
//
//    @PostMapping("/order")
//    public ResponseEntity<?> CreateNewOrder(@Valid @RequestBody OrderRequest orderRequest ){
//
//        return new ResponseEntity(HttpStatus.CREATED);
//    }
//    @GetMapping("/order")
//    public ResponseEntity<?> UpdateOrder(@RequestParam Integer orderId, @RequestParam String orderStatus){
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
