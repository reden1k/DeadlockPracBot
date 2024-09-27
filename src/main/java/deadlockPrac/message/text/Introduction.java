package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.bot.RoleId;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Introduction {
    public static final String TITLE = "\uD83D\uDC4B Welcome to the Deadlock Practice (ASIA)";
    public static final String TEXT = "# \uD83D\uDC4B Welcome to the Deadlock Practice (ASIA)\n" +
            "\n" +
            "**We're thrilled to have you here in our Deadlock community! This server is a place for players to train, share strategies, and connect with others who love the game, \n" +
            "as well as participate in cash tournaments!**\n" +
            "\n" +
            "## \uD83D\uDE80 What We Offer:\n" +
            "- \uD83C\uDFCB\uFE0F\u200D♂\uFE0F **Training Sessions**: Join our regular practice sessions to improve your skills and learn from others.\n" +
            "- \uD83D\uDCAC **General Chat:** Discuss anything from game strategies to your favorite memes! Feel free to share your thoughts and ideas.\n" +
            "- \uD83C\uDFC6 **Tournaments**: Participate in exciting tournaments! Stay tuned for announcements about upcoming events and competitions.\n" +
            "- \uD83D\uDCDC **Also we have <#1287778800318283798> **\n" +
            "## \uD83D\uDCC5 Upcoming Events:\n" +
            "Training Session: [Date & Time]\n" +
            "Tournament: [Date & Time]\n" +
            "If you have any questions, feel free to reach out to the <@&1288520382562963486> or <@&1288520448925106358>. Let’s make this community awesome together! Enjoy your stay! \uD83C\uDFAE✨";

    public static final String IMAGE_URL = null;
    public static final TextChannel channel = Bot.guild.getTextChannelById(1288515975523864688L);
}
