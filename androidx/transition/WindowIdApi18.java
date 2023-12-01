package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/transition/WindowIdApi18.class */
public class WindowIdApi18 implements WindowIdImpl {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f3518a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowIdApi18(View view) {
        this.f3518a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).f3518a.equals(this.f3518a);
    }

    public int hashCode() {
        return this.f3518a.hashCode();
    }
}
