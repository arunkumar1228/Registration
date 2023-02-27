package com.example.security.Admin.service;


import com.example.security.Admin.entity.Admin;
import com.example.security.Admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public Admin saveUser(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> getUserById(Long id) {
        return adminRepository.findById(id);
    }

    public List<Admin> getAllUsers() {
        return adminRepository.findAll();
    }

    public void deleteUser(Long id) {
        adminRepository.deleteById(id);
    }
}
