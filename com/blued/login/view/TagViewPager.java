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
    private boolean f6996a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private int f6997c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TagViewPager(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        this.f6996a = true;
    }

    public final float getBeforeX() {
        return this.b;
    }

    public final boolean getEnableScroll() {
        return this.f6996a;
    }

    public final int getLastIndex() {
        return this.f6997c;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Intrinsics.e(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = motionEvent.getX();
        } else if (action == 2) {
            if (motionEvent.getX() - this.b < 0.0f && getCurrentItem() == this.f6997c) {
                return true;
            }
            this.b = motionEvent.getX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.e(motionEvent, "event");
        if (this.f6996a) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.b = motionEvent.getX();
            } else if (action == 2) {
                if (motionEvent.getX() - this.b < 0.0f && getCurrentItem() == this.f6997c) {
                    return true;
                }
                this.b = motionEvent.getX();
            }
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final void setBeforeX(float f) {
        this.b = f;
    }

    public final void setEnableScroll(boolean z) {
        this.f6996a = z;
    }

    public final void setLastIndex(int i) {
        this.f6997c = i;
    }
}
