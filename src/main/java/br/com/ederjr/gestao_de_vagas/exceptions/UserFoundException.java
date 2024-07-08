package br.com.ederjr.gestao_de_vagas.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("Usuário já existe");
    }
}
