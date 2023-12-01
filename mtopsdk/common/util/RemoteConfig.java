package mtopsdk.common.util;

import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/RemoteConfig.class */
public class RemoteConfig {
    public boolean a;
    public boolean b;
    public boolean c;
    public long d;
    public String e;
    private Map f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/RemoteConfig$RemoteConfigInstanceHolder.class */
    public class RemoteConfigInstanceHolder {
        private static RemoteConfig a = new RemoteConfig();

        private RemoteConfigInstanceHolder() {
        }
    }

    private RemoteConfig() {
        this.f = null;
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = 10L;
        this.e = "";
    }

    public static RemoteConfig a() {
        return RemoteConfigInstanceHolder.a;
    }
}
