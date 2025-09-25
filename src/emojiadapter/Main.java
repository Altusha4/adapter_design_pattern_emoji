package emojiadapter;

public class Main {
    public static void main(String[] args) {
        EmojiNotificationService service = new EmojiNotificationService(); // (3)
        TextSender adapter = new EmojiTextAdapter(service);                // (4) реализует (2)
        new InteractiveClient(adapter).run();                              // (1)
    }
}
