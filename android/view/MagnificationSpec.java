package android.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pools;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-9557208-dex2jar.jar:android/view/MagnificationSpec.class */
public class MagnificationSpec implements Parcelable {
    private static final int MAX_POOL_SIZE = 20;
    public float offsetX;
    public float offsetY;
    public float scale = 1.0f;
    private static final Pools.SynchronizedPool<MagnificationSpec> sPool = new Pools.SynchronizedPool<>(20);
    public static final Parcelable.Creator<MagnificationSpec> CREATOR = new Parcelable.Creator<MagnificationSpec>() { // from class: android.view.MagnificationSpec.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MagnificationSpec createFromParcel(Parcel parcel) {
            MagnificationSpec obtain = MagnificationSpec.obtain();
            obtain.initFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MagnificationSpec[] newArray(int i) {
            return new MagnificationSpec[i];
        }
    };

    private MagnificationSpec() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFromParcel(Parcel parcel) {
        this.scale = parcel.readFloat();
        this.offsetX = parcel.readFloat();
        this.offsetY = parcel.readFloat();
    }

    public static MagnificationSpec obtain() {
        MagnificationSpec acquire = sPool.acquire();
        return acquire != null ? acquire : new MagnificationSpec();
    }

    public static MagnificationSpec obtain(MagnificationSpec magnificationSpec) {
        MagnificationSpec obtain = obtain();
        obtain.scale = magnificationSpec.scale;
        obtain.offsetX = magnificationSpec.offsetX;
        obtain.offsetY = magnificationSpec.offsetY;
        return obtain;
    }

    public void clear() {
        this.scale = 1.0f;
        this.offsetX = 0.0f;
        this.offsetY = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void initialize(float f, float f2, float f3) {
        if (f < 1.0f) {
            throw new IllegalArgumentException("Scale must be greater than or equal to one!");
        }
        this.scale = f;
        this.offsetX = f2;
        this.offsetY = f3;
    }

    public boolean isNop() {
        return this.scale == 1.0f && this.offsetX == 0.0f && this.offsetY == 0.0f;
    }

    public void recycle() {
        clear();
        sPool.release(this);
    }

    public String toString() {
        return "<scale:" + this.scale + ",offsetX:" + this.offsetX + ",offsetY:" + this.offsetY + SimpleComparison.GREATER_THAN_OPERATION;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.scale);
        parcel.writeFloat(this.offsetX);
        parcel.writeFloat(this.offsetY);
        recycle();
    }
}
