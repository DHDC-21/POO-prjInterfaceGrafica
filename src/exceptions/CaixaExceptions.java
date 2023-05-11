package exceptions;

public class CaixaExceptions extends Exception{
    private int codigoDoErro;

    public CaixaExceptions(int codigoDoErro){
        this.codigoDoErro = codigoDoErro;
    }

    @Override
    public String getMessage(){
        String erro = "";
        switch (codigoDoErro){
            case 1:
                erro = "Valor do depósito deve ser positivo";
                break;
            case 2:
                erro = "Saldo indisponível para este saque";
                break;
        }
        return erro;
    }
}
