package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.bot.RoleId;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Role {
    private static final Map<net.dv8tion.jda.api.entities.Role, String> requirements = Map.of(
            getRole(RoleId.TWITCH), " You need to have 3000 followers on Twitch."
    );

    public static final String TITLE = "Roles";
    public static final String TEXT = createText();
    public static final String IMAGE_URL = null;
    public static final TextChannel channel = Bot.guild.getTextChannelById(1289202257849745470L);


    private static String createText() {
        StringBuilder builder = new StringBuilder();
        builder.append("Requirements for roles: \n\n");

        for (Map.Entry<net.dv8tion.jda.api.entities.Role, String> e : requirements.entrySet()) {
            net.dv8tion.jda.api.entities.Role role = e.getKey();
            String requirements = e.getValue();
            builder.append(role.getAsMention()).append(" - ").append(requirements).append("\n");
        }

        builder.append("\n\nDM" + getRole(RoleId.HELPER).getAsMention() + " / "+ getRole(RoleId.MANAGER).getAsMention() + " for get a role");

        return builder.toString();
    }

    public static net.dv8tion.jda.api.entities.Role getRole(Long roleId) {
        List<net.dv8tion.jda.api.entities.Role> roles = Bot.guild.getRoles();

        for (net.dv8tion.jda.api.entities.Role role : roles) {
            if (role.getIdLong() == roleId) {
                return role;
            }
        }

        throw new IllegalArgumentException("No such role with this ID");
    }
}
