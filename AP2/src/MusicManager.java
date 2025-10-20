import java.util.Scanner;

public class MusicManager {
    public static void main(String[] args) {
        DoublyLinkedList playlist = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Bem-vindo ao Gerenciador de Músicas!");
            System.out.println("1. Próxima música");
            System.out.println("2. Música anterior");
            System.out.println("3. Ordenar playlist");
            System.out.println("4. Tocar música");
            System.out.println("5. Adicionar música");
            System.out.println("6. Remover música");
            System.out.println("7. Listar músicas");
            System.out.println("8. Sair");
            System.out.print("Digite a opção desejada: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Limpar buffer

            switch (option) {
                case 1:
                    playlist.nextMusic();
                    break;
                case 2:
                    playlist.previousMusic();
                    break;
                case 3:
                    System.out.println("Ordenar por: 1. Título  2. Artista");
                    int sortOption = scanner.nextInt();
                    if (sortOption == 1) playlist.sortByTitle();
                    else if (sortOption == 2) playlist.sortByArtist();
                    else System.out.println("Opção inválida.");
                    break;
                case 4:
                    playlist.playCurrentMusic();
                    break;
                case 5:
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artist = scanner.nextLine();
                    System.out.print("Álbum: ");
                    String album = scanner.nextLine();
                    System.out.print("Duração (segundos): ");
                    int duration = scanner.nextInt();
                    System.out.print("Posição (0 para início, -1 para fim): ");
                    int position = scanner.nextInt();
                    if (position == -1) playlist.addLast(title, artist, album, duration);
                    else playlist.addAtPosition(position, title, artist, album, duration);
                    break;
                case 6:
                    System.out.print("Posição da música a remover: ");
                    int removePosition = scanner.nextInt();
                    playlist.removeAtPosition(removePosition);
                    break;
                case 7:
                    playlist.listMusics();
                    break;
                case 8:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 8);
    }
}