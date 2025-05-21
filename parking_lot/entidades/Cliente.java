package parking_lot.entidades;

public class Cliente {
    private Long id;
    private String nome;
    private Veiculo veiculo;
    private double saldo;
    static Long idG = 0L;

    public Cliente( String nome, Veiculo veiculo, double saldo){
        this.id = this.idG + 1;
        this.nome = nome;
        this.veiculo = veiculo;
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    // estes dois sets criei pq acho que esses atributos podem ser alterados ao londo do codigo

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }


    public void aumentarSaldo(double valor) {
        this.saldo += valor;
    }
    // o cliente pode recargar o cartao "se q e necessario", mas ainda pode recaregar um cartao com conta negativa tipo Arao

    public void debitarSaldo(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
            // e msm assim ainda ser insuficiente conta de Arao kkk
        }
    }

    public double getSaldo() {
        return saldo;
    }

    /*public void exibirInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + cod);
        System.out.println("Saldo: " + saldo);
        if (veiculo != null) {
            System.out.println("Veículo: " + veiculo);
        } else {
            System.out.println("Veículo: Nenhum");
        }*/

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Saldo: " + saldo + "\n" +
                "Veículo: " + (veiculo != null ? veiculo.toString() : "Nenhum");
    }
    // isto aqui "veiculo != null ? veiculo : "Nenhum" vi no chat, dps vao dizer oq preferem


}

