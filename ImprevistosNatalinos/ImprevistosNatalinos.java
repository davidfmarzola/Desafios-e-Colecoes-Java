import java.io.IOException;
import java.util.Scanner;
 
public class URI  {
 
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int numAlunos = leitor.nextInt();
        int numPc = leitor.nextInt()-1;//um é do professor 
        int qtsPcsQuebrados = leitor.nextInt();
        int qtsPcsSemComp = leitor.nextInt();
        int qtsPcsDisponiveisParaAluno = numPc-(qtsPcsQuebrados+qtsPcsSemComp);
        if(qtsPcsDisponiveisParaAluno >= numAlunos) 
            System.out.println("Igor feliz!");
         else 
            if (qtsPcsDisponiveisParaAluno < numAlunos && qtsPcsSemComp>qtsPcsQuebrados)
                System.out.println("Igor bolado!");
            else
                System.out.println("Caio, a culpa eh sua!");
    }
   
}
