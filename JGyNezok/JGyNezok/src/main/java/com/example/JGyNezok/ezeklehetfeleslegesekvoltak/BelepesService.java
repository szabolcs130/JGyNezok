package com.example.JGyNezok.ezeklehetfeleslegesekvoltak;

import com.example.JGyNezok.Belepes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BelepesService {

    @Autowired
    private BelepesRepository belepesRepository;

    public List<Belepes> getAllBelepes() {
        return belepesRepository.findAll();
    }
}
