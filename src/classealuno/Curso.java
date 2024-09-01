package classealuno;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ander.battisti
 */
public class Curso
{
    private static ArrayList<Curso> cursos = new ArrayList<>();
    private int id;
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private Professor professor;
    private Sala sala;

    private static int count = 1;

    public void cadastrarCurso()
    {
        Curso curso = new Curso();
        Professor prof = new Professor();
        Sala sala = new Sala();
        Aluno aluno = new Aluno();

        if (prof.temProfessoresCadastrados() == true && sala.temSalasCadastradas() == true)
        {
            curso.id = count++;

            curso.nome = Entrada.leiaString("Qual o nome do curso? ");

            while (aluno.nomeInvalido(curso.nome))
            {
                curso.nome = Entrada.leiaString("Entrada inválida.\nQual o nome do curso? ");
            }

            curso.descricao = Entrada.leiaString("Qual a descrição do curso? ");

            curso.dataInicio = Entrada.leiaString("Qual a data de início do curso? [DD/MM/AAAA]");

            while (aluno.dataInvalida(curso.dataInicio))
            {
                curso.dataInicio = Entrada.leiaString("Entrada inválida. Qual a data de início do curso? \n(Use formatação [DD/MM/AAAA])");
            }

            curso.dataFim = Entrada.leiaString("Qual a data fim do curso? [DD/MM/AAAA]");

            while (aluno.dataInvalida(curso.dataFim))
            {
                curso.dataFim = Entrada.leiaString("Entrada inválida. Qual a data fim do curso? \n(Use formatação [DD/MM/AAAA])");
            }

            int idProfessor = Entrada.leiaInt(prof.getListaProfessores() + "\n\nQual o id do professor que você deseja atribuir a este curso? ");

            while (prof.professorNaoEncontrado(idProfessor))
            {
                idProfessor = Entrada.leiaInt(prof.getListaProfessores() + "Professor não encontrado!\nQual o id do professor que você deseja atribuir a este curso? ");
            }
            curso.professor = prof.getProfessor(idProfessor);

            int idSala = Entrada.leiaInt(sala.getStringListaSalas() + "\n\nQual o id da sala que você deseja atribuir a este curso? ");

            while (sala.salaNaoEncontrada(idSala))
            {
                idSala = Entrada.leiaInt(sala.getStringListaSalas() + "Sala não encontrada\nQual o id da sala que você deseja atribuir a este curso? ");
            }
            curso.sala = sala.getSala(idSala);

            cursos.add(curso);
            JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Você precisa ter professores e salas cadastradas para cadastrar um curso!");
        }
    }

    public void exibirCursos()
    {
        if (!cursos.isEmpty())
        {
            String listaDeCursos = "";
            for (Curso c : cursos)
            {
                listaDeCursos += (c.id + " - " + c.nome + " | Professor: " + c.professor.getNomeProfessor() + "\n"
                        + "Sala: " + c.sala.getNumeroSala() + " |  Data de início/fim: " + c.dataInicio + " | " + c.dataFim
                        + "\n----------------------------------------------------------------------------------------------\n");
            }
            JOptionPane.showMessageDialog(null, listaDeCursos);
        }    
        else
        {
            JOptionPane.showMessageDialog(null, "Não há nenhum curso cadastrado.");
        }
    }

    public String getListaCursos()
    {
        String listaDeCursos = "";
        for (Curso c : cursos)
        {
            listaDeCursos += (c.id + " - " + c.nome + "\n");
        }
        return listaDeCursos;
    }

    public Curso getCurso(int id)
    {
        for (Curso c : cursos)
        {
            if (c.id == id)
            {
                return c;
            }
        }
        return null;
    }

    public boolean cursoNãoEncontrado(int idCurso)
    {
        for (Curso c : cursos)
        {
            if (c.id == idCurso)
            {
                return false;
            }
        }
        return true;
    }

    public boolean temCursosCadastrados()
    {
        if (cursos.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public String getNomeCurso()
    {
        return nome;
    }
}
