package classealuno;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Sala
{
    private static ArrayList<Sala> salas = new ArrayList();
    private int id;
    private int numero;
    private int predio;
    public static int count = 1;

    int numeroSala = 0;
    int numeroPredio = 0;

    public void cadastrarSala()
    {
        Sala sala = new Sala();

        sala.id = count++;
        numeroSala = Entrada.leiaInt("Qual o número da sala? ");
        numeroPredio = Entrada.leiaInt("A qual prédio essa sala pertence? ");
        
        while (salaJaCadastrada(numeroSala, numeroPredio))
        {
            numeroSala = Entrada.leiaInt("Essa sala já foi cadastrada! Tente novamente\nQual o número da sala? ");
            numeroPredio = Entrada.leiaInt("A qual prédio essa sala pertence? ");
        }

        sala.numero = numeroSala;
        sala.predio = numeroPredio;

        salas.add(sala);
        JOptionPane.showMessageDialog(null, "Sala cadastrada com sucesso!");
    }

    public Sala getSala(int id)
    {
        for (Sala s : salas)
        {
            if (s.id == id)
            {
                return s;
            }
        }
        return null;
    }

    public String getStringListaSalas()
    {
        String listaDeSalas = "";

        for (Sala s : salas)
        {
            listaDeSalas += ("Id: " + s.id + "\n"
                    + "Número: " + s.numero + "\n"
                    + "Prédio: " + s.predio + "\n----------------------------\n");
        }
        return listaDeSalas;
    }

    public int getNumeroSala()
    {
        return numero;
    }

    public void exibirSalas()
    {
        if (!salas.isEmpty())
        {
            String listaDeSalas = "";

            for (Sala s : salas)
            {
                listaDeSalas += ("Id: " + s.id + "\n"
                        + "Número: " + s.numero + "\n"
                        + "Prédio: " + s.predio + "\n----------------------------\n");
            }
            JOptionPane.showMessageDialog(null, listaDeSalas);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Não há nenhuma sala cadastrada.");
        }
    }

    public boolean temSalasCadastradas()
    {
        if (salas.isEmpty() == true)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean salaNaoEncontrada(int id)
    {
        for (Sala s : salas)
        {
            if (s.id == id)
            {
                return false;
            }
        }
        return true;
    }

    public boolean salaJaCadastrada(int numeroSala, int numeroPredio)
    {
        for (Sala s : salas)
        {
            if (numeroSala == s.numero && numeroPredio == s.predio)
            {
                return true;
            }
        }
        return false;
    }
}
