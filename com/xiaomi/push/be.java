package com.xiaomi.push;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/be.class */
public class be implements bg {

    /* renamed from: a  reason: collision with root package name */
    private final String f27585a;
    private final String b;

    public be(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f27585a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.bg
    public String a() {
        return this.f27585a;
    }

    @Override // com.xiaomi.push.bg
    public String b() {
        return this.b;
    }
}
