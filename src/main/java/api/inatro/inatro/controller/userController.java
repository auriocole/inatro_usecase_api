package api.inatro.inatro.controller;

import org.springframework.web.bind.annotation.RestController;

import api.inatro.inatro.model.userModel.userModel;
import api.inatro.inatro.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class userController {

    @Autowired
    private userService us;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody userModel um){
        return us.cadastrar(um);
    }

    @GetMapping("/")
    public String rota(){
        return "Inatro API";
    }
    
}
