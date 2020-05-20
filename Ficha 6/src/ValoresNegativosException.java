public class ValoresNegativosException extends Exception{

    public ValoresNegativosException(int nr){
        super(String.valueOf(nr));
    }
}
