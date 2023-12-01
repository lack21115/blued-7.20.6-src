package mtopsdk.common.util;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/SdkSetting.class */
public class SdkSetting {
    private static ENV a = ENV.release;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/SdkSetting$ENV.class */
    public enum ENV {
        debug,
        develop,
        release
    }

    public static void a(ENV env) {
        if (env != null) {
            a = env;
        }
    }
}
