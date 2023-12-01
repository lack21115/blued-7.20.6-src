package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.anythink.core.common.k.u;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/CloseImageView.class */
public class CloseImageView extends ImageView implements a {
    private static final String a = CloseImageView.class.getSimpleName();
    private float b;
    private Rect c;

    public CloseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float f = this.b;
        if (f > 1.0f) {
            u.a(this, f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action;
        if (this.b >= 1.0f || (!((action = motionEvent.getAction()) == 0 || action == 5) || this.c.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY())))) {
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
            post(new Runnable() { // from class: com.anythink.basead.ui.CloseImageView.1
                @Override // java.lang.Runnable
                public final void run() {
                    CloseImageView.this.c = new Rect();
                    CloseImageView closeImageView = CloseImageView.this;
                    closeImageView.getHitRect(closeImageView.c);
                    int width = ((int) (CloseImageView.this.c.width() * (CloseImageView.this.b - 1.0f))) / 2;
                    int height = ((int) (CloseImageView.this.c.height() * (CloseImageView.this.b - 1.0f))) / 2;
                    CloseImageView.this.c.top -= height;
                    CloseImageView.this.c.bottom += height;
                    CloseImageView.this.c.left -= width;
                    CloseImageView.this.c.right += width;
                }
            });
        } else if (f2 > 1.0f) {
            u.a(this, f2);
        }
    }
}
