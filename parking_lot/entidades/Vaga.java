package parking_lot.entidades;

import parking_lot.feramentas.Repositorio;

import java.util.Vector;

import static parking_lot.feramentas.Repositorio.listarClientes;

public class Vaga {
  public Long id;
  public Cliente  cliente;
  public long horaDeRegistro;
  public double nHoras;
  public double preco;
  public double precoBase;
  static Long IDG = 0L;

  public Vaga(double precoBase) {
    this.id = IDG + 1;
    this.cliente = cliente;
    this.horaDeRegistro = 0;
    this.nHoras = 0;
    this.precoBase = precoBase;
  }

  public void ocupar(Cliente cLiente) {
    this.nHoras = 0;
    this.preco = 0;
    this.cliente = cliente;
    this.horaDeRegistro = System.currentTimeMillis();
  }

  public void desocupar(Long id) {
    if((boolean) Repositorio.pesquisarClientePorId(id).elementAt(0)) {
      this.nHoras = (System.currentTimeMillis() - this.horaDeRegistro) / 3600000.0;
      this.cliente = null;
      this.horaDeRegistro = 0;
      this.preco = this.nHoras * precoBase;
      System.out.println("Vaga desocupada com sucesso, adeus cliente: " +  Repositorio.pesquisarClientePorId(id).elementAt(1));
    }
  }

  public boolean estaDisponivel() {
    if(this.cliente != null) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Vaga{" +
            "id=" + id +
            ", cliente=" + cliente +
            ", horaDeRegistro=" + horaDeRegistro +
            ", nHoras=" + nHoras +
            ", preco=" + preco +
            ", precoBase=" + precoBase +
            '}';
  }

}