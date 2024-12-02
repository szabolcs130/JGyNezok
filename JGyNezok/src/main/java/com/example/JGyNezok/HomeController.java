package com.example.JGyNezok;

import com.example.JGyNezok.ezeklehetfeleslegesekvoltak.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    //kapcsolat oldal : 11.23.
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/messageLekerdezes")
    public String messageLekerdez(Model model) {
        List<Message> messageList = messageRepository.findAll();
        model.addAttribute("m", messageList);
        return "messageLekerdezes";
    }

    @GetMapping("/kapcsolat")
    public String kapcsolat(Model model) {

        model.addAttribute("messageForm", new Message());
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat_feldolgoz")
    public String kapcsolatFeldolgoz(@ModelAttribute("messageForm") Message message) {

        boolean isRegistered = false;

        String inputEmail = message.getEmail() != null ? message.getEmail().trim().toLowerCase() : "";

        //ez a komment emléket állít az elvesztegetett 45 percnek egy typo miatt

        for (User u: userRepo.findAll()) {
            String dbemail = u.getEmail().trim().toLowerCase();
            if (dbemail.equals(inputEmail)) {
                isRegistered = true;
                break;
            }
        }
        if(!isRegistered) {
            message.setName("Vendég");
        }
        message.setCreatedAt(LocalDateTime.now());
        messageRepository.save(message);
        return "kapcsolat";
    }

    @GetMapping("/message_error")
    public String message_error() {return "message_error";}
    @GetMapping("/message_success")
    public String message_success() {return "message_success";}

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
