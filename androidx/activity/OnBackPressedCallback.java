package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/activity/OnBackPressedCallback.class */
public abstract class OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1446a;
    private CopyOnWriteArrayList<Cancellable> b = new CopyOnWriteArrayList<>();

    public OnBackPressedCallback(boolean z) {
        this.f1446a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Cancellable cancellable) {
        this.b.add(cancellable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Cancellable cancellable) {
        this.b.remove(cancellable);
    }

    public abstract void handleOnBackPressed();

    public final boolean isEnabled() {
        return this.f1446a;
    }

    public final void remove() {
        Iterator<Cancellable> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    public final void setEnabled(boolean z) {
        this.f1446a = z;
    }
}
