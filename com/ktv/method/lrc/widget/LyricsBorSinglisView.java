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

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/widget/LyricsBorSinglisView.class */
public class LyricsBorSinglisView extends AbstractLrcView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10100a;
    private int[] b;

    /* renamed from: c  reason: collision with root package name */
    private float f10101c;

    public LyricsBorSinglisView(Context context) {
        super(context);
        this.f10100a = true;
        this.b = new int[]{Color.parseColor("#80000000"), Color.parseColor("#80000000")};
        this.f10101c = a(getContext(), 10.0f);
        a(context);
    }

    public LyricsBorSinglisView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10100a = true;
        this.b = new int[]{Color.parseColor("#80000000"), Color.parseColor("#80000000")};
        this.f10101c = a(getContext(), 10.0f);
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
        if (lyricsLineNum + 1 <= lrcLineInfos.size()) {
            float b = LyricsUtils.b(paint) + 40.0f;
            LyricsUtils.b(paint);
            float width = (getWidth() - a3) / 2.0f;
            paint.setAlpha(255);
            LyricsUtils.a(canvas, paintOutline, f, width, b);
            LyricsUtils.a(canvas, paint, paintHL, paintColors, paintHLColors, f, a2, width, b);
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
