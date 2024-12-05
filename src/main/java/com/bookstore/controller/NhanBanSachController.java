package com.bookstore.controller;

import com.bookstore.dto.NhanBanSachDto;
import com.bookstore.entity.NhanBanSach;
import com.bookstore.entity.Sach;
import com.bookstore.service.impl.NhanBanSachServiceImpl;
import com.bookstore.service.impl.SachServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NhanBanSachController {
    private final NhanBanSachServiceImpl nhanBanSachServiceImpl;
    private final SachServiceImpl sachServiceImpl;

    @GetMapping("/nhanbansach")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(nhanBanSachServiceImpl.getAll(), HttpStatus.OK);
    }

    @GetMapping("/nhanbansach/filter")
    public ResponseEntity<?> getByBookId(@RequestParam Integer id) {
        return new ResponseEntity<>(nhanBanSachServiceImpl.getByBookId(id), HttpStatus.OK);
    }

    @PostMapping("/nhanbansach")
    public ResponseEntity<?> saveNhanBan(@RequestBody NhanBanSachDto nhanBanSachDto) {
            NhanBanSach nhanBanSach = new NhanBanSach();
            nhanBanSach.setBookCondition(nhanBanSachDto.getBookCondition());
            nhanBanSach.setIsbn(nhanBanSachDto.getIsbn());
            Sach sach = sachServiceImpl.retrieveById(nhanBanSachDto.getBookId());
            nhanBanSach.setSach(sach);
            nhanBanSachServiceImpl.saveNhanBan(nhanBanSach);
            return new ResponseEntity(HttpStatus.CREATED);
    }

}
