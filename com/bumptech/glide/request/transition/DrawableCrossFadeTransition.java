package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/DrawableCrossFadeTransition.class */
public class DrawableCrossFadeTransition implements Transition<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f7476a;
    private final boolean b;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.f7476a = i;
        this.b = z;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean a(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable a2 = viewAdapter.a();
        Drawable drawable2 = a2;
        if (a2 == null) {
            drawable2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.f7476a);
        viewAdapter.b(transitionDrawable);
        return true;
    }
}
