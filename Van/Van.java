import java.util.*;

class Van {
    private String nomeAluno;
    private String regiao;
    private int distancia;

    public Van() {
        nomeAluno = "";
        regiao = "";
        distancia = 0;
    }

    public Van(String nomeAluno, String regiao, int distancia) {
        this.nomeAluno = nomeAluno;
        this.regiao = regiao;
        this.distancia = distancia;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String vetorTratado) {
        this.regiao = vetorTratado;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    void swap(int a, int b, Van[] vetAlunos) {
        Van temp = vetAlunos[a];
        vetAlunos[a] = vetAlunos[b];
        vetAlunos[b] = temp;
    }

    void imprimir(Van[] van) {
        for (int i = 0; i < van.length; i++) {
            System.out.println(van[i].getNomeAluno());
        }
    }

    boolean comparar2(int j, Van pivo, Van[] vetAlunos) {
        // ordenação decrescente
        while (vetAlunos[j].getDistancia() > pivo.getDistancia()
                || (vetAlunos[j].getDistancia() == pivo.getDistancia()
                        && vetAlunos[j].getRegiao().compareTo(pivo.getRegiao()) > 0)
                || (vetAlunos[j].getDistancia() == pivo.getDistancia()
                        && vetAlunos[j].getRegiao().compareTo(pivo.getRegiao()) == 0
                        && vetAlunos[j].getNomeAluno().compareTo(pivo.getNomeAluno()) > 0)) {
            return true;
        }
        return false;
    }

    boolean comparar1(int i, Van pivo, Van[] vetAlunos) {
        // ordenação decrescente
        while (vetAlunos[i].getDistancia() < pivo.getDistancia()
                || (vetAlunos[i].getDistancia() == pivo.getDistancia()
                        && vetAlunos[i].getRegiao().compareTo(pivo.getRegiao()) < 0)
                || (vetAlunos[i].getDistancia() == pivo.getDistancia()
                        && vetAlunos[i].getRegiao().compareTo(pivo.getRegiao()) == 0
                        && vetAlunos[i].getNomeAluno().compareTo(pivo.getNomeAluno()) < 0)) {
            return true;
        }
        return false;
    }

    Van[] quicksort(int esq, int dir, Van[] vetAlunos) {
        int i = esq, j = dir;
        Van pivo = vetAlunos[(dir + esq) / 2];
        // ordenação decrescente
        while (i <= j) {
            while (comparar1(i, pivo, vetAlunos))
                i++;
            while (comparar2(j, pivo, vetAlunos))
                j--;
            if (i <= j) {
                swap(i, j, vetAlunos);
                i++;
                j--;
            }
        }
        if (esq < j)
            quicksort(esq, j, vetAlunos);
        if (i < dir)
            quicksort(i, dir, vetAlunos);
        return vetAlunos;
    }

    void tratamentoDeDados(String[] vetorTratado) {
        this.setNomeAluno(vetorTratado[0]);
        this.setRegiao(vetorTratado[1]);
        this.setDistancia(Integer.parseInt(vetorTratado[2]));
    }

    public static void main(String[] args) {
        int numAlunos = Integer.parseInt(MyIO.readLine().trim());
        int i = 0;
        Van[] vetAlunos = new Van[numAlunos];
        Van van = new Van();
        String[] vetorTratado = new String[3];
        List<Van> alunos = new ArrayList<Van>();

        while (i < numAlunos) {
            String linha = MyIO.readLine();
            vetAlunos[i] = new Van();
            vetorTratado = linha.split(" ");
            vetAlunos[i++].tratamentoDeDados(vetorTratado);
        }
        van.imprimir(van.quicksort(0, vetAlunos.length - 1, vetAlunos));
    }
}
