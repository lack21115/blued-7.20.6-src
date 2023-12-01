package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHomeCradAniView.class */
public final class YYHomeCradAniView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f18226a;
    private final Paint b;

    /* renamed from: c  reason: collision with root package name */
    private int f18227c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHomeCradAniView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYHomeCradAniView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYHomeCradAniView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.icon_yy_home_ani);
        Intrinsics.c(decodeResource, "decodeResource(context.r…rawable.icon_yy_home_ani)");
        this.f18226a = decodeResource;
        this.b = new Paint();
        this.f18227c = -1;
    }

    public final int getMWidth() {
        return this.f18227c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18227c > getMeasuredWidth() + 10 || this.f18227c < 0) {
            return;
        }
        if (canvas != null) {
            Bitmap bitmap = this.f18226a;
            Rect rect = new Rect(0, 20, this.f18226a.getWidth(), this.f18226a.getHeight() - 20);
            int i = this.f18227c;
            canvas.drawBitmap(bitmap, rect, new Rect(i, 0, this.f18226a.getWidth() + i, getMeasuredHeight()), this.b);
        }
        setMWidth(this.f18227c + 8);
        invalidate();
    }

    public final void setMWidth(int i) {
        this.f18227c = i;
        invalidate();
    }
}
