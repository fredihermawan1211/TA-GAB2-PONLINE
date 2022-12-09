package com.api.ponline.controllers.jadwal;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ponline.dao.Request.JadwalRequest;
import com.api.ponline.dao.Response.AbstractResponse;
import com.api.ponline.model.Entity.jadwal.Jadwal;
import com.api.ponline.services.jadwal.JadwalServices;

@RestController
@RequestMapping("/jadwal")
public class JadwalController {

    @Autowired
    private JadwalServices jadwalServices;
    
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<AbstractResponse<Jadwal>> create(@Valid @RequestBody JadwalRequest jadwalRequest, Errors errors ) {
    
        AbstractResponse<Jadwal> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setSuccess(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Jadwal jadwal = modelMapper.map(jadwalRequest, Jadwal.class);
        responseData.setSuccess(true);
        responseData.setPayLoad(jadwalServices.save(jadwal));
        return ResponseEntity.ok(responseData);       

    }

    @PutMapping
    public ResponseEntity<AbstractResponse<Jadwal>> update(@Valid @RequestBody JadwalRequest jadwalRequest, Errors errors ) {
    
        AbstractResponse<Jadwal> responseData = new AbstractResponse<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setSuccess(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Jadwal jadwal = modelMapper.map(jadwalRequest, Jadwal.class);
        responseData.setSuccess(true);
        responseData.setPayLoad(jadwalServices.save(jadwal));
        return ResponseEntity.ok(responseData);       

    }

    @GetMapping
    public Iterable<Jadwal> findAll() {
        return jadwalServices.findAll();
    }
    
}
