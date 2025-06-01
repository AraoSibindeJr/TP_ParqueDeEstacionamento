package parking_lot.entidades;

import java.util.ArrayList;
import java.util.Optional;

public class Park {
    private int id;
    private String nome;
    private int totVagas;
    private int vagasOcupadas;
    private ArrayList<Integer> veiculos; // Array de Vaga
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
            msg01();
            return false;
        }
    }

    // Metodo para remover um veiculo
    public boolean removerVeiculo(int id){
        if(veiculos.remove(Optional.of(id))){
            vagasOcupadas--;
            return true;
        }else {
            msg02();
            return false;
        }
    }

    // verificar vagas livres
    public int getVagasLivres(){
        return totVagas - vagasOcupadas;
    }

    // Calcular receita: Metodo por desenvolver
    // Parametros: Tempo de parqueamento; valor por hora.

    // ver quantidade de carros no parque
    public int getTotVeiculos(){
        return veiculos.size();
    }

    // ver quantas vagas foram ocupadas
    public int getVagasOcupadas(){
        return vagasOcupadas;
    }


    // Mesagens
    void msg01(){
        System.out.println(" Parque cheio, nao e possivel adicionar o veiculo");
    }
    void msg02(){
        System.out.println(" Veiculo nao encontrado.");
    }

}
