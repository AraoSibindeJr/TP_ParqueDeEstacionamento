import java.io.IOException;

public interface IRepositorio{

    void salvarNoArquivo(Object object) throws IOException;
    Object ListarArquivo();
    void ApagarDoArquivo(Long id);
    void PesquisarPorID();
}