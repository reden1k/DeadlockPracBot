package deadlockPrac.message.button;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Btn {
    public static final Button sendMessage = Button.primary("admin::send-message", "Сообщение");
    public static final Button verification = Button.secondary("verification", Emoji.fromFormatted("✅"));
    public static final Button langRu = Button.secondary("lang-ru", Emoji.fromFormatted("\uD83C\uDDF7\uD83C\uDDFA"));
    public static final Button langEng = Button.secondary("lang-eng", Emoji.fromFormatted("\uD83C\uDDEC\uD83C\uDDE7"));
    public static final Button oneVsOne = Button.primary("1v1", "1v1");
    public static final Button twoVsTwo = Button.secondary("2v2", "2v2");
    public static final Button fourVsFour = Button.secondary("4v4", "4v4");
    public static final Button teamOnTeam = Button.secondary("6v6", "6v6");
}
