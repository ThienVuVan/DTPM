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
    public ResponseEntity<?> login(@RequestBody TaiKhoanDto taiKhoanDto){
        TaiKhoan taiKhoan = taiKhoanService.retrieveByEmail(taiKhoanDto.getEmail());
        if (taiKhoan.getEmail() == taiKhoanDto.getEmail() && taiKhoan.getPassword() == taiKhoanDto.getPassword()){
            return ResponseEntity.ok(taiKhoanService.retrieveByEmail(taiKhoanDto.getEmail()));
        }
        return ResponseEntity.status(403).body("invalid");
    }

    @GetMapping("/user")
    public ResponseEntity<?> RetrieveTaiKhoanById(@RequestParam Integer userId){
        TaiKhoan taiKhoan = taiKhoanService.retrieveById(userId);
        return new ResponseEntity<>(taiKhoan, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> CreateUser(@RequestBody TaiKhoanDto taiKhoanDto){
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUsername(taiKhoanDto.getUsername());
        taiKhoan.setPassword(taiKhoanDto.getUsername());
        taiKhoan.setFullName(taiKhoanDto.getUsername());
        taiKhoan.setEmail(taiKhoanDto.getUsername());
        taiKhoan.setPhone(taiKhoanDto.getUsername());
        DiaChi diaChi = diaChiService.retrieveById(taiKhoanDto.getAddress_id());
        Role role = roleService.retrieveById(taiKhoanDto.getRole_id());
        taiKhoan.setAddress(diaChi);
        taiKhoan.setRole(role);
        taiKhoanService.saveUser(taiKhoan);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
