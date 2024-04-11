package api.inatro.inatro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.inatro.inatro.model.vehicle.responseVehicle;
import api.inatro.inatro.model.vehicle.vehicle;
import api.inatro.inatro.repository.vehicleRepository;

@Service
public class vehicleService {

    @Autowired
    private vehicleRepository vr;

    @Autowired
    private responseVehicle mensagem;

    public Iterable<vehicle> listar(){
        return vr.findAll();
    }
    
    public ResponseEntity<?> adicionar(vehicle v){     
        if (v.getMatricula().equals("")) {
            mensagem.setMensagem("INSIRA A MATRICULA!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.BAD_REQUEST); 
        }else if (v.getProprietario().equals("")) {
            mensagem.setMensagem("INSIRA O PROPRIETARIO!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.BAD_REQUEST); 
        }else if (v.getMarca().equals("")) {
            mensagem.setMensagem("INSIRA A MARCA!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.BAD_REQUEST); 
        }else if (v.getModelo().equals("")) {
            mensagem.setMensagem("INSIRA O MODELO!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.BAD_REQUEST); 
        }else if (v.getAno().equals("")) {
            mensagem.setMensagem("INSIRA O ANO!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.BAD_REQUEST); 
        }else if (v.getCor().equals("")) {
            mensagem.setMensagem("INSIRA A COR!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (v.getEstadoMatricula().equals("")) {
            mensagem.setMensagem("INSIRA O ESTADO DA MATRICULA!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            vr.save(v);
            mensagem.setMensagem("VEICULO ADICIONADO COM SUCCESSO!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> atualizar(vehicle v){     
        Optional<vehicle> existingVehicle = vr.findById(v.getId());

        if (existingVehicle.isPresent()) {
            vehicle updatedVehicle = existingVehicle.get();
            updatedVehicle.setMatricula(v.getMatricula());
            updatedVehicle.setProprietario(v.getProprietario());
            updatedVehicle.setMarca(v.getMarca());
            updatedVehicle.setModelo(v.getModelo());
            updatedVehicle.setAno(v.getAno());
            updatedVehicle.setCor(v.getCor());
            updatedVehicle.setEstadoMatricula(v.getEstadoMatricula());

            vr.save(updatedVehicle);
            mensagem.setMensagem("VEICULO ATUALIZADO COM SUCESSO!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.OK);
        } else {
            mensagem.setMensagem("VEICULO NAO ENCONTRADO!");
            return new ResponseEntity<responseVehicle>(mensagem, HttpStatus.NOT_FOUND);
        }
    }
}
