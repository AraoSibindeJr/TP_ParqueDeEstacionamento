package parking_lot.app;

import parking_lot.entidades.Cliente;
import parking_lot.entidades.Park;
import parking_lot.entidades.Vaga;
import parking_lot.entidades.Veiculo;
import parking_lot.feramentas.Repositorio;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Insira o nome do parking lot");
        String nP = new Scanner(System.in).nextLine();

        Park park = new Park(1, nP, 10);

                menuPrincipal(park);
    }
    static Scanner sc = new Scanner(System.in);
    public static void menuPrincipal(Park park) {
        System.out.println("***** BEM VINDO AO PARQUE DE ESTACIONAMENTO *****");
        System.out.println("""
                1.Registrar um cliente
                2.Apagar Cliente
                3.Listar Clientes
                4.Verificar vagas disponiveis
                5.Verificar vagas ocupadas
                6.Sair
                """);

        int opp = Integer.parseInt(sc.nextLine());
        while (opp != 6){
            switch(opp){
                case 1 -> registrarCliente();
                case 2 -> deleteClientById();
                case 3 -> listAllClients();
                case 4 -> listAvalible(park);
                case 5 -> listUnAvailible(park);
            }
            System.out.println("""
                1.Registrar um cliente
                2.Apagar Cliente
                3.Listar Clientes
                4.Verificar vagas disponiveis
                5.Verificar vagas ocupadas
                6.Sair
                """);
            opp = Integer.parseInt(sc.nextLine());
        }

    }

    private static void listAvalible(Park park) {
        for (Vaga v : park.listarVagasLivres()) {
            System.out.println(v.toString());
        }
    }

    private static void listUnAvailible(Park park) {
        for(Vaga v : park.listarVagasOcupadas()){
            System.out.println(v.toString());
        }
    }

    static Cliente registrarCliente(Park park){
        System.out.println("Nome do cliente");
        String nomeC = sc.nextLine();
        System.out.println("Saldo do Cliente\n");
        double saldo = Double.parseDouble(sc.nextLine());
        System.out.println("Marca do veiculo");
        String marca = sc.nextLine();
        System.out.println("Modelo do veiculo");
        String modelo = sc.nextLine();
        System.out.println("Ano de Fabrico do veiculo");
        int anoF = Integer.parseInt(sc.nextLine());
        System.out.println("Tipo de veiculo");
        String t = null;
        System.out.println("""
                1.MOTORIZADA,
                2.BICICLETA,
                3.CARRO,
                4.CAMIAO,
                5.CAMIONETA
                """);
        int opp = Integer.parseInt(sc.nextLine());
        switch (opp){
            case 1 -> t = "MOTORIZADA";
            case 2 -> t = "BICICLETA";
            case 3 -> t = "CARRO";
            case 4 -> t = "CAMIAO";
            case 5 -> t = "CAMIONETA";
            default -> System.out.println("Opção invalida.");
        }
        Veiculo v = new Veiculo(marca, modelo, anoF, t);
        Cliente c = new Cliente(nomeC, v, saldo);
        System.out.println(c.toString());
        park.parquearVeiculo(c);
        return c;
    }

    static void deleteClientById(){
        System.out.println("Digite o ID do cliente: ");
        Long id = Long.parseLong(sc.nextLine());
        Vector<Cliente> clients = Repositorio.listarClientes();
        for(Cliente c : clients){
            if(c.getId() == id){
                Repositorio.deleteById(id);
                System.out.println("O cliente foi apagado com sucesso.\n" + c.toString());
            }else{
                System.out.println("Não existe um clinte com esse nome");
            }
        }
    }

    static Vector<Cliente> listAllClients(){
        Vector<Cliente> clients = new Vector<>();
        for(Cliente c : Repositorio.listarClientes()){
            clients.addElement(c);
        }
        return clients;
    }
}
