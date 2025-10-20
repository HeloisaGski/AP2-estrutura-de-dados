public class MusicNode {
    String title;
    String artist;
    String album;
    int duration;  // Em segundos
    MusicNode next;
    MusicNode prev;

    public MusicNode(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.next = null;
        this.prev = null;
    }
}