package com.blued.login.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/view/TagViewPager.class */
public final class TagViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20602a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private int f20603c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TagViewPager(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        this.f20602a = true;
    }

    public final float getBeforeX() {
        return this.b;
    }

    public final boolean getEnableScroll() {
        return this.f20602a;
    }

    public final int getLastIndex() {
        return this.f20603c;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.e(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.b = event.getX();
        } else if (action == 2) {
            if (event.getX() - this.b < 0.0f && getCurrentItem() == this.f20603c) {
                return true;
            }
            this.b = event.getX();
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.e(event, "event");
        if (this.f20602a) {
            int action = event.getAction();
            if (action == 0) {
                this.b = event.getX();
            } else if (action == 2) {
                if (event.getX() - this.b < 0.0f && getCurrentItem() == this.f20603c) {
                    return true;
                }
                this.b = event.getX();
            }
            return super.onTouchEvent(event);
        }
        return false;
    }

    public final void setBeforeX(float f) {
        this.b = f;
    }

    public final void setEnableScroll(boolean z) {
        this.f20602a = z;
    }

    public final void setLastIndex(int i) {
        this.f20603c = i;
    }
}
