package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.message.linkConverter.GoogleDriveConverter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Rules extends GoogleDriveConverter {
    public static final long CHANNEL_ID = 1287778800318283798L;
    public static final String TITLE = "Server Rules";
    public static final String TEXT = "- You are recommended to communicate with all participants in our public channels listed in the 'Chatting' section, but please choose the appropriate channel for your message and communicate in the language specified in the chat. Always be respectful; any form of hate speech, racism, sexual harassment, threats, or impersonation will result in a ban.\n" +
            "\n" +
            "- Avoid initiating or introducing unnecessary drama. Topics such as religion and politics are considered too delicate and may provoke conflict. It is best to resolve any issues directly between the parties involved in private messages.\n" +
            "\n" +
            "- Spamming in any form is prohibited, including chat clutter, excessive use of emojis or GIFs.\n" +
            "\n" +
            "- Do not disclose personal information about other participants, either publicly or privately.\n" +
            "\n" +
            "- Advertising is prohibited.";
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1288503052810191019/2.gif?ex=66f56b7b&is=66f419fb&hm=f3b66364d92532f41ac1fa4bc11e78250400590ff6da1b87a848655b0b218cfd&";
    public static final TextChannel channel = Bot.jda.getTextChannelById(CHANNEL_ID);
}
