public class DoublyLinkedList {
    private MusicNode head;
    private MusicNode current;  // Para navegação

    public DoublyLinkedList() {
        head = null;
        current = null;
    }

    public void addFirst(String title, String artist, String album, int duration) {
        MusicNode newNode = new MusicNode(title, artist, album, duration);
        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(String title, String artist, String album, int duration) {
        MusicNode newNode = new MusicNode(title, artist, album, duration);
        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            MusicNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public void addAtPosition(int position, String title, String artist, String album, int duration) {
        MusicNode newNode = new MusicNode(title, artist, album, duration);
        if (position == 0) {
            addFirst(title, artist, album, duration);
            return;
        }
        MusicNode currentNode = head;
        for (int i = 0; i < position && currentNode != null; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode != null) {
            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;
        }
    }

    public void removeAtPosition(int position) {
        MusicNode currentNode = head;
        for (int i = 0; i < position && currentNode != null; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode != null) {
            if (currentNode.prev != null) {
                currentNode.prev.next = currentNode.next;
            } else {
                head = currentNode.next;
            }
            if (currentNode.next != null) {
                currentNode.next.prev = currentNode.prev;
            }
        }
    }

    public void listMusics() {
        MusicNode currentNode = head;
        int index = 0;
        while (currentNode != null) {
            System.out.println("Índice: " + index + ", Título: " + currentNode.title + ", Artista: " + currentNode.artist +
                    ", Álbum: " + currentNode.album + ", Duração: " + currentNode.duration + " segundos");
            currentNode = currentNode.next;
            index++;
        }
    }

    public void nextMusic() {
        if (current != null && current.next != null) {
            current = current.next;
            playCurrentMusic();
        } else {
            System.out.println("Fim da playlist.");
        }
    }

    public void previousMusic() {
        if (current != null && current.prev != null) {
            current = current.prev;
            playCurrentMusic();
        } else {
            System.out.println("Início da playlist.");
        }
    }

    public void playCurrentMusic() {
        if (current != null) {
            System.out.println("Tocando: " + current.title + " por " + current.artist + " do álbum " + current.album +
                    ", Duração: " + current.duration + " segundos");
        }
    }

    public void sortByTitle() {
        if (head == null) return;
        boolean swapped;
        MusicNode ptr1;
        do {
            swapped = false;
            ptr1 = head;
            while (ptr1 != null && ptr1.next != null) {
                if (ptr1.title.compareTo(ptr1.next.title) > 0) {
                    String tempTitle = ptr1.title;
                    String tempArtist = ptr1.artist;
                    String tempAlbum = ptr1.album;
                    int tempDuration = ptr1.duration;

                    ptr1.title = ptr1.next.title;
                    ptr1.artist = ptr1.next.artist;
                    ptr1.album = ptr1.next.album;
                    ptr1.duration = ptr1.next.duration;

                    ptr1.next.title = tempTitle;
                    ptr1.next.artist = tempArtist;
                    ptr1.next.album = tempAlbum;
                    ptr1.next.duration = tempDuration;

                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
        } while (swapped);
    }

    public void sortByArtist() {
        if (head == null) return;
        boolean swapped;
        MusicNode ptr1;
        do {
            swapped = false;
            ptr1 = head;
            while (ptr1 != null && ptr1.next != null) {
                if (ptr1.artist.compareTo(ptr1.next.artist) > 0) {
                    String tempTitle = ptr1.title;
                    String tempArtist = ptr1.artist;
                    String tempAlbum = ptr1.album;
                    int tempDuration = ptr1.duration;

                    ptr1.title = ptr1.next.title;
                    ptr1.artist = ptr1.next.artist;
                    ptr1.album = ptr1.next.album;
                    ptr1.duration = ptr1.next.duration;

                    ptr1.next.title = tempTitle;
                    ptr1.next.artist = tempArtist;
                    ptr1.next.album = tempAlbum;
                    ptr1.next.duration = tempDuration;

                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
        } while (swapped);
    }
}