package desafiotata;

import java.util.ArrayList;
import java.util.List;

public class RelatorioFinanceiro {

    public static List<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        carregarBaseDeAlunos();
        relatarPendenciasFinanceiras();
    }

    private static void relatarPendenciasFinanceiras() {
        alunos.stream()
                .filter(RelatorioFinanceiro::possuiPendenciaFinanceira)
                .forEach(System.out::println);
    }

    /**
     * TATA DEVE IMPLEMENTAR A FUNCAO ABAIXO, RETORNANDO TRUE OU FALSE DE ACORDO COM A SITUACAO DO ALUNO
     */
    private static boolean possuiPendenciaFinanceira(Aluno aluno) {
        if (aluno.credito-aluno.saldoDevedor<0){ //then
            return true;
        }else{
            return false;
        }
    }

    private static void carregarBaseDeAlunos() {
        alunos.add(new Aluno("Ana", 100, 120));
        alunos.add(new Aluno("Bob", 130, 90));
        alunos.add(new Aluno("John", 0, 0));
        alunos.add(new Aluno("Clare", 100, 120));
        alunos.add(new Aluno("Chris", 200, 120));
        alunos.add(new Aluno("Boris", 10, 20));
    }
}
