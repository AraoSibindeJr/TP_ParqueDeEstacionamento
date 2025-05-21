package parking_lot.entidades;

public class Veiculo {
    
    private Long id;
    private String marca;
    private String modelo;
    private int anoFabrico;
    private Tipo tipo;
    static Long idG = 0L;

    public Veiculo( String marca, String modelo, int anoF, Tipo tipo){
        this.id = this.idG + 1;
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
