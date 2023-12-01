package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.g.b.f;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/id3/GeobFrame.class */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.GeobFrame.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GeobFrame[] newArray(int i) {
            return new GeobFrame[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f11845a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11846c;
    public final byte[] d;

    GeobFrame(Parcel parcel) {
        super(f.f4513a);
        this.f11845a = parcel.readString();
        this.b = parcel.readString();
        this.f11846c = parcel.readString();
        this.d = parcel.createByteArray();
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(f.f4513a);
        this.f11845a = str;
        this.b = str2;
        this.f11846c = str3;
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
                GeobFrame geobFrame = (GeobFrame) obj;
                z = false;
                if (u.a(this.f11845a, geobFrame.f11845a)) {
                    z = false;
                    if (u.a(this.b, geobFrame.b)) {
                        z = false;
                        if (u.a(this.f11846c, geobFrame.f11846c)) {
                            if (!Arrays.equals(this.d, geobFrame.d)) {
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
        String str = this.f11845a;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.b;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.f11846c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((hashCode2 + ((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31)) * 31) + i) * 31) + Arrays.hashCode(this.d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11845a);
        parcel.writeString(this.b);
        parcel.writeString(this.f11846c);
        parcel.writeByteArray(this.d);
    }
}
