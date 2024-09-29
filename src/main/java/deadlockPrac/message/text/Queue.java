package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.members.QueueType;
import deadlockPrac.members.ServerMember;
import deadlockPrac.members.ServerMembers;
import deadlockPrac.message.builder.Embed;
import deadlockPrac.message.button.Btn;
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
    public static final String IMAGE_URL_MAIN = "https://cdn.discordapp.com/attachments/581047676695478282/1289636505479811102/queue.gif?ex=66f98b17&is=66f83997&hm=aa23059065f626f77f2ff911ce2878d2f719cd7292f0087dc099c87a725bb9ad&";
    public static final TextChannel channel = Bot.jda.getTextChannelById(CHANNEL_ID);

    public static void updateQueueMessage() {
        String queueText = "Current queue: " + Searcher.getQueueOnline(null) +
                "\n\n6v6: " + Searcher.getQueueOnline(QueueType.TEAM_ON_TEAM) +
                "\n4v4: " + Searcher.getQueueOnline(QueueType.FOUR_VS_FOUR) +
                "\n2v2: " + Searcher.getQueueOnline(QueueType.TWO_VS_TWO) +
                "\n1v1: " + Searcher.getQueueOnline(QueueType.ONE_VS_ONE);

        channel.editMessageEmbedsById(
                1289637686801596477L, Embed.message(TITLE_MAIN, queueText, IMAGE_URL_MAIN, ColorType.DEFAULT)
        ).queue();
    }
    public static void sendQueuingMessage(ButtonInteractionEvent event, String queueType) {
        ServerMember serverMember = ServerMembers.getMemberById(event.getMember().getIdLong());

        String title = "You are in queue!";
        String text = null;
        String imageUrl = null;


        if (serverMember.isInQueue()) {
            title = "Queue changed to " + queueType;
        }

        event.replyEmbeds(
                Embed.message(title, text, imageUrl, ColorType.DEFAULT)
        ).setActionRow(Btn.cancelQueue)
                .setEphemeral(true)
                .queue();
    }
}
