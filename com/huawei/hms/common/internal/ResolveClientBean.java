package com.huawei.hms.common.internal;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/ResolveClientBean.class */
public class ResolveClientBean {

    /* renamed from: a  reason: collision with root package name */
    private final int f22661a;
    private final AnyClient b;

    /* renamed from: c  reason: collision with root package name */
    private int f22662c;

    public ResolveClientBean(AnyClient anyClient, int i) {
        this.b = anyClient;
        this.f22661a = Objects.hashCode(anyClient);
        this.f22662c = i;
    }

    public void clientReconnect() {
        this.b.connect(this.f22662c, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResolveClientBean)) {
            return false;
        }
        return this.b.equals(((ResolveClientBean) obj).b);
    }

    public AnyClient getClient() {
        return this.b;
    }

    public int hashCode() {
        return this.f22661a;
    }
}
