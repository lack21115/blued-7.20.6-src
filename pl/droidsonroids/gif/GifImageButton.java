package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import pl.droidsonroids.gif.GifViewUtils;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifImageButton.class */
public class GifImageButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private boolean f44138a;

    public GifImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(GifViewUtils.a((ImageView) this, attributeSet, 0, 0));
    }

    public GifImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(GifViewUtils.a((ImageView) this, attributeSet, i, 0));
    }

    private void a(GifViewUtils.InitResult initResult) {
        this.f44138a = initResult.f44154c;
        if (initResult.f44153a > 0) {
            super.setImageResource(initResult.f44153a);
        }
        if (initResult.b > 0) {
            super.setBackgroundResource(initResult.b);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable drawable = null;
        Drawable drawable2 = this.f44138a ? getDrawable() : null;
        if (this.f44138a) {
            drawable = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawable2, drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (GifViewUtils.a((ImageView) this, false, i)) {
            return;
        }
        super.setBackgroundResource(i);
    }

    public void setFreezesAnimation(boolean z) {
        this.f44138a = z;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (GifViewUtils.a((ImageView) this, true, i)) {
            return;
        }
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (GifViewUtils.a(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }
}
