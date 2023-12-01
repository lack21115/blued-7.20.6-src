package androidx.transition;

import android.os.IBinder;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/WindowIdApi14.class */
class WindowIdApi14 implements WindowIdImpl {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f3469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowIdApi14(IBinder iBinder) {
        this.f3469a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).f3469a.equals(this.f3469a);
    }

    public int hashCode() {
        return this.f3469a.hashCode();
    }
}
