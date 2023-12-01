package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.widget.RelativeLayout;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.u;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseEndCardView.class */
public abstract class BaseEndCardView extends RelativeLayout {
    protected String a;
    protected i b;
    protected j c;
    protected k d;
    private boolean e;

    public BaseEndCardView(Context context, i iVar, j jVar) {
        super(context);
        this.a = getClass().getSimpleName();
        super.setWillNotDraw(false);
        this.b = iVar;
        this.c = jVar;
        this.d = jVar.m;
    }

    private static RectF a(int i, int i2) {
        int i3 = i / 2;
        float f = i2;
        int i4 = (int) (1.0f * f);
        RectF rectF = new RectF();
        rectF.left = i3 - i4;
        rectF.top = i2 - (i4 * 2);
        rectF.right = i3 + i4;
        rectF.bottom = f;
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int height;
        try {
            if (this.e) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.draw(canvas);
                int width = getWidth();
                int height2 = getHeight();
                int width2 = getWidth();
                int i = width2 / 2;
                float height3 = getHeight();
                int i2 = (int) (1.0f * height3);
                RectF rectF = new RectF();
                rectF.left = i - i2;
                rectF.top = height - (i2 * 2);
                rectF.right = i + i2;
                rectF.bottom = height3;
                u.a(canvas, width, height2, rectF);
                canvas.restoreToCount(saveLayer);
                return;
            }
        } catch (Exception e) {
        }
        super.draw(canvas);
    }

    public void setNeedArc(boolean z) {
        this.e = z;
        invalidate();
    }
}
