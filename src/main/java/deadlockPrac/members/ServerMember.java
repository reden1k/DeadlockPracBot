package deadlockPrac.members;

import deadlockPrac.bot.Bot;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;

public class ServerMember {
    Long id;
    String name;
    QueueStatus queueStatus;
    QueueType queueType;
    Long queueRoleId;
    Long createdChannelId;
    User user;
    public ServerMember(
            Long id,
            String name,
            QueueType queueType,
            QueueStatus queueStatus,
            @Nullable Long queueRoleId,
            @Nullable Long createdChannelId,
            User user
    ) {
        this.id = id;
        this.name = name;
        this.queueStatus = queueStatus;
        this.queueType = queueType;
        this.queueRoleId = queueRoleId;
        this.createdChannelId = createdChannelId;
        this.user = user;
    }

    public static ServerMember create(Member member) {
        return new ServerMember(
                member.getIdLong(),
                member.getUser().getName(),
                QueueType.NONE,
                QueueStatus.NOT_STARTED,
                null,
                null,
                member.getUser()
        );
    }
    public static void updateServerMember(Member member) {
        for (ServerMember serverMember : Bot.serverMembers) {
            if (member.getIdLong() == serverMember.getId() && !member.getUser().getName().equals(serverMember.getName())) {
                serverMember.setName(member.getUser().getName());
                return;
            }
        }
    }

    public static void updateServerMember(ServerMember member) {
        for (ServerMember serverMember : Bot.serverMembers) {
            if (member.getId() == serverMember.getId() && !member.getUser().getName().equals(serverMember.getName())) {
                serverMember.setName(member.getUser().getName());
                return;
            }
        }
    }

    public static ServerMember getServerMember(Member member) {
        for (ServerMember serverMember : Bot.serverMembers) {
            if (member.getIdLong() == serverMember.getId()) {
                return serverMember;
            }
        }
        throw new NoSuchElementException("Can't get Server Member");
    }

    public static void addToServerMembers(ServerMember serverMember) throws Exception {
        for (ServerMember member : Bot.serverMembers) {
            if (member.getId() == serverMember.getId()) {
                throw new Exception("Already contains in list of users");
            }
        }
        Bot.serverMembers.add(serverMember);
    }

    public void queuing(QueueType enumQueueType) {
        queueType = enumQueueType;
        queueStatus = QueueStatus.LOOKING;
    }

    public void resetAfterQueue() {
        queueRoleId = null;
        queueStatus = QueueStatus.NOT_STARTED;
        queueType = QueueType.NONE;

        ServerMember.updateServerMember(this);
    }

    public String getStringQueueType() {
        switch (queueType) {
            case TEAM_ON_TEAM -> {
                return "6v6";
            }
            case FOUR_VS_FOUR -> {
                return "4v4";
            }
            case TWO_VS_TWO -> {
                return "2v2";
            }
            case ONE_VS_ONE -> {
                return "1v1";
            }
            default -> {
                return "none";
            }
        }
    }

    public boolean isInQueue() {
        if (queueStatus == QueueStatus.LOOKING) {
            return true;
        }
        return false;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public QueueStatus getQueueStatus() {
        return queueStatus;
    }

    public QueueType getQueueType() {
        return queueType;
    }

    public Long getQueueRoleId() {
        return queueRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setQueueStatus(QueueStatus queueStatus) {
        this.queueStatus = queueStatus;
    }

    public void setQueueRoleId(Long queueRoleId) {
        this.queueRoleId = queueRoleId;
    }

    public Long getCreatedChannelId() {
        return createdChannelId;
    }

    public void setCreatedChannelId(Long createdChannelId) {
        this.createdChannelId = createdChannelId;
    }

    public String toString() {
        return "Name: " + name + "\n" +
                "ID: " + id + "\n" +
                "QueueType: " + queueType + "\n" +
                "QueueStatus: " + queueStatus + "\n";
    }
}
