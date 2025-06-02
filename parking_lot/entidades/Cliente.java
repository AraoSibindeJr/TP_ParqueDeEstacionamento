package parking_lot.entidades;

public class Cliente {
    private Long id;
    private String nome;
    private Veiculo veiculo;
    private double saldo;
    private static Long idG = 0L;

    public Cliente(String nome, Veiculo veiculo, double saldo) {
        this.id = idG++;
        this.nome = nome;
        this.veiculo = veiculo;
        this.saldo = saldo;
    }

    public Cliente(Long id, String nome, Veiculo veiculo, double saldo) {
        this.id = id;
        this.nome = nome;
        this.veiculo = veiculo;
        this.saldo = saldo;
    }

    public void aumentarSaldo(double valor) {
        this.saldo += valor;
    }

    public boolean debitarSaldo(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    public boolean temSaldoSuficiente(double valor) {
        return this.saldo >= valor;
    }

    public boolean temId() {
        return this.id.equals(id);
    }

    public boolean temId(Long outroId) {
        return this.id.equals(outroId); // método público de comparação
    }

    public boolean temNome(String nome) {
        return this.nome.equalsIgnoreCase(nome);
    }

    public boolean temVeiculo(Veiculo veiculo) {
        return this.veiculo.equals(veiculo);
    }

    public String descricaoVeiculo() {
        return veiculo != null ? veiculo.toString() : "Nenhum";
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Saldo: " + saldo + "\n" +
                "Veículo: " + descricaoVeiculo();
    }
}