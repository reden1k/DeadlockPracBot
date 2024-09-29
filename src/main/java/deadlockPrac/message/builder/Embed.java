package deadlockPrac.message.builder;

import deadlockPrac.message.colors.ColorType;
import deadlockPrac.message.colors.MessageColor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.ArrayList;

public class Embed {
    public static MessageEmbed message(
            String title,
            @Nullable String description,
            @Nullable String imageUrl,
            ColorType colorType,
            @Nullable ArrayList<MessageEmbed.Field> fieldList
            )
    {
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

        if (fieldList != null) {
            for (MessageEmbed.Field field : fieldList) {
                builder.addBlankField(false);
                builder.addField(field);
            }
        }

        return builder.build();
    }

    public static MessageEmbed message(
            String title,
            @Nullable String description,
            @Nullable String imageUrl,
            ColorType colorType
    )
    {
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

    public static MessageEmbed message(
            String title,
            @Nullable String description,
            @Nullable String imageUrl,
            ColorType colorType,
            @Nullable MessageEmbed.Footer footer
    )
    {
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

        if (footer != null) {
            builder.setFooter(footer.getText());
        }

        return builder.build();
    }

    public static MessageEmbed message(
            String title,
            @Nullable String description,
            @Nullable String imageUrl,
            ColorType colorType,
            @Nullable ArrayList<MessageEmbed.Field> fieldList,
            @Nullable MessageEmbed.Footer footer
    )
    {
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

        if (footer != null) {
            builder.setFooter(footer.getText());
        }

        if (fieldList != null) {
            for (MessageEmbed.Field field : fieldList) {
                builder.addField(field);
            }
        }

        return builder.build();
    }
}
