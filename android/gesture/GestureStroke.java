package android.gesture;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/GestureStroke.class */
public class GestureStroke {
    static final float TOUCH_TOLERANCE = 3.0f;
    public final RectF boundingBox;
    public final float length;
    private Path mCachedPath;
    public final float[] points;
    private final long[] timestamps;

    private GestureStroke(RectF rectF, float f, float[] fArr, long[] jArr) {
        this.boundingBox = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.length = f;
        this.points = (float[]) fArr.clone();
        this.timestamps = (long[]) jArr.clone();
    }

    public GestureStroke(ArrayList<GesturePoint> arrayList) {
        int size = arrayList.size();
        float[] fArr = new float[size * 2];
        long[] jArr = new long[size];
        RectF rectF = null;
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                this.timestamps = jArr;
                this.points = fArr;
                this.boundingBox = rectF;
                this.length = f;
                return;
            }
            GesturePoint gesturePoint = arrayList.get(i3);
            fArr[i3 * 2] = gesturePoint.x;
            fArr[(i3 * 2) + 1] = gesturePoint.y;
            jArr[i] = gesturePoint.timestamp;
            if (rectF == null) {
                rectF = new RectF();
                rectF.top = gesturePoint.y;
                rectF.left = gesturePoint.x;
                rectF.right = gesturePoint.x;
                rectF.bottom = gesturePoint.y;
                f = 0.0f;
            } else {
                f = (float) (f + Math.sqrt(Math.pow(gesturePoint.x - fArr[(i3 - 1) * 2], 2.0d) + Math.pow(gesturePoint.y - fArr[((i3 - 1) * 2) + 1], 2.0d)));
                rectF.union(gesturePoint.x, gesturePoint.y);
            }
            i++;
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GestureStroke deserialize(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return new GestureStroke(arrayList);
            }
            arrayList.add(GesturePoint.deserialize(dataInputStream));
            i = i2 + 1;
        }
    }

    private void makePath() {
        float f;
        float f2;
        Path path;
        float[] fArr = this.points;
        int length = fArr.length;
        Path path2 = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i = 0;
        while (i < length) {
            float f5 = fArr[i];
            float f6 = fArr[i + 1];
            if (path2 == null) {
                path = new Path();
                path.moveTo(f5, f6);
                f = f5;
                f2 = f6;
            } else {
                float abs = Math.abs(f5 - f3);
                float abs2 = Math.abs(f6 - f4);
                if (abs < 3.0f) {
                    f = f3;
                    f2 = f4;
                    path = path2;
                    if (abs2 < 3.0f) {
                    }
                }
                path2.quadTo(f3, f4, (f5 + f3) / 2.0f, (f6 + f4) / 2.0f);
                f = f5;
                f2 = f6;
                path = path2;
            }
            i += 2;
            f3 = f;
            f4 = f2;
            path2 = path;
        }
        this.mCachedPath = path2;
    }

    public void clearPath() {
        if (this.mCachedPath != null) {
            this.mCachedPath.rewind();
        }
    }

    public Object clone() {
        return new GestureStroke(this.boundingBox, this.length, this.points, this.timestamps);
    }

    public OrientedBoundingBox computeOrientedBoundingBox() {
        return GestureUtils.computeOrientedBoundingBox(this.points);
    }

    void draw(Canvas canvas, Paint paint) {
        if (this.mCachedPath == null) {
            makePath();
        }
        canvas.drawPath(this.mCachedPath, paint);
    }

    public Path getPath() {
        if (this.mCachedPath == null) {
            makePath();
        }
        return this.mCachedPath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        float[] fArr = this.points;
        long[] jArr = this.timestamps;
        int length = this.points.length;
        dataOutputStream.writeInt(length / 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            dataOutputStream.writeFloat(fArr[i2]);
            dataOutputStream.writeFloat(fArr[i2 + 1]);
            dataOutputStream.writeLong(jArr[i2 / 2]);
            i = i2 + 2;
        }
    }

    public Path toPath(float f, float f2, int i) {
        float f3;
        float f4;
        Path path;
        float[] temporalSampling = GestureUtils.temporalSampling(this, i);
        RectF rectF = this.boundingBox;
        GestureUtils.translate(temporalSampling, -rectF.left, -rectF.top);
        float width = f / rectF.width();
        float height = f2 / rectF.height();
        if (width > height) {
            width = height;
        }
        GestureUtils.scale(temporalSampling, width, width);
        float f5 = 0.0f;
        float f6 = 0.0f;
        Path path2 = null;
        int length = temporalSampling.length;
        int i2 = 0;
        while (i2 < length) {
            float f7 = temporalSampling[i2];
            float f8 = temporalSampling[i2 + 1];
            if (path2 == null) {
                path = new Path();
                path.moveTo(f7, f8);
                f3 = f7;
                f4 = f8;
            } else {
                float abs = Math.abs(f7 - f5);
                float abs2 = Math.abs(f8 - f6);
                if (abs < 3.0f) {
                    f3 = f5;
                    f4 = f6;
                    path = path2;
                    if (abs2 < 3.0f) {
                    }
                }
                path2.quadTo(f5, f6, (f7 + f5) / 2.0f, (f8 + f6) / 2.0f);
                f3 = f7;
                f4 = f8;
                path = path2;
            }
            i2 += 2;
            f5 = f3;
            f6 = f4;
            path2 = path;
        }
        return path2;
    }
}
