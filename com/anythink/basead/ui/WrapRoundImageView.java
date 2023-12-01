package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.anythink.core.common.k.u;
import com.anythink.core.common.ui.component.RoundImageView;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/WrapRoundImageView.class */
public class WrapRoundImageView extends RoundImageView {
    public WrapRoundImageView(Context context) {
        super(context);
    }

    public WrapRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int[] setBitmapAndResize(Bitmap bitmap, int i, int i2) {
        setImageBitmap(bitmap);
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        try {
            int[] a2 = u.a(i, i2, bitmap.getWidth() / bitmap.getHeight());
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = a2[0];
                layoutParams.height = a2[1];
                setLayoutParams(layoutParams);
                return a2;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
