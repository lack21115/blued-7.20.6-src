package android.app;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/app/ComposedIconInfo.class */
public class ComposedIconInfo implements Parcelable {
    public static final Parcelable.Creator<ComposedIconInfo> CREATOR = new Parcelable.Creator<ComposedIconInfo>() { // from class: android.app.ComposedIconInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ComposedIconInfo createFromParcel(Parcel parcel) {
            return new ComposedIconInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ComposedIconInfo[] newArray(int i) {
            return new ComposedIconInfo[0];
        }
    };
    public float[] colorFilter;
    public int[] defaultSwatchColors;
    public int[] iconBacks;
    public int iconDensity;
    public int iconMask;
    public int iconPaletteBack;
    public float iconRotation;
    public float iconRotationVariance;
    public float iconScale;
    public int iconSize;
    public float iconTranslationX;
    public float iconTranslationY;
    public int iconUpon;
    public SwatchType swatchType;

    /* loaded from: source-9557208-dex2jar.jar:android/app/ComposedIconInfo$SwatchType.class */
    public enum SwatchType {
        None,
        Vibrant,
        VibrantLight,
        VibrantDark,
        Muted,
        MutedLight,
        MutedDark
    }

    public ComposedIconInfo() {
        this.iconPaletteBack = 0;
        this.swatchType = SwatchType.None;
        this.iconRotation = 0.0f;
        this.iconTranslationX = 0.0f;
        this.iconTranslationY = 0.0f;
        this.iconScale = 1.0f;
    }

    private ComposedIconInfo(Parcel parcel) {
        this.iconScale = parcel.readFloat();
        this.iconRotation = parcel.readFloat();
        this.iconRotationVariance = parcel.readFloat();
        this.iconTranslationX = parcel.readFloat();
        this.iconTranslationY = parcel.readFloat();
        this.iconDensity = parcel.readInt();
        this.iconSize = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.iconBacks = new int[readInt];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                this.iconBacks[i2] = parcel.readInt();
                i = i2 + 1;
            }
        }
        this.iconMask = parcel.readInt();
        this.iconUpon = parcel.readInt();
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            this.colorFilter = new float[readInt2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= readInt2) {
                    break;
                }
                this.colorFilter[i4] = parcel.readFloat();
                i3 = i4 + 1;
            }
        }
        this.iconPaletteBack = parcel.readInt();
        this.swatchType = SwatchType.values()[parcel.readInt()];
        int readInt3 = parcel.readInt();
        if (readInt3 <= 0) {
            return;
        }
        this.defaultSwatchColors = new int[readInt3];
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= readInt3) {
                return;
            }
            this.defaultSwatchColors[i6] = parcel.readInt();
            i5 = i6 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.iconScale);
        parcel.writeFloat(this.iconRotation);
        parcel.writeFloat(this.iconRotationVariance);
        parcel.writeFloat(this.iconTranslationX);
        parcel.writeFloat(this.iconTranslationY);
        parcel.writeInt(this.iconDensity);
        parcel.writeInt(this.iconSize);
        parcel.writeInt(this.iconBacks != null ? this.iconBacks.length : 0);
        if (this.iconBacks != null) {
            int[] iArr = this.iconBacks;
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                parcel.writeInt(iArr[i3]);
                i2 = i3 + 1;
            }
        }
        parcel.writeInt(this.iconMask);
        parcel.writeInt(this.iconUpon);
        if (this.colorFilter != null) {
            parcel.writeInt(this.colorFilter.length);
            float[] fArr = this.colorFilter;
            int length2 = fArr.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    break;
                }
                parcel.writeFloat(fArr[i5]);
                i4 = i5 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.iconPaletteBack);
        parcel.writeInt(this.swatchType.ordinal());
        if (this.defaultSwatchColors == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.defaultSwatchColors.length);
        int[] iArr2 = this.defaultSwatchColors;
        int length3 = iArr2.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= length3) {
                return;
            }
            parcel.writeInt(iArr2[i7]);
            i6 = i7 + 1;
        }
    }
}
