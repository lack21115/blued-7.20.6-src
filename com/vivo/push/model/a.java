package com.vivo.push.model;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/model/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f41109a;
    private String b;

    public a(String str, String str2) {
        this.f41109a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f41109a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f41109a;
            String str2 = ((a) obj).f41109a;
            return str == null ? str2 == null : str.equals(str2);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f41109a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f41109a + "', mValue='" + this.b + "'}";
    }
}
