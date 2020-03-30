package d;

import java.util.Scanner;

public class dddd {
    public static void main (String args[]) {
        Boolean a1 = true;
        while (a1==true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите интервал:");
            String type = in.next();
            OpredChisel chislo = new OpredChisel();
            Ugad ch = new Ugad();
            chislo.chisla = type;
            chislo.Preobraz();
            int a=0;
            ch.ugad();
            System.out.println("Вы загадали число "+ch.rand+"? В случае правильного ответа введите 'Да', иначе введите '>' или '<'");
            while ((type.equals("Да")) != true) {
                type = in.next();
                if (type.equals(">")) {
                    ch.bol();
                    System.out.println("Вы загадали число " + ch.rand + "? В случае правильного ответа введите 'Да', иначе введите '>' или '<'");
                }
                if (type.equals("<")) {
                    ch.men();
                    System.out.println("Вы загадали число " + ch.rand + "? В случае правильного ответа введите 'Да', иначе введите '>' или '<'");
                }
                a++;
            }
            System.out.println("Ура! Количество итераций поиска составило - " + a + " Сыграем еще раз? Введите 'да' или 'нет'");
            type = in.next();
            if (type.equals("нет")){
                a1=false;
            }
        }
    }
}
class OpredChisel{
    String chisla;
    String a="";
    private int b;
    String c="";
    static int ch1;
    static int ch2;
    void Preobraz() {
        for (int i = 0; i < chisla.length(); i++) {
            if (chisla.charAt(i)!='-'){
                a =a+ chisla.charAt(i);
            }else {
                b=i+1;
                break;
            }
        }
        ch1 = Integer.valueOf(a);
        for (int i = b; i < chisla.length(); i++) {
            c = c + chisla.charAt(i);
        }
        ch2 = Integer.valueOf(c);
    }
}
//class Ugad{                          //ТАКОЙ СЕБЕ МЕТОД УГАДЫВАНИЯ, НО НА НЕГО БЫЛА НАДЕЖДА, ЗАЧЕМ ТЫ МЕНЯ ПОДВЕЛ БРАТ
//    private int min;
//    private int max;
//    static int rand;
//    void ugad(){
//        max=OpredChisel.ch2;
//        min=OpredChisel.ch1;
//        rand= (int) (Math.random() * ((max-min)+1)) + min;
//        System.out.println(min+" "+max+" "+rand);
//    }
//    void bol(){
//        min=Ugad.rand;
//        System.out.println(min+" "+max+" "+rand);
//        rand= (int) (Math.random() * ((max-min)+1)) + min;
//    }
//    void men(){
//        max=Ugad.rand;
//        System.out.println(min+" "+max+" "+rand);
//        rand= (int) (Math.random() * ((max-min)+1)) + min;
//    }
//}
class Ugad{
    private int low;
    private int high;
    static int rand;
    void ugad(){
        high=OpredChisel.ch2;
        low=OpredChisel.ch1;
        rand = (low + high) / 2;
    }
    void bol(){
        high=OpredChisel.ch2;
        low=rand+1;
        rand = (low + high) / 2;
    }
    void men(){
        high=rand-1;
        low=OpredChisel.ch1;
        rand = (low + high) / 2;
    }
}
