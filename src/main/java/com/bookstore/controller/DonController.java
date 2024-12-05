package com.bookstore.controller;

import com.bookstore.dto.BookOrderDto;
import com.bookstore.dto.DonDto;
import com.bookstore.entity.*;
import com.bookstore.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class DonController {
    private final DonService donService;
    private final ChiTietDonService chiTietDonService;
    private final TaiKhoanService taiKhoanService;
    private final SachService sachService;
    private final NhanBanSachService nhanBanSachService;

    // API lấy thông tin đơn hàng
//    @GetMapping("/don")
//    public ResponseEntity<DonDto> getOrderDetails(@RequestParam Integer orderId) {
//        // Lấy đơn hàng từ service
//        Don don = donService.retrieveById(orderId);
//        // Lấy danh sách chi tiết đơn hàng
//        List<ChiTietDon> chiTietDonList = chiTietDonService.findByOrderId(orderId);
//
//        // Chuyển đổi sang DTO
//        DonDto donDto = new DonDto();
//        donDto.setOrderId(don.getOrderId());
//        donDto.setAccountId(don.getAccount().getAccountId());
//        donDto.setDate(don.getOrderDate());
//        donDto.setStatus(don.getStatus());
//
//        List<BookOrderDto> bookOrderDtoList = chiTietDonList.stream()
//                .map(chiTiet -> {
//                    BookOrderDto bookOrderDto = new BookOrderDto();
//                    bookOrderDto.setBookId(chiTiet.getSach().getBookId());
//                    bookOrderDto.setQuantity(chiTiet.getQuantity());
//                    bookOrderDto.setPrice(chiTiet.getPrice());
//                    return bookOrderDto;
//                })
//                .collect(Collectors.toList());
//
//        donDto.setBookOrderDtoList(bookOrderDtoList);
//
//        return ResponseEntity.ok(donDto);
//    }
    @PostMapping("/don")
    public ResponseEntity<String> createOrder(@RequestBody DonDto donDto) {
            Don don = new Don();
        TaiKhoan taiKhoan = taiKhoanService.retrieveById(donDto.getAccountId());
            don.setAccount(taiKhoan);
            don.setOrderDate(LocalDateTime.now());
            don.setStatus("pending");
            Don savedDon = donService.saveOrder(don);
            double sum = 0;

            // Duyệt qua danh sách sách và số lượng
            for (BookOrderDto bookOrderDto : donDto.getBookOrderDtoList()) {
                Integer bookId = bookOrderDto.getBookId();
                Integer quantity = bookOrderDto.getQuantity();

                Sach sach = sachService.retrieveById(bookId);
                // Giảm tồn kho
                sach.setStock(sach.getStock() - quantity);
                sachService.saveSach(sach);

                // Tạo chi tiết đơn hàng
                ChiTietDon chiTietDon = new ChiTietDon();
                chiTietDon.setOrder(savedDon);
                chiTietDon.setSach(sach);
                chiTietDon.setQuantity(quantity);
                chiTietDon.setPrice(sach.getPrice() * quantity); // Tính giá tiền
                chiTietDonService.save(chiTietDon);

                // Gán một bản sao sách bất kỳ (order_detail_id null) cho chi tiết đơn hàng
                for (int i = 0; i < quantity; i++) {
                    NhanBanSach nhanBanSach = nhanBanSachService.findRandom();
                    nhanBanSach.setOrderDetail(chiTietDon);
                    nhanBanSachService.saveNhanBan(nhanBanSach);
                }
                sum += sach.getPrice() * quantity;
            }
            savedDon.setTotalAmount(sum);
            donService.saveOrder(savedDon);
            return ResponseEntity.ok("Tạo đơn hàng thành công!");
    }
}
