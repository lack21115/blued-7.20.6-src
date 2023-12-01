package com.autonavi.base.ae.gmap.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.col.p0003sl.aa;
import com.amap.api.col.p0003sl.dw;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/bean/NativeTextGenerate.class */
public class NativeTextGenerate {
    private static volatile NativeTextGenerate instance;
    private TextPaint text_paint_bitmap;
    private TextPaint text_paint_size;
    private float density = 1.0f;
    private final int kTextLayoutLeftToRight = 0;
    private final int kTextLayoutUpToDown = 1;
    private final int kTextAlignmentCenter = 0;
    private final int kTextAlignmentLeft = 1;
    private final int kTextAlignmentRight = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/bean/NativeTextGenerate$TextGeneratePOIStyleDesc.class */
    public static class TextGeneratePOIStyleDesc {
        int fontSize = 0;
        int fontColor = 0;
        int fontBorderColor = 0;
        int fontBgColor = 0;
        int boldFont = 0;

        TextGeneratePOIStyleDesc() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/bean/NativeTextGenerate$TextGenerateTextBitmap.class */
    public static class TextGenerateTextBitmap {
        byte[] data;
        public int dataId;
        int dataLength;
        double height;
        BitmapDescriptor imageData;
        String text;
        double width;

        TextGenerateTextBitmap() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/bean/NativeTextGenerate$TextGenerateTextStyle.class */
    public static class TextGenerateTextStyle {
        int singleLineCharaterLimit = 7;
        int textAlignment = 0;
        int layoutDirection = 0;

        TextGenerateTextStyle() {
        }
    }

    private NativeTextGenerate() {
        this.text_paint_size = null;
        this.text_paint_bitmap = null;
        this.text_paint_size = new TextPaint();
        this.text_paint_bitmap = new TextPaint();
    }

    public static NativeTextGenerate getInstance() {
        if (instance == null) {
            synchronized (NativeTextGenerate.class) {
                try {
                    if (instance == null) {
                        instance = new NativeTextGenerate();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private StaticLayout setPaintStyle(TextPaint textPaint, TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return null;
        }
        float f = textGeneratePOIStyleDesc.fontSize * this.density;
        textPaint.setColor(textGeneratePOIStyleDesc.fontColor);
        textPaint.setTextSize(f);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(textGeneratePOIStyleDesc.boldFont == 1 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        int i = textGenerateTextStyle.textAlignment;
        if (i == 0) {
            textPaint.setTextAlign(Paint.Align.CENTER);
        } else if (i != 2) {
            textPaint.setTextAlign(Paint.Align.LEFT);
        } else {
            textPaint.setTextAlign(Paint.Align.RIGHT);
        }
        int length = textGenerateTextBitmap.text.length();
        int i2 = textGenerateTextStyle.singleLineCharaterLimit;
        if (length > textGenerateTextStyle.singleLineCharaterLimit || length % textGenerateTextStyle.singleLineCharaterLimit != 0) {
            int i3 = (length / textGenerateTextStyle.singleLineCharaterLimit) + 1;
            i2 = (length / i3) + (length % i3 > 0 ? 1 : 0);
        }
        return new StaticLayout(textGenerateTextBitmap.text, textPaint, (int) (f * i2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    void calculateTextBoundSize(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_size, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        float measureText = this.text_paint_size.measureText(textGenerateTextBitmap.text);
        Paint.FontMetrics fontMetrics = this.text_paint_size.getFontMetrics();
        textGenerateTextBitmap.width = measureText;
        textGenerateTextBitmap.height = fontMetrics.descent - fontMetrics.ascent;
        textGenerateTextBitmap.width = paintStyle.getWidth();
        textGenerateTextBitmap.height = paintStyle.getHeight();
    }

    void generateTextBitmap(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_bitmap, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        Bitmap createBitmap = Bitmap.createBitmap((int) textGenerateTextBitmap.width, (int) textGenerateTextBitmap.height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (textGenerateTextStyle.textAlignment == 0) {
            canvas.translate(((float) textGenerateTextBitmap.width) / 2.0f, 0.0f);
        } else if (textGenerateTextStyle.textAlignment == 2) {
            canvas.translate((float) textGenerateTextBitmap.width, 0.0f);
        }
        paintStyle.draw(canvas);
        this.text_paint_bitmap.setStyle(Paint.Style.STROKE);
        this.text_paint_bitmap.setStrokeWidth(1.0f);
        this.text_paint_bitmap.setColor(textGeneratePOIStyleDesc.fontBorderColor);
        paintStyle.draw(canvas);
        textGenerateTextBitmap.dataLength = (int) (textGenerateTextBitmap.width * textGenerateTextBitmap.height * 4.0d);
        textGenerateTextBitmap.data = new byte[textGenerateTextBitmap.dataLength];
        textGenerateTextBitmap.dataId = dw.b();
        createBitmap.copyPixelsToBuffer(ByteBuffer.wrap(textGenerateTextBitmap.data));
    }

    BitmapDescriptor getIconBitmap(String str) {
        if (str == null) {
            return null;
        }
        try {
            Context context = aa.f4728a;
            byte[] uncompress = FileUtil.uncompress(FileUtil.readFileContentsFromAssetsByPreName(context, AMapEngineUtils.MAP_MAP_ASSETS_NAME, str + BridgeUtil.UNDERLINE_STR));
            if (uncompress != null) {
                return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeByteArray(uncompress, 0, uncompress.length));
            }
            return null;
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    byte[] getMapStyleJsonData() {
        try {
            return FileUtil.uncompress(FileUtil.readFileContentsFromAssets(aa.f4728a, "map_custom/terrain/terrainStyle.data"));
        } catch (Throwable th) {
            dw.a(th);
            return null;
        }
    }

    public void setDensity(float f) {
        this.density = f;
    }
}
