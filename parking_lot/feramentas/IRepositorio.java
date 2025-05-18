import java.io.IOException;

public interface IRepositorio{

    void salvarNoArquivo(Object object) throws IOException;
    void LerArquivo();
    void ListarArquivo();
    void ApagarDoArquivo();
    void PesquisarPorID();
}