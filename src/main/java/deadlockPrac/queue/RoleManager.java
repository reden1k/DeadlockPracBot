package deadlockPrac.queue;

import deadlockPrac.bot.Bot;
import deadlockPrac.members.ServerMember;
import net.dv8tion.jda.api.entities.Role;

public class RoleManager {
    public static void createQueueRole(ServerMember member) {
        String roleName = makeRoleName(member);

        try {
            // Создаем роль синхронно и блокируем выполнение до завершения
            Role createdRole = Bot.guild.createRole()
                    .setName(roleName)
                    .setHoisted(false)
                    .setMentionable(false)
                    .complete();

            System.out.println("Role " + roleName + " created!");

            // Синхронно добавляем роль участнику
            Bot.guild.addRoleToMember(member.getUser(), createdRole).complete();

            // Устанавливаем ID роли в объекте member
            member.setQueueRoleId(createdRole.getIdLong());

        } catch (Exception e) {
            System.err.println("Failed to create role: " + e.getMessage());
        }
    }
    public static void removeQueueRole(ServerMember member) {
        Role queueStatus = Bot.guild.getRoleById(member.getQueueRoleId());

        Bot.guild.removeRoleFromMember(member.getUser(), queueStatus).complete();
        queueStatus.delete().queue();
    }

    private static String makeRoleName(ServerMember member) {
        return member.getName() + " (" + member.getStringQueueType() +")";
    }
}
