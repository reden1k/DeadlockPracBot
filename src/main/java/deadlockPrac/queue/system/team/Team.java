package deadlockPrac.queue.system.team;

import net.dv8tion.jda.api.entities.Member;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {
    private final String name;
    private final Member teamLeader;
    private final Member player1;
    private final Member player2;
    private final Member player3;
    private final Member player4;
    private final Member player5;
    private final List<Member> players;
    private final TeamType teamType;
    private QueueType queueType;

    public Team(
            String name,
            Member teamLeader,
            @Nullable Member player1,
            @Nullable Member player2,
            @Nullable Member player3,
            @Nullable Member player4,
            @Nullable Member player5,
            List<Member> players,
            TeamType teamType,
            QueueType queueType

    ) {
        this.name = name;
        this.teamLeader = teamLeader;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.players = players;
        this.teamType = teamType;
        this.queueType = queueType;
    }

    public static Team create(List<Member> players) {
        String teamLeaderName = players.get(0).getUser().getName();


        int playersCount = players.size();

        switch (playersCount) {
            case 1 -> {
                return new Team(
                        teamLeaderName + "'s team",
                        players.get(0),
                        null,
                        null,
                        null,
                        null,
                        null,
                        new ArrayList<>(Arrays.asList(players.get(0))),
                        TeamType.ONE_VS_ONE,
                        QueueType.NOT_STARTED
                );
            }
            case 2 -> {
                return new Team(
                        teamLeaderName + "'s team",
                        players.get(0),
                        players.get(1),
                        null,
                        null,
                        null,
                        null,
                        new ArrayList<>(Arrays.asList(players.get(0), players.get(1))),
                        TeamType.TWO_VS_TWO,
                        QueueType.NOT_STARTED
                );
            }
            case 3 -> {
                return new Team(
                        teamLeaderName + "'s team",
                        players.get(0),
                        players.get(1),
                        players.get(2),
                        null,
                        null,
                        null,
                        new ArrayList<>(Arrays.asList(players.get(0), players.get(1), players.get(2))),
                        TeamType.THREE_VS_THREE,
                        QueueType.NOT_STARTED
                );
            }
            case 4 -> {
                return new Team(
                        teamLeaderName + "'s team",
                        players.get(0),
                        players.get(1),
                        players.get(2),
                        players.get(3),
                        null,
                        null,
                        new ArrayList<>(Arrays.asList(players.get(0), players.get(1), players.get(2), players.get(3))),
                        TeamType.FOUR_VS_FOUR,
                        QueueType.NOT_STARTED
                );
            }
            case 5 -> {
                return new Team(
                        teamLeaderName + "'s team",
                        players.get(0),
                        players.get(1),
                        players.get(2),
                        players.get(3),
                        players.get(4),
                        null,
                        new ArrayList<>(Arrays.asList(players.get(0), players.get(1), players.get(2), players.get(3), players.get(4))),
                        TeamType.FIVE_VS_FIVE,
                        QueueType.NOT_STARTED
                );
            }
            default -> {
                return new Team(
                        teamLeaderName + "'s team",
                        players.get(0),
                        players.get(1),
                        players.get(2),
                        players.get(3),
                        players.get(4),
                        players.get(5),
                        new ArrayList<>(Arrays.asList(players.get(0), players.get(1), players.get(2), players.get(3), players.get(4), players.get(5))),
                        TeamType.TEAM_VS_TEAM,
                        QueueType.NOT_STARTED
                );
            }
        }
    }

    public boolean isCorrect() throws IllegalArgumentException {
        List<Member> players = new ArrayList<>(Arrays.asList(teamLeader, player1, player2, player3, player4, player5));

        Long prevId = 0L;
        if (teamType == TeamType.TEAM_VS_TEAM) {

            for (Member player : players) {
                System.out.println("Current id: " + player.getIdLong() + " - " + "Prev id: " + prevId);
                if (player.getIdLong() == prevId) {
                    throw new IllegalArgumentException("Can't be same members in team");
                }
                prevId = player.getIdLong();
            }
        }
        return true;
    }

    public String output() {
        StringBuilder builder = new StringBuilder();
        builder.append("Your team:\n\n");
        builder.append("Team leader: ").append(teamLeader.getUser().getName());

        if (player1 != null) {
            builder.append("\n1. ").append(player1.getUser().getName()).toString();
        }
        if (player2 != null) {
            builder.append("\n2. ").append(player2.getUser().getName()).toString();
        }
        if (player3 != null) {
            builder.append("\n3. ").append(player3.getUser().getName()).toString();
        }
        if (player4 != null) {
            builder.append("\n4. ").append(player4.getUser().getName()).toString();
        }
        if (player5 != null) {
            builder.append("\n5. ").append(player5.getUser().getName()).toString();
        }

        return builder.toString();
    }

    public String toString() {
        return "Team: " +
                "\nTeam Leader: " + teamLeader +
                "\nTeammate 1: " + player1 +
                "\nTeammate 2: " + player2 +
                "\nTeammate 3: " + player3 +
                "\nTeammate 4: " + player4 +
                "\nTeammate 5: " + player5;
    }

    public String getName() {
        return name;
    }

    public Member getTeamLeader() {
        return teamLeader;
    }

    public Member getPlayer1() {
        return player1;
    }

    public Member getPlayer2() {
        return player2;
    }

    public Member getPlayer3() {
        return player3;
    }

    public Member getPlayer4() {
        return player4;
    }

    public Member getPlayer5() {
        return player5;
    }

    public List<Member> getPlayers() {
        return players;
    }

    public TeamType getTeamType() {
        return teamType;
    }

    public QueueType getQueueType() {
        return queueType;
    }

    public void setQueueType(QueueType type) {
        this.queueType = type;
    }
}
