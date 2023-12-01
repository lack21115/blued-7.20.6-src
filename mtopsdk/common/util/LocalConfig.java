package mtopsdk.common.util;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/LocalConfig.class */
public class LocalConfig {
    public boolean a;
    public boolean b;
    public boolean c;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/LocalConfig$LocalConfigInstanceHolder.class */
    class LocalConfigInstanceHolder {
        private static LocalConfig a = new LocalConfig();

        private LocalConfigInstanceHolder() {
        }
    }

    private LocalConfig() {
        this.a = true;
        this.b = true;
        this.c = true;
    }

    public static LocalConfig a() {
        return LocalConfigInstanceHolder.a;
    }
}
