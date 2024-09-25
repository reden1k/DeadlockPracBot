package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.message.linkConverter.GoogleDriveConverter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Language extends GoogleDriveConverter {
    public static final String TITLE = "Language";
    public static final String TEXT = "Click on some of buttons for choose language";
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1288504093270343760/5.gif?ex=66f56c73&is=66f41af3&hm=2de18e19e11cf4f2c716b8067806f6e3d11226d57933a8c007c7cd6585dbc9ca&";
    public static final TextChannel channel = Bot.jda.getTextChannelsByName("language", true).get(0);

}
