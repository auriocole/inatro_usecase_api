package api.inatro.inatro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.inatro.inatro.model.userModel.responseUserModel;
import api.inatro.inatro.model.userModel.userModel;
import api.inatro.inatro.repository.userRepository;

@Service
public class userService {

    @Autowired
    private userRepository ur;

    @Autowired
    private responseUserModel rum;

    // metodo para cadastrar usuarios
    public ResponseEntity<?> cadastrar(userModel um){

        if (um.getBi().equals("")) {
            rum.setMessage("O número de BI é obrigatório!");
            return new ResponseEntity<responseUserModel>(rum, HttpStatus.BAD_REQUEST);
        } else if (um.getNome().equals("")){
            rum.setMessage("O nome é obrigatório!");
            return new ResponseEntity<responseUserModel>(rum, HttpStatus.BAD_REQUEST);
         }else if (um.getTelefone().equals("")){
            rum.setMessage("O número de telefone é obrigatório!");
            return new ResponseEntity<responseUserModel>(rum, HttpStatus.BAD_REQUEST);
        } else if (um.getEmail().equals("")){
            rum.setMessage("O email é obrigatório!");
            return new ResponseEntity<responseUserModel>(rum, HttpStatus.BAD_REQUEST);
        } else if (um.getSenha().equals("")){
            rum.setMessage("A senha é obrigatória!");
            return new ResponseEntity<responseUserModel>(rum, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<userModel>(ur.save(um), HttpStatus.OK);
        }
    }
    
}
