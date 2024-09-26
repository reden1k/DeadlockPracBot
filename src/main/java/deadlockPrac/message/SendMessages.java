package deadlockPrac.message;

import deadlockPrac.message.builder.Embed;
import deadlockPrac.message.button.Btn;
import deadlockPrac.message.colors.ColorType;
import deadlockPrac.message.text.*;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class SendMessages {
    public static void send() {
        MessageEmbed serverRules = Embed.message(Rules.TITLE, Rules.TEXT, Rules.IMAGE_URL, ColorType.DEFAULT);
        MessageEmbed verification = Embed.message(Verification.TITLE, Verification.TEXT, Verification.IMAGE_URL, ColorType.DEFAULT);
        MessageEmbed language = Embed.message(Language.TITLE, Language.TEXT, Language.IMAGE_URL, ColorType.DEFAULT);
        MessageEmbed queue = Embed.message(Queue.TITLE_MAIN, Queue.TEXT_MAIN, Queue.IMAGE_URL_MAIN, ColorType.DEFAULT);

//        Queue.channel.sendMessageEmbeds(queue).setActionRow(Btn.oneVsOne, Btn.twoVsTwo, Btn.fourVsFour, Btn.teamOnTeam).queue();
//        ServerRules.channel.sendMessageEmbeds(serverRules).queue();
//        Verification.channel.sendMessageEmbeds(verification).setActionRow(Btn.verification).queue();
//        Language.channel.sendMessageEmbeds(language).setActionRow(Btn.langRu, Btn.langEng).queue();
    }
}
