
import java.io.FileWriter;
import java.io.IOException;

public class VeiculoRepositorio implements IRepositorio{

    @Override
    public void salvarNoArquivo(Object object) throws IOException {
        String fileName = "veiculos-salvos.txt";
        StringTokenizer st = new StringTokenizer();


        FileWriter fr = new FileWriter(object.toString());
        
    }

    @Override
    public List<Object obj> ListarArquivo() {
       return null;
    }

    @Override
    public void ApagarDoArquivo(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ApagarDoArquivo'");
    }

    @Override
    public void PesquisarPorID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PesquisarPorID'");
    }
    
    public Veiculo fileToObject(){
        StringTokenizer
    }
}
