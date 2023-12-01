package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.expressad.exoplayer.b;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.s;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/scte35/TimeSignalCommand.class */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() { // from class: com.opos.exoplayer.core.metadata.scte35.TimeSignalCommand.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeSignalCommand[] newArray(int i) {
            return new TimeSignalCommand[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final long f11863a;
    public final long b;

    private TimeSignalCommand(long j, long j2) {
        this.f11863a = j;
        this.b = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(m mVar, long j) {
        long g = mVar.g();
        return (128 & g) != 0 ? 8589934591L & ((((g & 1) << 32) | mVar.m()) + j) : b.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeSignalCommand a(m mVar, long j, s sVar) {
        long a2 = a(mVar, j);
        return new TimeSignalCommand(a2, sVar.b(a2));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f11863a);
        parcel.writeLong(this.b);
    }
}
