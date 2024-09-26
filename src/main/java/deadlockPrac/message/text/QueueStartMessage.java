package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.message.builder.Embed;
import deadlockPrac.message.colors.ColorType;
import deadlockPrac.queue.system.Queue;
import deadlockPrac.queue.system.team.Team;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class QueueStartMessage {
    public static final String TITLE = "Started queue";
    public static final String TEXT = "You currently in queue";
    public static final String IMAGE_URL = null;
    public static final TextChannel channel = Bot.jda.getTextChannelsByName("queue", false).get(0);

    public static MessageEmbed createMessage(Member member) {
        Team team = Queue.getTeamByLeader(member);

        String teamType = Queue.getTeamType(team);

        return Embed.message(TITLE, TEXT + teamType, IMAGE_URL, ColorType.DEFAULT);
    }
}
