package deadlockPrac.voice.chat;

import deadlockPrac.bot.Bot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class VoiceChat {
    private static final Long CREATE_VC_ROOM_ID = 1289319214397657188L;
    private static final Long CATEGORY_FOR_CREATE_VC = 1287777587757584496L;
    private static final Long TALKING_ROOM_ID = 1287783263338893342L;
    private static final Long PARTY_ROOM_ONE_ID = 1289320692658995248L;
    private static final Long PARTY_ROOM_TWO_ID = 1289320739605844069L;

    private static final ArrayList<Long> UNDELETABLE_IDs = new ArrayList<>(Arrays.asList(
            CREATE_VC_ROOM_ID,
            CATEGORY_FOR_CREATE_VC,
            TALKING_ROOM_ID,
            PARTY_ROOM_ONE_ID,
            PARTY_ROOM_TWO_ID
    ));

    public static void voiceChatJoinInteractionHandler(GuildVoiceUpdateEvent event) {
        AudioChannel joinedChannel = event.getChannelJoined();
        AudioChannel leftChannel = event.getChannelLeft();
        AudioChannel prevChannel = event.getOldValue();
        AudioChannel currentChannel = event.getNewValue();

        if (prevChannel != null) {
            System.out.println(prevChannel.getName());
        }

        if (joinedChannel != null && leftChannel == null && joinedChannel.getIdLong() == CREATE_VC_ROOM_ID || (currentChannel != null && currentChannel.getIdLong() == CREATE_VC_ROOM_ID)) {
            Member member = event.getMember();

            createCustomVoiceChat(member);

            System.out.println(member.getEffectiveName() + " присоединился к каналу: " + joinedChannel.getName());
        }


        if ((leftChannel != null || (prevChannel != null && !UNDELETABLE_IDs.contains(prevChannel.getIdLong()) && prevChannel.getMembers().isEmpty()))  && !UNDELETABLE_IDs.contains(leftChannel.getIdLong())) {
            Member member = event.getMember();

            if (leftChannel.getMembers().isEmpty()) {
                deleteEmptyVC(leftChannel);
            }

            System.out.println(member.getEffectiveName() + " вышел из канала: " + leftChannel.getName());
        }

    }

    private static void createCustomVoiceChat(Member member) {
        Permission[] grantPermissions = {
                Permission.KICK_MEMBERS,
                Permission.VIEW_CHANNEL,
                Permission.MANAGE_CHANNEL
        };

        Permission[] denyPermissions = {
                Permission.ADMINISTRATOR
        };

        Category roomsCategory = Bot.guild.getCategoryById(CATEGORY_FOR_CREATE_VC);

        AudioChannel audioChannel = roomsCategory.createVoiceChannel(member.getEffectiveName() + "'s room")
                .setUserlimit(6)
                .complete();

        audioChannel.upsertPermissionOverride(member)
                .grant(grantPermissions)
                .deny(denyPermissions)
                .queue();


        Bot.guild.moveVoiceMember(member, audioChannel).queue();
        System.out.println(member.getEffectiveName() + " был перемещен в канал: " + audioChannel.getName());
    }

    private static void deleteEmptyVC(AudioChannel channel) {
        channel.delete().queue();
    }
}
