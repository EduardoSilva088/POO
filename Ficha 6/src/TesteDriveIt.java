import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TesteDriveIt {
    public static void main(String[] args){

        Veiculo a = new VeiculoNormal("1","Volks","Rs 106",2010,130,7.6,7.5,140,5);
        Veiculo b = new VeiculoNormal("2","Peugeot","C",2012,90,6.2,1,1000,1);
        Veiculo c = new VeiculoNormal("3","Lambo","B",2018,290,31,10,50,1);
        Veiculo d = new VeiculoNormal("4","Merce","A",2013,125,10,8,61,7);
        Veiculo e = new VeiculoNormal("5","Volks","Rs Gt 900", 2012,145,8,9,130,7);

        VeiculoOcasiao o = new VeiculoOcasiao("6","Ferrari","Rs Gt 900", 2012,145,8,9,130,7,false);
        VeiculoOcasiao p = new VeiculoOcasiao("7","McLaren","Rs Gt 900", 2012,145,10,9,130,7,false);
        VeiculoOcasiao l = new VeiculoOcasiao("8","McLaren","Rs Gt 900a", 2012,145,5,9,30,7,false);

        AutocarroInteligente at1 = new AutocarroInteligente("9","Volvo","b",2000,50,30,5.4,3500,50,0.7);
        AutocarroInteligente at2 = new AutocarroInteligente("10","Volvo","a",2000,50,100,5.4,90000,50,0.3);




        DriveIt a1 = new DriveIt();



        a1.adiciona(a);
        a1.adiciona(b);
        a1.adiciona(c);
        a1.adiciona(d);
        a1.adiciona(e);


        a1.adiciona(o);
        a1.adiciona(p);
        a1.adiciona(l);
        a1.adiciona(at1);
        a1.adiciona(at2);


        System.out.println("DriveIt 1: ");
        System.out.println(a1.toString());

        a1.alteraPromocao(true);

        System.out.println("Ordenado Lista: ");
        System.out.println(a1.ordenarVeiculosLista());

        System.out.println("Ordenado Set: ");
        System.out.println(a1.ordenarVeiculos());

        System.out.println("Menos utilizado: " + a1.veiculoMenosUtilizado());
        System.out.println("Mais barato: " + a1.veiculoMaisBarato());
        System.out.println("Preço médio: " + a1.valorMedioKmBus());


        System.out.println("\nOrdenado Kms: ");
        a1.addCriterio("kms",new ComparatorKms());
        Iterator<Veiculo> it1 = a1.ordenarVeiculos("kms");
        while (it1.hasNext()) {
            Veiculo v = it1.next();
            System.out.print(v);
        }

        System.out.println("\nOrdenado VelMedia");
        a1.addCriterio("VelMediaDecre",new ComparatorVelMed());
        Iterator<Veiculo> it2 = a1.ordenarVeiculos("VelMediaDecre");
        while (it2.hasNext()) {
            Veiculo v = it2.next();
            System.out.print(v);
        }


/*
        //i
        System.out.println(a1.existeVeiculo("1"));
        System.out.println("----------");

        //ii
        System.out.println(a1.quantos());
        System.out.println("----------");

        //iii
        System.out.println(a1.quantos("Volks"));
        System.out.println("----------");

        //iv
        System.out.println(a1.getVeiculo("2").toString());
        System.out.println("----------");

        //v
        //Testada em cima

        //vi
        System.out.println(a1.getVeiculos().toString());
        System.out.println("----------");

        //vii
        a1.registarAluguer("1",300);
        System.out.println(a1.getVeiculo("1").toString());
        System.out.println("----------");

        //viii
        a1.classificarVeiculo("2",5);
        System.out.println(a1.getVeiculo("2").toString());
        System.out.println("----------");

        //ix
        System.out.println(a1.custoRealKm("3"));
*/

    }
}
