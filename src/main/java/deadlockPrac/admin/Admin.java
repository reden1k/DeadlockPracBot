package deadlockPrac.admin;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class Admin {
    private static final Long REDEN_ID = 287874172225585152L;
    private static final Long LESHA_ID = 452051119364112385L;
    public static final ArrayList<Long> ADMIN_IDs = new ArrayList<>(Arrays.asList(REDEN_ID, LESHA_ID));
    private static final Button stopQueue = Button.danger("admin::stop:queue", "Stop queue");
    private static final Button stopCreateVC = Button.danger("admin::stop:create_vc", "Stop create vc");

    public static void handleAdminInteraction(ButtonInteractionEvent event) {

    }

    public static void handleOnMessageReceive(MessageReceivedEvent event) {
        if (event.isFromType(ChannelType.PRIVATE)) {
            Message message = event.getMessage();
            Long userId = event.getAuthor().getIdLong();

            if (ADMIN_IDs.contains(userId)) {
                //TODO add funcs if needed
            }
        }
    }

    private static MessageEmbed menu() {
        return null;
    }

}
