package com.bookstore.controller;

import com.bookstore.dto.SachDto;
import com.bookstore.entity.LoaiSach;
import com.bookstore.entity.NhaXuatBan;
import com.bookstore.entity.Sach;
import com.bookstore.service.LoaiSachService;
import com.bookstore.service.NhaXuatBanService;
import com.bookstore.service.SachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SachController {
    private final SachService sachService;
    private final NhaXuatBanService nhaXuatBanService;
    private final LoaiSachService loaiSachService;

    @GetMapping("/book")
    public ResponseEntity<?> RetrieveBooksByPage(){
        return new ResponseEntity<>(sachService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/book/id")
    public ResponseEntity<?> RetrieveBookById(@RequestParam Integer bookId){
        return new ResponseEntity<>(sachService.retrieveById(bookId), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<?> CreateNewBook(@RequestBody SachDto sachDto){
        Sach sach = new Sach();
        sach.setTitle(sach.getTitle());
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
    public ResponseEntity<?> UpdateBook(@RequestBody SachDto sachDto){
        Sach sach = sachService.retrieveById(sachDto.getBookId());
        sach.setTitle(sach.getTitle());
        sach.setAuthor(sachDto.getAuthor());
        sach.setPrice(sachDto.getPrice());
        sach.setStock(sachDto.getStock());
        NhaXuatBan nhaXuatBan = nhaXuatBanService.getById(sachDto.getPublisher_id());
        sach.setPublisher(nhaXuatBan);
        LoaiSach loaiSach = loaiSachService.getById(sachDto.getCategory_id());
        sach.setCategory(loaiSach);
        sachService.saveSach(sach);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
