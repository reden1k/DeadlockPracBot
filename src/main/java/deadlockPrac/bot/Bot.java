package deadlockPrac.bot;

import deadlockPrac.message.SendMessages;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;


public class Bot extends ListenerAdapter {
    private static final String TOKEN = "MTI4Nzg5NjYxMjQxMjA2Nzg3MQ.GfdENW.PcNU1rSFD3eEcZbCmx5NSqN2injoIWP6uHHeFs";
    public static JDA jda;
    public static Guild guild;

    public static void main( String[] args ) {
        try {
         jda = JDABuilder.createDefault(TOKEN)
                .setActivity(Activity.customStatus("Status: Developing"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
                .disableCache(CacheFlag.VOICE_STATE)
                .addEventListeners(new Bot())
                .build();

            jda.awaitReady();

            guild = jda.getGuildsByName("Deadlock PRAC (ASIA)", true).get(0);

            guild.updateCommands().addCommands(
                    Commands.slash("create-team", "Create your team")
                            .addOption(OptionType.MENTIONABLE, "player1", "First player")
                            .addOption(OptionType.MENTIONABLE, "player2", "Second player")
                            .addOption(OptionType.MENTIONABLE, "player3", "Third player")
                            .addOption(OptionType.MENTIONABLE, "player4", "Fourth player")
                            .addOption(OptionType.MENTIONABLE, "player5", "Fifth player"),
                    Commands.slash("disband", "Disband your team"),
                    Commands.slash("leave", "Leave from team"),
                    Commands.slash("kick", "Kick someone from team")
            ).queue();

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
