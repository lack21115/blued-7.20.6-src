package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PointF.class */
public class PointF implements Parcelable {
    public static final Parcelable.Creator<PointF> CREATOR = new Parcelable.Creator<PointF>() { // from class: android.graphics.PointF.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointF createFromParcel(Parcel parcel) {
            PointF pointF = new PointF();
            pointF.readFromParcel(parcel);
            return pointF;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointF[] newArray(int i) {
            return new PointF[i];
        }
    };
    public float x;
    public float y;

    public PointF() {
    }

    public PointF(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public PointF(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public static float length(float f, float f2) {
        return FloatMath.sqrt((f * f) + (f2 * f2));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(float f, float f2) {
        return this.x == f && this.y == f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PointF pointF = (PointF) obj;
        return Float.compare(pointF.x, this.x) == 0 && Float.compare(pointF.y, this.y) == 0;
    }

    public int hashCode() {
        int i = 0;
        int floatToIntBits = this.x != 0.0f ? Float.floatToIntBits(this.x) : 0;
        if (this.y != 0.0f) {
            i = Float.floatToIntBits(this.y);
        }
        return (floatToIntBits * 31) + i;
    }

    public final float length() {
        return length(this.x, this.y);
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public final void offset(float f, float f2) {
        this.x += f;
        this.y += f2;
    }

    public void readFromParcel(Parcel parcel) {
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
    }

    public final void set(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public final void set(PointF pointF) {
        this.x = pointF.x;
        this.y = pointF.y;
    }

    public String toString() {
        return "PointF(" + this.x + ", " + this.y + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
    }
}
