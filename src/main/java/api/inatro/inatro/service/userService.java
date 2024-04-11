package api.inatro.inatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.inatro.inatro.model.user.user;
import api.inatro.inatro.repository.userRepository;

@Service
public class userService {

    @Autowired
    private userRepository ur;

    // Metodo para listar todos os usuarios
    public Iterable<user> listar(){
        return ur.findAll();
    }
    
}
