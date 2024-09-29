package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class HowTo {
    public static final Long CHANNEL_ID = 1288522856166195223L;
    public static final String TITLE = "How to";
    public static final String TEXT = "**- General Information: In the <#1288515975523864688>, you can learn about what the server is about and the opportunities it offers.\n" +
            "\n" +
            "- Language Selection: To open chats in your language, simply choose it in the <#1288360757842546698>.\n" +
            "\n" +
            "- News: All updates about tournaments, cash prizes, and new features are available in the <#1287780873269153803>.\n" +
            "\n" +
            "- Practice Matches: To participate in practice matches, go to the <#1287782755521925202>, select your desired mode, and start searching. To cancel the search, click the cancel button. Once a game is found, a room will be created with the leaders of both teams.\n" +
            "\n" +
            "- Creating a Voice Channel: You can create your own voice channel by entering the <#1289319214397657188>**";
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1289226527531335780/how_to.gif?ex=66f95ec4&is=66f80d44&hm=9a1b080122ddffebea65e49fed819fc01fcf827c9b3a71497c58152549e54619&";
    public static final TextChannel channel = Bot.guild.getTextChannelById(CHANNEL_ID);
}
