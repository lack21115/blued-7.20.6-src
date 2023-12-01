package android.hardware.camera2.params;

import android.graphics.Point;
import android.graphics.Rect;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/params/Face.class */
public final class Face {
    public static final int ID_UNSUPPORTED = -1;
    public static final int SCORE_MAX = 100;
    public static final int SCORE_MIN = 1;
    private final Rect mBounds;
    private final int mId;
    private final Point mLeftEye;
    private final Point mMouth;
    private final Point mRightEye;
    private final int mScore;

    public Face(Rect rect, int i) {
        this(rect, i, -1, null, null, null);
    }

    public Face(Rect rect, int i, int i2, Point point, Point point2, Point point3) {
        checkNotNull("bounds", rect);
        if (i < 1 || i > 100) {
            throw new IllegalArgumentException("Confidence out of range");
        }
        if (i2 < 0 && i2 != -1) {
            throw new IllegalArgumentException("Id out of range");
        }
        if (i2 == -1) {
            checkNull("leftEyePosition", point);
            checkNull("rightEyePosition", point2);
            checkNull("mouthPosition", point3);
        }
        this.mBounds = rect;
        this.mScore = i;
        this.mId = i2;
        this.mLeftEye = point;
        this.mRightEye = point2;
        this.mMouth = point3;
    }

    private static void checkNotNull(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(str + " was required, but it was null");
        }
    }

    private static void checkNull(String str, Object obj) {
        if (obj != null) {
            throw new IllegalArgumentException(str + " was required to be null, but it wasn't");
        }
    }

    public Rect getBounds() {
        return this.mBounds;
    }

    public int getId() {
        return this.mId;
    }

    public Point getLeftEyePosition() {
        return this.mLeftEye;
    }

    public Point getMouthPosition() {
        return this.mMouth;
    }

    public Point getRightEyePosition() {
        return this.mRightEye;
    }

    public int getScore() {
        return this.mScore;
    }

    public String toString() {
        return String.format("{ bounds: %s, score: %s, id: %d, leftEyePosition: %s, rightEyePosition: %s, mouthPosition: %s }", this.mBounds, Integer.valueOf(this.mScore), Integer.valueOf(this.mId), this.mLeftEye, this.mRightEye, this.mMouth);
    }
}
