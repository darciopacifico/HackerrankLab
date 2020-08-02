package desafiotata;

public class Aluno {

    public String nome;

    public double saldoDevedor;

    public double credito;

    public Aluno(String nome, double saldoDevedor, double credito) {
        this.nome = nome;
        this.saldoDevedor = saldoDevedor;
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
