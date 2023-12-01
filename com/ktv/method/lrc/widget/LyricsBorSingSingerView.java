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

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/widget/LyricsBorSingSingerView.class */
public class LyricsBorSingSingerView extends AbstractLrcView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10098a;
    private int[] b;

    /* renamed from: c  reason: collision with root package name */
    private float f10099c;

    public LyricsBorSingSingerView(Context context) {
        super(context);
        this.f10098a = true;
        this.b = new int[]{Color.parseColor("#80000000"), Color.parseColor("#80000000")};
        this.f10099c = a(getContext(), 10.0f);
        a(context);
    }

    public LyricsBorSingSingerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10098a = true;
        this.b = new int[]{Color.parseColor("#80000000"), Color.parseColor("#80000000")};
        this.f10099c = a(getContext(), 10.0f);
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
        int i = lyricsLineNum + 1;
        if (i <= lrcLineInfos.size()) {
            float f2 = this.f10099c;
            float f3 = 40.0f + f2;
            float b = LyricsUtils.b(paint) + f2 + f3;
            float width = (getWidth() - a3) / 2.0f;
            float f4 = width + a2;
            float f5 = width;
            if (f4 < 90.0f) {
                f5 = (width - f4) + 90.0f;
            }
            float f6 = f5;
            if (f4 > getWidth() - 70) {
                f6 = f5 - ((f4 - getWidth()) + 70.0f);
            }
            paint.setAlpha(255);
            LyricsUtils.a(canvas, paintOutline, f, f6, f3);
            LyricsUtils.a(canvas, paint, paintHL, paintColors, paintHLColors, f, a2, f6, f3);
            if (i < lrcLineInfos.size()) {
                paintOutline.setTextSize(b(getContext(), 12.0f));
                paint.setTextSize(b(getContext(), 12.0f));
                String f7 = lrcLineInfos.get(Integer.valueOf(i)).a().get(0).f();
                float width2 = (getWidth() - LyricsUtils.a(paint, f7)) / 2.0f;
                paint.setAlpha(177);
                LyricsUtils.a(canvas, paintOutline, f7, width2, b);
                LyricsUtils.b(canvas, paint, f7, width2, b);
            }
            float b2 = b + this.f10099c + LyricsUtils.b(paint);
            int i2 = lyricsLineNum + 2;
            if (i2 < lrcLineInfos.size()) {
                paintOutline.setTextSize(b(getContext(), 12.0f));
                paint.setTextSize(b(getContext(), 12.0f));
                String f8 = lrcLineInfos.get(Integer.valueOf(i2)).a().get(0).f();
                float width3 = (getWidth() - LyricsUtils.a(paint, f8)) / 2.0f;
                paint.setAlpha(177);
                LyricsUtils.a(canvas, paintOutline, f8, width3, b2);
                LyricsUtils.b(canvas, paint, f8, width3, b2);
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
