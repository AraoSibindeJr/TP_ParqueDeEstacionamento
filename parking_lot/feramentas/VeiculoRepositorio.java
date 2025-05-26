package parking_lot.feramentas;

import parking_lot.entidades.Cliente;
import parking_lot.entidades.Veiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class VeiculoRepositorio{


    public void salvarNoArquivo(Veiculo veiculo) throws IOException {
        FileWriter writer = new FileWriter("veiculos.txt");
        writer.write(veiculo.veiculoDTO() + "\n");
    }

    public static List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String FileName = "src/parking_lot/ficheiros/clientes.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] atributo = linha.split(",");
                Long id = Long.parseLong(atributo[0]);
                String nome = atributo[1];
                double saldo = Double.parseDouble(atributo[2]);

                // atributos do veículo
                Long veiculoId = Long.parseLong(atributo[3]);
                String marca = atributo[4];
                String modelo = atributo[5];
                int ano = Integer.parseInt(atributo[6]);
                String tipo = atributo[7];

                Veiculo v = new Veiculo(veiculoId, marca, modelo, ano, tipo);
                Cliente c = new Cliente(id, nome, v, saldo);

                clientes.add(c);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
        }

        return clientes;
    }

    public void ApagarDoArquivo(Long id) {

     }

    public void PesquisarPorID() {

    }
}
