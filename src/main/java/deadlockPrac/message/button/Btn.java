package deadlockPrac.message.button;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Btn {
    public static final Button sendMessage = Button.primary("admin::send-message", "Сообщение");
    public static final Button verification = Button.secondary("verification", Emoji.fromFormatted("✅"));
    public static final Button langRu = Button.secondary("lang-ru", Emoji.fromFormatted("\uD83C\uDDF7\uD83C\uDDFA"));
    public static final Button langEng = Button.secondary("lang-eng", Emoji.fromFormatted("\uD83C\uDDEC\uD83C\uDDE7"));
    public static final Button queue = Button.primary("queue", "Queue");
}
