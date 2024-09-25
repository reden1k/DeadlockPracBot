package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.message.linkConverter.GoogleDriveConverter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Verification extends GoogleDriveConverter {
    public static final String TITLE = "Verification";
    public static final String TEXT = "Click on ✅ for verification";
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1288503117440352368/3.gif?ex=66f56b8a&is=66f41a0a&hm=8b406f7e659e20cbbfd2eff61450fa887948db0ff0a2e8323eca6f7c75793220&";
    public static final TextChannel channel = Bot.jda.getTextChannelsByName("verification", true).get(0);
}
