import java.util.Scanner;

public class Agenda {
    private String[][] contatos;
    private int contador;

    // Construtor
    public Agenda(int tamanho) {
        contatos = new String[tamanho][2]; // 2 colunas: uma para o nome, outra para o telefone
        contador = 0;
    }

    // Método para entrada de dados
    public void entDados() {
        Scanner scanner = new Scanner(System.in);
        if (contador < contatos.length) {
            System.out.println("Digite o nome:");
            contatos[contador][0] = scanner.nextLine();
            System.out.println("Digite o telefone:");
            contatos[contador][1] = scanner.nextLine();
            contador++;
        } else {
            System.out.println("Agenda cheia!");
        }
    }

    // Método para imprimir os dados da agenda
    public void imprimir() {
        System.out.println("Agenda de Contatos:");
        for (int i = 0; i < contador; i++) {
            System.out.println("Nome: " + contatos[i][0] + " - Telefone: " + contatos[i][1]);
        }
    }

    // Método para buscar um nome na agenda
    public void buscar(String nome) {
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (contatos[i][0].equalsIgnoreCase(nome)) {
                System.out.println("Nome: " + contatos[i][0] + " - Telefone: " + contatos[i][1]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }
}