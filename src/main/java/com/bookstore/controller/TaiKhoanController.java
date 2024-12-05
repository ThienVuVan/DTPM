package com.bookstore.controller;

import com.bookstore.dto.TaiKhoanDto;
import com.bookstore.entity.DiaChi;
import com.bookstore.entity.Role;
import com.bookstore.entity.TaiKhoan;
import com.bookstore.service.DiaChiService;
import com.bookstore.service.RoleService;
import com.bookstore.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TaiKhoanController {
    private final TaiKhoanService taiKhoanService;
    private final RoleService roleService;
    private final DiaChiService diaChiService;

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody TaiKhoanDto taiKhoanDto){
        TaiKhoan taiKhoan = taiKhoanService.login(taiKhoanDto.getUsername(), taiKhoanDto.getPassword());
        if(taiKhoan == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(taiKhoan, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> RetrieveTaiKhoanById(@PathVariable Integer id){
        TaiKhoan taiKhoan = taiKhoanService.retrieveById(id);
        return new ResponseEntity<>(taiKhoan, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> CreateUser(@RequestBody TaiKhoanDto taiKhoanDto) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUsername(taiKhoanDto.getUsername());
        taiKhoan.setPassword(taiKhoanDto.getPassword());
        taiKhoan.setEmail(taiKhoanDto.getEmail());
        taiKhoan.setFullName(taiKhoanDto.getFullName());
        taiKhoan.setPhone(taiKhoanDto.getPhone());
        taiKhoan.setRole(roleService.retrieveById(2)); //default Role is USER
        return new ResponseEntity<>(taiKhoanService.saveUser(taiKhoan), HttpStatus.CREATED);
    }
}
