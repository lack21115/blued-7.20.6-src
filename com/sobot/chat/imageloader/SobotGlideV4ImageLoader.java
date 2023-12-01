package com.sobot.chat.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.sobot.chat.imageloader.SobotImageLoader;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/imageloader/SobotGlideV4ImageLoader.class */
public class SobotGlideV4ImageLoader extends SobotImageLoader {
    @Override // com.sobot.chat.imageloader.SobotImageLoader
    public void displayImage(Context context, final ImageView imageView, int i, int i2, int i3, int i4, int i5, final SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener) {
        RequestBuilder l = Glide.b(context).f().b(Integer.valueOf(i)).h(i2).f(i3).l();
        if (i4 != 0 || i5 != 0) {
            l.b(i4, i5);
        }
        l.d(new RequestListener<Bitmap>() { // from class: com.sobot.chat.imageloader.SobotGlideV4ImageLoader.2
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener2 = sobotDisplayImageListener;
                if (sobotDisplayImageListener2 != null) {
                    sobotDisplayImageListener2.onSuccess(imageView, "");
                    return false;
                }
                return false;
            }
        }).a(imageView);
    }

    @Override // com.sobot.chat.imageloader.SobotImageLoader
    public void displayImage(Context context, final ImageView imageView, final String str, int i, int i2, int i3, int i4, final SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener) {
        RequestBuilder l = Glide.b(context).f().b(str).h(i).f(i2).l();
        if (i3 != 0 || i4 != 0) {
            l.b(i3, i4);
        }
        l.d(new RequestListener<Bitmap>() { // from class: com.sobot.chat.imageloader.SobotGlideV4ImageLoader.1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Bitmap> target, boolean z) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener2 = sobotDisplayImageListener;
                if (sobotDisplayImageListener2 != null) {
                    sobotDisplayImageListener2.onSuccess(imageView, str);
                    return false;
                }
                return false;
            }
        }).a(imageView);
    }
}
