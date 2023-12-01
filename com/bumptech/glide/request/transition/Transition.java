package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/Transition.class */
public interface Transition<R> {

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/transition/Transition$ViewAdapter.class */
    public interface ViewAdapter {
        Drawable a();

        void b(Drawable drawable);

        View d();
    }

    boolean a(R r, ViewAdapter viewAdapter);
}
