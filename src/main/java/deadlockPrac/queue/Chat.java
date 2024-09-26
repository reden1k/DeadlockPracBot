package deadlockPrac.queue;

import deadlockPrac.bot.Bot;
import deadlockPrac.members.ServerMember;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Chat {
    private static final long CATEGORY_ID = 1288524428703174716L;
    private static final Category CATEGORY = Bot.guild.getCategoryById(CATEGORY_ID);

    private static final Permission[] permissionsToGrant = {
            Permission.VIEW_CHANNEL,                  // Просмотр канала
            Permission.MESSAGE_SEND,                  // Отправлять сообщения
            Permission.MESSAGE_SEND_IN_THREADS,       // Отправлять сообщения в ветках
            Permission.CREATE_PUBLIC_THREADS,         // Создать публичные ветки
            Permission.MESSAGE_ATTACH_FILES,          // Прикреплять файлы
            Permission.MESSAGE_ADD_REACTION,          // Добавлять реакции
            Permission.MESSAGE_HISTORY,               // Читать историю сообщений
            Permission.USE_APPLICATION_COMMANDS       // Использовать команды приложения
    };

    private static final Permission[] permissionsToDeny = {
            Permission.MANAGE_CHANNEL,                // Управлять каналом
            Permission.MANAGE_PERMISSIONS,            // Управлять правами
            Permission.MANAGE_WEBHOOKS,               // Управлять вебхуками
            Permission.CREATE_INSTANT_INVITE,         // Создание приглашений
            Permission.CREATE_PRIVATE_THREADS,        // Создать приватные ветки
            Permission.BAN_MEMBERS,                   // Упоминание @everyone, @here и всех ролей
            Permission.KICK_MEMBERS,
            Permission.MANAGE_ROLES,
            Permission.MANAGE_EVENTS,
            Permission.MANAGE_THREADS,                // Управление ветками
            Permission.MESSAGE_TTS,                   // Отправка сообщений text-to-speech
            Permission.MANAGE_SERVER,               // Управлять сообщениями
    };


    public static void create(ServerMember player, ServerMember anotherPlayer) {
        Role playerRole = Bot.guild.getRoleById(player.getQueueRoleId());
        Role anotherPlayerRole = Bot.guild.getRoleById(anotherPlayer.getQueueRoleId());
        String chatName = makeChatName(player, anotherPlayer);

        try {
            // Синхронное создание текстового канала
            TextChannel textChannel = CATEGORY.createTextChannel(chatName).complete();

            // Синхронное обновление прав для playerRole
            textChannel.upsertPermissionOverride(playerRole)
                    .grant(permissionsToGrant)
                    .deny(permissionsToDeny)
                    .complete();

            // Синхронное обновление прав для anotherPlayerRole
            textChannel.upsertPermissionOverride(anotherPlayerRole)
                    .grant(permissionsToGrant)
                    .deny(permissionsToDeny)
                    .complete();

            // Получение ID созданного канала и его установка для игроков
            long textChannelId = textChannel.getIdLong();
            player.setCreatedChannelId(textChannelId);
            anotherPlayer.setCreatedChannelId(textChannelId);

        } catch (Exception e) {
            System.err.println("Failed to create channel or set permissions: " + e.getMessage());
        }
    }

    private static String makeChatName(ServerMember player, ServerMember anotherPlayer) {
        return player.getName() + "-vs-" + anotherPlayer.getName();
    }
}
