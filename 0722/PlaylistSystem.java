public class PlaylistSystem {
    public static void main(String[] args) {
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        System.out.println("=== 1. 新增歌曲 ===");
        playlist.addLast("S01", "Song A");
        playlist.addLast("S02", "Song B");
        playlist.addLast("S03", "Song C");
        playlist.addLast("S01", "Duplicate Song");

        playlist.printPlaylist();

        System.out.println("\n=== 2. 搜尋歌曲 ===");
        PlaylistNode found = playlist.findByCode("S02");
        if (found != null) {
            System.out.println("✅ 找到歌曲：" + found);
        } else {
            System.out.println("❌ 查無此歌曲！");
        }

        System.out.println("\n=== 3. 刪除第一首 (S01) ===");
        if (playlist.removeByCode("S01")) {
            System.out.println("✅ 成功刪除 S01");
        }
        playlist.printPlaylist();

        System.out.println("\n=== 4. 刪除最後一首 (S03) ===");
        if (playlist.removeByCode("S03")) {
            System.out.println("✅ 成功刪除 S03");
        }
        playlist.printPlaylist();
    }
}