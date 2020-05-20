package Turma;

public class ExisteAlunoException extends Exception {

    public ExisteAlunoException(){
        super();
    }

    public ExisteAlunoException(String nr){
        super(nr);
    }
}
