package com.reserved.web.controller;

import com.reserved.domain.Reserve;
import com.reserved.domain.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserve")
public class ReserveController {
    @Autowired
    ReserveService reserveService;

    @GetMapping("/all")
    public List<Reserve> getAll(){
        return reserveService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reserve> getReserve(@PathVariable("id") int reserveId){
        return reserveService.getReserve(reserveId);
    }

    @PostMapping("/save")
    public Reserve save(Reserve reserve){
        return reserveService.save(reserve);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int reserveId){
        return reserveService.delete(reserveId);
    }
}
