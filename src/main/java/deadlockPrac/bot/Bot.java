package deadlockPrac.bot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

public class Bot extends ListenerAdapter {
    private static String TOKEN = "MTI4Nzg5NjYxMjQxMjA2Nzg3MQ.GfdENW.PcNU1rSFD3eEcZbCmx5NSqN2injoIWP6uHHeFs";

    public static void main( String[] args ) {
        try {
        JDA jda = JDABuilder.createDefault(TOKEN)
                .setActivity(Activity.customStatus("Status: Developing"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
                .disableCache(CacheFlag.VOICE_STATE)
                .addEventListeners(new Bot())
                .build();

            jda.awaitReady();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {

    }
}
