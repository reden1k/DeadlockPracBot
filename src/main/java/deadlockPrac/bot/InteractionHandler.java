package deadlockPrac.bot;

import deadlockPrac.message.builder.Embed;
import deadlockPrac.message.colors.ColorType;
import deadlockPrac.message.text.QueueText;
import deadlockPrac.queue.system.Queue;
import deadlockPrac.queue.system.roles.QueueRole;
import deadlockPrac.queue.system.team.QueueType;
import deadlockPrac.queue.system.team.Team;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InteractionHandler {

    public static void slashHandler(SlashCommandInteractionEvent event) {
        String channelName = event.getChannel().getName();
        String commandName = event.getFullCommandName();

        if (event.getUser().isBot()) {
            return;
        }

        if (channelName.equals("create-team") && commandName.equals("create-team")) {
            Member teamLeader = event.getMember();
            List<IMentionable> mentionableList = new ArrayList<>();
            List<OptionMapping> optionMappings = event.getOptionsByType(OptionType.MENTIONABLE);

            for (OptionMapping mapping : optionMappings) {
                mentionableList.add(mapping.getAsMentionable());
            }

            List<Member> players = new ArrayList<>(Arrays.asList(teamLeader));

            for (IMentionable mentionable : mentionableList) {
                if (mentionable instanceof Role) {
                    event.reply("You mentioned a role!").setEphemeral(true).queue();
                    return;
                }

                if (mentionable instanceof Member) {
                    Member player = (Member) mentionable;
                    players.add(player);
                }
            }

            Team team = Team.create(players);

            try {
                if (team.isCorrect() && !Queue.hasTeam(teamLeader)) {
//                    System.out.println(team);
                    MessageEmbed successCreateTeam = Embed.message("Success", team.output(), null, ColorType.SUCCESS);

                    QueueRole.createTeamRole(team);
                    Queue.teams.add(team);

                    event.replyEmbeds(successCreateTeam).setEphemeral(true).queue();
                }
            } catch (Exception ex) {
                MessageEmbed errorCreateTeam = Embed.message("Error", ex.getMessage(), null, ColorType.ERROR);

                event.replyEmbeds(errorCreateTeam).setEphemeral(true).queue();
            }
        }

    }
    public static void buttonHandler(ButtonInteractionEvent event) {
        String buttonId = event.getComponentId();
        Member member = event.getMember();

        switch (buttonId) {
            case("verification") -> {
                Role role = Bot.guild.getRoleById(ServerRoleIds.VERIFIED);
                Role newMemberRole = Bot.guild.getRoleById(ServerRoleIds.NEW_MEMBER);

                if (role != null) {
                    Bot.guild.addRoleToMember(member, role).queue(
                            success ->  {
                                Bot.guild.removeRoleFromMember(member, newMemberRole).queue();
                                event.reply("Verified").setEphemeral(true).queue();
                            },
                            error -> event.reply("Error, can't verify").setEphemeral(true).queue()
                    );
                } else {
                    event.reply("Role doesn't exist").setEphemeral(true).queue();
                }
            }
            case("lang-ru") -> {
                Role role = Bot.guild.getRoleById(ServerRoleIds.LANG_RU);

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
                Role role = Bot.guild.getRoleById(ServerRoleIds.LANG_ENG);

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
            case("queue") -> {
                if (!Queue.isLeader(member)) {
                    event.reply("Only team leader can start queue").setEphemeral(true).queue();
                    return;
                }

                event.editMessageEmbeds(QueueText.update()).queue();
                Queue.start(member);
            }
        }
    }

    public static void guildJoinHandler(GuildMemberJoinEvent event) {
        Member member = event.getMember();
        Role role = Bot.guild.getRoleById(ServerRoleIds.NEW_MEMBER);

        Bot.guild.addRoleToMember(member, role).queue();
    }
}
