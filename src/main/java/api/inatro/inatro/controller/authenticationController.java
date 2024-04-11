package api.inatro.inatro.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.inatro.inatro.model.user.user;
import api.inatro.inatro.model.user.userDTO.RegisterDTO;
import api.inatro.inatro.model.user.userDTO.authenticationDTO;
import api.inatro.inatro.repository.userRepository;

@RestController
@RequestMapping("auth")
public class authenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private userRepository ur;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid authenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.bi(), data.senha());
        this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data){
        if (this.ur.findByBi(data.bi()) != null) {
            return ResponseEntity.badRequest().build();
        } else {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
            user newUser = new user(data.bi(), data.nome(), data.telefone(), data.email(), encryptedPassword, data.role());
            this.ur.save(newUser);
            return ResponseEntity.ok().build();
        }

    }
    
}
