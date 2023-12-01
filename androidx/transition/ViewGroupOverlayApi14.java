package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ViewGroupOverlayApi14.class */
public class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewGroupOverlayApi14 a(ViewGroup viewGroup) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.b(viewGroup);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View view) {
        this.f3497a.add(view);
    }

    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View view) {
        this.f3497a.remove(view);
    }
}
