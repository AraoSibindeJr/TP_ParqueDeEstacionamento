package parking_lot.entidades;

import java.util.ArrayList;

public class Park {
    private int id;
    private String nome;
    private int totVagas;
    private int vagasOcupadas;
    private ArrayList<Integer> veiculos; // Lista das matriculas dos carros
    private double receita; // A receita e calculada com base: nrHoras * Valor

    // Construtor
    public Park(int id, String nome, int totVagas, int vagasOcupadas){
        this.id = id;
        this.nome = nome;
        this.totVagas = totVagas;
        this.veiculos = new ArrayList<>();
        this.receita = 0.0;
    }

    // Metodo para adicionar um veiculo
    public boolean adicionarVeiculo(int id){
        if(vagasOcupadas < totVagas){
            veiculos.add(id);
            vagasOcupadas++;
            return true;
        }else {
            System.out.println(" Parque Cheio, Nao e Possivel adicionar veiculo");
            return false;
        }
    }

}
