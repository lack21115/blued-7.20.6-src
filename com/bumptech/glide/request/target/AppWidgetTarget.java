package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/request/target/AppWidgetTarget.class */
public class AppWidgetTarget extends CustomTarget<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f21054a;
    private final ComponentName b;

    /* renamed from: c  reason: collision with root package name */
    private final RemoteViews f21055c;
    private final Context d;
    private final int e;

    private void a(Bitmap bitmap) {
        this.f21055c.setImageViewBitmap(this.e, bitmap);
        update();
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.d);
        ComponentName componentName = this.b;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f21055c);
        } else {
            appWidgetManager.updateAppWidget(this.f21054a, this.f21055c);
        }
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
