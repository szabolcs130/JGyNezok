package com.example.JGyNezok.ezeklehetfeleslegesekvoltak;
import com.example.JGyNezok.Nezo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NezoService {

    @Autowired
    private NezoRepository nezoRepository;

    public List<Nezo> getAllNezo() {
        return nezoRepository.findAll();
    }
}
