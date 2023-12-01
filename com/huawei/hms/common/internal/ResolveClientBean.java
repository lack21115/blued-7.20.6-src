package com.huawei.hms.common.internal;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/ResolveClientBean.class */
public class ResolveClientBean {

    /* renamed from: a  reason: collision with root package name */
    private final int f9053a;
    private final AnyClient b;

    /* renamed from: c  reason: collision with root package name */
    private int f9054c;

    public ResolveClientBean(AnyClient anyClient, int i) {
        this.b = anyClient;
        this.f9053a = Objects.hashCode(anyClient);
        this.f9054c = i;
    }

    public void clientReconnect() {
        this.b.connect(this.f9054c, true);
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
        return this.f9053a;
    }
}
