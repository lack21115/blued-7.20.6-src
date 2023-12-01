package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.anythink.core.common.k.u;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/CloseFrameLayout.class */
public class CloseFrameLayout extends FrameLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6100a = CloseFrameLayout.class.getSimpleName();
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f6101c;

    public CloseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 1.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action;
        if (this.b >= 1.0f || (!((action = motionEvent.getAction()) == 0 || action == 5) || this.f6101c.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY())))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.anythink.basead.ui.a
    public void setClickAreaScaleFactor(float f) {
        this.b = f;
        if (f <= 0.0f) {
            this.b = 1.0f;
        }
        new StringBuilder("setClickAreaScaleFactor: ").append(this.b);
        float f2 = this.b;
        if (f2 < 1.0f) {
            post(new Runnable() { // from class: com.anythink.basead.ui.CloseFrameLayout.1
                @Override // java.lang.Runnable
                public final void run() {
                    CloseFrameLayout.this.f6101c = new Rect();
                    CloseFrameLayout closeFrameLayout = CloseFrameLayout.this;
                    closeFrameLayout.getHitRect(closeFrameLayout.f6101c);
                    int width = ((int) (CloseFrameLayout.this.f6101c.width() * (CloseFrameLayout.this.b - 1.0f))) / 2;
                    int height = ((int) (CloseFrameLayout.this.f6101c.height() * (CloseFrameLayout.this.b - 1.0f))) / 2;
                    CloseFrameLayout.this.f6101c.top -= height;
                    CloseFrameLayout.this.f6101c.bottom += height;
                    CloseFrameLayout.this.f6101c.left -= width;
                    CloseFrameLayout.this.f6101c.right += width;
                }
            });
        } else if (f2 > 1.0f) {
            u.a(this, f2);
        }
    }
}
