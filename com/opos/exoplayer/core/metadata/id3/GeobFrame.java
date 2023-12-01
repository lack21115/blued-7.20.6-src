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
    public final String f25533a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25534c;
    public final byte[] d;

    GeobFrame(Parcel parcel) {
        super(f.f7352a);
        this.f25533a = parcel.readString();
        this.b = parcel.readString();
        this.f25534c = parcel.readString();
        this.d = parcel.createByteArray();
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(f.f7352a);
        this.f25533a = str;
        this.b = str2;
        this.f25534c = str3;
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
                if (u.a(this.f25533a, geobFrame.f25533a)) {
                    z = false;
                    if (u.a(this.b, geobFrame.b)) {
                        z = false;
                        if (u.a(this.f25534c, geobFrame.f25534c)) {
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
        String str = this.f25533a;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.b;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.f25534c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return ((((hashCode2 + ((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31)) * 31) + i) * 31) + Arrays.hashCode(this.d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f25533a);
        parcel.writeString(this.b);
        parcel.writeString(this.f25534c);
        parcel.writeByteArray(this.d);
    }
}
