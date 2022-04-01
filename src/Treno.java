import java.util.Random;
public class Treno extends Thread{

    /* == CLASSI UTILIZZATE == */

    private Random R = new Random();

    /* == ATTRIBUTI PRIVATI == */

    protected int N_treno;
    protected double Tratta = R.nextInt(8000)+1000; /* 1000-9000 */
    protected double Vagoni = R.nextInt(5)+5; /* 5-10 */
    protected double Passeggeri=100;
    protected double Num_PasseggeriTrasportati=100;

    /* == COSTRUTTORI == */

    public Treno(int n){ this.N_treno=n; }

    /* == METODI PRIVATI == */

    protected void Percorrere(){
        double percentuale_riduzione_tratta = ((Vagoni*Tratta)/250)/100; /* Calcolo della percentuale per la riduzione della tratta. */

        Tratta-=Tratta*percentuale_riduzione_tratta;

        Tratta--;

        /* Verifico se la Tratta è andata in negativo. */
        if(Tratta<0)
            Tratta=0;

        if(Tratta==0){
            Arrivo();
        }
    }

    protected void Salita_Passeggeri(){
        int num_passeggeri_saliti = R.nextInt(20)+10; /* 10-30 */
        Passeggeri+=num_passeggeri_saliti;
        /* Mi salvo che questi passeggeri sono saliti */
        Num_PasseggeriTrasportati+=num_passeggeri_saliti;
    }

    protected void Discesa_Passeggeri(){
        /* Qui è necessario verificare
        *  se il numero casuale è maggiore
        *  del numero di passeggeri,
        *  non vogliamo rischiare di fare
        *  andare i passeggeri in negativo. */

        if(Passeggeri>0){
            int Passeggeri_da_far_uscire = R.nextInt(20)+10; /* 10-30 */
            if(Passeggeri_da_far_uscire < Passeggeri){
                Passeggeri-=Passeggeri_da_far_uscire;
            }
        }
    }
    public void Arrivo(){ /* Questo metodo viene richiamato da Percorrere() quando la Tratta diventa 0. */

        Passeggeri = 0; /* Scendono tutti i passeggeri. */


    }


    /* == METODI PUBBLICI == */
    @Override
    public void run(){

        while(Tratta>0){
                if(R.nextBoolean())
                    this.Salita_Passeggeri();
                if(R.nextBoolean())
                    this.Discesa_Passeggeri();
                Percorrere();

        }
        System.out.println("Treno N."+N_treno+" Passeggeri trasportati: "+Num_PasseggeriTrasportati);
    }


}
