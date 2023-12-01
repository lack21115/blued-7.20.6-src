package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/ApicFrame.class */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.ApicFrame.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApicFrame[] newArray(int i) {
            return new ApicFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f25524a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final int f25525c;
    public final byte[] d;

    ApicFrame(Parcel parcel) {
        super(com.anythink.expressad.exoplayer.g.b.a.f7343a);
        this.f25524a = parcel.readString();
        this.b = parcel.readString();
        this.f25525c = parcel.readInt();
        this.d = parcel.createByteArray();
    }

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super(com.anythink.expressad.exoplayer.g.b.a.f7343a);
        this.f25524a = str;
        this.b = str2;
        this.f25525c = i;
        this.d = bArr;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                ApicFrame apicFrame = (ApicFrame) obj;
                z = false;
                if (this.f25525c == apicFrame.f25525c) {
                    z = false;
                    if (u.a(this.f25524a, apicFrame.f25524a)) {
                        z = false;
                        if (u.a(this.b, apicFrame.b)) {
                            if (!Arrays.equals(this.d, apicFrame.d)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        int i = this.f25525c;
        String str = this.f25524a;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((((hashCode + ((i + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31)) * 31) + i2) * 31) + Arrays.hashCode(this.d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f25524a);
        parcel.writeString(this.b);
        parcel.writeInt(this.f25525c);
        parcel.writeByteArray(this.d);
    }
}
