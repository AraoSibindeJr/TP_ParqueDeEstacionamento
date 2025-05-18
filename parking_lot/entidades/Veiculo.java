package parking_lot.entidades;

public class Veiculo {
    
    private Long id;
    private String marca;
    private String modelo;
    private int anoFabrico;
    private Tipo tipo;

    public Veiculo(Long id, String marca, String modelo, int anoF, Tipo tipo){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabrico = anoF;
        this.tipo = tipo;
    }

    
    @Override
    public String toString() {
        return "Veiculo [id: " + id + ", marca: " + marca + ", modelo: " + modelo + ", anoFabrico: " + anoFabrico
                + ", tipo: " + tipo + "]";
    }

    public String veiculoDTO(){
        return id + "," + marca + "," + modelo + "," + anoFabrico
                + "," + tipo;
    }
    public static void main(String[] args) {
        Veiculo v = new Veiculo(1L, "Toyota", "Corolla", 1999, Tipo.CARRO);

        System.out.println("\n \n"  + v.veiculoDTO());
    }
}
