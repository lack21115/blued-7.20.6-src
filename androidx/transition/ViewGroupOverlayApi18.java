package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ViewGroupOverlayApi18.class */
public class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f3492a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.f3492a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable drawable) {
        this.f3492a.add(drawable);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View view) {
        this.f3492a.add(view);
    }

    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable drawable) {
        this.f3492a.remove(drawable);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View view) {
        this.f3492a.remove(view);
    }
}
