import java.util.Random;

public class Main {

    public static void main(String[] args){

        Random R = new Random();
        Treno[] T = new Treno[R.nextInt(10)+5];
        for(int i=0; i<T.length;i++){
            T[i] = new Treno(i);
        }
        for (Treno treno : T) {
            treno.start();
        }
    }


}
