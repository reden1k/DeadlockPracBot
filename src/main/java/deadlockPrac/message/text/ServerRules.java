package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.message.linkConverter.GoogleDriveConverter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class ServerRules extends GoogleDriveConverter {
    public static final String TITLE = "Server Rules";
    public static final String TEXT = "Example rules";
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1288456359918178396/rules.gif?ex=66f53ffe&is=66f3ee7e&hm=8a54a4b7f7edb606ad218432f293dd7d5caaca9492baae88e21099c00fbf64b0&";
    public static final TextChannel channel = Bot.jda.getTextChannelsByName("server-rules", true).get(0);
}
