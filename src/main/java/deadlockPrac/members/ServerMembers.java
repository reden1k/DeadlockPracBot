package deadlockPrac.members;

import java.util.ArrayList;

public class ServerMembers {
    private static final ArrayList<ServerMember> serverMembers = new ArrayList<>();

    public static void add(ServerMember addMember) {
        for (ServerMember serverMember : serverMembers) {
            if (addMember.getId() == serverMember.getId()) {
                throw new IllegalArgumentException("This server member already exists");
            }
        }
        serverMembers.add(addMember);
    }

    public static void remove(ServerMember removeMember) { // for banned users or something else
        for (ServerMember serverMember : serverMembers) {
            if (removeMember.getId() == serverMember.getId()) {
                serverMembers.remove(serverMember);
                return;
            }
        }
        throw new IllegalArgumentException("No such member for remove from server members");
    }

    public static ArrayList<ServerMember> get() {
        return serverMembers;
    }

    public static ServerMember getMemberById(Long id) {
        for (ServerMember serverMember : serverMembers) {
            if (serverMember.getId() == id) {
                return serverMember;
            }
        }
        throw new IllegalArgumentException("No such member with this id");
    }

    public static void outputMembers() {
        StringBuilder builder = new StringBuilder();
        builder.append("Server members: \n\n");

        int i = 1;
        for (ServerMember member : serverMembers) {
            builder.append(i).append(". ").append(member).append("\n");
            i++;
        }

        System.out.println(builder);
    }
}
