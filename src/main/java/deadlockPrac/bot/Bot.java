package deadlockPrac.bot;

import deadlockPrac.members.ServerMember;
import deadlockPrac.message.SendMessages;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class Bot extends ListenerAdapter {
    private static final String TOKEN = "MTI4Nzg5NjYxMjQxMjA2Nzg3MQ.GfdENW.PcNU1rSFD3eEcZbCmx5NSqN2injoIWP6uHHeFs";
    public static JDA jda;
    public static Guild guild;
    public static final long guildId = 1287777587757584494L;
    public static final ArrayList<ServerMember> serverMembers = new ArrayList<>();

    public static void main( String[] args ) {
        try {
         jda = JDABuilder.createDefault(TOKEN)
                .setActivity(Activity.customStatus("Status: Developing"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
                .disableCache(CacheFlag.VOICE_STATE)
                .addEventListeners(new Bot())
                .build();

            jda.awaitReady();

            guild = jda.getGuildById(guildId);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SendMessages.send();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        InteractionHandler.slashHandler(event);
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        InteractionHandler.buttonHandler(event);
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        InteractionHandler.guildJoinHandler(event);
    }
}
