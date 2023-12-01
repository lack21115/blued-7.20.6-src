package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/c.class */
public class c extends a {
    private Bitmap j;

    public c(Context context, int i, String str, HashMap<ZkViewSDK.KEY, Object> hashMap, int i2, Map map, ZkViewSDK.a aVar) {
        super(context, i, str, hashMap, i2, map, aVar);
        if (!new File(this.b + "no_first_draw").exists()) {
            h();
        }
        g();
    }

    private void g() {
        int i;
        String str;
        if (this.h == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap<ZkViewSDK.KEY, Object> hashMap2 = this.f;
        if (hashMap2 != null) {
            Object obj = hashMap2.get(ZkViewSDK.KEY.KEY_SKIP_TIME);
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                str = ZkViewSDK.c.q;
                i = intValue * 1000;
                hashMap.put(str, Integer.valueOf(i));
                this.h.a(this.g, hashMap);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append("isVideo");
        i = new File(sb.toString()).exists() ? 6000 : 4000;
        str = ZkViewSDK.c.q;
        hashMap.put(str, Integer.valueOf(i));
        this.h.a(this.g, hashMap);
    }

    private void h() {
        try {
            ImageView imageView = new ImageView(this.f41957c);
            Bitmap decodeFile = BitmapFactory.decodeFile(this.b + "bj.jpg");
            this.j = decodeFile;
            imageView.setImageBitmap(decodeFile);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        } catch (Throwable th) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdkwrapper.a
    public void b() {
        synchronized (this) {
            super.b();
            try {
                Bitmap bitmap = this.j;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.j.recycle();
                    this.j = null;
                }
            } catch (Throwable th) {
            }
        }
    }
}
