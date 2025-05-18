import java.io.IOException;

public interface IRepositorio{

    void salvarNoArquivo(Object object) throws IOException;
    void LerArquivo();
    Object ListarArquivo();
    void ApagarDoArquivo();
    void PesquisarPorID();
}