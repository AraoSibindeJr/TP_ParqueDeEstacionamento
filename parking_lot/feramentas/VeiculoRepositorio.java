package parking_lot.feramentas;

import parking_lot.entidades.Veiculo;

import java.io.FileReader;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class VeiculoRepositorio{


    public void salvarNoArquivo(Veiculo veiculo) throws IOException {
        FileWriter writer = new FileWriter("veiculos.txt");
        writer.write(veiculo.veiculoDTO() + "\n");
    }

    public List<Veiculo> ListarArquivo() throws IOException{
        StringTokenizer st = new StringTokenizer(";");
        FileReader fr = new FileReader("veiculos.txt");
        List<Veiculo> veiculos = new ArrayList<>();
        int data = fr.read();

        while(data != -1){


        }

        return veiculos;
    }


    public void ApagarDoArquivo(Long id) {

    }

    @
    public void PesquisarPorID() {

    }
}
