package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/DownloadProgressBar.class */
public class DownloadProgressBar extends View {
    private Runnable CI;
    Paint aCO;
    Paint aCP;
    Paint aCQ;
    private String aCR;
    private float aCS;
    private Rect aCT;
    private LinearGradient aCU;
    private LinearGradient aCV;
    private LinearGradient aCW;
    private Matrix mMatrix;
    private Path mPath;
    private RectF mRectF;
    private long mStartTime;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.CI = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.aCO = new Paint(1);
        this.aCP = new Paint(1);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.aCQ = paint;
        paint.setTextSize(com.kwad.sdk.c.kwai.a.a(context, 16.0f));
        this.aCQ.setColor(-1);
        this.aCQ.setTextAlign(Paint.Align.CENTER);
        this.aCT = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.CI);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.aCO.setShader(this.aCU);
        canvas.drawRect(this.mRectF, this.aCO);
        this.aCO.setShader(this.aCV);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.aCS) / 100.0f, getHeight(), this.aCO);
        float f = this.aCS;
        if (f > 0.0f && f < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % 2500;
            int i = (elapsedRealtime > com.igexin.push.config.c.j ? 1 : (elapsedRealtime == com.igexin.push.config.c.j ? 0 : -1));
            float f2 = i >= 0 ? 0.0f : ((float) elapsedRealtime) / 1500.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f2);
            this.aCW.setLocalMatrix(this.mMatrix);
            this.aCP.setShader(this.aCW);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.aCS) / 100.0f) * f2, getHeight(), this.aCP);
            float f3 = 0.0f;
            if (elapsedRealtime > 500) {
                f3 = i > 0 ? 0.0f : ((float) (elapsedRealtime - 500)) / 1000.0f;
            }
            float width = (getWidth() * this.aCS) / 100.0f;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f2);
            this.aCW.setLocalMatrix(this.mMatrix);
            this.aCP.setShader(this.aCW);
            canvas.drawRect(0.0f, 0.0f, width * f3, getHeight(), this.aCP);
        }
        String str = this.aCR;
        if (str != null) {
            this.aCQ.getTextBounds(str, 0, str.length(), this.aCT);
            canvas.drawText(this.aCR, getWidth() / 2.0f, (getHeight() / 2.0f) - ((this.aCT.top + this.aCT.bottom) / 2.0f), this.aCQ);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.aCU = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aCV = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aCO.setShader(this.aCU);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        this.aCW = linearGradient;
        this.aCP.setShader(linearGradient);
        float f = i;
        this.mRectF.set(0.0f, 0.0f, f, i2);
        this.mPath.reset();
        float f2 = f / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f2, f2, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            removeCallbacks(this.CI);
            return;
        }
        float f = this.aCS;
        if (f <= 0.0f || f >= 100.0f) {
            return;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        post(this.CI);
    }

    public void setProgress(float f) {
        this.aCS = f;
        invalidate();
        if (f == 0.0f || f == 100.0f) {
            removeCallbacks(this.CI);
        } else if (getWindowVisibility() == 0 && this.mStartTime == 0) {
            post(this.CI);
        }
    }

    public void setText(String str) {
        this.aCR = str;
        invalidate();
    }
}
