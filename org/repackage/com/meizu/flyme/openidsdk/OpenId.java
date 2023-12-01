package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/meizu/flyme/openidsdk/OpenId.class */
class OpenId {
    long a;
    String b;
    String c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenId(String str) {
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.a = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.a > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.a = 0L;
    }
}
