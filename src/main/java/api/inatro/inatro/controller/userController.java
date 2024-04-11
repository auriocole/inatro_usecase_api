package api.inatro.inatro.controller;

import api.inatro.inatro.model.user.user;
import api.inatro.inatro.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")
public class userController {

    @Autowired
    private userService us;

    @GetMapping("/listar")
    public Iterable<user> listar(){
        return us.listar();
    }
    
}
