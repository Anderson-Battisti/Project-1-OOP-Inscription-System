package classealuno;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Aluno
{
    private static ArrayList<Aluno> alunos = new ArrayList();
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private char genero;

    private static int count = 1;

    public void cadastrarAluno()
    {
        Aluno aluno = new Aluno();

        aluno.nome = Entrada.leiaString("Qual o nome do aluno? ");

        while (nomeInvalido(aluno.nome))
        {
            aluno.nome = Entrada.leiaString("Entrada inválida. Qual o nome do aluno?");
        }

        aluno.cpf = Entrada.leiaString("Qual o CPF do aluno? ");

        while (cpfInvalido(aluno.cpf))
        {
            aluno.cpf = Entrada.leiaString("CPF inválido. Qual o CPF do aluno? \n(Use formatação 'XXX.XXX.XXX-XX')");
        }

        aluno.dataNascimento = Entrada.leiaString("Qual a data de nascimento do aluno? [DD/MM/AAAA]");

        while (dataInvalida(aluno.dataNascimento))
        {
            aluno.dataNascimento = Entrada.leiaString("Entrada inválida. Qual a data de nascimento do aluno? \n(Use formatação [DD/MM/AAAA])");
        }

        aluno.email = Entrada.leiaString("Qual o email do aluno? ");

        while (emailInvalido(aluno.email))
        {
            aluno.email = Entrada.leiaString("Email inválido. Qual o email do aluno? ");
        }

        while (aluno.genero != 'M' && aluno.genero != 'F')
        {
            char genero = (Character.toUpperCase(Entrada.leiaChar("Qual o gênero do aluno? [M/F]")));
            aluno.genero = genero;
        }

        aluno.id = count++;

        alunos.add(aluno);
        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
    }

    public void exibirAlunos()
    {
        if (!alunos.isEmpty())
        {
            String nomesAlunos = "";
            for (Aluno a : alunos)
            {
                nomesAlunos += (a.id + " - " + a.nome + "\n");
            }
            JOptionPane.showMessageDialog(null, nomesAlunos);
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Não há nenhum aluno cadastrado.");
        }
    }

    public String getListaAlunos()
    {
        String nomesAlunos = "";
        for (Aluno a : alunos)
        {
            nomesAlunos += (a.id + " - " + a.nome + "\n");
        }
        return nomesAlunos;
    }

    public Aluno getAluno(int id)
    {
        for (Aluno a : alunos)
        {
            if (a.id == id)
            {
                return a;
            }
        }
        return null;
    }

    public String getNomeCompleto(int id)
    {
        for (Aluno a : alunos)
        {
            if (a.id == id)
            {
                return a.nome;
            }
        }
        return null;
    }

    public String getStringNomeCompleto(int id)
    {
        for (Aluno a : alunos)
        {
            if (a.id == id)
            {
                return a.nome;
            }
        }
        return null;
    }

    public boolean emailInvalido(String email)
    {
        boolean contemCaracteresInvalidos = false, flag1 = false, flag2 = false, flag3 = false;
        for (int i = 0; i < email.length(); i++)
        {
            if (!Character.isAlphabetic(email.charAt(i)) && !Character.isDigit(email.charAt(i)) && email.charAt(i) != '@' && email.charAt(i) != '.')
            {
                contemCaracteresInvalidos = true;
                break;
            }

            if (Character.isAlphabetic(email.charAt(i)))
            {
                flag1 = true;
            }

            if (email.charAt(i) == '@')
            {
                flag2 = true;
            }

            if (email.charAt(i) == '.')
            {
                flag3 = true;
            }
        }

        if ((flag1 && flag2 && flag3) && !contemCaracteresInvalidos)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean dataInvalida(String data)
    {
        boolean temCaractereInvalido = false, temFormatoInvalido = false, temBarra = false;
        for (int i = 0; i < data.length(); i++)
        {
            if (!Character.isDigit(data.charAt(i)) && data.charAt(i) != '/')
            {
                temCaractereInvalido = true;
            }

            if (data.charAt(i) == '/')
            {
                temBarra = true;
            }
        }

        if (data.trim().isEmpty() || data.length() < 10 || data.length() > 10)
        {
            temFormatoInvalido = true;
        }

        if (temCaractereInvalido || temFormatoInvalido || !temBarra)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean nomeInvalido(String nome)
    {
        boolean nomeNaoAlfabetico = false;

        for (int i = 0; i < nome.length(); i++)
        {
            if (!Character.isAlphabetic(nome.charAt(i)) && nome.charAt(i) != ' ')
            {
                nomeNaoAlfabetico = true;
                break;
            }
        }

        if (nome.trim().isEmpty() || nomeNaoAlfabetico == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean cpfInvalido(String cpf)
    {
        boolean temCaractereInvalido = false, flag1 = false, flag2 = false;

        for (int i = 0; i < cpf.length(); i++)
        {
            if (Character.isLetter(cpf.charAt(i)))
            {
                temCaractereInvalido = true;
            }

            if (cpf.charAt(i) == '.')
            {
                flag1 = true;
            }

            if (cpf.charAt(i) == '-')
            {
                flag2 = true;
            }
        }

        if (cpf.length() < 14 || cpf.length() > 14 || flag1 == false || flag2 == false || temCaractereInvalido == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean alunoNaoEncontrado(int idAluno)
    {
        for (Aluno a : alunos)
        {
            if (a.id == idAluno)
            {
                return false;
            }
        }
        return true;
    }

    public boolean temAlunosCadastrados()
    {
        if (alunos.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
