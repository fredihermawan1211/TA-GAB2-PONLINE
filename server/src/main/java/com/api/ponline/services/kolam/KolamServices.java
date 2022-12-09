package com.api.ponline.services.kolam;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ponline.model.Entity.kolam.Kolam;
import com.api.ponline.model.repository.kolam.KolamRepo;

@Service
@Transactional
public class KolamServices{
    
    @Autowired
    private KolamRepo kolamRepo;

    public Kolam save(Kolam kolam) {
        return kolamRepo.save(kolam);
    }

    public Kolam findOne(Long id) {
        return kolamRepo.findById(id).get();
    }

    public Iterable<Kolam> findAll() {
        return kolamRepo.findAll();
    }

    public Boolean deleteById(Long id) {
        if (isExist(id)) {
            kolamRepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Boolean isExist(Long id) {
        Kolam kolam = findOne(id);
        if (kolam!=null) {
            return true;
        }else{
            return false;
        }
    }
}
