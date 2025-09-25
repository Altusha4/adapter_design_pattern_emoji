package emojiadapter;

public class EmojiTextAdapter implements TextSender {
    private final EmojiNotificationService service;
    private final EmojiReplacer replacer;

    public EmojiTextAdapter(EmojiNotificationService service) {
        this.service = service;
        this.replacer = new EmojiReplacer();
    }
    @Override
    public void send(String text) {
        service.deliver(replacer.apply(text));
    }
}
