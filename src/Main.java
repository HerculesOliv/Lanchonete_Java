import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Lanches> lanchesDisponiveis = new ArrayList<>();
    private static List<Venda> vendasRealizadas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu\n1- Cadastrar Lanche\n2- Ver Lanches Disponiveis\n3- Realizar Venda\n4- Listar Vendas\n5- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLanche(scanner);
                    break;

                case 2:
                    verLanchesDisponiveis();
                    break;

                case 3: 
                    realizarVendas(scanner);
                    break;

                case 4:
                    listarVendasRealizadas();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarLanche(Scanner scanner) {
        System.out.print("Digite o Nome do Lanche: ");
        String nomeLanche = scanner.nextLine();
        System.out.print("Digite o Valor: ");
        double valor = scanner.nextDouble(); // Alterado para aceitar valores numéricos
        scanner.nextLine(); // Consumir a nova linha restante
        System.out.print("Digite os Ingredientes: ");
        String ingredientes = scanner.nextLine();

        Lanches novoLanche = new Lanches(nomeLanche, valor, ingredientes);
        lanchesDisponiveis.add(novoLanche);

        System.out.println("Lanche Cadastrado!");
    }

    private static void verLanchesDisponiveis() {
        if (lanchesDisponiveis.isEmpty()) {
            System.out.println("Nenhum Lanche Disponivel.");
        } else {
            System.out.println("Lanches Disponiveis: ");
            for (Lanches lanche : lanchesDisponiveis) {
                System.out.println(lanche);
            }
        }
    }

    private static void realizarVendas(Scanner scanner) {
        System.out.println("Lanches Disponiveis: ");
        for (int i = 0; i < lanchesDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + lanchesDisponiveis.get(i)); 
        }
        System.out.print("Escolha o Número do Lanche para Vender: ");
        int indiceLanche = scanner.nextInt();
        scanner.nextLine();

        if (indiceLanche > 0 && indiceLanche <= lanchesDisponiveis.size()) {
            Lanches lancheVendido = lanchesDisponiveis.get(indiceLanche - 1);
            vendasRealizadas.add(new Venda(lancheVendido));
            System.out.println("Venda Realizada: " + lancheVendido);  
        } else {
            System.out.println("Número do Lanche Inválido.");
        }        
    }

    private static void listarVendasRealizadas() {
        if (vendasRealizadas.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
        } else {
            System.out.println("Vendas Realizadas: ");
            for (Venda venda : vendasRealizadas) {
                System.out.println(venda);
            }
        }
    }
}

class Lanches {
    private String nomeLanche;
    private double valor; // Alterado para tipo primitivo double
    private String ingredientes;

    public Lanches(String nomeLanche, double valor, String ingredientes) {
        this.nomeLanche = nomeLanche;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public String toString() {
        return "Nome do Lanche: " + nomeLanche + ", Valor: R$" + valor + ", Ingredientes: " + ingredientes; 
    }
}

class Venda {
    private Lanches lancheVendido;

    public Venda(Lanches lancheVendido) {
        this.lancheVendido = lancheVendido;
    }

    public String toString() {
        return "Venda do Lanche: " + lancheVendido;
    }
}