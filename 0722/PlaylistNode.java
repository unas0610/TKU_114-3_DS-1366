public class PlaylistNode {
    String code;
    String title;
    PlaylistNode next;

    public PlaylistNode(String code, String title) {
        this.code = code;
        this.title = title;
        this.next = null;
    }
    @Override
    public String toString() {
        return "[" + code + "] " + title;
    }
}