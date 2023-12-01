package android.view;

import android.graphics.Rect;

/* loaded from: source-9557208-dex2jar.jar:android/view/FocusFinderHelper.class */
public class FocusFinderHelper {
    private FocusFinder mFocusFinder;

    public FocusFinderHelper(FocusFinder focusFinder) {
        this.mFocusFinder = focusFinder;
    }

    public static int majorAxisDistance(int i, Rect rect, Rect rect2) {
        return FocusFinder.majorAxisDistance(i, rect, rect2);
    }

    public static int majorAxisDistanceToFarEdge(int i, Rect rect, Rect rect2) {
        return FocusFinder.majorAxisDistanceToFarEdge(i, rect, rect2);
    }

    public boolean beamBeats(int i, Rect rect, Rect rect2, Rect rect3) {
        return this.mFocusFinder.beamBeats(i, rect, rect2, rect3);
    }

    public boolean beamsOverlap(int i, Rect rect, Rect rect2) {
        return this.mFocusFinder.beamsOverlap(i, rect, rect2);
    }

    public boolean isBetterCandidate(int i, Rect rect, Rect rect2, Rect rect3) {
        return this.mFocusFinder.isBetterCandidate(i, rect, rect2, rect3);
    }

    public boolean isCandidate(Rect rect, Rect rect2, int i) {
        return this.mFocusFinder.isCandidate(rect, rect2, i);
    }
}
