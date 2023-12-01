package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/scte35/PrivateCommand.class */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() { // from class: com.opos.exoplayer.core.metadata.scte35.PrivateCommand.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivateCommand[] newArray(int i) {
            return new PrivateCommand[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f25541a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f25542c;

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.f25541a = j2;
        this.b = j;
        this.f25542c = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f25541a = parcel.readLong();
        this.b = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.f25542c = bArr;
        parcel.readByteArray(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PrivateCommand a(m mVar, int i, long j) {
        long m = mVar.m();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        return new PrivateCommand(m, bArr, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f25541a);
        parcel.writeLong(this.b);
        parcel.writeInt(this.f25542c.length);
        parcel.writeByteArray(this.f25542c);
    }
}
