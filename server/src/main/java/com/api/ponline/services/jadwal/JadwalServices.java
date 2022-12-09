package com.api.ponline.services.jadwal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ponline.model.Entity.jadwal.Jadwal;
import com.api.ponline.model.repository.jadwal.JadwalRepo;

@Service
@Transactional
public class JadwalServices{
    
    @Autowired
    private JadwalRepo jadwalRepo;

    public Jadwal save(Jadwal jadwal) {
        return jadwalRepo.save(jadwal);
    }

    public Jadwal findOne(Long id) {
        return jadwalRepo.findById(id).get();
    }

    public Iterable<Jadwal> findAll() {
        return jadwalRepo.findAll();
    }
}
