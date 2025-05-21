public class Vaga { 
  public int ID;
  public Veiculo veiculo;
  public long horaDeRegistro;
  public double nHoras;
  public double preco;

  public Vaga(int ID) {
    this.ID = ID;
    this.veiculo = null;
    this.horaDeRegistro = 0;
    this.nHoras = 0;
  }

  public void ocupar(Veiculo veiculo) {
    this.nHoras = 0;
    this.preco = 0;
    this.veiculo = veiculo;
    this.horaDeRegistro = System.currentTimeMillis();
  }

  public void desocupar(double precoBase) {
    this.nHoras = (double)(this.horaDeRegistro - System.currentTimeMillis()) / 3600000.0;
    this.veiculo = null;
    this.horaDeRegistro = 0;
    this.preco = this.nHoras * precoBase;
  }

  public boolean estaDisponivel() {
    return this.veiculo == null;
  }

  public Veiculo getVeiculo() {
    if (this.veiculo == null) { 
      return null; 
    }
    return this.veiculo;
  }

  public double getPreco() {
    return this.preco;
  }

  public int getID() {
    return this.ID;
  }
}