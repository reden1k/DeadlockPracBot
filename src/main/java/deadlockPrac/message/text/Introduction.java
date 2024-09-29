package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.ArrayList;
import java.util.List;

public class Introduction {
    public static final String TITLE = "\uD83D\uDC4B Welcome to the Deadlock Practice (ASIA)";
    public static final String TEXT = "We're thrilled to have you here in our Deadlock community! This server is a place for players to train, share strategies, and connect with others who love the game, as well as participate in cash tournaments!";
    public static final ArrayList<MessageEmbed.Field> fields = new ArrayList<>(List.of(
            new MessageEmbed.Field("\uD83D\uDE80 What We Offer:", "* 🏋️‍♂️ **Training Sessions**: Join our regular practice sessions to improve your skills and learn from others.\n\n" +
                    "* 💬 **General Chat:** Discuss anything from game strategies to your favorite memes! Feel free to share your thoughts and ideas.\n\n" +
                    "* 🏆 **Tournaments**: Participate in exciting tournaments! Stay tuned for announcements about upcoming events and competitions.\n\n" +
                    "* 📜 **Also we have <#1287778800318283798>**", false)
//            new MessageEmbed.Field("📅 Upcoming Events:", "Training Session: [Date & Time]\n" +
//                    "Tournament: [Date & Time]", false)
    ));

    public static final MessageEmbed.Footer footer = new MessageEmbed.Footer("If you have any questions, feel free to reach out to the staff roles. Enjoy your stay! 🎮✨", null, null);
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1289226527141138543/introduction.gif?ex=66f95ec4&is=66f80d44&hm=e48df41c4d3498dda1a0b59aafab263b9e49c4167f82dd9e135cb582ab80ca92&";
    public static final TextChannel channel = Bot.guild.getTextChannelById(1288515975523864688L);

}
