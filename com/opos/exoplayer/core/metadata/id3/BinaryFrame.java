package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/BinaryFrame.class */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.BinaryFrame.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BinaryFrame[] newArray(int i) {
            return new BinaryFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f25526a;

    BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        this.f25526a = parcel.createByteArray();
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f25526a = bArr;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                BinaryFrame binaryFrame = (BinaryFrame) obj;
                z = false;
                if (this.f.equals(binaryFrame.f)) {
                    if (!Arrays.equals(this.f25526a, binaryFrame.f25526a)) {
                        return false;
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        return ((this.f.hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + Arrays.hashCode(this.f25526a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeByteArray(this.f25526a);
    }
}
