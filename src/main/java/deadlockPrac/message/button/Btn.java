package deadlockPrac.message.button;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Btn {
    public static final Button sendMessage = Button.primary("admin::send-message", "Сообщение");
    public static final Button verification = Button.secondary("verification", Emoji.fromUnicode("U+2705"));
    public static final Button langRu = Button.secondary("lang-ru", Emoji.fromUnicode("U+1F1F7"));
    public static final Button langEng = Button.secondary("lang-eng", Emoji.fromUnicode("U+1F1E7"));
}
