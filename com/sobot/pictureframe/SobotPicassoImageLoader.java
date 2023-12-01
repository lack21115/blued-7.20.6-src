package com.sobot.pictureframe;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.sobot.chat.imageloader.SobotImageLoader;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/pictureframe/SobotPicassoImageLoader.class */
public class SobotPicassoImageLoader extends SobotImageLoader {
    @Override // com.sobot.chat.imageloader.SobotImageLoader
    public void displayImage(Context context, final ImageView imageView, int i, int i2, int i3, int i4, int i5, final SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener) {
        RequestCreator config = Picasso.with(context).load(i).config(Bitmap.Config.RGB_565);
        if (i2 != 0) {
            config.placeholder(i2);
        }
        if (i3 != 0) {
            config.error(i3);
        }
        if (i4 == 0 && i5 == 0) {
            config.fit().centerCrop();
        } else {
            config.resize(i4, i5).centerCrop();
        }
        config.into(imageView, new Callback.EmptyCallback() { // from class: com.sobot.pictureframe.SobotPicassoImageLoader.2
            public void onSuccess() {
                SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener2 = sobotDisplayImageListener;
                if (sobotDisplayImageListener2 != null) {
                    sobotDisplayImageListener2.onSuccess(imageView, "");
                }
            }
        });
    }

    @Override // com.sobot.chat.imageloader.SobotImageLoader
    public void displayImage(Context context, final ImageView imageView, final String str, int i, int i2, int i3, int i4, final SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener) {
        RequestCreator load = Picasso.with(context).load(TextUtils.isEmpty(str) ? "error" : str);
        if (i != 0) {
            load.placeholder(i);
        }
        if (i2 != 0) {
            load.error(i2);
        }
        load.config(Bitmap.Config.RGB_565);
        if (i3 == 0 && i4 == 0) {
            load.fit().centerCrop();
        } else {
            load.resize(i3, i4).centerCrop();
        }
        load.into(imageView, new Callback.EmptyCallback() { // from class: com.sobot.pictureframe.SobotPicassoImageLoader.1
            public void onSuccess() {
                SobotImageLoader.SobotDisplayImageListener sobotDisplayImageListener2 = sobotDisplayImageListener;
                if (sobotDisplayImageListener2 != null) {
                    sobotDisplayImageListener2.onSuccess(imageView, str);
                }
            }
        });
    }
}
