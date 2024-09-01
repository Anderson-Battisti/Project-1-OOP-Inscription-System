package classealuno;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Inscricao
{

    private static ArrayList<Inscricao> inscricoes = new ArrayList();
    private static int count = 1;

    private int id;
    private Aluno aluno;
    private Curso curso;
    private String dataInscricao;

    public void fazerInscricao()
    {
        Inscricao inscricao = new Inscricao();
        Aluno aluno = new Aluno();
        Curso curso = new Curso();

        if (aluno.temAlunosCadastrados() && curso.temCursosCadastrados())
        {
            int idAluno = Entrada.leiaInt(aluno.getListaAlunos() + "\n\nQual o id do aluno que você deseja inscrever? ");

            while (aluno.alunoNaoEncontrado(idAluno))
            {
                idAluno = Entrada.leiaInt(aluno.getListaAlunos() + "Aluno não encontrado\nQual o id do aluno que você deseja inscrever? ");
            }
            inscricao.aluno = aluno.getAluno(idAluno);

            int idCurso = Entrada.leiaInt(curso.getListaCursos() + "\n\nQual o id do curso que você deseja matricular " + aluno.getNomeCompleto(idAluno) + "?");

            while (curso.cursoNãoEncontrado(idCurso))
            {
                idCurso = Entrada.leiaInt("Curso não encontrado!" + curso.getListaCursos() + "\nQual o id do curso que você deseja matricular " + aluno.getNomeCompleto(idAluno) + "?");
            }
            inscricao.curso = curso.getCurso(idCurso);

            inscricao.dataInscricao = Entrada.leiaString("Qual a data de inscrição? [DD/MM/AAAA]");

            while (aluno.dataInvalida(inscricao.dataInscricao))
            {
                inscricao.dataInscricao = Entrada.leiaString("Data inválida.\nQual a data de inscrição? \n(Use formatação [DD/MM/AAAA])");
            }

            inscricao.id = count++;
            inscricoes.add(inscricao);
            JOptionPane.showMessageDialog(null, "Inscrição realizada com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Você precisa ter cursos e alunos cadastrados para realizar uma inscrição!");
        }
    }

    public void exibirInscricoes()
    {
        if (!inscricoes.isEmpty())
        {
            String listaDeInscricoes = "";
            for (Inscricao i : inscricoes)
            {
                listaDeInscricoes += (i.id + " - " + i.aluno.getStringNomeCompleto(i.id) + "\n"
                        + "Curso: " + i.curso.getNomeCurso() + "\n"
                        + "Data de inscrição: " + i.dataInscricao + "\n-----------------------------------------------\n");
            }
            JOptionPane.showMessageDialog(null, listaDeInscricoes);
        } 
        else
        {
            JOptionPane.showMessageDialog(null, "Não há nenhuma inscrição registrada.");
        }
    }
}
