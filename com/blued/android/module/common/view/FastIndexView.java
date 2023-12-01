package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/FastIndexView.class */
public class FastIndexView extends View {

    /* renamed from: a  reason: collision with root package name */
    private String f10984a;
    private OnLetterUpdateListener b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f10985c;
    private int d;
    private int e;
    private float f;
    private float g;
    private int h;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/FastIndexView$OnLetterUpdateListener.class */
    public interface OnLetterUpdateListener {
        void onLetterUpdate(String str);
    }

    public FastIndexView(Context context) {
        this(context, null);
    }

    public FastIndexView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FastIndexView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10984a = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.h = -1;
        Paint paint = new Paint();
        this.f10985c = paint;
        paint.setTextSize(DensityUtils.a(context, 12.0f));
        this.f10985c.setAntiAlias(true);
        this.d = BluedSkinUtils.a(context, R.color.syc_m);
        this.e = BluedSkinUtils.a(context, R.color.syc_w);
    }

    public String getIndexName() {
        return this.f10984a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f10984a.length()) {
                return;
            }
            int i3 = i2 + 1;
            String substring = this.f10984a.substring(i2, i3);
            int measureText = (int) ((this.g / 2.0f) - (this.f10985c.measureText(substring) / 2.0f));
            Rect rect = new Rect();
            this.f10985c.getTextBounds(substring, 0, substring.length(), rect);
            int height = rect.height();
            float f = this.f;
            int i4 = (int) ((f / 2.0f) + (height / 2.0f) + (i2 * f));
            this.f10985c.setColor(this.h == i2 ? this.e : this.d);
            canvas.drawText(substring, measureText, i4, this.f10985c);
            i = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = getMeasuredWidth();
        this.f = (getMeasuredHeight() * 1.0f) / this.f10984a.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r0 != 4) goto L11;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            r0 = r7
            int r0 = r0.getAction()
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L6c
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L64
            r0 = r8
            r1 = 2
            if (r0 == r1) goto L20
            r0 = r8
            r1 = 3
            if (r0 == r1) goto L64
            r0 = r8
            r1 = 4
            if (r0 == r1) goto L64
            goto La5
        L20:
            r0 = r7
            float r0 = r0.getY()
            r1 = r6
            float r1 = r1.f
            float r0 = r0 / r1
            int r0 = (int) r0
            r8 = r0
            r0 = r8
            if (r0 < 0) goto La5
            r0 = r8
            r1 = r6
            java.lang.String r1 = r1.f10984a
            int r1 = r1.length()
            if (r0 >= r1) goto La5
            r0 = r8
            r1 = r6
            int r1 = r1.h
            if (r0 == r1) goto La5
            r0 = r6
            com.blued.android.module.common.view.FastIndexView$OnLetterUpdateListener r0 = r0.b
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L5c
            r0 = r7
            r1 = r6
            java.lang.String r1 = r1.f10984a
            r2 = r8
            r3 = r8
            r4 = 1
            int r3 = r3 + r4
            java.lang.String r1 = r1.substring(r2, r3)
            r0.onLetterUpdate(r1)
        L5c:
            r0 = r6
            r1 = r8
            r0.h = r1
            goto La5
        L64:
            r0 = r6
            r1 = -1
            r0.h = r1
            goto La5
        L6c:
            r0 = r7
            float r0 = r0.getY()
            r1 = r6
            float r1 = r1.f
            float r0 = r0 / r1
            int r0 = (int) r0
            r8 = r0
            r0 = r8
            if (r0 < 0) goto La5
            r0 = r8
            r1 = r6
            java.lang.String r1 = r1.f10984a
            int r1 = r1.length()
            if (r0 >= r1) goto La5
            r0 = r6
            com.blued.android.module.common.view.FastIndexView$OnLetterUpdateListener r0 = r0.b
            r7 = r0
            r0 = r7
            if (r0 == 0) goto La0
            r0 = r7
            r1 = r6
            java.lang.String r1 = r1.f10984a
            r2 = r8
            r3 = r8
            r4 = 1
            int r3 = r3 + r4
            java.lang.String r1 = r1.substring(r2, r3)
            r0.onLetterUpdate(r1)
        La0:
            r0 = r6
            r1 = r8
            r0.h = r1
        La5:
            r0 = r6
            r0.invalidate()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.FastIndexView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setIndexName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f10984a = str;
        invalidate();
    }

    public void setListener(OnLetterUpdateListener onLetterUpdateListener) {
        this.b = onLetterUpdateListener;
    }
}
