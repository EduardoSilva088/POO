import java.util.Comparator;

public class ComparatorKms implements Comparator<Veiculo> {
    public int compare(Veiculo v1, Veiculo v2){
        if(v1.getNrKms() < v2.getNrKms()) return -1;
        if(v1.getNrKms() > v2.getNrKms()) return 1;
        return v1.compareTo(v2);
    }
}
