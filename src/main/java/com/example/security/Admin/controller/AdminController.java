package com.example.security.Admin.controller;

import com.example.security.Admin.entity.Admin;
import com.example.security.Admin.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/admin")
public class AdminController {


    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(value = "addAdmin")
    public Admin createUser(@RequestBody Admin admin) {
        return adminService.saveUser(admin);
    }

    @GetMapping(value = "AdminDetailsGetById/{id}")
    public ResponseEntity<Admin> getUserById(@PathVariable Long id) {
        Optional<Admin> user = adminService.getUserById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "GetAllAdminDetails")
    public List<Admin> getAllUsers() {
        return adminService.getAllUsers();
    }

    @DeleteMapping("DeleteAdminDetailsById/{id}")
    public void deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
    }
}

