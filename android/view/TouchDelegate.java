package android.view;

import android.graphics.Rect;

/* loaded from: source-9557208-dex2jar.jar:android/view/TouchDelegate.class */
public class TouchDelegate {
    public static final int ABOVE = 1;
    public static final int BELOW = 2;
    public static final int TO_LEFT = 4;
    public static final int TO_RIGHT = 8;
    private Rect mBounds;
    private boolean mDelegateTargeted;
    private View mDelegateView;
    private int mSlop;
    private Rect mSlopBounds;

    public TouchDelegate(Rect rect, View view) {
        this.mBounds = rect;
        this.mSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.mSlopBounds = new Rect(rect);
        this.mSlopBounds.inset(-this.mSlop, -this.mSlop);
        this.mDelegateView = view;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        boolean z2 = false;
        boolean z3 = false;
        switch (motionEvent.getAction()) {
            case 0:
                z = true;
                if (this.mBounds.contains(x, y)) {
                    this.mDelegateTargeted = true;
                    z2 = true;
                    z = true;
                    break;
                }
                break;
            case 1:
            case 2:
                boolean z4 = this.mDelegateTargeted;
                z = true;
                z2 = z4;
                if (z4) {
                    z = true;
                    z2 = z4;
                    if (!this.mSlopBounds.contains(x, y)) {
                        z = false;
                        z2 = z4;
                        break;
                    }
                }
                break;
            case 3:
                z2 = this.mDelegateTargeted;
                this.mDelegateTargeted = false;
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (z2) {
            View view = this.mDelegateView;
            if (z) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                int i = this.mSlop;
                motionEvent.setLocation(-(i * 2), -(i * 2));
            }
            z3 = view.dispatchTouchEvent(motionEvent);
        }
        return z3;
    }
}
