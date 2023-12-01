package com.ktv.method.lrc.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ktv.method.lrc.LyricsReader;
import com.ktv.method.lrc.model.LyricsLineInfo;
import com.ktv.method.lrc.utils.LyricsUtils;
import java.util.TreeMap;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/widget/LyricsView.class */
public class LyricsView extends AbstractLrcView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10102a;
    private int[] b;

    /* renamed from: c  reason: collision with root package name */
    private float f10103c;

    public LyricsView(Context context) {
        super(context);
        this.f10102a = true;
        this.b = new int[]{Color.parseColor("#80000000"), Color.parseColor("#80000000")};
        this.f10103c = a(getContext(), 10.0f);
        a(context);
    }

    public LyricsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10102a = true;
        this.b = new int[]{Color.parseColor("#80000000"), Color.parseColor("#80000000")};
        this.f10103c = a(getContext(), 10.0f);
        a(context);
    }

    private void a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        setTextMaxWidth((displayMetrics.widthPixels / 3) * 2);
    }

    public int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.ktv.method.lrc.widget.AbstractLrcView
    public void a(long j) {
        LyricsReader lyricsReader = getLyricsReader();
        setLyricsLineNum(LyricsUtils.a(lyricsReader.a(), getLrcLineInfos(), j, lyricsReader.c()));
        d(j);
    }

    @Override // com.ktv.method.lrc.widget.AbstractLrcView
    protected void a(Canvas canvas) {
        LyricsReader lyricsReader = getLyricsReader();
        TreeMap<Integer, LyricsLineInfo> lrcLineInfos = getLrcLineInfos();
        int lyricsLineNum = getLyricsLineNum();
        int splitLyricsLineNum = getSplitLyricsLineNum();
        int splitLyricsWordIndex = getSplitLyricsWordIndex();
        float lyricsWordHLTime = getLyricsWordHLTime();
        Paint paint = getPaint();
        paint.setColor(this.b[0]);
        Paint paintHL = getPaintHL();
        Paint paintOutline = getPaintOutline();
        int[] paintColors = getPaintColors();
        int[] paintHLColors = getPaintHLColors();
        paintOutline.setTextSize(b(getContext(), 16.0f));
        paintHL.setTextSize(b(getContext(), 16.0f));
        paint.setTextSize(b(getContext(), 16.0f));
        LyricsLineInfo lyricsLineInfo = lrcLineInfos.get(Integer.valueOf(lyricsLineNum)).a().get(splitLyricsLineNum);
        float a2 = LyricsUtils.a(lyricsReader.a(), paint, lyricsLineInfo, splitLyricsWordIndex, lyricsWordHLTime);
        String f = lyricsLineInfo.f();
        float a3 = LyricsUtils.a(paint, f);
        if (this.f10102a) {
            int i = lyricsLineNum + 1;
            if (i <= lrcLineInfos.size()) {
                float b = 40.0f + LyricsUtils.b(paint);
                float b2 = LyricsUtils.b(paint) + this.f10103c + b;
                float width = (getWidth() - a3) / 2.0f;
                paint.setAlpha(255);
                LyricsUtils.a(canvas, paintOutline, f, width, b);
                LyricsUtils.a(canvas, paint, paintHL, paintColors, paintHLColors, f, a2, width, b);
                if (i == lrcLineInfos.size()) {
                    return;
                }
                paintOutline.setTextSize(b(getContext(), 12.0f));
                paint.setTextSize(b(getContext(), 12.0f));
                String f2 = lrcLineInfos.get(Integer.valueOf(i)).a().get(0).f();
                float width2 = (getWidth() - LyricsUtils.a(paint, f2)) / 2.0f;
                paint.setAlpha(177);
                LyricsUtils.a(canvas, paintOutline, f2, width2, b2);
                LyricsUtils.b(canvas, paint, f2, width2, b2);
                return;
            }
            return;
        }
        int i2 = lyricsLineNum + 1;
        if (i2 <= lrcLineInfos.size()) {
            paintOutline.setTextSize(b(getContext(), 12.0f));
            paint.setTextSize(b(getContext(), 12.0f));
            paint.setAlpha(177);
            float b3 = LyricsUtils.b(paint) + this.f10103c + LyricsUtils.b(paint);
            int i3 = lyricsLineNum - 2;
            if (i3 >= 0) {
                String f3 = lrcLineInfos.get(Integer.valueOf(i3)).a().get(0).f();
                float width3 = (getWidth() - LyricsUtils.a(paint, f3)) / 2.0f;
                LyricsUtils.a(canvas, paintOutline, f3, width3, b3);
                LyricsUtils.b(canvas, paint, f3, width3, b3);
            }
            float b4 = b3 + this.f10103c + LyricsUtils.b(paint);
            int i4 = lyricsLineNum - 1;
            if (i4 >= 0) {
                String f4 = lrcLineInfos.get(Integer.valueOf(i4)).a().get(0).f();
                float width4 = (getWidth() - LyricsUtils.a(paint, f4)) / 2.0f;
                LyricsUtils.a(canvas, paintOutline, f4, width4, b4);
                LyricsUtils.b(canvas, paint, f4, width4, b4);
            }
            paint.setAlpha(255);
            paintOutline.setTextSize(b(getContext(), 16.0f));
            paint.setTextSize(b(getContext(), 16.0f));
            float b5 = b4 + this.f10103c + LyricsUtils.b(paint);
            float width5 = (getWidth() - a3) / 2.0f;
            LyricsUtils.a(canvas, paintOutline, f, width5, b5);
            LyricsUtils.a(canvas, paint, paintHL, paintColors, paintHLColors, f, a2, width5, b5);
            paintOutline.setTextSize(b(getContext(), 12.0f));
            paint.setTextSize(b(getContext(), 12.0f));
            paint.setAlpha(177);
            if (i2 < lrcLineInfos.size()) {
                b5 = b5 + this.f10103c + LyricsUtils.b(paint);
                String f5 = lrcLineInfos.get(Integer.valueOf(i2)).a().get(0).f();
                float width6 = (getWidth() - LyricsUtils.a(paint, f5)) / 2.0f;
                LyricsUtils.a(canvas, paintOutline, f5, width6, b5);
                LyricsUtils.b(canvas, paint, f5, width6, b5);
            }
            int i5 = lyricsLineNum + 2;
            if (i5 < lrcLineInfos.size()) {
                float b6 = b5 + this.f10103c + LyricsUtils.b(paint);
                String f6 = lrcLineInfos.get(Integer.valueOf(i5)).a().get(0).f();
                float width7 = (getWidth() - LyricsUtils.a(paint, f6)) / 2.0f;
                LyricsUtils.a(canvas, paintOutline, f6, width7, b6);
                LyricsUtils.b(canvas, paint, f6, width7, b6);
            }
        }
    }

    public float b(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f;
    }

    @Override // com.ktv.method.lrc.widget.AbstractLrcView
    public void setFontSize(float f) {
        setFontSize(f);
    }

    public void setHost(boolean z) {
        this.f10102a = z;
    }

    @Override // com.ktv.method.lrc.widget.AbstractLrcView
    public void setLyricsReader(LyricsReader lyricsReader) {
        super.setLyricsReader(lyricsReader);
        if (lyricsReader == null || lyricsReader.a() != 1) {
            setLrcStatus(6);
        }
    }

    public void setPaintColor(int[] iArr) {
        a(iArr, false);
    }

    public void setPaintHLColor(int[] iArr) {
        b(iArr, false);
    }

    public void setSpaceLineHeight(float f) {
        a(f, false);
    }

    public void setTypeFace(Typeface typeface) {
        a(typeface, false);
    }
}
