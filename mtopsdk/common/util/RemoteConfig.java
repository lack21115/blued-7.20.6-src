package mtopsdk.common.util;

import java.util.Map;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/RemoteConfig.class */
public class RemoteConfig {

    /* renamed from: a  reason: collision with root package name */
    public boolean f43684a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43685c;
    public long d;
    public String e;
    private Map f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/RemoteConfig$RemoteConfigInstanceHolder.class */
    public class RemoteConfigInstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static RemoteConfig f43686a = new RemoteConfig();

        private RemoteConfigInstanceHolder() {
        }
    }

    private RemoteConfig() {
        this.f = null;
        this.f43684a = true;
        this.b = true;
        this.f43685c = true;
        this.d = 10L;
        this.e = "";
    }

    public static RemoteConfig a() {
        return RemoteConfigInstanceHolder.f43686a;
    }
}
