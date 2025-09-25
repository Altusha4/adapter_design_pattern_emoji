package emojiadapter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmojiNotificationService service = new EmojiNotificationService();
        TextSender sender = new EmojiTextAdapter(service);

        System.out.println("Type a message (use /exit to quit)...");
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                if (!sc.hasNextLine()) break;
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("/exit")) {
                    System.out.println("Bye!");
                    break;
                }
                sender.send(line);
            }
        }
    }
}
