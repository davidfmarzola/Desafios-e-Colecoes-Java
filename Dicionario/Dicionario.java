import java.io.*;
import java.util.*;

class Dicionario {

    // metodo incompleto
    void removerDuplicatas(ArrayList<String> listaDeStrings) throws Exception {
        Set<String> set = new HashSet<>(listaDeStrings);
        listaDeStrings.clear();
        listaDeStrings.addAll(set);
        List<String> sortedList = new ArrayList(set);
        Collections.sort(sortedList);
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new FileReader("pub.in")).useDelimiter("\\n");
        Dicionario dc = new Dicionario();
        ArrayList<String> listaDePalavras = new ArrayList<String>();
        ArrayList<String> listaDeStrings = new ArrayList<String>();
        String[] vetor = new String[10];
        String[] output = new String[] {};

        while (scanner.hasNextLine()) {
            listaDePalavras.add(scanner.nextLine());
        }
        Collections.sort(listaDePalavras);
        // usando vetor, pois não tem como usar split, nem replace numa lista
        for (int i = 0; i < listaDePalavras.size(); i++) {
            vetor[i] = listaDePalavras.get(i);
            vetor[i] = vetor[i].replace("\"", "");
            vetor[i] = vetor[i].replace("*", "");
            vetor[i] = vetor[i].replace(".", "");
            vetor[i] = vetor[i].replace("#", "");
            vetor[i] = vetor[i].replace(":", "");
            vetor[i] = vetor[i].replace("(", "");
            vetor[i] = vetor[i].replace("$", "");
            vetor[i] = vetor[i].toLowerCase();
            output = vetor[i].split(" ");
            for (int j = 0; j < output.length; j++)
                listaDeStrings.add(output[j]);// lista com duplicatas
        }
        Collections.sort(listaDeStrings);
        dc.removerDuplicatas(listaDeStrings);

    }
}
