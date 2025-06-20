package parking_lot.entidades;

public class Veiculo {
    
    private Long id;
    private String marca;
    private String modelo;
    private int anoFabrico;
    private String tipo;
    static Long idG = 0L;

    public Veiculo(){};
    public Veiculo(String marca, String modelo, int anoF, String tipo){
        this.id = this.idG + 1;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabrico = anoF;
        this.tipo = tipo;
    }
    public Veiculo(Long id, String marca, String modelo, int anoF, String tipo){
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
}
