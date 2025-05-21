package parking_lot.app;

import parking_lot.entidades.Cliente;
import parking_lot.entidades.Tipo;
import parking_lot.entidades.Veiculo;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        menuPrincipal();
    }
    static Scanner sc = new Scanner(System.in);
    public static void menuPrincipal(){
        System.out.println("***** BEM VINDO AO PARQUE DE ESTACIONAMENTO *****");
        System.out.println("""
                1.Registrar um cliente
                2.Apagar Cliente
                3.Listar Clientes
                4.Verificar vagas disponiveis
                5.Verificar vagas ocupadas
                6.Sair
                """);

        registrarCliente();
    }

    static Cliente registrarCliente(){
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
        Tipo t = null;
        System.out.println("""
                1.MOTORIZADA,
                2.BICICLETA,
                3.CARRO,
                4.CAMIAO,
                5.CAMIONETA
                """);
        int opp = Integer.parseInt(sc.nextLine());
        switch (opp){
            case 1 -> t = Tipo.MOTORIZADA;
            case 2 -> t = Tipo.BICICLETA;
            case 3 -> t = Tipo.CARRO;
            case 4 -> t = Tipo.CAMIAO;
            case 5 -> t = Tipo.CAMIONETA;
            default -> System.out.println("Opção invalida.");
        }
        Veiculo v = new Veiculo(marca, modelo, anoF, t);
        Cliente c = new Cliente(nomeC, v, saldo);
        System.out.println(c.toString());
        return c;
    }

}
