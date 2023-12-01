package com.autonavi.base.ae.gmap.glyph;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/glyph/GlyphLoader.class */
public class GlyphLoader {
    private static Map<String, Typeface> FontFaceMap = new HashMap();

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    private static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static String decodeUnicode(short s) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) s);
        return stringBuffer.toString();
    }

    public static void destroyGlyphLoader(long j) {
        nativeDestroyGlyphLoader(j);
    }

    private static FontMetricsRequestParam genFontMetricsParam(byte[] bArr) {
        FontMetricsRequestParam fontMetricsRequestParam = new FontMetricsRequestParam();
        fontMetricsRequestParam.fFontSize = GLConvertUtil.getInt(bArr, 0) * 0.001f;
        fontMetricsRequestParam.nFontStyleCode = GLConvertUtil.getInt(bArr, 4);
        int i = 12;
        if (1 == GLConvertUtil.getInt(bArr, 8)) {
            int i2 = GLConvertUtil.getInt(bArr, 12);
            fontMetricsRequestParam.strName = new String(bArr, 16, i2);
            i = i2 + 16;
        }
        fontMetricsRequestParam.languageArr = new String(bArr, i + 4, GLConvertUtil.getInt(bArr, i));
        return fontMetricsRequestParam;
    }

    private static GlyphRequestParam genGlyphRequestParam(byte[] bArr) {
        GlyphRequestParam glyphRequestParam = new GlyphRequestParam();
        int i = GLConvertUtil.getInt(bArr, 0);
        glyphRequestParam.strBuffer = new String(bArr, 4, i);
        int i2 = i + 4;
        Font font = new Font();
        font.nFontStyleCode = GLConvertUtil.getInt(bArr, i2);
        int i3 = i2 + 4;
        font.nFontSize = GLConvertUtil.getInt(bArr, i3);
        int i4 = i3 + 4;
        int i5 = GLConvertUtil.getInt(bArr, i4);
        int i6 = i4 + 4;
        font.strName = new String(bArr, i6, i5);
        int i7 = i6 + i5;
        FontMetrics fontMetrics = new FontMetrics();
        int i8 = GLConvertUtil.getInt(bArr, i7);
        int i9 = i7 + 4;
        fontMetrics.fAscent = i8 * 0.001f;
        int i10 = GLConvertUtil.getInt(bArr, i9);
        int i11 = i9 + 4;
        fontMetrics.fDescent = i10 * 0.001f;
        int i12 = GLConvertUtil.getInt(bArr, i11);
        int i13 = i11 + 4;
        fontMetrics.fLeading = i12 * 0.001f;
        int i14 = GLConvertUtil.getInt(bArr, i13);
        int i15 = i13 + 4;
        fontMetrics.fHeight = i14 * 0.001f;
        font.fontMetrics = fontMetrics;
        glyphRequestParam.font = font;
        glyphRequestParam.drawingMode = GLConvertUtil.getInt(bArr, i15);
        int i16 = i15 + 4;
        int i17 = GLConvertUtil.getInt(bArr, i16);
        int i18 = i16 + 4;
        glyphRequestParam.strokeWidth = i17 * 0.001f;
        int i19 = GLConvertUtil.getInt(bArr, i18);
        int i20 = i18 + 4;
        glyphRequestParam.languageArr = new String(bArr, i20, i19);
        glyphRequestParam.isEmoji = GLConvertUtil.getInt(bArr, i20);
        int i21 = i20 + 4;
        glyphRequestParam.isSDF = GLConvertUtil.getInt(bArr, i21);
        int i22 = i21 + 4;
        int i23 = GLConvertUtil.getInt(bArr, i22);
        int i24 = i22 + 4;
        if (1 == i23) {
            GlyphMetrics glyphMetrics = new GlyphMetrics();
            glyphMetrics.nWidth = GLConvertUtil.getInt(bArr, i24);
            int i25 = i24 + 4;
            glyphMetrics.nHeight = GLConvertUtil.getInt(bArr, i25);
            int i26 = i25 + 4;
            int i27 = GLConvertUtil.getInt(bArr, i26);
            int i28 = i26 + 4;
            glyphMetrics.fLeft = i27 * 0.001f;
            glyphMetrics.fTop = GLConvertUtil.getInt(bArr, i28) * 0.001f;
            glyphMetrics.fAdvance = GLConvertUtil.getInt(bArr, i28 + 4) * 0.001f;
            glyphRequestParam.fGlyphMetrics = glyphMetrics;
        }
        return glyphRequestParam;
    }

    private static FontMetrics getFontMetrics(byte[] bArr) {
        FontMetricsRequestParam genFontMetricsParam = genFontMetricsParam(bArr);
        TextPaint newTextPaint = newTextPaint(new FontStyle(genFontMetricsParam.nFontStyleCode), genFontMetricsParam.fFontSize, genFontMetricsParam.strName, false, 0.0f);
        Paint.FontMetrics fontMetrics = newTextPaint.getFontMetrics();
        FontMetrics fontMetrics2 = new FontMetrics();
        fontMetrics2.bSuccess = true;
        fontMetrics2.fAscent = Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        newTextPaint.setTypeface(null);
        return fontMetrics2;
    }

    private static GlyphMetrics getGlyphMetrics(byte[] bArr) {
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        return loadGlyphMetrics(genGlyphRequestParam.strBuffer, new FontStyle(genGlyphRequestParam.font.nFontStyleCode), genGlyphRequestParam.font.nFontSize, genGlyphRequestParam.font.strName, genGlyphRequestParam.drawingMode != 0, genGlyphRequestParam.strokeWidth, genGlyphRequestParam.isEmoji > 0, genGlyphRequestParam.isSDF > 0);
    }

    private static GlyphRaster getGlyphRaster(byte[] bArr) {
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        boolean z = genGlyphRequestParam.drawingMode != 0;
        if (genGlyphRequestParam.drawingMode == 3) {
            return loadPathRaster(genGlyphRequestParam.strBuffer, fontStyle, genGlyphRequestParam.font.nFontSize, genGlyphRequestParam.font.strName, z, 2.0f * genGlyphRequestParam.strokeWidth);
        }
        return loadGlyphRaster(genGlyphRequestParam.strBuffer, fontStyle, genGlyphRequestParam.font.nFontSize, genGlyphRequestParam.font.strName, z, genGlyphRequestParam.strokeWidth, genGlyphRequestParam.isEmoji > 0, genGlyphRequestParam.isSDF > 0);
    }

    private static GlyphMetrics loadGlyphMetrics(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2, boolean z2, boolean z3) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (fontStyle != null && !TextUtils.isEmpty(str)) {
            try {
                if (z2) {
                    glyphMetrics.bSuccess = true;
                    glyphMetrics.fLeft = 0.0f;
                    glyphMetrics.fTop = 0.0f;
                    int i = (int) f;
                    glyphMetrics.nWidth = i;
                    glyphMetrics.nHeight = i;
                    glyphMetrics.fAdvance = f;
                    return glyphMetrics;
                }
                TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
                Rect rect = new Rect();
                newTextPaint.getTextBounds(str, 0, str.length(), rect);
                if (rect.width() == 0 && rect.height() == 0) {
                    float measureText = newTextPaint.measureText(" ", 0, 1);
                    float abs = Math.abs(newTextPaint.getFontMetrics().ascent);
                    float abs2 = Math.abs(newTextPaint.getFontMetrics().descent);
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = (int) measureText;
                    rect.bottom = (int) (abs + abs2);
                }
                if (z && f2 > 0.0f) {
                    float f3 = f2 / 2.0f;
                    rect.top = (int) (rect.top - f3);
                    rect.left = (int) (rect.left - f3);
                    rect.right = (int) (rect.right + f3);
                    rect.bottom = (int) (rect.bottom + f3);
                }
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = rect.left;
                glyphMetrics.fTop = Math.abs(newTextPaint.getFontMetrics().ascent) - Math.abs(rect.top);
                glyphMetrics.nWidth = rect.width();
                glyphMetrics.nHeight = rect.height();
                glyphMetrics.fAdvance = newTextPaint.measureText(str);
                newTextPaint.setTypeface(null);
                return glyphMetrics;
            } catch (Exception e) {
                glyphMetrics.bSuccess = false;
                return glyphMetrics;
            }
        }
        return glyphMetrics;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x012f A[Catch: Exception -> 0x024b, TRY_LEAVE, TryCatch #0 {Exception -> 0x024b, blocks: (B:16:0x006f, B:18:0x0097, B:20:0x009f, B:25:0x00ea, B:27:0x0129, B:29:0x012f, B:36:0x014a, B:38:0x0157, B:40:0x01a9, B:43:0x01c1, B:47:0x01d6, B:49:0x01ff, B:51:0x0212, B:54:0x0223, B:52:0x021b, B:34:0x0140, B:56:0x023a), top: B:72:0x006f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.base.ae.gmap.glyph.GlyphRaster loadGlyphRaster(java.lang.String r6, com.autonavi.base.ae.gmap.glyph.FontStyle r7, float r8, java.lang.String r9, boolean r10, float r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glyph.GlyphLoader.loadGlyphRaster(java.lang.String, com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float, boolean, boolean):com.autonavi.base.ae.gmap.glyph.GlyphRaster");
    }

    public static GlyphRaster loadPathRaster(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle != null && !TextUtils.isEmpty(str)) {
            try {
                TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, false, 0.0f);
                Rect rect = new Rect();
                newTextPaint.getTextBounds(str, 0, str.length(), rect);
                new Canvas(Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ALPHA_8)).drawText(str, 0 - rect.left, 0 - rect.top, newTextPaint);
                TextPaint newTextPaint2 = newTextPaint(fontStyle, f, str2, z, f2);
                Rect rect2 = new Rect();
                newTextPaint2.getTextBounds(str, 0, str.length(), rect2);
                if (z && f2 > 0.0f) {
                    float f3 = 0.5f * f2;
                    rect2.top = (int) (rect2.top - f3);
                    rect2.left = (int) (rect2.left - f3);
                    rect2.right = (int) (rect2.right + f3);
                    rect2.bottom = (int) (rect2.bottom + f3);
                }
                if (!rect2.isEmpty()) {
                    Bitmap createBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ALPHA_8);
                    Canvas canvas = new Canvas(createBitmap);
                    float f4 = 0 - rect2.left;
                    float f5 = 0 - rect2.top;
                    Path path = new Path();
                    newTextPaint.getTextPath(str, 0, str.length(), f4, f5, path);
                    canvas.drawPath(path, newTextPaint2);
                    int width = rect2.width() * rect2.height();
                    byte[] bArr = new byte[width];
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    glyphRaster.bitmapWidth = rect2.width();
                    glyphRaster.bitmapHeight = rect2.height();
                    glyphRaster.bitmapPixelMode = 0;
                    glyphRaster.bitmapSize = width;
                    createBitmap.copyPixelsToBuffer(wrap);
                    createBitmap.recycle();
                    glyphRaster.bitmapBuffer = bArr;
                    glyphRaster.bSuccess = true;
                }
                newTextPaint.setTypeface(null);
                newTextPaint2.setTypeface(null);
                return glyphRaster;
            } catch (Exception e) {
                glyphRaster.bSuccess = false;
                return glyphRaster;
            }
        }
        return glyphRaster;
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j);

    /* JADX WARN: Can't wrap try/catch for region: R(18:6|(1:8)(1:63)|9|(1:62)(1:15)|16|17|19|(2:55|(1:57)(2:58|(9:60|25|26|27|(1:29)|30|(1:51)(4:34|35|144|44)|45|46)))(1:23)|24|25|26|27|(0)|30|(1:32)|51|45|46) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0197, code lost:
        r10 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.text.TextPaint newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle r4, float r5, java.lang.String r6, boolean r7, float r8) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glyph.GlyphLoader.newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float):android.text.TextPaint");
    }
}
