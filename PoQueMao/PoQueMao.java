import java.util.*;

class PoQueMao {
    List<Integer> numDocesEvolucao = new ArrayList<Integer>();

    int comparar(int numDoces) {
        int numEvolucoes = 0, i = 0;
        while (i < numDocesEvolucao.size() && numDoces - numDocesEvolucao.get(i) >= 0) {
            numDoces -= numDocesEvolucao.get(i++);
            numEvolucoes++;
        }
        return numEvolucoes;
    }

    public static void main(String[] args) {
        PoQueMao pqm = new PoQueMao();
        int numDoces = MyIO.readInt();
        int x = MyIO.readInt();
        int y = MyIO.readInt();
        int z = MyIO.readInt();

        pqm.numDocesEvolucao.add(x);
        pqm.numDocesEvolucao.add(y);
        pqm.numDocesEvolucao.add(z);
        Collections.sort(pqm.numDocesEvolucao);

        int numEvolucoes = pqm.comparar(numDoces);

        System.out.println(numEvolucoes);
    }
}