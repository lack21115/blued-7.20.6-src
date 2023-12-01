package mtopsdk.common.util;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/LocalConfig.class */
public class LocalConfig {

    /* renamed from: a  reason: collision with root package name */
    public boolean f43680a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43681c;

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/LocalConfig$LocalConfigInstanceHolder.class */
    class LocalConfigInstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static LocalConfig f43682a = new LocalConfig();

        private LocalConfigInstanceHolder() {
        }
    }

    private LocalConfig() {
        this.f43680a = true;
        this.b = true;
        this.f43681c = true;
    }

    public static LocalConfig a() {
        return LocalConfigInstanceHolder.f43682a;
    }
}
