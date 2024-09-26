package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.members.QueueType;
import deadlockPrac.message.builder.Embed;
import deadlockPrac.message.colors.ColorType;
import deadlockPrac.queue.Searcher;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

public class Queue {
    public static final long CHANNEL_ID = 1287782755521925202L;
    public static final String TITLE_MAIN = "Queue";
    public static final String TEXT_MAIN = "Current queue: 0" +
            "\n\n6v6: 0" +
            "\n4v4: 0" +
            "\n2v2: 0" +
            "\n1v1: 0";
    public static final String IMAGE_URL_MAIN = null;
    public static final TextChannel channel = Bot.jda.getTextChannelById(CHANNEL_ID);

    public static void updateQueueMessage(ButtonInteractionEvent event) {
        String queueText = "Current queue: " + Searcher.getQueueOnline(null) +
                "\n\n6v6: " + Searcher.getQueueOnline(QueueType.TEAM_ON_TEAM) +
                "\n4v4: " + Searcher.getQueueOnline(QueueType.FOUR_VS_FOUR) +
                "\n2v2: " + Searcher.getQueueOnline(QueueType.TWO_VS_TWO) +
                "\n1v1: " + Searcher.getQueueOnline(QueueType.ONE_VS_ONE);

        event.editMessageEmbeds(
                Embed.message(TITLE_MAIN, queueText, IMAGE_URL_MAIN, ColorType.DEFAULT)
        ).queue();
    }

    public static void sendQueuingMessage(ButtonInteractionEvent event) {
        String title = "You are in queue!";
        String text = "";
        String imageUrl = null;

        event.replyEmbeds(
                Embed.message(title, text, imageUrl, ColorType.DEFAULT)
        ).setEphemeral(true)
                .queue();
    }
}
