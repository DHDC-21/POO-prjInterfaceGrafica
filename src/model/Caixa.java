package model;

public class Caixa {
    // definindo atributos
    private double saldo;
    public boolean depositar(double valor){
        if(valor>0){
            saldo+=valor;
            return true;
        }
        return false;
    }
    public boolean sacar(double vlaor){
        if (valor<= saldo){
            saldo-=valor;
            return true;
        }
        return false;
    }
    public double getSaldo(){
        return saldo;
    }
}
