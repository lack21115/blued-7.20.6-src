package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/BaseImageView.class */
public abstract class BaseImageView extends ImageView {
    private static final String b = BaseImageView.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static final Xfermode f10943c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: a  reason: collision with root package name */
    protected Context f10944a;
    private Bitmap d;
    private Paint e;
    private WeakReference<Bitmap> f;

    public BaseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public BaseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f10944a = context;
        this.e = new Paint(1);
    }

    public abstract Bitmap getBitmap();

    @Override // android.view.View
    public void invalidate() {
        this.f = null;
        Bitmap bitmap = this.d;
        if (bitmap != null) {
            bitmap.recycle();
        }
        super.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (r11.isRecycled() != false) goto L22;
     */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(android.graphics.Canvas r9) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.view.BaseImageView.onDraw(android.graphics.Canvas):void");
    }
}
