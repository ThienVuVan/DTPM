package com.bookstore.controller;

import com.bookstore.dto.NhanBanSachDto;
import com.bookstore.dto.SachDto;
import com.bookstore.entity.LoaiSach;
import com.bookstore.entity.NhaXuatBan;
import com.bookstore.entity.NhanBanSach;
import com.bookstore.entity.Sach;
import com.bookstore.service.LoaiSachService;
import com.bookstore.service.NhaXuatBanService;
import com.bookstore.service.NhanBanSachService;
import com.bookstore.service.SachService;
import com.bookstore.service.impl.SachServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SachController {
    private static final Logger log = LoggerFactory.getLogger(SachController.class);
    private final SachServiceImpl sachService;
    private final NhaXuatBanService nhaXuatBanService;
    private final LoaiSachService loaiSachService;
    private final NhanBanSachService nhanBanSachService;

    @GetMapping("/book")
    public ResponseEntity<?> RetrieveBooksByPage() {
        return new ResponseEntity<>(sachService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> retrieveBookById(@PathVariable Integer id) {
        Sach sach = sachService.retrieveById(id);

        if (sach == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(sach, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<?> CreateNewBook(@RequestBody SachDto sachDto) {
        Sach sach = new Sach();
        sach.setTitle(sachDto.getTitle());
        sach.setAuthor(sachDto.getAuthor());
        sach.setPrice(sachDto.getPrice());
        sach.setStock(sachDto.getStock());
        NhaXuatBan nhaXuatBan = nhaXuatBanService.getById(sachDto.getPublisher_id());
        sach.setPublisher(nhaXuatBan);
        LoaiSach loaiSach = loaiSachService.getById(sachDto.getCategory_id());
        sach.setCategory(loaiSach);
        sachService.saveSach(sach);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/book/update")
    public ResponseEntity<?> UpdateBook(@RequestBody SachDto sachDto) {
        Sach sach = sachService.retrieveById(sachDto.getBookId());
        sach.setTitle(sachDto.getTitle());
        sach.setAuthor(sachDto.getAuthor());
        sach.setPrice(sachDto.getPrice());
        sach.setStock(sachDto.getStock());
        NhaXuatBan nhaXuatBan = nhaXuatBanService.getById(sachDto.getPublisher_id());
        sach.setPublisher(nhaXuatBan);
        LoaiSach loaiSach = loaiSachService.getById(sachDto.getCategory_id());
        sach.setCategory(loaiSach);
        sachService.updateSach(sach);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> DeleteBook(@PathVariable Integer id) {
        Sach sach = sachService.retrieveById(id);
        if (sach == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sachService.deleteSach(sach);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/book-copy")
    public ResponseEntity<?> CreateNewBookCopy(@RequestBody NhanBanSachDto nhanBanSachDto) {
        NhanBanSach nhanBanSach = new NhanBanSach();
        nhanBanSach.setBookCondition(nhanBanSachDto.getBookCondition());
        nhanBanSach.setIsbn(nhanBanSachDto.getIsbn());
        Sach sach = sachService.retrieveById(nhanBanSachDto.getBookId());
        nhanBanSach.setSach(sach);
        nhanBanSachService.saveNhanBan(nhanBanSach);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
