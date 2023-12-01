package com.blued.android.module.live_china.same;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.live_china.R;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/LiveBitmapUtils.class */
public class LiveBitmapUtils {
    public static Bitmap a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth / i;
        int i3 = options.outHeight / i;
        if (i2 > 1 || i3 > 1) {
            if (i2 > i3) {
                options.inSampleSize = i2;
            } else {
                options.inSampleSize = i3;
            }
        }
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            MemoryRequest.a().b();
            return null;
        }
    }

    public static Drawable a() {
        return AppInfo.d().getResources().getDrawable(R.drawable.icon_live_manager_new);
    }

    public static Drawable a(Context context, int i) {
        int a2 = BitmapUtils.a(context, (ImageView) null, i);
        if (a2 != -1) {
            return context.getResources().getDrawable(a2);
        }
        return null;
    }

    public static void a(Bitmap bitmap, String str, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            Logger.a("drb", "baos.size() = ", Integer.valueOf(byteArrayOutputStream.size()));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
