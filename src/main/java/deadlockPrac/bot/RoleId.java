package deadlockPrac.bot;

import net.dv8tion.jda.api.entities.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoleId {
    public static final Long BOT = 1289245764882792492L;
    public static final Long MANAGER = 1288520382562963486L;
    public static final Long HELPER = 1288520448925106358L;
    public static final Long DOT = 1287779653070749793L;


    public static final Long NEW_MEMBER = 1289241488219308093L;
    public static final Long VERIFIED = 1288355242286649375L;
    public static final Long LANG_RU = 1288355413829615616L;
    public static final Long LANG_ENG = 1288355442694684692L;
    public static final Long LANG_KR = 1288365087412715560L;
    public static final Long LANG_CH = 1288365415445168140L;
    public static final Long LANG_JP = 1288355465058717708L;
    public static final Long TWITCH = 1288520299788374127L;
    public static final Long EVERYONE = 1287777587757584494L;

    public static final ArrayList<Long> REQUIRED_IDs = new ArrayList<>(Arrays.asList(
            BOT,
            MANAGER,
            HELPER,
            DOT,
            NEW_MEMBER,
            VERIFIED,
            LANG_RU,
            LANG_ENG,
            LANG_KR,
            LANG_CH,
            LANG_JP,
            TWITCH,
            EVERYONE
    ));
}
