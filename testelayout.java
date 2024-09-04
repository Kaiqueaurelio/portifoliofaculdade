package exemplolayouyt;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exemplolayouyt extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buttonNorth, buttonSouth, buttonEast, buttonWest, buttonCenter;
    private static int xOffset = 30; // Deslocamento em X para sobreposição
    private static int yOffset = 30; // Deslocamento em Y para sobreposição

    public Exemplolayouyt() {
        // Configurações da janela
        setTitle("Exemplo de Layout com Botões");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento de fechamento

        // Definindo o layout como BorderLayout
        setLayout(new BorderLayout());

        // Criando os botões
        buttonNorth = new JButton("Norte");
        buttonSouth = new JButton("Sul");
        buttonEast = new JButton("Leste");
        buttonWest = new JButton("Oeste");
        buttonCenter = new JButton("Centro");

        // Registrando os listeners para os botões
        buttonNorth.addActionListener(this);
        buttonSouth.addActionListener(this);
        buttonEast.addActionListener(this);
        buttonWest.addActionListener(this);
        buttonCenter.addActionListener(this);

        // Adicionando os botões ao layout BorderLayout
        add(buttonNorth, BorderLayout.NORTH);
        add(buttonSouth, BorderLayout.SOUTH);
        add(buttonEast, BorderLayout.EAST);
        add(buttonWest, BorderLayout.WEST);
        add(buttonCenter, BorderLayout.CENTER);
    }

    public static void incrementOffsets() {
        // Atualizando o deslocamento para a próxima janela
        xOffset += 30;
        yOffset += 30;

        // Reseta o deslocamento se sair da tela
        if (xOffset > 800) xOffset = 30;
        if (yOffset > 600) yOffset = 30;
    }

    public static int getXOffset() {
        return xOffset;
    }

    public static int getYOffset() {
        return yOffset;
    }

    public static void main(String[] args) {
        // Criando e exibindo a janela principal
        Exemplolayouyt frame = new Exemplolayouyt();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Determinando qual botão foi clicado e abrindo a janela correspondente
        if (e.getSource() == buttonNorth) {
            NovaJanela novaJanela = new NovaJanela("Você clicou no Norte", "Clique no botão Norte");
            novaJanela.setVisible(true);
        } else if (e.getSource() == buttonSouth) {
            NovaJanela novaJanela = new NovaJanela("Você clicou no Sul", "Clique no botão Sul");
            novaJanela.setVisible(true);
        } else if (e.getSource() == buttonEast) {
            NovaJanela novaJanela = new NovaJanela("Você clicou no Leste", "Clique no botão Leste");
            novaJanela.setVisible(true);
        } else if (e.getSource() == buttonWest) {
            NovaJanela novaJanela = new NovaJanela("Você clicou no Oeste", "Clique no botão Oeste");
            novaJanela.setVisible(true);
        } else if (e.getSource() == buttonCenter) {
            NovaJanela novaJanela = new NovaJanela("Você clicou no Centro", "Clique no botão Centro");
            novaJanela.setVisible(true);
        }
    }
}

// Nova classe para representar a nova janela
class NovaJanela extends JFrame implements ActionListener {

    private JButton actionButton;
    private JButton closeButton;

    public NovaJanela(String mensagem, String buttonText) {
        // Configurações da nova janela
        setTitle("Nova Janela");
        setSize(300, 150);

        // Determinando a posição da nova janela com base no deslocamento
        setLocation(Exemplolayouyt.getXOffset(), Exemplolayouyt.getYOffset());

        // Atualizando o deslocamento para a próxima janela
        Exemplolayouyt.incrementOffsets();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a nova janela

        // Painel principal com layout BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Adicionando um rótulo com a mensagem personalizada à nova janela
        JLabel label = new JLabel(mensagem);
        label.setHorizontalAlignment(JLabel.CENTER); // Centraliza o texto no eixo X
        panel.add(label, BorderLayout.CENTER);

        // Adicionando um botão que fará uma ação ao ser clicado
        actionButton = new JButton(buttonText);
        actionButton.addActionListener(this);
        panel.add(actionButton, BorderLayout.NORTH);

        // Adicionando um botão para fechar esta janela
        closeButton = new JButton("Fechar esta janela");
        closeButton.addActionListener(this);
        panel.add(closeButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == actionButton) {
            // Exibir mensagem ao clicar no botão da nova janela
            System.out.println("Botão da nova janela foi clicado!");
        } else if (e.getSource() == closeButton) {
            // Fecha apenas esta janela
            this.dispose();
        }
    }
}
