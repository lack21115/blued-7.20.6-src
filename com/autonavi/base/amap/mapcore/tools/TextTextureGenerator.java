package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amap.api.col.3sl.dw;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/tools/TextTextureGenerator.class */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private Paint text_paint = null;

    public TextTextureGenerator() {
        createTextParam();
    }

    public static int GetNearstSize2N(int i) {
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i <= i3) {
                return i3;
            }
            i2 = i3 * 2;
        }
    }

    private void createTextParam() {
        float f;
        int i = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = i;
        Paint newPaint = newPaint(null, i, 49);
        this.text_paint = newPaint;
        float f2 = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = f2;
        float f3 = -27.832031f;
        try {
            Paint.FontMetrics fontMetrics = newPaint.getFontMetrics();
            float f4 = fontMetrics.descent;
            try {
                float f5 = fontMetrics.ascent;
                float f6 = fontMetrics.top;
                float f7 = fontMetrics.bottom;
                f3 = f5;
                float f8 = fontMetrics.leading;
                f3 = f5;
                f = f4;
            } catch (Exception e) {
                f = f4;
            }
        } catch (Exception e2) {
            f = 7.3242188f;
        }
        this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f + f3)) / 2.0f) + f2 + 0.5f;
    }

    public static float getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    private static Paint newPaint(String str, int i, int i2) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(i);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        switch (i2) {
            case 49:
                textPaint.setTextAlign(Paint.Align.LEFT);
                return textPaint;
            case 50:
                textPaint.setTextAlign(Paint.Align.RIGHT);
                return textPaint;
            case 51:
                textPaint.setTextAlign(Paint.Align.CENTER);
                return textPaint;
            default:
                textPaint.setTextAlign(Paint.Align.LEFT);
                return textPaint;
        }
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            Paint paint = this.text_paint;
            StringBuilder sb = new StringBuilder();
            sb.append((char) iArr[i2]);
            fArr[0] = paint.measureText(sb.toString());
            bArr[i2] = (byte) (fArr[0] + (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE));
            i = i2 + 1;
        }
    }

    public byte[] getTextPixelBuffer(int i, int i2) {
        if (this.TEXT_FONTSIZE != i2) {
            this.TEXT_FONTSIZE = i2;
            createTextParam();
        }
        try {
            char[] cArr = new char[1];
            char c2 = (char) i;
            cArr[0] = c2;
            float f = this.base_line;
            Bitmap createBitmap = Bitmap.createBitmap(this.TEXT_FONTSIZE, this.TEXT_FONTSIZE, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            byte[] bArr = new byte[this.TEXT_FONTSIZE * this.TEXT_FONTSIZE];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(String.valueOf(c2));
            float f2 = f;
            if (cArr[0] > 0) {
                f2 = f;
                if (cArr[0] < 256) {
                    f2 = f - 1.5f;
                }
            }
            Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f3 = measureText - this.TEXT_FONTSIZE_TRUE;
            if (textAlign == Paint.Align.CENTER || f3 < 4.0f) {
                canvas.drawText(cArr, 0, 1, this.start_x, f2, this.text_paint);
            } else {
                this.text_paint.setTextAlign(Paint.Align.CENTER);
                this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - f3);
                canvas.drawText(cArr, 0, 1, (this.TEXT_FONTSIZE_TRUE - f3) / 2.0f, f2, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            dw.a(createBitmap);
            return bArr;
        } catch (Exception | OutOfMemoryError e) {
            return null;
        }
    }
}
