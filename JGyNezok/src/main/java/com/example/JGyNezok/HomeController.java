package com.example.JGyNezok;

import com.example.JGyNezok.ezeklehetfeleslegesekvoltak.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MeccsRepository meccsRepository;

    @Autowired
    private NezoRepository nezoRepository;

    @Autowired
    private BelepesRepository belepesRepository;

    @GetMapping("/valaszt")
    public String showMatches(Model model) {
        List<Meccs> meccsek = meccsRepository.findAll();
        List<Nezo> nezok = nezoRepository.findAll();
        List<Belepes> belepesek = belepesRepository.findAll();

        model.addAttribute("meccsek", meccsek);
        model.addAttribute("nezok", nezok);
        model.addAttribute("belepesek", belepesek);

        return "valaszt";
    }


    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/home")
    public String user() {
        return "user";
    }
    @GetMapping("/admin/home")
    public String admin() {
        return "admin";
    }

    @GetMapping("/regisztral")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new User());
        return "regisztral";
    }

    @Autowired
    private UserRepository userRepo;
    @PostMapping("/regisztral_feldolgoz")
    public String Regisztráció(@ModelAttribute User user, Model model) {
        for(User felhasznalo2: userRepo.findAll())
            if(felhasznalo2.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "A regisztrációs email már foglalt!");
                return "reghiba";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_Vendeg");
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        return "regjo";
    }
}