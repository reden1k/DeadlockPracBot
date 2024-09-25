package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.message.linkConverter.GoogleDriveConverter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Language extends GoogleDriveConverter {
    public static final String TITLE = "Language";
    public static final String TEXT = "Click on some of buttons for choose language";
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1288453704873410581/lang.gif?ex=66f53d85&is=66f3ec05&hm=ff8fdf16dce4a472ae1d2edce347fd8d4c1a30763201fe4b8202f23bceda85f3&";
    public static final TextChannel channel = Bot.jda.getTextChannelsByName("language", true).get(0);

}
