import java.util.*;

class CoresArcoIris {
    public static void main(String[] args) {
        System.out.println("Crie uma conjunto contendo as cores do arco-íris: ");
        Set<String> minhasCores = new HashSet<>();
        minhasCores.add("Violeta");
        minhasCores.add("Anil");
        minhasCores.add("Azul");
        minhasCores.add("Verde");
        minhasCores.add("Amarelo");
        minhasCores.add("Laranja");
        minhasCores.add("Vermelho");
        System.out.println(minhasCores);// ordem aleatoria

        System.out.println("Quantidade de cores que o arco-íris tem");
        System.out.println(minhasCores.size());

        System.out.println("Exiba as cores em ordem alfabética");
        Set<String> minhasCores2 = new TreeSet<>();
        minhasCores2.addAll(minhasCores);
        System.out.println(minhasCores2);// ordem alfabética

        System.out.println("Exiba as cores na ordem inversa da que foi informada");
        Set<String> minhasCores3 = new LinkedHashSet<>(
                Arrays.asList("Violeta", "Anil", "Azul", "Verde", "Amarelo", "Laranja", "Vermelho"));
        List<String> lista = new ArrayList<>(minhasCores3);
        Collections.reverse(lista);
        System.out.println(lista);

        System.out.println("Exiba todas as cores que começam com a letra \"v\"");
        for (String cor : minhasCores) {
            if (cor.startsWith("V"))
                System.out.println(cor);
        }

        System.out.println("Remova todas as cores que não começam com a letra \"v\"");
        Iterator<String> iterator = minhasCores.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().startsWith("V"))
                iterator.remove();
        }
        System.out.println(minhasCores);

        System.out.println("Limpe o conjunto");
        minhasCores.clear();

        System.out.println("Confira se o conjunto está vazio");
        String vazio = minhasCores.isEmpty() ? "Lista vazia" : "lista não está vazia";
        System.out.println(vazio);
    }

}