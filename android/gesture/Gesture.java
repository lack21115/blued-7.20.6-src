package android.gesture;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/Gesture.class */
public class Gesture implements Parcelable {
    private static final boolean BITMAP_RENDERING_ANTIALIAS = true;
    private static final boolean BITMAP_RENDERING_DITHER = true;
    private static final int BITMAP_RENDERING_WIDTH = 2;
    private static final long GESTURE_ID_BASE = System.currentTimeMillis();
    private static final AtomicInteger sGestureCount = new AtomicInteger(0);
    public static final Parcelable.Creator<Gesture> CREATOR = new Parcelable.Creator<Gesture>() { // from class: android.gesture.Gesture.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Gesture createFromParcel(Parcel parcel) {
            Gesture gesture;
            long readLong = parcel.readLong();
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(parcel.createByteArray()));
            try {
                try {
                    gesture = Gesture.deserialize(dataInputStream);
                } catch (IOException e) {
                    Log.e(GestureConstants.LOG_TAG, "Error reading Gesture from parcel:", e);
                    GestureUtils.closeStream(dataInputStream);
                    gesture = null;
                }
                if (gesture != null) {
                    gesture.mGestureID = readLong;
                }
                return gesture;
            } finally {
                GestureUtils.closeStream(dataInputStream);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Gesture[] newArray(int i) {
            return new Gesture[i];
        }
    };
    private final RectF mBoundingBox = new RectF();
    private final ArrayList<GestureStroke> mStrokes = new ArrayList<>();
    private long mGestureID = GESTURE_ID_BASE + sGestureCount.incrementAndGet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Gesture deserialize(DataInputStream dataInputStream) throws IOException {
        Gesture gesture = new Gesture();
        gesture.mGestureID = dataInputStream.readLong();
        int readInt = dataInputStream.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return gesture;
            }
            gesture.addStroke(GestureStroke.deserialize(dataInputStream));
            i = i2 + 1;
        }
    }

    public void addStroke(GestureStroke gestureStroke) {
        this.mStrokes.add(gestureStroke);
        this.mBoundingBox.union(gestureStroke.boundingBox);
    }

    public Object clone() {
        Gesture gesture = new Gesture();
        gesture.mBoundingBox.set(this.mBoundingBox.left, this.mBoundingBox.top, this.mBoundingBox.right, this.mBoundingBox.bottom);
        int size = this.mStrokes.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return gesture;
            }
            gesture.mStrokes.add((GestureStroke) this.mStrokes.get(i2).clone());
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RectF getBoundingBox() {
        return this.mBoundingBox;
    }

    public long getID() {
        return this.mGestureID;
    }

    public float getLength() {
        int i = 0;
        ArrayList<GestureStroke> arrayList = this.mStrokes;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return i;
            }
            i = (int) (arrayList.get(i3).length + i);
            i2 = i3 + 1;
        }
    }

    public ArrayList<GestureStroke> getStrokes() {
        return this.mStrokes;
    }

    public int getStrokesCount() {
        return this.mStrokes.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        ArrayList<GestureStroke> arrayList = this.mStrokes;
        int size = arrayList.size();
        dataOutputStream.writeLong(this.mGestureID);
        dataOutputStream.writeInt(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).serialize(dataOutputStream);
            i = i2 + 1;
        }
    }

    void setID(long j) {
        this.mGestureID = j;
    }

    public Bitmap toBitmap(int i, int i2, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(i4);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(2.0f);
        Path path = toPath();
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        float width = (i - (i3 * 2)) / rectF.width();
        float height = (i2 - (i3 * 2)) / rectF.height();
        if (width > height) {
            width = height;
        }
        paint.setStrokeWidth(2.0f / width);
        path.offset((-rectF.left) + ((i - (rectF.width() * width)) / 2.0f), (-rectF.top) + ((i2 - (rectF.height() * width)) / 2.0f));
        canvas.translate(i3, i3);
        canvas.scale(width, width);
        canvas.drawPath(path, paint);
        return createBitmap;
    }

    public Bitmap toBitmap(int i, int i2, int i3, int i4, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(i3, i3);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(i5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(2.0f);
        ArrayList<GestureStroke> arrayList = this.mStrokes;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= size) {
                return createBitmap;
            }
            canvas.drawPath(arrayList.get(i7).toPath(i - (i3 * 2), i2 - (i3 * 2), i4), paint);
            i6 = i7 + 1;
        }
    }

    public Path toPath() {
        return toPath(null);
    }

    public Path toPath(int i, int i2, int i3, int i4) {
        return toPath(null, i, i2, i3, i4);
    }

    public Path toPath(Path path) {
        Path path2 = path;
        if (path == null) {
            path2 = new Path();
        }
        ArrayList<GestureStroke> arrayList = this.mStrokes;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return path2;
            }
            path2.addPath(arrayList.get(i2).getPath());
            i = i2 + 1;
        }
    }

    public Path toPath(Path path, int i, int i2, int i3, int i4) {
        Path path2 = path;
        if (path == null) {
            path2 = new Path();
        }
        ArrayList<GestureStroke> arrayList = this.mStrokes;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= size) {
                return path2;
            }
            path2.addPath(arrayList.get(i6).toPath(i - (i3 * 2), i2 - (i3 * 2), i4));
            i5 = i6 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mGestureID);
        boolean z = false;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(32768);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            serialize(dataOutputStream);
            z = true;
        } catch (IOException e) {
            Log.e(GestureConstants.LOG_TAG, "Error writing Gesture to parcel:", e);
        } finally {
            GestureUtils.closeStream(dataOutputStream);
            GestureUtils.closeStream(byteArrayOutputStream);
        }
        if (z) {
            parcel.writeByteArray(byteArrayOutputStream.toByteArray());
        }
    }
}
