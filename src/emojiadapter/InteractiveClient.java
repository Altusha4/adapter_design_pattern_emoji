package emojiadapter;

import java.util.Scanner;

public class InteractiveClient {
    private final TextSender sender;

    public InteractiveClient(TextSender sender) { this.sender = sender; }

    public void run() {
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
