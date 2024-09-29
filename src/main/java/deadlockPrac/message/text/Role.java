package deadlockPrac.message.text;

import deadlockPrac.bot.Bot;
import deadlockPrac.bot.RoleId;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Role {
    private static final Map<net.dv8tion.jda.api.entities.Role, String> requirements = Map.of(
            getRole(RoleId.HELPER), "\uD83D\uDEE0\uFE0F - Openings for this role may arise occasionally. Keep an eye on the <#1287780873269153803> channel! ",
            getRole(RoleId.TWITCH), "\uD83C\uDFAE - You need to have 3000 followers on Twitch."
    );
    public static final String TITLE = "\uD83C\uDF1F Roles Available \uD83C\uDF1F";
    public static final String TEXT = createText();
    public static final String IMAGE_URL = "https://cdn.discordapp.com/attachments/581047676695478282/1289226526688284748/roles.gif?ex=66f95ec4&is=66f80d44&hm=7a964106c4d31483ce690382ac430317f8d534b68c2583fb5eb409656039f4d5&";
    public static final TextChannel channel = Bot.guild.getTextChannelById(1289202257849745470L);


    private static String createText() {
        StringBuilder builder = new StringBuilder();
        builder.append("Requirements for roles: \n\n");

        for (Map.Entry<net.dv8tion.jda.api.entities.Role, String> e : requirements.entrySet()) {
            net.dv8tion.jda.api.entities.Role role = e.getKey();
            String requirements = e.getValue();
            builder.append("* ").append(role.getAsMention()).append(requirements).append("\n\n");
        }

        builder.append("DM " + getRole(RoleId.HELPER).getAsMention() + " / "+ getRole(RoleId.MANAGER).getAsMention() + " for get a role");

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
