package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.g.b.j;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/PrivFrame.class */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.PrivFrame.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivFrame[] newArray(int i) {
            return new PrivFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f25535a;
    public final byte[] b;

    PrivFrame(Parcel parcel) {
        super(j.f7360a);
        this.f25535a = parcel.readString();
        this.b = parcel.createByteArray();
    }

    public PrivFrame(String str, byte[] bArr) {
        super(j.f7360a);
        this.f25535a = str;
        this.b = bArr;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                PrivFrame privFrame = (PrivFrame) obj;
                z = false;
                if (u.a(this.f25535a, privFrame.f25535a)) {
                    if (!Arrays.equals(this.b, privFrame.b)) {
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
        String str = this.f25535a;
        return (((str != null ? str.hashCode() : 0) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + Arrays.hashCode(this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f25535a);
        parcel.writeByteArray(this.b);
    }
}
