package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.message.builder.Embed;
import deadlockPrac.message.colors.ColorType;
import deadlockPrac.queue.system.Queue;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class QueueText {
    public static final String TITLE = "Queue";
    public static  String TEXT = "Current queue: 0" +
            "\n6v6 queue: 0" +
            "\n5v5 queue: 0" +
            "\n4v4 queue: 0" +
            "\n3v3 queue: 0" +
            "\n2v2 queue: 0" +
            "\n1v1 queue: 0";
    public static final String IMAGE_URL = null;
    public static final TextChannel channel = Bot.jda.getTextChannelsByName("queue", true).get(0);

    public static MessageEmbed update() {
        EmbedBuilder builder = new EmbedBuilder();

        String stringBuilder = "Current queue: " + Queue.getActiveCurrentQueueCount() + "\n" +
                "6v6 queue: " + Queue.getActiveTeamQueueCount() + "\n" +
                "5v5 queue: " + Queue.getActiveFiveQueueCount() + "\n" +
                "4v4 queue: " + Queue.getActiveFourQueueCount() + "\n" +
                "3v3 queue: " + Queue.getActiveThreeQueueCount() + "\n" +
                "2v2 queue: " + Queue.getActiveTwoQueueCount() + "\n" +
                "1v1 queue: " + Queue.getActiveOneQueueCount() + "\n";

        TEXT = stringBuilder.toString();

        return Embed.message(TITLE, TEXT, IMAGE_URL, ColorType.DEFAULT);
    }
}
