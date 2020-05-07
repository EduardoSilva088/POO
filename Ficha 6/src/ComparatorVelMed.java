import java.util.Comparator;

public class ComparatorVelMed implements Comparator<Veiculo> {
    public int compare(Veiculo v1, Veiculo v2){
        if(v1.getVelMed() < v2.getVelMed()) return -1;
        if(v1.getVelMed() > v2.getVelMed()) return 1;
        return v1.compareTo(v2);
    }
}
