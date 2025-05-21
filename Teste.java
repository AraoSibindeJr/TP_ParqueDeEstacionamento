import parking_lot.entidades.Cliente;

public class Teste {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1, "Arão", "toyota ractis", 100.0, "C123");

        System.out.println(cliente1);
        System.out.println();

        //dps de Arao aumantar o saldo, se for necessario
        cliente1.aumentarSaldo(50);
        System.out.println("\n Após aumentar saldo:");
        System.out.println(cliente1);

        // n sei se e necessario, caso Arao acerte uma bolada
        cliente1.setVeiculo("Ford F-150 Raptor");
        System.out.println("\n Após alterar veículo:");
        System.out.println(cliente1);

    }
}

