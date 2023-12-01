package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/meizu/flyme/openidsdk/OpenId.class */
class OpenId {

    /* renamed from: a  reason: collision with root package name */
    long f44106a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f44107c;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenId(String str) {
        this.f44107c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        this.f44106a = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f44106a > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f44106a = 0L;
    }
}
