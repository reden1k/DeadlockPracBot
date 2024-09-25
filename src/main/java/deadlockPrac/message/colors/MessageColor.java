package deadlockPrac.message.colors;

import java.awt.*;

public class MessageColor {
    public static final Color DEFAULT_COLOR = new Color(255, 201, 59);
    public static final Color DANGER_COLOR = new Color(255, 0, 0);
    public static final Color TIPS_COLOR = new Color(127, 0, 255);
    public static final Color ERROR = new Color(255, 0, 0);
    public static final Color SUCCESS = new Color(0,255,0);
    public static Color getColor(ColorType type) {
        switch (type) {
            case TIPS -> {
                return TIPS_COLOR;
            }
            case DANGER -> {
                return DANGER_COLOR;
            }
            case ERROR -> {
                return ERROR;
            }
            case SUCCESS -> {
                return SUCCESS;
            }
            default -> {
                return DEFAULT_COLOR;
            }
        }
    }
}
