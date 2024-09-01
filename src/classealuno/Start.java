package classealuno;

/**
 *
 * @author ander.battisti
 */
public class Start
{
    public static void main(String[] args)
    { 
        int opcaoMenu = 1;

        while (true)
        {
            opcaoMenu = Entrada.leiaInt(""
                    + "MENU CENTRAL DE INSCRIÇÕES \n\n"
                    + "[1] - Cadastrar um professor \n"
                    + "[2] - Cadastrar um aluno \n"
                    + "[3] - Cadastrar sala \n"
                    + "[4] - Cadastrar um curso \n"
                    + "[5] - Realizar uma inscrição \n"
                    + "[6] - Listar professores \n"
                    + "[7] - Listar cursos \n"
                    + "[8] - Listar salas \n"
                    + "[9] - Listar inscrições \n"
                    + "[10] - Listar alunos \n"
                    + "[0] - Sair do programa \n");

            if (opcaoMenu == 1)
            {
                Professor professor = new Professor();
                professor.cadastrarProfessor();
            }

            else if (opcaoMenu == 2)
            {
                Aluno aluno = new Aluno();
                aluno.cadastrarAluno();
            }

            else if (opcaoMenu == 3)
            {
                Sala sala = new Sala();
                sala.cadastrarSala();
            }

            else if (opcaoMenu == 4)
            {
                Curso curso = new Curso();
                curso.cadastrarCurso();
            }

            else if (opcaoMenu == 5)
            {
                Inscricao inscricao = new Inscricao();
                inscricao.fazerInscricao();
            }

            else if (opcaoMenu == 6)
            {
                Professor professor = new Professor();
                professor.exibirProfessores();
            }

            else if (opcaoMenu == 7)
            {
                Curso curso = new Curso();
                curso.exibirCursos();
            }

            else if (opcaoMenu == 8)
            {
                Sala sala = new Sala();
                sala.exibirSalas();
            }

            else if (opcaoMenu == 9)
            {
                Inscricao inscricao = new Inscricao();
                inscricao.exibirInscricoes();
            }

            else if (opcaoMenu == 10)
            {
                Aluno aluno = new Aluno();
                aluno.exibirAlunos();

            }

            else if (opcaoMenu == 0)
            {
                break;
            }
        }
        System.exit(0);
    }
}
