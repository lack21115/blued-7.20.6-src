package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActionBarBackgroundDrawable.class */
class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1701a;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f1701a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1701a.d) {
            if (this.f1701a.f1703c != null) {
                this.f1701a.f1703c.draw(canvas);
                return;
            }
            return;
        }
        if (this.f1701a.f1702a != null) {
            this.f1701a.f1702a.draw(canvas);
        }
        if (this.f1701a.b == null || !this.f1701a.e) {
            return;
        }
        this.f1701a.b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f1701a.d) {
            if (this.f1701a.f1703c != null) {
                this.f1701a.f1703c.getOutline(outline);
            }
        } else if (this.f1701a.f1702a != null) {
            this.f1701a.f1702a.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
