import java.util.*;

//pendente
class palavrasDuplicadas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeroDeLinhas = scan.nextInt();
        System.out.println(numeroDeLinhas);
        List<String> lista = new LinkedList<>();
        while (scan.hasNextLine()) {
            lista.add(scan.nextLine());
        }
        Set<String> set = new LinkedHashSet<>();
        set.addAll(lista);
        System.out.println(set);
    }
}