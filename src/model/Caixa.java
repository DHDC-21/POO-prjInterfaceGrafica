package model;

import exceptions.CaixaExceptions;

public class Caixa {
    // definindo atributos
    private double saldo;
    public void depositar(double valor) throws CaixaExceptions {
        if(valor>0){
            saldo+=valor;
        }else {
            throw new CaixaExceptions(1);
        }
    }
    public void sacar(double valor) throws CaixaExceptions{
        if (valor<= saldo){
            saldo-=valor;
        }else {
            throw new CaixaExceptions(2);
        }
    }
    public double getSaldo(){
        return saldo;
    }
}
