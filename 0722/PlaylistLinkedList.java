public class PlaylistLinkedList {
    private PlaylistNode head;

    public boolean addLast(String code, String title) {
        if (findByCode(code) != null) {
            System.out.println("❌ 新增失敗：歌曲代碼 [" + code + "] 已存在！");
            return false;
        }

        PlaylistNode newNode = new PlaylistNode(code, title);
        if (head == null) {
            head = newNode;
            return true;
        }

        PlaylistNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return true;
    }

    public PlaylistNode findByCode(String code) {
        PlaylistNode current = head;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean removeByCode(String code) {
        if (head == null) {
            return false;
        }

        if (head.code.equalsIgnoreCase(code)) {
            head = head.next;
            return true;
        }


        
        PlaylistNode current = head;
        while (current.next != null) {
            if (current.next.code.equalsIgnoreCase(code)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printPlaylist() {
        if (head == null) {
            System.out.println("播放清單為空。");
            return;
        }

        PlaylistNode current = head;
        System.out.println("=== 完整播放順序 ===");
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current);
            current = current.next;
            index++;
        }
    }
}