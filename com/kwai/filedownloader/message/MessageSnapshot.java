package com.kwai.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/MessageSnapshot.class */
public abstract class MessageSnapshot implements Parcelable, c {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwai.filedownloader.message.MessageSnapshot.1
        private static MessageSnapshot a(Parcel parcel) {
            boolean z = parcel.readByte() == 1;
            byte readByte = parcel.readByte();
            MessageSnapshot bVar = readByte != -4 ? readByte != -3 ? readByte != -1 ? readByte != 1 ? readByte != 2 ? readByte != 3 ? readByte != 5 ? readByte != 6 ? null : new b(parcel) : z ? new d.h(parcel) : new h.C0422h(parcel) : z ? new d.g(parcel) : new h.g(parcel) : z ? new d.c(parcel) : new h.c(parcel) : z ? new d.f(parcel) : new h.f(parcel) : z ? new d.C0421d(parcel) : new h.d(parcel) : z ? new d.b(parcel) : new h.b(parcel) : z ? new d.j(parcel) : new h.j(parcel);
            if (bVar != null) {
                bVar.aIv = z;
                return bVar;
            }
            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) readByte));
        }

        private static MessageSnapshot[] cY(int i) {
            return new MessageSnapshot[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MessageSnapshot[] newArray(int i) {
            return cY(i);
        }
    };
    protected boolean aIv;
    private final int id;

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/MessageSnapshot$NoFieldException.class */
    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwai.filedownloader.e.f.j("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Gq()), messageSnapshot.getClass().getName()));
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/MessageSnapshot$a.class */
    public interface a {
        MessageSnapshot Iu();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/MessageSnapshot$b.class */
    public static final class b extends MessageSnapshot {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i) {
            super(i);
        }

        b(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(int i) {
        this.id = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageSnapshot(Parcel parcel) {
        this.id = parcel.readInt();
    }

    public int Gu() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public final boolean Gw() {
        return this.aIv;
    }

    public boolean Ig() {
        throw new NoFieldException("isResuming", this);
    }

    public int Io() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int Ip() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public long Iq() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public boolean Ir() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    public long Is() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public Throwable It() {
        throw new NoFieldException("getThrowable", this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getEtag() {
        throw new NoFieldException("getEtag", this);
    }

    public String getFileName() {
        throw new NoFieldException("getFileName", this);
    }

    public final int getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.aIv ? (byte) 1 : (byte) 0);
        parcel.writeByte(Gq());
        parcel.writeInt(this.id);
    }
}
