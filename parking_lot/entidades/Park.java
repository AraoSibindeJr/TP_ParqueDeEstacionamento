package parking_lot.entidades;

import java.util.*;

//classe
public class Park {
    private int id;
    private String nome;
    private Vaga[] vagas; // Lista das matriculas dos carros
    private double receita; // A receita e calculada com base: nrHoras * Valor

    // Construtor
    public Park(int id, String nome, int numeroVagas){
        this.id = id;
        this.nome = nome;
        this.vagas = new Vaga[numeroVagas];
        this.receita = 0.0;
    }

    Vaga[] buildVagas(Lis<Vaga> v){
        Vaga[] vv = new Vaga[v.size()];
        for(int i = 0; i<v.size(); i++){
            this.vagas = vv;
        }
        return vv;
    }
    public Park(int id, String nome, int numeroVagas, Vector<Vaga> v){
        this.id = id;
        this.nome = nome;
        this. vagas = buildVagas(v);
        this.receita = 0.0;
    }

    // Metodo para adicionar um veiculo
    public void parquearVeiculo(Cliente c){
        System.out.println("Insira o valor base de estacionameto: ");
        double valorB = Double.parseDouble(new Scanner(System.in).nextLine());
        Vaga v = new Vaga(valorB);
        v.cliente = c;
       int index = 0;
       for(int i = 0; i<vagas.length; i++){
           if(vagas[i] == null){
               vagas[i] = v;
           }
       }
    }

    public List<Vaga> listarVagasOcupadas(){
        List<Vaga> vagas = new ArrayList<>();
        for(int i = 0; i < this.vagas.length ; i++){
            if(!this.vagas[i].estaDisponivel()){
                vagas.add(this.vagas[i]);
            }
        }
        return vagas;
    }

    public List<Vaga> listarVagasLivres(){
        Vector<Vaga> vagas = new ArrayList<>();
        for(int i = 0; i < this.vagas.length ; i++){
            if(this.vagas[i].estaDisponivel()){
                vagas.add(this.vagas[i]);
            }
        }
        return vagas;
    }

    public double calcularReceita(){
        double total = 0.0;
        for(Vaga v : this.vagas){
            total = v.preco;
        }
        return total;
    }


    void msg01(){
        System.out.println(" Parque cheio, nao e possivel adicionar o veiculo");
    }
    void msg02(){
        System.out.println(" Veiculo nao encontrado.");
    }

}
