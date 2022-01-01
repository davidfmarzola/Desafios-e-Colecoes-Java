import java.util.*;

class QuadroMedalhas {
    private String pais;
    private int qtdOuro;
    private int qtdPrata;
    private int qtdBronze;

    public QuadroMedalhas() {
        pais = "";
        qtdOuro = 0;
        qtdPrata = 0;
        qtdBronze = 0;
    }

    public QuadroMedalhas(String pais, int qtdOuro, int qtdPrata, int qtdBronze) {
        this.pais = pais;
        this.qtdOuro = qtdOuro;
        this.qtdPrata = qtdPrata;
        this.qtdBronze = qtdBronze;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getQtdOuro() {
        return qtdOuro;
    }

    public void setQtdOuro(int qtdOuro) {
        this.qtdOuro = qtdOuro;
    }

    public int getQtdPrata() {
        return qtdPrata;
    }

    public void setQtdPrata(int qtdPrata) {
        this.qtdPrata = qtdPrata;
    }

    public int getQtdBronze() {
        return qtdBronze;
    }

    public void setQtdBronze(int qtdBronze) {
        this.qtdBronze = qtdBronze;
    }

    void imprimir(QuadroMedalhas[] q) {
        for (int i = 0; i < q.length; i++) {
            System.out.println(
                    q[i].getPais() + " " + q[i].getQtdOuro() + " " + q[i].getQtdPrata() + " " + q[i].getQtdBronze());
        }
    }

    void swap(int a, int b, QuadroMedalhas[] vetMedalhas) {
        QuadroMedalhas temp = vetMedalhas[a];
        vetMedalhas[a] = vetMedalhas[b];
        vetMedalhas[b] = temp;
    }

    boolean comparar2(int j, QuadroMedalhas pivo, QuadroMedalhas[] vetMedalhas) {
        // ordenação decrescente
        while (vetMedalhas[j].getQtdOuro() < pivo.getQtdOuro() || (vetMedalhas[j].getQtdOuro() == pivo.getQtdOuro() &&
                vetMedalhas[j].getQtdPrata() < pivo.getQtdPrata()) ||
                (vetMedalhas[j].getQtdOuro() == pivo.getQtdOuro() &&
                        vetMedalhas[j].getQtdPrata() == pivo.getQtdPrata()
                        && vetMedalhas[j].getQtdBronze() < pivo.getQtdBronze())
                || (vetMedalhas[j].getQtdOuro() == pivo.getQtdOuro() &&
                        vetMedalhas[j].getQtdPrata() == pivo.getQtdPrata()
                        && vetMedalhas[j].getQtdBronze() == pivo.getQtdBronze() &&
                        vetMedalhas[j].getPais().compareTo(pivo.getPais()) > 0)) {
            return true;
        }
        return false;
    }

    boolean comparar1(int i, QuadroMedalhas pivo, QuadroMedalhas[] vetMedalhas) {
        // ordenação decrescente
        while (vetMedalhas[i].getQtdOuro() > pivo.getQtdOuro() || (vetMedalhas[i].getQtdOuro() == pivo.getQtdOuro() &&
                vetMedalhas[i].getQtdPrata() > pivo.getQtdPrata()) ||
                (vetMedalhas[i].getQtdOuro() == pivo.getQtdOuro() &&
                        vetMedalhas[i].getQtdPrata() == pivo.getQtdPrata()
                        && vetMedalhas[i].getQtdBronze() > pivo.getQtdBronze())
                || (vetMedalhas[i].getQtdOuro() == pivo.getQtdOuro() &&
                        vetMedalhas[i].getQtdPrata() == pivo.getQtdPrata()
                        && vetMedalhas[i].getQtdBronze() == pivo.getQtdBronze()
                        && vetMedalhas[i].getPais().compareTo(pivo.getPais()) < 0)) {
            return true;
        }
        return false;
    }

    QuadroMedalhas[] quicksort(int esq, int dir, QuadroMedalhas[] vetMedalhas) {
        int i = esq, j = dir;
        QuadroMedalhas pivo = vetMedalhas[(dir + esq) / 2];
        // ordenação decrescente
        while (i <= j) {
            while (comparar1(i, j, pivo, vetMedalhas))
                i++;
            while (comparar2(i, j, pivo, vetMedalhas))
                j--;
            if (i <= j) {
                swap(i, j, vetMedalhas);
                i++;
                j--;
            }
        }
        if (esq < j)
            quicksort(esq, j, vetMedalhas);
        if (i < dir)
            quicksort(i, dir, vetMedalhas);
        return vetMedalhas;
    }

    void tratamentoDeDados(String[] vetorTratado) {
        this.setPais(vetorTratado[0]);
        this.setQtdOuro(Integer.parseInt(vetorTratado[1]));
        this.setQtdPrata(Integer.parseInt(vetorTratado[2]));
        this.setQtdBronze(Integer.parseInt(vetorTratado[3]));
    }

    public static void main(String[] args) throws Exception {
        int numPaises = MyIO.readInt(), i = 0;
        QuadroMedalhas q = new QuadroMedalhas();
        QuadroMedalhas[] vetMedalhas = new QuadroMedalhas[numPaises];
        String linha = "";
        String[] vetorTratado = new String[4];
        List<QuadroMedalhas> paises = new ArrayList<QuadroMedalhas>();

        while (i < numPaises) {
            linha = MyIO.readLine();
            vetMedalhas[i] = new QuadroMedalhas();
            vetorTratado = linha.split(" ");
            vetMedalhas[i].tratamentoDeDados(vetorTratado);
            i++;
        }

        q.imprimir(q.quicksort(0, vetMedalhas.length - 1, vetMedalhas));
        // q.imprimir(q);
    }
}