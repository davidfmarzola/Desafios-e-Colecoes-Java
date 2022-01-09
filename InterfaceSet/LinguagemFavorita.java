import java.util.*;

public class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "LinguagemFavorita [nome=" + nome + ", anoDeCriacao=" + anoDeCriacao + ", ide=" + ide + "]";
    }

    public int compareTo(LinguagemFavorita lf) {
        return this.getNome().compareTo(lf.getNome());
    }

    public static void main(String[] args) {
        Set<LinguagemFavorita> linguagemFavorita = new LinkedHashSet<>();// ordem de inserção
        linguagemFavorita.add(new LinguagemFavorita("Python", 1991, "Pycharm"));
        linguagemFavorita.add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
        linguagemFavorita.add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));
        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(linguagemFavorita.toString());

        System.out.println("--\tOrdem natural (Nome)\t--");
        Set<LinguagemFavorita> linguagemFavorita2 = new TreeSet<>(linguagemFavorita); // ordem alfabética
        System.out.println(linguagemFavorita2);

        System.out.println("--\tIDE\t--");
        Set<LinguagemFavorita> linguagemFavorita3 = new TreeSet<>(new ComparatorIde()); // ordem
                                                                                        // alfabética
        linguagemFavorita3.addAll(linguagemFavorita);
        for (LinguagemFavorita lf : linguagemFavorita3)
            System.out.println(lf);

        System.out.println("--\tAno de criação e nome\t--");
        Set<LinguagemFavorita> linguagemFavorita4 = new TreeSet<>(new ComparatorAnoDeCriacaoENome()); // ordem
        // alfabética
        linguagemFavorita4.addAll(linguagemFavorita);
        for (LinguagemFavorita lf : linguagemFavorita4)
            System.out.println(lf);

        System.out.println("--\tNome, ano de criacao e IDE\t--");
        Set<LinguagemFavorita> linguagemFavorita5 = new TreeSet<>(new ComparatorNomeAnoDeCriacaoIde()); // ordem
        // alfabética
        linguagemFavorita5.addAll(linguagemFavorita);
        for (LinguagemFavorita lf : linguagemFavorita5)
            System.out.println(lf);
        // for (LinguagemFavorita lf : linguagemFavorita2)
        // System.out.println(lf.getNome() + " - "
        // + lf.getAnoDeCriacao() + " - " + lf.getIde());

    }
}

class ComparatorIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareTo(o2.getIde());
    }

}

class ComparatorAnoDeCriacaoENome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int anoCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (anoCriacao != 0)
            return anoCriacao;

        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0)
            return nome;

        return o1.getIde().compareTo(o2.getIde());
    }

}

class ComparatorNomeAnoDeCriacaoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0)
            return nome;

        int anoCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (anoCriacao != 0)
            return anoCriacao;

        return o1.getIde().compareTo(o2.getIde());
    }

}
