package android.gesture;

import java.io.DataInputStream;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/GesturePoint.class */
public class GesturePoint {
    public final long timestamp;
    public final float x;
    public final float y;

    public GesturePoint(float f, float f2, long j) {
        this.x = f;
        this.y = f2;
        this.timestamp = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GesturePoint deserialize(DataInputStream dataInputStream) throws IOException {
        return new GesturePoint(dataInputStream.readFloat(), dataInputStream.readFloat(), dataInputStream.readLong());
    }

    public Object clone() {
        return new GesturePoint(this.x, this.y, this.timestamp);
    }
}
