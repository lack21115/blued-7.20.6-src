package com.sobot.chat.imageloader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/imageloader/SobotImageLoader.class */
public abstract class SobotImageLoader {

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/imageloader/SobotImageLoader$SobotDisplayImageListener.class */
    public interface SobotDisplayImageListener {
        void onSuccess(View view, String str);
    }

    public abstract void displayImage(Context context, ImageView imageView, int i, int i2, int i3, int i4, int i5, SobotDisplayImageListener sobotDisplayImageListener);

    public abstract void displayImage(Context context, ImageView imageView, String str, int i, int i2, int i3, int i4, SobotDisplayImageListener sobotDisplayImageListener);
}
