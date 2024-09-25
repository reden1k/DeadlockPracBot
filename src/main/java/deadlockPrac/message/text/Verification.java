package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.message.linkConverter.GoogleDriveConverter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Verification extends GoogleDriveConverter {
    public static final String TITLE = "Verification";
    public static final String TEXT = "Click on ✅ for verification";
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1288449616723050518/verify.gif?ex=66f539b6&is=66f3e836&hm=9278a4e258fcce585dbfeeff0a9b6c315082f9fa9bc9dd21f23abeaa18b2b908&";
    public static final TextChannel channel = Bot.jda.getTextChannelsByName("verification", true).get(0);
}
