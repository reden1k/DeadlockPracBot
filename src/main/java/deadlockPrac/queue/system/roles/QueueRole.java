package deadlockPrac.queue.system.roles;

import deadlockPrac.bot.Bot;
import deadlockPrac.queue.system.team.Team;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.restaction.RoleAction;

public class QueueRole {
    public static void createTeamLeaderRole(Team team) {

    }

    public static void createTeamRole(Team team) {
        RoleAction roleAction = Bot.guild.createRole()
                .setName(team.getName())
                .setHoisted(false)
                .setMentionable(false);

        roleAction.queue(success -> {
                    System.out.println("Role " + team.getName() + " created!");
                    Role role = Bot.guild.getRolesByName(team.getName(), false).get(0);
                    Role queue = Bot.guild.getRolesByName("QUEUE", false).get(0);

                    Bot.guild.addRoleToMember(team.getTeamLeader(), queue).queue();

                    for (Member member : team.getPlayers()) {
                        Bot.guild.addRoleToMember(member, role).queue();
                    }
                },
                failure -> {
                    System.err.println("Failed to create role: " + failure.getMessage());
                });
    }

    public static void createTeamTypeModeRole(Team team) {

    }
}
