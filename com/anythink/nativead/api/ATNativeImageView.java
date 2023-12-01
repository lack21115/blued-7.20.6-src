package com.anythink.nativead.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/ATNativeImageView.class */
public class ATNativeImageView extends ImageView {
    public static final String TAG = ATNativeImageView.class.getSimpleName();
    String mImageUrl;

    public ATNativeImageView(Context context) {
        super(context);
    }

    public ATNativeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATNativeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public void setImage(String str) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setImage(str, layoutParams.width, layoutParams.height);
        } else {
            setImage(str, -1, -1);
        }
    }

    public void setImage(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "load: url is empty!");
            return;
        }
        this.mImageUrl = str;
        final WeakReference weakReference = new WeakReference(this);
        b.a(getContext()).a(new e(2, str), i, i2, new b.a() { // from class: com.anythink.nativead.api.ATNativeImageView.1
            public final void onFail(String str2, String str3) {
                Log.e(ATNativeImageView.TAG, "load: image load fail:".concat(String.valueOf(str3)));
            }

            public final void onSuccess(String str2, Bitmap bitmap) {
                ATNativeImageView aTNativeImageView = (ATNativeImageView) weakReference.get();
                if (!TextUtils.equals(ATNativeImageView.this.mImageUrl, str2) || aTNativeImageView == null) {
                    return;
                }
                aTNativeImageView.setImageBitmap(bitmap);
            }
        });
    }
}
