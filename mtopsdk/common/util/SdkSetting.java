package mtopsdk.common.util;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/SdkSetting.class */
public class SdkSetting {

    /* renamed from: a  reason: collision with root package name */
    private static ENV f43687a = ENV.release;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/SdkSetting$ENV.class */
    public enum ENV {
        debug,
        develop,
        release
    }

    public static void a(ENV env) {
        if (env != null) {
            f43687a = env;
        }
    }
}
