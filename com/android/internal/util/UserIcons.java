package com.android.internal.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/UserIcons.class */
public class UserIcons {
    private static final int[] USER_ICON_COLORS = {R.color.user_icon_1, R.color.user_icon_2, R.color.user_icon_3, R.color.user_icon_4, R.color.user_icon_5, R.color.user_icon_6, R.color.user_icon_7, R.color.user_icon_8};

    public static Bitmap convertToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Drawable getDefaultUserIcon(int i, boolean z) {
        int i2 = z ? 17170535 : 17170534;
        if (i != -10000) {
            i2 = USER_ICON_COLORS[i % USER_ICON_COLORS.length];
        }
        Drawable mutate = Resources.getSystem().getDrawable(R.drawable.ic_account_circle).mutate();
        mutate.setColorFilter(Resources.getSystem().getColor(i2), PorterDuff.Mode.SRC_IN);
        mutate.setBounds(0, 0, mutate.getIntrinsicWidth(), mutate.getIntrinsicHeight());
        return mutate;
    }
}
