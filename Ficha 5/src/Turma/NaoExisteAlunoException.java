package Turma;

public class NaoExisteAlunoException extends Exception{

    public NaoExisteAlunoException(){
        super();
    }

    public NaoExisteAlunoException(String cod){
        super(cod);
    }
}
