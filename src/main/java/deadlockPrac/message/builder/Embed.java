package deadlockPrac.message.builder;

import deadlockPrac.message.colors.ColorType;
import deadlockPrac.message.colors.MessageColor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class Embed {
    public static MessageEmbed message(String title, @Nullable String description, @Nullable String imageUrl, ColorType colorType) {
        EmbedBuilder builder = new EmbedBuilder();
        Color color = MessageColor.getColor(colorType);

        builder.setTitle(title);
        builder.setColor(color);

        if (description != null) {
            builder.setDescription(description);
        }
        if (imageUrl != null) {
            builder.setImage(imageUrl);
        }

        return builder.build();
    }
}
