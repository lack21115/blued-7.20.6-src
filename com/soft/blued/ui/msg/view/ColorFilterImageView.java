package com.soft.blued.ui.msg.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/view/ColorFilterImageView.class */
public final class ColorFilterImageView extends AppCompatImageView implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f32603a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorFilterImageView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorFilterImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorFilterImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        a();
    }

    private final void a() {
        setOnTouchListener(this);
    }

    public final boolean getEnable() {
        return this.f32603a;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.e(v, "v");
        Intrinsics.e(event, "event");
        if (this.f32603a) {
            int action = event.getAction();
            if (action == 0) {
                setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                return false;
            } else if (action == 1 || action == 3) {
                setColorFilter(0);
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    public final void setEnable(boolean z) {
        this.f32603a = z;
    }
}
