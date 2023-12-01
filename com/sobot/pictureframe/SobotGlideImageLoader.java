package com.sobot.pictureframe;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.sobot.chat.imageloader.SobotImageLoader;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/pictureframe/SobotGlideImageLoader.class */
public class SobotGlideImageLoader extends SobotImageLoader {
    @Override // com.sobot.chat.imageloader.SobotImageLoader
    public void displayImage(Context context, final ImageView imageView, int i, int i2, int i3, int i4, int i5, final SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener) {
        BitmapRequestBuilder centerCrop = Glide.b(context).load(Integer.valueOf(i)).asBitmap().placeholder(i2).error(i3).centerCrop();
        if (i4 != 0 || i5 != 0) {
            centerCrop.override(i4, i5);
        }
        centerCrop.listener(new RequestListener<Integer, Bitmap>() { // from class: com.sobot.pictureframe.SobotGlideImageLoader.2
            public boolean onException(Exception exc, Integer num, Target<Bitmap> target, boolean z) {
                return false;
            }

            public /* bridge */ /* synthetic */ boolean onException(Exception exc, Object obj, Target target, boolean z) {
                return onException(exc, (Integer) obj, (Target<Bitmap>) target, z);
            }

            public boolean onResourceReady(Bitmap bitmap, Integer num, Target<Bitmap> target, boolean z, boolean z2) {
                SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener2 = sobotDisplayImageListener;
                if (sobotDisplayImageListener2 != null) {
                    sobotDisplayImageListener2.onSuccess(imageView, "");
                    return false;
                }
                return false;
            }

            public /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
                return onResourceReady((Bitmap) obj, (Integer) obj2, (Target<Bitmap>) target, z, z2);
            }
        }).into(imageView);
    }

    @Override // com.sobot.chat.imageloader.SobotImageLoader
    public void displayImage(Context context, final ImageView imageView, final String str, int i, int i2, int i3, int i4, final SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener) {
        BitmapRequestBuilder centerCrop = Glide.b(context).load(str).asBitmap().placeholder(i).error(i2).centerCrop();
        if (i3 != 0 || i4 != 0) {
            centerCrop.override(i3, i4);
        }
        centerCrop.listener(new RequestListener<String, Bitmap>() { // from class: com.sobot.pictureframe.SobotGlideImageLoader.1
            public /* bridge */ /* synthetic */ boolean onException(Exception exc, Object obj, Target target, boolean z) {
                return onException(exc, (String) obj, (Target<Bitmap>) target, z);
            }

            public boolean onException(Exception exc, String str2, Target<Bitmap> target, boolean z) {
                return false;
            }

            public boolean onResourceReady(Bitmap bitmap, String str2, Target<Bitmap> target, boolean z, boolean z2) {
                SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener2 = sobotDisplayImageListener;
                if (sobotDisplayImageListener2 != null) {
                    sobotDisplayImageListener2.onSuccess(imageView, str);
                    return false;
                }
                return false;
            }

            public /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
                return onResourceReady((Bitmap) obj, (String) obj2, (Target<Bitmap>) target, z, z2);
            }
        }).into(imageView);
    }
}
