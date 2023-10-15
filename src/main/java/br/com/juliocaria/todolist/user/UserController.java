package br.com.juliocaria.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/* Modificadores de Acesso
* public - Acesso Geral
* private - Acesso um pouco mais restrito ao código e as informações
* protected - Só tem acesso quando está presente na mesma estrutura de pacote
*/

@RestController
@RequestMapping("/users")
public class UserController {

  /**
   * Tipos de Retorno:
   * String (Texto)
   * Integer (int) - Números inteiros
   * Double Números 0.0000
   * Float - 0.000
   * char (A C) - Um único caracter
   * Date (Data)
   * void
   */

  @Autowired
  private IUserRepository userRepository;

  @PostMapping("/create")
  public ResponseEntity create(@RequestBody UserModel userModel) {
    var user = this.userRepository.findByUsername(userModel.getUsername());

    if (user != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USUÁRIO JÁ CADASTRADO NO SISTEMA");
    }

    var passwordHashed = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

    userModel.setPassword(passwordHashed);

    var userCreated = this.userRepository.save(userModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
  }
}
