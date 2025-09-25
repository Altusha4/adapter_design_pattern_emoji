package emojiadapter;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public final class EmojiReplacer {
    private record Rule(Pattern pattern, String replacement) { }

    private final List<Rule> rules;

    public EmojiReplacer() {
        this.rules = List.of(
                rule("(?i)\\bthank you\\b", "🙏"),
                rule("(?i)\\bgood morning\\b", "☀️"),
                rule("(?i)\\bgood night\\b", "🌙"),
                rule("(?i)\\bi love you\\b", "❤️"),
                rule("(?i)\\bhello\\b", "👋"),
                rule("(?i)\\bhi\\b", "👋"),
                rule("(?i)\\blove\\b", "❤️"),
                rule("(?i)\\blike\\b", "👍"),
                rule("(?i)\\bok\\b", "👌"),
                rule("(?i)\\bcool\\b", "😎"),
                rule("(?i)\\bfire\\b", "🔥"),
                rule("(?i)\\bhappy\\b", "😊"),
                rule("(?i)\\bsad\\b", "😢"),
                rule("(?i)\\bcat\\b", "🐱"),
                rule("(?i)\\bdog\\b", "🐶"),
                rule("(?i)\\bcoffee\\b", "☕"),
                rule("(?i)\\bmoney\\b", "💸")
        );
    }
    public String apply(String input) {
        if (input == null || input.isBlank()) return "💤";
        String out = input;
        for (Rule r : rules) {
            out = r.pattern.matcher(out).replaceAll(r.replacement);
        }
        return out;
    }
    private static Rule rule(String regex, String replacement) {
        Objects.requireNonNull(regex);
        Objects.requireNonNull(replacement);
        return new Rule(Pattern.compile(regex), replacement);
    }
}
