package deadlockPrac.queue;

import deadlockPrac.bot.Bot;
import deadlockPrac.members.QueueStatus;
import deadlockPrac.members.QueueType;
import deadlockPrac.members.ServerMember;
import deadlockPrac.message.text.Queue;
import deadlockPrac.message.text.QueueChat;
import net.dv8tion.jda.api.entities.Member;
import org.jetbrains.annotations.Nullable;

public class Searcher {
    public static void startQueue(Member member, QueueType queueType) {
        ServerMember player = ServerMember.getServerMember(member);

        if (player.isInQueue() && queueType != player.getQueueType()) {
            System.out.println("is changed");
            RoleManager.removeQueueRole(player);
        }
        player.queuing(queueType);
        RoleManager.createQueueRole(player);

        ServerMember enemy = getEnemy(player);

        if (enemy != null) {
            Chat.create(player, enemy);
            QueueChat.sendMessage(player, enemy);
        }

    }

    public static void afterQueue() {
        //TODO make afterQueue reset
    }

    public static ServerMember getEnemy(ServerMember player) {

        for (ServerMember member : Bot.serverMembers) {
            if (member.getId() == player.getId()) {
                continue;
            }
            if (member.isInQueue() && member.getQueueType() == player.getQueueType()) {
                member.setQueueStatus(QueueStatus.PLAYING);
                player.setQueueStatus(QueueStatus.PLAYING);
                return member;
            }
        }
        return null;
    }

    public static int getQueueOnline(@Nullable QueueType queueType) {
        int counter = 0;
        if (queueType == null) {
            for (ServerMember serverMember : Bot.serverMembers) {
                if (serverMember.isInQueue()) {
                    counter++;
                }
            }
            return counter;
        }

        for (ServerMember serverMember : Bot.serverMembers) {
            if (serverMember.isInQueue() && serverMember.getQueueType() == queueType) {
                counter++;
            }
        }
        return counter;
    }
}
