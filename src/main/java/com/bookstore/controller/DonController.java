package com.bookstore.controller;

import com.bookstore.dto.BookOrderDto;
import com.bookstore.dto.DonDto;
import com.bookstore.entity.*;
import com.bookstore.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DonController {
    private final DonService donService;
    private final ChiTietDonService chiTietDonService;
    private final TaiKhoanService taiKhoanService;
    private final SachService sachService;
    private final NhanBanSachService nhanBanSachService;

    @GetMapping("/don")
    public ResponseEntity<List<Don>> getOrder() {
        // Lấy đơn hàng từ service
        List<Don> donList = donService.getall();
        return ResponseEntity.ok(donList);
    }

    @GetMapping("/don/chitiet")
    public ResponseEntity<List<ChiTietDon>> getOrderDetails(@RequestParam Integer donID) {
        // Lấy đơn hàng từ service
        Don don = donService.retrieveById(donID);
        List<ChiTietDon> chiTietDonList = chiTietDonService.getByDon(don);
        return ResponseEntity.ok(chiTietDonList);
    }

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
