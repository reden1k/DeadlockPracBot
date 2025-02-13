package deadlockPrac.bot;

import deadlockPrac.loader.Loader;
import deadlockPrac.message.SendMessages;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

public class Bot extends ListenerAdapter {
    private static final String TOKEN = "token";
    public static JDA jda;
    public static volatile Guild guild;
    public static final long guildId = 1287777587757584494L;

    public static void main( String[] args ) {
        try {
         jda = JDABuilder.createDefault(TOKEN)
                .setActivity(Activity.customStatus("Status: Developing"))
                 .enableIntents(
                         GatewayIntent.GUILD_MEMBERS,
                         GatewayIntent.GUILD_PRESENCES,
                         GatewayIntent.GUILD_VOICE_STATES
                 )
                .addEventListeners(new Bot())
                .build();

            jda.awaitReady();

            guild = jda.getGuildById(guildId);

            Loader.execute();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SendMessages.send();
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        InteractionHandler.buttonHandler(event);
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        InteractionHandler.guildJoinHandler(event);
    }

    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {
        InteractionHandler.voiceChatJoinHandler(event);
    }
}
