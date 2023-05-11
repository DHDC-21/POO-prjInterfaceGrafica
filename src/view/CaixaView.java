package view;

// biblicd oteca da interface grafica
import model.Caixa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


// transformando a classe em um  JFrame
public class CaixaView extends JFrame implements WindowListener, ActionListener {
    // definindo os atributos
    private Dimension dLabel, dTextField, dTextArea, dFrame, dButtom;
    private Label lblValor, lblSaldo;
    private TextField txtValor, txtSaldo;
    private Button cmdEntrada, cmdRetirada, cmdSaldo, cmdSaida;
    private TextArea txtMsg;
    private Caixa caixa = new Caixa();

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

        this.addWindowListener(this);
        cmdEntrada.addActionListener(this);
        cmdRetirada.addActionListener(this);
        cmdSaldo.addActionListener(this);
        cmdSaida.addActionListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(
                null,
                "Saindo com cuidado",
                "Saind do programa",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* observação: "e" representa o evento a ser acionado */
        if(e.getSource() == cmdEntrada){
            // tratamento de exceção
            try {
                // pegar o valor do textfield
                double valor = Double.parseDouble(txtValor.getText());
                boolean ok = caixa.depositar(valor);
                if (ok) {
                    // condição verdadeira
                    txtMsg.append("Deposito de " + valor + " feito \n"); // append é anexar, em outras palavras ele concatena e
                } else {
                    // condição falsa
                    txtMsg.append("Valor inválido para depósito \n"); // append é anexar, em outras palavras ele concatena e
                }
                txtValor.setText(null);
                txtValor.requestFocus();
                return;
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null,
                        "Erro: "+ex.getMessage(),
                        "Atenção!",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        if (e.getSource() == cmdRetirada){
            // tratamento de exceção
            try {
                // pegar o valor do textfield
                double valor = Double.parseDouble(txtValor.getText());
                txtMsg.append("Saque de " + valor + " feito \n"); // append é anexar, em outras palavras ele concatena e
                txtValor.setText(null);
                txtValor.requestFocus();
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null,
                        "Erro: "+ex.getMessage(),
                        "Atenção!",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        if (e.getSource() == cmdSaldo){
            txtSaldo.setText(Double.toString(caixa.getSaldo()));
            return;
        }
        if (e.getSource() == cmdSaida){
            windowClosing(null);
            System.exit(0);
        }
    }
}
