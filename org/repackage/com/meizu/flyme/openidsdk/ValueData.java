package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/meizu/flyme/openidsdk/ValueData.class */
class ValueData {

    /* renamed from: a  reason: collision with root package name */
    public String f44110a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public long f44111c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i) {
        this.f44110a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.f44110a + "', code=" + this.b + ", expired=" + this.f44111c + '}';
    }
}
