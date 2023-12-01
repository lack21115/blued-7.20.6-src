package com.android.internal.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.Pair;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/NotificationColorUtil.class */
public class NotificationColorUtil {
    private static final String TAG = "NotificationColorUtil";
    private static NotificationColorUtil sInstance;
    private static final Object sLock = new Object();
    private final int mGrayscaleIconMaxSize;
    private final ImageUtils mImageUtils = new ImageUtils();
    private final WeakHashMap<Bitmap, Pair<Boolean, Integer>> mGrayscaleBitmapCache = new WeakHashMap<>();

    private NotificationColorUtil(Context context) {
        this.mGrayscaleIconMaxSize = context.getResources().getDimensionPixelSize(17104901);
    }

    public static NotificationColorUtil getInstance(Context context) {
        NotificationColorUtil notificationColorUtil;
        synchronized (sLock) {
            if (sInstance == null) {
                sInstance = new NotificationColorUtil(context);
            }
            notificationColorUtil = sInstance;
        }
        return notificationColorUtil;
    }

    private int processColor(int i) {
        return Color.argb(Color.alpha(i), 255 - Color.red(i), 255 - Color.green(i), 255 - Color.blue(i));
    }

    private TextAppearanceSpan processTextAppearanceSpan(TextAppearanceSpan textAppearanceSpan) {
        ColorStateList textColor = textAppearanceSpan.getTextColor();
        if (textColor != null) {
            int[] colors = textColor.getColors();
            boolean z = false;
            int i = 0;
            while (i < colors.length) {
                boolean z2 = z;
                int[] iArr = colors;
                if (ImageUtils.isGrayscale(colors[i])) {
                    iArr = colors;
                    if (!z) {
                        iArr = Arrays.copyOf(colors, colors.length);
                    }
                    iArr[i] = processColor(iArr[i]);
                    z2 = true;
                }
                i++;
                z = z2;
                colors = iArr;
            }
            if (z) {
                return new TextAppearanceSpan(textAppearanceSpan.getFamily(), textAppearanceSpan.getTextStyle(), textAppearanceSpan.getTextSize(), new ColorStateList(textColor.getStates(), colors), textAppearanceSpan.getLinkTextColor());
            }
        }
        return textAppearanceSpan;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.text.Spanned, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object[]] */
    public CharSequence invertCharSequenceColors(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            ?? r0 = (Spanned) charSequence;
            ?? spans = r0.getSpans(0, r0.length(), Object.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(r0.toString());
            int length = spans.length;
            int i = 0;
            while (true) {
                int i2 = i;
                charSequence = spannableStringBuilder;
                if (i2 >= length) {
                    break;
                }
                ?? r02 = spans[i2];
                TextAppearanceSpan textAppearanceSpan = r02;
                if (r02 instanceof TextAppearanceSpan) {
                    textAppearanceSpan = processTextAppearanceSpan((TextAppearanceSpan) r02);
                }
                spannableStringBuilder.setSpan(textAppearanceSpan, r0.getSpanStart(r02), r0.getSpanEnd(r02), r0.getSpanFlags(r02));
                i = i2 + 1;
            }
        }
        return charSequence;
    }

    public boolean isGrayscaleIcon(Context context, int i) {
        boolean z = false;
        if (i != 0) {
            try {
                z = isGrayscaleIcon(context.getDrawable(i));
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "Drawable not found: " + i);
                return false;
            }
        }
        return z;
    }

    public boolean isGrayscaleIcon(Bitmap bitmap) {
        boolean isGrayscale;
        int generationId;
        if (bitmap.getWidth() > this.mGrayscaleIconMaxSize || bitmap.getHeight() > this.mGrayscaleIconMaxSize) {
            return false;
        }
        synchronized (sLock) {
            Pair<Boolean, Integer> pair = this.mGrayscaleBitmapCache.get(bitmap);
            if (pair != null && pair.second.intValue() == bitmap.getGenerationId()) {
                return pair.first.booleanValue();
            }
            synchronized (this.mImageUtils) {
                isGrayscale = this.mImageUtils.isGrayscale(bitmap);
                generationId = bitmap.getGenerationId();
            }
            synchronized (sLock) {
                this.mGrayscaleBitmapCache.put(bitmap, Pair.create(Boolean.valueOf(isGrayscale), Integer.valueOf(generationId)));
            }
            return isGrayscale;
        }
    }

    public boolean isGrayscaleIcon(Drawable drawable) {
        boolean z = true;
        if (drawable == null) {
            z = false;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null || !isGrayscaleIcon(bitmapDrawable.getBitmap())) {
                return false;
            }
        } else if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            if (animationDrawable.getNumberOfFrames() <= 0 || !isGrayscaleIcon(animationDrawable.getFrame(0))) {
                return false;
            }
        } else if (!(drawable instanceof VectorDrawable)) {
            return false;
        }
        return z;
    }
}
