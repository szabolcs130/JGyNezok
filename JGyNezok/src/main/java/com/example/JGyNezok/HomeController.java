package com.example.JGyNezok;

import com.example.JGyNezok.ezeklehetfeleslegesekvoltak.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    //kapcsolat oldal : 11.23.
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/kapcsolat")
    public String kapcsolat(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = (authentication != null && authentication.isAuthenticated()) ? authentication.getName() : "Vendég";

        Message messageForm = new Message();
        messageForm.setName(name);

        model.addAttribute("messageForm", messageForm);
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat_feldolgoz")
    public String kapcsolatFeldolgoz(@ModelAttribute Message message, Model model) {
        try{
        messageRepository.save(message);
        model.addAttribute("successMessage", "Üzenet sikeresen elküldve");
        return "message_success";
        }
        catch(Exception e){
            return "message_error";
        }
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
