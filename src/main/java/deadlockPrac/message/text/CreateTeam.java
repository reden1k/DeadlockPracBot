package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class CreateTeam {
    public static final String TITLE = "Create team";
    public static final String TEXT = "Type /create-team and mention your teammates";
    public static final String IMAGE_URL = null;
    public static final TextChannel channel = Bot.jda.getTextChannelsByName("create-team", true).get(0);
}
