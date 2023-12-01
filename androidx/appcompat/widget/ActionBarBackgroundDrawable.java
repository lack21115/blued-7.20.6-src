package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ActionBarBackgroundDrawable.class */
class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1653a;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f1653a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1653a.d) {
            if (this.f1653a.f1655c != null) {
                this.f1653a.f1655c.draw(canvas);
                return;
            }
            return;
        }
        if (this.f1653a.f1654a != null) {
            this.f1653a.f1654a.draw(canvas);
        }
        if (this.f1653a.b == null || !this.f1653a.e) {
            return;
        }
        this.f1653a.b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f1653a.d) {
            if (this.f1653a.f1655c != null) {
                this.f1653a.f1655c.getOutline(outline);
            }
        } else if (this.f1653a.f1654a != null) {
            this.f1653a.f1654a.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
