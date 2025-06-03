package parking_lot.feramentas;

import parking_lot.entidades.Cliente;
import parking_lot.entidades.Vaga;
import parking_lot.entidades.Veiculo;

import java.io.*;
import java.util.*;

public class Repositorio {

    /*

    public static void deleteById(Long id) {
    }

    public void salvarNoArquivo(Veiculo veiculo) throws IOException {
        FileWriter writer = new FileWriter("parking_lot/ficheiros/clientes.txt");
        writer.write(veiculo.veiculoDTO() + "\n");
    }

    public static Vector<Cliente> listarClientes() {
        Vector<Cliente> clientes = new Vector();
        String FileName = "parking_lot/ficheiros/clientes.txt";
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

                clientes.addElement(c);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
        }

        return clientes;
    }

    public static void removerClientePorId(int idRemover) {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",", 2); // separamos só o primeiro campo (ID)
                if (partes.length > 0) {
                    int id = Integer.parseInt(partes[0].trim());
                    if (id != idRemover) {
                        linhas.add(linha); // mantém apenas os clientes com ID diferente
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // Reescrevendo o arquivo sem o cliente removido
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("parking_lot/ficheiros/clientes.txt"))) {
            for (String l : linhas) {
                bw.write(l);
                bw.newLine();
            }
            System.out.println("Cliente com ID " + idRemover + " removido com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }


    public static Vector<Object> pesquisarClientePorId(Long idProcurado) {
        try (BufferedReader br = new BufferedReader(new FileReader("parking_lot/ficheiros/clientes.txt"))) {
            String linha;
            Vector<Object> response = new Vector<>();

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",", 2); // divide apenas na primeira vírgula
                if (partes.length > 0) {
                    int id = Integer.parseInt(partes[0].trim());
                    if (id == idProcurado) {
                        response.addElement(true);
                        response.addElement(linha);
                        return response; // retorna a linha inteira do cliente encontrado
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        Vector fr = new Vector();
        fr.addElement(false);
        return fr; // se não encontrar o cliente
    }

    public static Vector<Vaga> reconstruirVagasOcupadas() {
        Vector<Vaga> vagasOcupadas = new Vector<>();
        Vector<Cliente> clientes = listarClientes();

        for (Cliente cliente : clientes) {
            double precoBase = 100.0;
            Vaga vaga = new Vaga(precoBase);
            vaga.cliente = cliente;
            vaga.horaDeRegistro = System.currentTimeMillis();
            vagasOcupadas.add(vaga);
        }

        return vagasOcupadas;
    }
    */

    public static void writeToFIle(List<Vaga> vagas, String filePath){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Vaga vaga : vagas){
                writer.write(
                        vaga.toString()
                );
                System.out.println(vaga.toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<Vaga> readFromFile(String filePath){
        List<Vaga> vagas = new ArrayList<Vaga>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = "";

            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");

                Veiculo v = new Veiculo(Long.parseLong(parts[3]), parts[4], parts[5], Integer.parseInt(parts[6]), parts[7]);

                Cliente c = new Cliente(Long.parseLong(parts[1]), parts[2], v, Double.parseDouble(parts[8]));

                Vaga vv = new Vaga(Long.parseLong(parts[1]), c, Long.parseLong(parts[9]), Integer.parseInt(parts[10]), Double.parseDouble(parts[11]), Double.parseDouble(parts[12]));
                vagas.add(vv);
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        return vagas;
    }

    public static void removeFromFile(Long id, String filePath){
        List<Vaga> vagas = readFromFile(filePath);

        for(Vaga v : vagas){
            if(v.id == id){
                vagas.remove(v);
            }
        }

        writeToFIle(vagas, filePath);
    }

    public static void updateFile(Long id, String filePath){
        List<Vaga> vagas = readFromFile(filePath);

        for(Vaga v : vagas){
            vagas.set(vagas.indexOf(v), v);
        }

        writeToFIle(vagas, filePath);
    }
}
