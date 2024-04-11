package api.inatro.inatro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.inatro.inatro.model.vehicle.vehicle;
import api.inatro.inatro.service.vehicleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("vehicle")
public class vehicleController {

    @Autowired
    private vehicleService vs;

    @GetMapping("/listar")
    public Iterable<vehicle> listar(){
        return vs.listar();
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionar (@RequestBody vehicle v) {
        return vs.adicionar(v);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizar (@RequestBody vehicle v) {
        return vs.atualizar(v);
    }
    
}
