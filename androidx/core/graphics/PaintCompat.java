package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pair;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PaintCompat.class */
public final class PaintCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Pair<Rect, Rect>> f2450a = new ThreadLocal<>();

    private PaintCompat() {
    }

    private static Pair<Rect, Rect> a() {
        Pair<Rect, Rect> pair = f2450a.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            f2450a.set(pair2);
            return pair2;
        }
        pair.first.setEmpty();
        pair.second.setEmpty();
        return pair;
    }

    public static boolean hasGlyph(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("��");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                int charCount = Character.charCount(str.codePointAt(i2)) + i2;
                f += paint.measureText(str, i2, charCount);
                i = charCount;
            }
            if (measureText3 >= f) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair<Rect, Rect> a2 = a();
        paint.getTextBounds("��", 0, 2, a2.first);
        paint.getTextBounds(str, 0, length, a2.second);
        return !a2.first.equals(a2.second);
    }

    public static boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            BlendMode blendMode = null;
            if (blendModeCompat != null) {
                blendMode = BlendModeUtils.a(blendModeCompat);
            }
            paint.setBlendMode(blendMode);
            return true;
        } else if (blendModeCompat == null) {
            paint.setXfermode(null);
            return true;
        } else {
            PorterDuff.Mode b = BlendModeUtils.b(blendModeCompat);
            PorterDuffXfermode porterDuffXfermode = null;
            if (b != null) {
                porterDuffXfermode = new PorterDuffXfermode(b);
            }
            paint.setXfermode(porterDuffXfermode);
            return b != null;
        }
    }
}
