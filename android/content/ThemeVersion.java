package android.content;

/* loaded from: source-9557208-dex2jar.jar:android/content/ThemeVersion.class */
public class ThemeVersion {
    public static int THEME_VERSION = 3;
    public static int MIN_SUPPORTED_THEME_VERSION = 2;

    /* loaded from: source-9557208-dex2jar.jar:android/content/ThemeVersion$ComponentVersion.class */
    public enum ComponentVersion {
        OVERLAY(0, 2, 2),
        BOOT_ANIM(1, 1, 1),
        WALLPAPER(2, 1, 2),
        LOCKSCREEN(3, 1, 1),
        FONT(4, 1, 2),
        ICON(5, 1, 1),
        SOUNDS(6, 1, 1);
        
        public int currentVersion;
        public int id;
        public int minSupportedVersion;

        ComponentVersion(int i, int i2, int i3) {
            this.id = i;
            this.minSupportedVersion = i2;
            this.currentVersion = i3;
        }
    }
}
