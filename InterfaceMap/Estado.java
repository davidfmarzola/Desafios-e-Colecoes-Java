//package br.com.dio.collection.map;
/*Dada a população estimada de alguns estados do NE brasileiro, faça:
        Estado = PE - População = 9.616.621
        Estado = AL - População = 3.351.543
        Estado = CE - População = 9.187.103
        Estado = RN - População = 3.534.265
*/

import java.util.*;

class Estado {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações");
        Map<String, Integer> estadosHash = new HashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };
        System.out.println(estadosHash); // ordem aleatória

        System.out.println("Substitua a população do estado do RN por 3.534.165;");
        estadosHash.put("RN", 3534165);
        System.out.println(estadosHash);

        System.out.println("Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277;");
        if (!estadosHash.containsKey("PB")) {
            estadosHash.put("PB", 4039277);
        }
        System.out.println(estadosHash);

        System.out.println("Exiba a população PE: " + estadosHash.get("PE"));

        System.out.println("Exiba todos os estados e suas populações na ordem que foi informado");
        Map<String, Integer> estadosLinked = new LinkedHashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
                put("PB", 4039277);
            }
        };// ordem de inserção
        System.out.println(estadosLinked);

        System.out.println("Exiba os estados e suas populações em ordem alfabética");
        Map<String, Integer> estadosTree = new TreeMap<>(estadosLinked); // ordem natural
        System.out.println(estadosTree.toString());
        // }

        Collection<Integer> e1 = estadosTree.values();// população
        Set<Map.Entry<String, Integer>> entries2 = estadosTree.entrySet();// conjunto (set) dos mesmos elementos
                                                                          // (entries) contidos no mapa (map)
        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";

        for (Map.Entry<String, Integer> entry : entries2) {
            if (entry.getValue().equals(Collections.max(e1))) {
                estadoMaiorPopulacao = entry.getKey();
                System.out.printf("Exiba o estado com a maior população(%s) e sua quantidade(%d)",
                        estadoMaiorPopulacao, Collections.max(e1));
                System.out.println();
            } else if (entry.getValue().equals(Collections.min(e1))) {
                estadoMenorPopulacao = entry.getKey();
                System.out.printf("Estado com a menor população(%s) e sua quantidade(%d)", estadoMenorPopulacao,
                        Collections.min(e1));
                System.out.println();

            }
        }

        Iterator<Integer> iterator = estadosTree.values().iterator();
        Integer soma = 0;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da população desses estados: " + soma);

        System.out.println("Exiba a média da população deste dicionário de estados: " + soma / estadosTree.size());

        System.out.println("Remova os estados com a população menor que 4.000.000");
        Iterator<Integer> iterator1 = estadosTree.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() < 4000000)
                iterator1.remove();
        }
        System.out.println(estadosTree);

        System.out.println("Apague o dicionário de estados");
        estadosTree.clear();
        System.out.println(estadosTree);

        System.out.println("Confira se o dicionário está vazio: " + estadosTree.isEmpty());

    }

}
