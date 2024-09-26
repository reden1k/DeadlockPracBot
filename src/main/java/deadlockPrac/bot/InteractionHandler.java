package deadlockPrac.bot;

import deadlockPrac.members.QueueType;
import deadlockPrac.message.builder.Embed;
import deadlockPrac.message.colors.ColorType;
import deadlockPrac.message.text.Global;
import deadlockPrac.message.text.Queue;
import deadlockPrac.message.text.QueueChat;
import deadlockPrac.queue.Searcher;
import deadlockPrac.verification.Verification;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;

import java.util.List;

public class InteractionHandler {

    public static void slashHandler(SlashCommandInteractionEvent event) {
        String channelName = event.getChannel().getName();
        String commandName = event.getFullCommandName();

        if (event.getUser().isBot()) {
            return;
        }
    }
    public static void buttonHandler(ButtonInteractionEvent event) {
        String buttonId = event.getComponentId();
        Member member = event.getMember();

        switch (buttonId) {
            case("verification") -> {
                Role role = Bot.guild.getRoleById(RoleIds.VERIFIED);
                Role newMemberRole = Bot.guild.getRoleById(RoleIds.NEW_MEMBER);

                if (role != null) {
                    Bot.guild.addRoleToMember(member, role).queue(
                            success ->  {
                                Bot.guild.removeRoleFromMember(member, newMemberRole).queue();
                                try {
                                    Verification.verify(member);
                                    event.replyEmbeds(
                                            Embed.message(
                                                    "Verified",
                                                    null,
                                                    Global.IMAGE_URL_SUCCESS,
                                                    ColorType.SUCCESS
                                            )
                                    ).setEphemeral(true)
                                            .queue();
                                } catch (Exception e) {
                                    event.replyEmbeds(
                                            Embed.message(
                                                    Global.TITLE_ERROR,
                                                    e.getMessage(),
                                                    Global.IMAGE_URL_ERROR,
                                                    ColorType.ERROR
                                            )
                                    ).setEphemeral(true)
                                            .queue();
                                }
                            },
                            error -> event.replyEmbeds(
                                            Embed.message(
                                                    Global.TITLE_ERROR,
                                                    "Error can't verify",
                                                    Global.IMAGE_URL_ERROR,
                                                    ColorType.ERROR
                                            )
                                    ).setEphemeral(true)
                                    .queue()
                    );
                } else {
                    event.reply("Role doesn't exist").setEphemeral(true).queue();
                }
            }

            case("lang-ru") -> {
                Role role = Bot.guild.getRoleById(RoleIds.LANG_RU);

                List<Role> roles = member.getRoles();

                for (Role r : roles) {
                    if (r.getIdLong() == role.getIdLong()) {
                        Bot.guild.removeRoleFromMember(member, role).queue();
                        event.reply("Role removed").setEphemeral(true).queue();
                        return;
                    }
                }

                if (role != null) {
                    Bot.guild.addRoleToMember(member, role).queue(
                            success -> event.reply("Role added").setEphemeral(true).queue(),
                            error -> event.reply("Error, can't add role").setEphemeral(true).queue()
                    );
                } else {
                    event.reply("Role doesn't exist").setEphemeral(true).queue();
                }
            }
            case("lang-eng") -> {
                Role role = Bot.guild.getRoleById(RoleIds.LANG_ENG);

                List<Role> roles = member.getRoles();

                for (Role r : roles) {
                    if (r.getIdLong() == role.getIdLong()) {
                        Bot.guild.removeRoleFromMember(member, role).queue();
                        event.reply("Role removed").setEphemeral(true).queue();
                        return;
                    }
                }

                if (role != null) {
                    Bot.guild.addRoleToMember(member, role).queue(
                            success -> event.reply("Role added").setEphemeral(true).queue(),
                            error -> event.reply("Error, can't add role").setEphemeral(true).queue()
                    );
                } else {
                    event.reply("Role doesn't exist").setEphemeral(true).queue();
                }
            }
            case("1v1") -> {
                Searcher.startQueue(member, QueueType.ONE_VS_ONE);
                Queue.updateQueueMessage(event);
                Queue.sendQueuingMessage(event);
            }
            case("2v2") -> {
                Searcher.startQueue(member, QueueType.TWO_VS_TWO);
                Queue.updateQueueMessage(event);
                Queue.sendQueuingMessage(event);
            }
            case("4v4") -> {
                Searcher.startQueue(member, QueueType.FOUR_VS_FOUR);
                Queue.updateQueueMessage(event);
                Queue.sendQueuingMessage(event);
            }
            case("6v6") -> {
                Searcher.startQueue(member, QueueType.TEAM_ON_TEAM);
                Queue.updateQueueMessage(event);
                Queue.sendQueuingMessage(event);
            }
        }
    }

    public static void guildJoinHandler(GuildMemberJoinEvent event) {
        Member member = event.getMember();
        Role role = Bot.guild.getRoleById(RoleIds.NEW_MEMBER);

        Bot.guild.addRoleToMember(member, role).queue();
    }
}
