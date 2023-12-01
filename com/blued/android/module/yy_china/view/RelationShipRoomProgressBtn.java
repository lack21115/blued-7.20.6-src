package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/RelationShipRoomProgressBtn.class */
public final class RelationShipRoomProgressBtn extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f17980a;
    private final Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f17981c;
    private int d;
    private int e;
    private String f;
    private String g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RelationShipRoomProgressBtn(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RelationShipRoomProgressBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationShipRoomProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f17980a = new Paint();
        this.b = new Paint();
        this.f = "";
        this.g = "";
        this.f17980a.setColor(getResources().getColor(R.color.syc_C8EEFF));
        this.f17980a.setStrokeWidth(10.0f);
        this.f17980a.setAntiAlias(true);
        this.f17980a.setStyle(Paint.Style.STROKE);
        this.f17980a.setStrokeCap(Paint.Cap.ROUND);
        this.b.setColor(getResources().getColor(R.color.syc_C8EEFF));
        this.b.setStrokeWidth(10.0f);
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeCap(Paint.Cap.ROUND);
    }

    public final void a(IRequestHost re, String img, int i, int i2, String color1, String color2, String color3) {
        Intrinsics.e(re, "re");
        Intrinsics.e(img, "img");
        Intrinsics.e(color1, "color1");
        Intrinsics.e(color2, "color2");
        Intrinsics.e(color3, "color3");
        this.d = i;
        this.e = i2;
        this.f17980a.setColor(Color.parseColor(color1));
        this.f = color2;
        this.g = color3;
        invalidate();
        ImageLoader.a(re, img).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.view.RelationShipRoomProgressBtn$setDa$1
            @Override // com.bumptech.glide.request.target.Target
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                Intrinsics.e(resource, "resource");
                if (resource instanceof BitmapDrawable) {
                    RelationShipRoomProgressBtn.this.f17981c = ((BitmapDrawable) resource).getBitmap();
                    RelationShipRoomProgressBtn.this.invalidate();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.d >= 0) {
            float measuredHeight = (getMeasuredHeight() - (2 * this.f17980a.getStrokeWidth())) * 0.8f;
            int measuredHeight2 = (int) ((getMeasuredHeight() - measuredHeight) / 2.0f);
            int i = (int) (measuredHeight2 + measuredHeight);
            Rect rect = new Rect(measuredHeight2, measuredHeight2, i, i);
            Bitmap bitmap = this.f17981c;
            if (bitmap != null && canvas != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rect, this.b);
            }
            RectF rectF = new RectF(this.f17980a.getStrokeWidth() + 0.0f, this.f17980a.getStrokeWidth() + 0.0f, getMeasuredHeight() - this.f17980a.getStrokeWidth(), getMeasuredHeight() - this.f17980a.getStrokeWidth());
            if (canvas != null) {
                canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f17980a);
            }
            this.b.setShader(new LinearGradient(getMeasuredWidth(), 0.0f, 0.0f, getMeasuredHeight(), Color.parseColor(this.f), Color.parseColor(this.g), Shader.TileMode.CLAMP));
            if (canvas == null) {
                return;
            }
            canvas.drawArc(rectF, -90.0f, (this.e / (this.d * 1.0f)) * 360.0f, false, this.b);
        }
    }
}
