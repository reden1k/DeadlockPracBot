package deadlockPrac.verification;

import deadlockPrac.members.ServerMembers;
import deadlockPrac.members.ServerMember;
import net.dv8tion.jda.api.entities.Member;

public class Verification {
    public static void verify(Member member) throws Exception {
        ServerMember serverMember = ServerMember.create(member);
        ServerMember.addToServerMembers(serverMember);

        System.out.println(ServerMembers.get());
    }
}
