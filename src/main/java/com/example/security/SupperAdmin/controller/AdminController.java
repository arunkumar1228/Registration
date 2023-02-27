package com.example.security.SupperAdmin.controller;

import com.example.security.SupperAdmin.entity.Admin;
import com.example.security.SupperAdmin.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class AdminController {


    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public Admin createUser(@RequestBody Admin admin) {
        return adminService.saveUser(admin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getUserById(@PathVariable Long id) {
        Optional<Admin> user = adminService.getUserById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Admin> getAllUsers() {
        return adminService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
    }
}

