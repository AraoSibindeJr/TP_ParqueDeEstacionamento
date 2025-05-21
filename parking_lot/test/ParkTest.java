package parking_lot.test;
import parking_lot.entidades.Cliente;
import parking_lot.entidades.Tipo;
import parking_lot.entidades.Veiculo;
public class ParkTest {
    public static void main(String[] args) {

        Veiculo veiculo = new Veiculo(1L, "Toyota","Vitz", 1999, Tipo.CARRO);
        Cliente client = new Cliente(1L,"John Doe",veiculo, 2345, "1111");
    }
}
