package android.animation;

import android.view.RenderNodeAnimator;
import android.view.View;

/* loaded from: source-9557208-dex2jar.jar:android/animation/RevealAnimator.class */
public class RevealAnimator extends RenderNodeAnimator {
    private View mClipView;

    public RevealAnimator(View view, int i, int i2, float f, float f2) {
        super(i, i2, f, f2);
        this.mClipView = view;
        setTarget(this.mClipView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.RenderNodeAnimator
    public void onFinished() {
        this.mClipView.setRevealClip(false, 0.0f, 0.0f, 0.0f);
        super.onFinished();
    }
}
