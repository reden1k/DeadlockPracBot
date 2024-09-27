package deadlockPrac.loader;

import deadlockPrac.bot.Bot;
import deadlockPrac.bot.RoleId;
import deadlockPrac.members.ServerMember;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class Loader {

    public static void execute() {
        cleanUpRoles();
        loadUsersAfterRestart();
        System.out.println(Bot.serverMembers);

        System.out.println("\n\nLoaded!");
    }

    private static void loadUsersAfterRestart() {
        List<Member> members = Bot.guild.getMembers();

        for (Member member : members) {
            System.out.println(member.getEffectiveName());
            if (isVerified(member)) {
                ServerMember serverMember = ServerMember.create(member);
                Bot.serverMembers.add(serverMember);
            }
        }
    }

    private static void cleanUpRoles() {
        List<Role> roles = Bot.guild.getRoles();
        for (Role role : roles) {
            if (!RoleId.REQUIRED_IDs.contains(role.getIdLong())) {
                role.delete().complete();
            }
        }
    }

    private static boolean isVerified(Member member) {
        List<Role> roles = member.getRoles();

        for (Role role : roles) {
            if (role.getIdLong() == RoleId.VERIFIED) {
                return true;
            }
        }
        return false;
    }
}
