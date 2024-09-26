package deadlockPrac.queue.system;

import deadlockPrac.queue.system.team.QueueType;
import deadlockPrac.queue.system.team.Team;
import deadlockPrac.queue.system.team.TeamType;
import net.dv8tion.jda.api.entities.Member;

import java.util.ArrayList;


public class Queue {
    //TODO Make queue logic more elastic
    public static final ArrayList<Team> teams = new ArrayList<>();

    public static void start(Member member) {
        Team team = Queue.getTeamByLeader(member);

        if (team != null) {
            team.setQueueType(QueueType.LOOKING);
        }
    }

    public static boolean hasTeam(Member member) {
        for (Team team : teams) {
            long leaderId = team.getTeamLeader().getIdLong();

            if (member.getIdLong() == leaderId) {
                return true;
            }
        }
        return false;
    }

    public static boolean availableCreateTeam(Member member) {
        return false;
    }

    public static boolean isLeader(Member member) {
        for (Team team : teams) {
            long leaderId = team.getTeamLeader().getIdLong();

            if (leaderId == member.getIdLong()) {
                return true;
            }
        }
        return false;
    }

    public static Team getTeamByLeader(Member member) {
        for (Team team : teams) {
            long leaderId = team.getTeamLeader().getIdLong();

            if (leaderId == member.getIdLong()) {
                return team;
            }
        }
        return null;
    }

    public static String getTeamType(Team team) {
        switch (team.getTeamType()) {
            case ONE_VS_ONE -> {
                return "1v1";
            }
            case TWO_VS_TWO -> {
                return "2v2";
            }
            case THREE_VS_THREE -> {
                return "3v3";
            }
            case FOUR_VS_FOUR -> {
                return "4v4";
            }
            case FIVE_VS_FIVE -> {
                return "5v5";
            }
            default -> {
                return "6v6";
            }
        }
    }

    public static int getActiveCurrentQueueCount() {
        int counter = 0;
        for (Team team : teams) {
            if (team.getQueueType() == QueueType.LOOKING) {
                counter++;
            }
        }
        return counter;
    }

    public static int getActiveTeamQueueCount() {
        int counter = 0;
        for (Team team : teams) {
            if (team.getTeamType() == TeamType.TEAM_VS_TEAM) {
                counter++;
            }
        }
        return counter;
    }

    public static int getActiveFiveQueueCount() {
        int counter = 0;
        for (Team team : teams) {
            if (team.getTeamType() == TeamType.FIVE_VS_FIVE) {
                counter++;
            }
        }
        return counter;
    }

    public static int getActiveFourQueueCount() {
        int counter = 0;
        for (Team team : teams) {
            if (team.getTeamType() == TeamType.FOUR_VS_FOUR) {
                counter++;
            }
        }
        return counter;
    }

    public static int getActiveThreeQueueCount() {
        int counter = 0;
        for (Team team : teams) {
            if (team.getTeamType() == TeamType.THREE_VS_THREE) {
                counter++;
            }
        }
        return counter;
    }

    public static int getActiveTwoQueueCount() {
        int counter = 0;
        for (Team team : teams) {
            if (team.getTeamType() == TeamType.TWO_VS_TWO) {
                counter++;
            }
        }
        return counter;
    }

    public static int getActiveOneQueueCount() {
        int counter = 0;
        for (Team team : teams) {
            if (team.getTeamType() == TeamType.ONE_VS_ONE) {
                counter++;
            }
        }
        return counter;
    }
}
