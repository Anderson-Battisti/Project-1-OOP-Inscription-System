package classealuno;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Professor
{
    private static ArrayList<Professor> professores = new ArrayList();
    private static int count = 1;

    private int id;
    private String nome;
    private String cpf;
    private String endereco;

    public void cadastrarProfessor()
    {
        boolean temLetras = false, nomeNaoAlfabetico = false;
        Professor professor = new Professor();
        Aluno aluno = new Aluno();

        professor.id = count++;

        professor.nome = Entrada.leiaString("Qual o nome do professor? ");
        
        while (aluno.nomeInvalido(professor.nome))
        {
            professor.nome = Entrada.leiaString("Entrada Inválida!\nQual o nome do professor? ");
        }

        professor.cpf = Entrada.leiaString("Qual o CPF do professor? ");
        
        while (aluno.cpfInvalido(professor.cpf))
        {
            professor.cpf = Entrada.leiaString("CPF inválido. Qual o CPF do professor? \n(Use formatação 'XXX.XXX.XXX-XX')");
        }

        professor.endereco = Entrada.leiaString("Qual o endereço do professor? ");
        while (professor.endereco.isEmpty())
        {
            professor.endereco = Entrada.leiaString("Entrada inválida. Qual o endereço do professor? ");
        }

        professores.add(professor);
        JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
    }

    public Professor getProfessor(int id)
    {
        for (Professor p : professores)
        {
            if (p.id == id)
            {
                return p;
            }
        }
        return null;
    }
    
    public String getNomeProfessor()
    {
        return nome;
    }

    public String getListaProfessores()
    {
        String listaDeProfessores = "";
        for (Professor p : professores)
        {
            listaDeProfessores += (p.id + " - " + p.nome + "\n");
        }
        return listaDeProfessores;
    }

    public void exibirProfessores()
    {
        if (!professores.isEmpty())
        {
            String listaDeProfessores = "";
            for (Professor p : professores)
            {
                listaDeProfessores += (p.id + " - " + p.nome + "\n");
            }
            JOptionPane.showMessageDialog(null, listaDeProfessores);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Não há nenhum professor cadastrado.");
        }
    }

    public boolean temProfessoresCadastrados()
    {
        if (professores.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean professorNaoEncontrado(int idProfessor)
    {
        for (Professor professor : professores)
        {
            if (idProfessor == professor.id)
            {
                return false;
            }
        }
        return true;
    }
}
