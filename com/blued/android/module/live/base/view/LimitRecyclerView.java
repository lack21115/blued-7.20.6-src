package com.blued.android.module.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/LimitRecyclerView.class */
public class LimitRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private int f11476a;
    private int b;

    public LimitRecyclerView(Context context) {
        this(context, null);
    }

    public LimitRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LimitRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArray;
        if (getContext() == null || attributeSet == null) {
            return;
        }
        TypedArray typedArray2 = null;
        TypedArray typedArray3 = null;
        try {
            try {
                typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.LimitRecyclerView);
                if (typedArray.hasValue(R.styleable.LimitRecyclerView_maxHeight)) {
                    this.f11476a = typedArray.getDimensionPixelOffset(R.styleable.LimitRecyclerView_maxHeight, -1);
                }
                if (typedArray.hasValue(R.styleable.LimitRecyclerView_maxWidth)) {
                    typedArray3 = typedArray;
                    typedArray2 = typedArray;
                    this.b = typedArray.getDimensionPixelOffset(R.styleable.LimitRecyclerView_maxWidth, -1);
                }
                if (typedArray == null) {
                    return;
                }
            } catch (Exception e) {
                typedArray3 = typedArray2;
                e.printStackTrace();
                if (typedArray2 == null) {
                    return;
                }
                typedArray = typedArray2;
            }
            typedArray.recycle();
        } catch (Throwable th) {
            if (typedArray3 != null) {
                typedArray3.recycle();
            }
            throw th;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.f11476a;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
        }
        int i4 = this.b;
        if (i4 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
