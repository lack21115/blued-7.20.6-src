package com.ktv.method.lrc.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ktv.method.lrc.LyricsReader;
import com.ktv.method.lrc.model.LyricsLineInfo;
import com.ktv.method.lrc.utils.LyricsUtils;
import java.util.TreeMap;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/widget/LyricsBorShowingView.class */
public class LyricsBorShowingView extends AbstractLrcView {

    /* renamed from: a  reason: collision with root package name */
    private int[] f10097a;
    private float b;

    public LyricsBorShowingView(Context context) {
        super(context);
        this.f10097a = new int[]{Color.parseColor("#80000000"), Color.parseColor("#80000000")};
        this.b = a(getContext(), 15.0f);
        a(context);
    }

    public LyricsBorShowingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10097a = new int[]{Color.parseColor("#80000000"), Color.parseColor("#80000000")};
        this.b = a(getContext(), 15.0f);
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
        paint.setColor(this.f10097a[0]);
        Paint paintHL = getPaintHL();
        Paint paintOutline = getPaintOutline();
        int[] paintColors = getPaintColors();
        int[] paintHLColors = getPaintHLColors();
        paintOutline.setTextSize(b(getContext(), 14.0f));
        paintHL.setTextSize(b(getContext(), 14.0f));
        paint.setTextSize(b(getContext(), 14.0f));
        LyricsLineInfo lyricsLineInfo = lrcLineInfos.get(Integer.valueOf(lyricsLineNum)).a().get(splitLyricsLineNum);
        float a2 = LyricsUtils.a(lyricsReader.a(), paint, lyricsLineInfo, splitLyricsWordIndex, lyricsWordHLTime);
        String f = lyricsLineInfo.f();
        LyricsUtils.a(paint, f);
        int i = lyricsLineNum + 1;
        if (i <= lrcLineInfos.size()) {
            paint.setAlpha(255);
            paintOutline.setTextSize(b(getContext(), 14.0f));
            paint.setTextSize(b(getContext(), 14.0f));
            float b = LyricsUtils.b(paint) + this.b + 0.0f;
            LyricsUtils.a(canvas, paintOutline, f, 0.0f, b);
            LyricsUtils.a(canvas, paint, paintHL, paintColors, paintHLColors, f, a2, 0.0f, b);
            paintOutline.setTextSize(b(getContext(), 14.0f));
            paint.setTextSize(b(getContext(), 14.0f));
            paint.setAlpha(177);
            if (i < lrcLineInfos.size()) {
                b = b + this.b + LyricsUtils.b(paint);
                String f2 = lrcLineInfos.get(Integer.valueOf(i)).a().get(0).f();
                LyricsUtils.a(canvas, paintOutline, f2, 0.0f, b);
                LyricsUtils.b(canvas, paint, f2, 0.0f, b);
            }
            int i2 = lyricsLineNum + 2;
            if (i2 < lrcLineInfos.size()) {
                float b2 = b + this.b + LyricsUtils.b(paint);
                String f3 = lrcLineInfos.get(Integer.valueOf(i2)).a().get(0).f();
                LyricsUtils.a(canvas, paintOutline, f3, 0.0f, b2);
                LyricsUtils.b(canvas, paint, f3, 0.0f, b2);
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
}
