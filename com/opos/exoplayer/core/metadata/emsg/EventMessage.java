package com.opos.exoplayer.core.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/emsg/EventMessage.class */
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() { // from class: com.opos.exoplayer.core.metadata.emsg.EventMessage.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EventMessage[] newArray(int i) {
            return new EventMessage[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f11832a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11833c;
    public final long d;
    public final long e;
    public final byte[] f;
    private int g;

    EventMessage(Parcel parcel) {
        this.f11832a = parcel.readString();
        this.b = parcel.readString();
        this.d = parcel.readLong();
        this.f11833c = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.createByteArray();
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr, long j3) {
        this.f11832a = str;
        this.b = str2;
        this.f11833c = j;
        this.e = j2;
        this.f = bArr;
        this.d = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                EventMessage eventMessage = (EventMessage) obj;
                z = false;
                if (this.d == eventMessage.d) {
                    z = false;
                    if (this.f11833c == eventMessage.f11833c) {
                        z = false;
                        if (this.e == eventMessage.e) {
                            z = false;
                            if (u.a(this.f11832a, eventMessage.f11832a)) {
                                z = false;
                                if (u.a(this.b, eventMessage.b)) {
                                    if (!Arrays.equals(this.f, eventMessage.f)) {
                                        return false;
                                    }
                                }
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
        if (this.g == 0) {
            String str = this.f11832a;
            int i = 0;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            long j = this.d;
            int i2 = (int) (j ^ (j >>> 32));
            long j2 = this.f11833c;
            int i3 = (int) (j2 ^ (j2 >>> 32));
            long j3 = this.e;
            this.g = ((((((((((hashCode + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + i) * 31) + i2) * 31) + i3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.f);
        }
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11832a);
        parcel.writeString(this.b);
        parcel.writeLong(this.d);
        parcel.writeLong(this.f11833c);
        parcel.writeLong(this.e);
        parcel.writeByteArray(this.f);
    }
}
