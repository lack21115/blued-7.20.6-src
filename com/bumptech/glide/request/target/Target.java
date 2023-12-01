package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/Target.class */
public interface Target<R> extends LifecycleListener {
    Request getRequest();

    void getSize(SizeReadyCallback sizeReadyCallback);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, Transition<? super R> transition);

    void removeCallback(SizeReadyCallback sizeReadyCallback);

    void setRequest(Request request);
}
