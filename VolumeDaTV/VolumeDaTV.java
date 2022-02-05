import java.io.IOException;
import java.util.Scanner;
 
public class DIO  {
 
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int volume = leitor.nextInt();
        int numeroTrocasDeVolume = leitor.nextInt();
        for (int i = 0; i<numeroTrocasDeVolume; i++) {
		    int numeroLido = leitor.nextInt();
    		  if(volume+numeroLido>100)
		        volume = 100;
		      else if(volume+numeroLido<0)
		        volume = 0;
          else if(volume <=100)
    	      volume += numeroLido;
	    
        }
        System.out.println(volume);
    }
 
}
