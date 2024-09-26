package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.members.ServerMember;
import deadlockPrac.message.builder.Embed;
import deadlockPrac.message.colors.ColorType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class QueueChat {
    public static void sendMessage(ServerMember player, ServerMember anotherPlayer) {
        String title = player.getName() + " VS " + anotherPlayer.getName();
        String text = "Example of message queue found";
        String imageUrl = null;
        TextChannel channel = Bot.jda.getTextChannelById(player.getCreatedChannelId());

        channel.sendMessageEmbeds(Embed.message(title, text, imageUrl, ColorType.DEFAULT)).queue();
    }
}
