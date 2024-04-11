package api.inatro.inatro.model.user.userDTO;

import api.inatro.inatro.model.user.userRole;

public record RegisterDTO(String bi, String nome, String telefone, String email, String senha, userRole role) {

}
