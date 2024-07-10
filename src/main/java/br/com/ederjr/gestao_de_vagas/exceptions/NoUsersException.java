package br.com.ederjr.gestao_de_vagas.exceptions;

public class NoUsersException extends RuntimeException {

    public NoUsersException() {
        super("Nenhum usuário encontrado.");
    }
}
