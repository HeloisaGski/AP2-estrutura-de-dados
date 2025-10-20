import java.util.Scanner;

public class PedidoSystem {
    private static Queue queue = new Queue();
    private static Stack stack = new Stack();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Sistema de Gerenciamento de Pedidos:");
            System.out.println("1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o ID do pedido: ");
                    String idAdd = scanner.nextLine();
                    System.out.print("Digite a descrição do pedido: ");
                    String descAdd = scanner.nextLine();
                    queue.enqueue(idAdd, descAdd);
                    System.out.println("Pedido adicionado à fila.");
                    break;

                case 2:
                    Node attended = queue.dequeue();
                    if (attended != null) {
                        System.out.println("Pedido atendido: ID " + attended.id + ", Descrição: " + attended.description);
                    } else {
                        System.out.println("Nenhum pedido pendente.");
                    }
                    break;

                case 3:
                    Node canceled = queue.dequeue();
                    if (canceled != null) {
                        stack.push(canceled.id, canceled.description);
                        System.out.println("Pedido cancelado: ID " + canceled.id + ", Descrição: " + canceled.description);
                    } else {
                        System.out.println("Nenhum pedido pendente para cancelar.");
                    }
                    break;

                case 4:
                    Node restored = stack.pop();
                    if (restored != null) {
                        queue.enqueue(restored.id, restored.description);
                        System.out.println("Pedido restaurado: ID " + restored.id + ", Descrição: " + restored.description);
                    } else {
                        System.out.println("Nenhum pedido cancelado para restaurar.");
                    }
                    break;

                case 5:
                    queue.printQueue();
                    break;

                case 6:
                    stack.printStack();
                    break;

                case 7:
                    System.out.println("Saindo do sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 7);
    }
}