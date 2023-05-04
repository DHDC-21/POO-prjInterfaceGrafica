package view;

// biblicd oteca da interface grafica
import javax.swing.*;
import java.awt.*;


// transformando a classe em um  JFrame
public class CaixaView extends JFrame {
    // definindo os atributos
    private Dimension dLabel, dTextField, dTextArea, dFrame, dButtom;
    private Label lblValor, lblSaldo;
    private TextField txtValor, txtSaldo;
    private Button cmdEntrada, cmdRetirada, cmdSaldo, cmdSaida;
    private TextArea txtMsg;

    // metodo contrutor
    public CaixaView(){

        definirAparenciaDaJanela();

        adicionarComponentesNaJanela();

        /* Observações:
         *  - Atalho: "Ctrl"+"Alt"+M
         *  - Função:  refatorar codigo, extraindo as linhas selecionadas para um método externo
         **/
    }

    private void definirAparenciaDaJanela() {
        // definir a aparencia inicial da janela
        dFrame = new Dimension(350,400);
        dLabel = new Dimension(40,20);
        dTextField = new Dimension(150,20);
        dButtom = new Dimension(95,20);
        dTextArea = new Dimension(300,140);
        this.setSize(dFrame);
        /* Obsercações:
         * 1. em java todas as propriedades da classse são definidas com o ".this";
         * */
        this.setTitle("CONTROLE DE CAIXA");
        this.setLocationRelativeTo(null); // centraliza a janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false); // para não redmensionar
        this.setLayout(null); // sem layout pre-definido
    }

    private void adicionarComponentesNaJanela() {
        // colocando os componentes na janela
        lblValor = new Label("Valor: ");
        lblValor.setSize(dLabel);
        lblValor.setLocation(25,50);
        this.add(lblValor);
        /* Observação:
         * (x,y) das coordenadas estão em reelação com o topo esquerdio;
         * */

        lblSaldo = new Label("Saldo: ");
        lblSaldo.setSize(dLabel);
        lblSaldo.setLocation(25,80);
        this.add(lblSaldo);

        txtSaldo = new TextField(null);
        txtSaldo.setSize(dTextField);
        txtSaldo.setLocation(75,80);
        this.add(txtSaldo);

        txtValor = new TextField(null);
        txtValor.setSize(dTextField);
        txtValor.setLocation(75,50);
        this.add(txtValor);

        cmdEntrada = new Button("Entrada");
        cmdEntrada.setSize(dButtom);
        cmdEntrada.setLocation(25,150);
        this.add(cmdEntrada);

        cmdRetirada = new Button("Retirada");
        cmdRetirada.setSize(dButtom);
        cmdRetirada.setLocation(180,150);
        this.add(cmdRetirada);

        cmdSaldo = new Button("Saldo");
        cmdSaldo.setSize(dButtom);
        cmdSaldo.setLocation(25,185);
        this.add(cmdSaldo);

        cmdSaida = new Button("Sair");
        cmdSaida.setSize(dButtom);
        cmdSaida.setLocation(180,185);
        this.add(cmdSaida);

        txtMsg = new TextArea(null);
        txtMsg.setSize(dTextArea);
        txtMsg.setLocation(25,220);
        this.add(txtMsg);
    }
}
