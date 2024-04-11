package api.inatro.inatro.model.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "vehicles")
@Table(name = "vehicles")
@Getter
@Setter
public class vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String proprietario;
    private String marca; 
    private String modelo;
    private String ano;
    private String cor;
    private String estadoMatricula;
    
}
