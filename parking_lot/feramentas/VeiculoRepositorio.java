
import java.io.FileWriter;
import java.io.IOException;

public class VeiculoRepositorio implements IRepositorio{

    @Override
    public void salvarNoArquivo(Object object) throws IOException {
        String fileName = "veiculos-salvos.txt";

        FileWriter fr = new FileWriter(object.toString());
        
    }

    @Override
    public void LerArquivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LerArquivo'");
    }

    @Override
    public void ListarArquivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ListarArquivo'");
    }

    @Override
    public void ApagarDoArquivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ApagarDoArquivo'");
    }

    @Override
    public void PesquisarPorID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PesquisarPorID'");
    }
    
}
