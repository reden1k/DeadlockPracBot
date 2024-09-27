package deadlockPrac.voice.chat;

import deadlockPrac.bot.Bot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;

public class VoiceChat {
    private static final Long CREATE_VC_ROOM_ID = 1289196171612651581L;
    private static final Long CATEGORY_FOR_CREATE_VC = 1287777587757584496L;

    public static void voiceChatJoinInteractionHandler(GuildVoiceUpdateEvent event) {
        if (event.getChannelJoined() != null && event.getChannelLeft() == null) {
            Member member = event.getMember();
            AudioChannel joinedChannel = event.getChannelJoined();

            createCustomVoiceChat(member);

            System.out.println(member.getEffectiveName() + " присоединился к каналу: " + joinedChannel.getName());
        }

        // Пользователь вышел из голосового канала
        if (event.getChannelLeft() != null && event.getChannelJoined() == null) {
            Member member = event.getMember();
            AudioChannel leftChannel = event.getChannelLeft();

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
