package constants;

/**
 * Окружение и общие настройки для тестов.
 */
public class Configuration {
    public static final String BROWSER = "chrome";
    //public static final String BROWSER = "firefox";
    //public static final String BROWSER = "edge";

    public static final int IMPLICITLY_WAIT = 5;
    public static final int EXPLICITLY_WAIT = 8;
    public static final boolean DELETE_COOKIES = true;
    public static final boolean DELETE_SESSION_STORAGE = true;
    public static final boolean QUIT_BROWSER = true;
    public static final boolean SKIP_MESSAGE_COOKIES = true;

}
