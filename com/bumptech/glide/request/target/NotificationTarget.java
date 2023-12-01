package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/NotificationTarget.class */
public class NotificationTarget extends CustomTarget<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteViews f21068a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21069c;
    private final String d;
    private final Notification e;
    private final int f;

    private void a(Bitmap bitmap) {
        this.f21068a.setImageViewBitmap(this.f, bitmap);
        update();
    }

    private void update() {
        ((NotificationManager) Preconditions.a((NotificationManager) this.b.getSystemService("notification"))).notify(this.d, this.f21069c, this.e);
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: a */
    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        a(bitmap);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        a(null);
    }
}
