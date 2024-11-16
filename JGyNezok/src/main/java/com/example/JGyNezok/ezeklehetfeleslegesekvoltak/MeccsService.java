package com.example.JGyNezok.ezeklehetfeleslegesekvoltak;
import com.example.JGyNezok.Meccs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MeccsService {

    @Autowired
    private MeccsRepository meccsRepository;

    public List<Meccs> getAllMeccsek() {
        return meccsRepository.findAll();
    }
}
