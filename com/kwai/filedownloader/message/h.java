package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h.class */
public abstract class h extends MessageSnapshot {

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$a.class */
    public static final class a extends b implements com.kwai.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, boolean z, int i2) {
            super(i, true, i2);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$b.class */
    public static class b extends h {
        private final int aIF;
        private final boolean aIq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i, boolean z, int i2) {
            super(i);
            this.aIq = z;
            this.aIF = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Parcel parcel) {
            super(parcel);
            this.aIq = parcel.readByte() != 0;
            this.aIF = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Ip() {
            return this.aIF;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final boolean Ir() {
            return this.aIq;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$c.class */
    public static final class c extends h {
        private final String aGO;
        private final int aIF;
        private final boolean aIr;
        private final String aIs;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.aIr = z;
            this.aIF = i2;
            this.aGO = str;
            this.aIs = str2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Parcel parcel) {
            super(parcel);
            this.aIr = parcel.readByte() != 0;
            this.aIF = parcel.readInt();
            this.aGO = parcel.readString();
            this.aIs = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final boolean Ig() {
            return this.aIr;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Ip() {
            return this.aIF;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.aGO;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.aIs;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$d.class */
    public static class d extends h {
        private final int aIG;
        private final Throwable aIu;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(int i, int i2, Throwable th) {
            super(i);
            this.aIG = i2;
            this.aIu = th;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Parcel parcel) {
            super(parcel);
            this.aIG = parcel.readInt();
            this.aIu = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte Gq() {
            return (byte) -1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Io() {
            return this.aIG;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final Throwable It() {
            return this.aIu;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aIG);
            parcel.writeSerializable(this.aIu);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$e.class */
    public static final class e extends f {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -2;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$f.class */
    public static class f extends h {
        private final int aIF;
        private final int aIG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(int i, int i2, int i3) {
            super(i);
            this.aIG = i2;
            this.aIF = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(Parcel parcel) {
            super(parcel);
            this.aIG = parcel.readInt();
            this.aIF = parcel.readInt();
        }

        f(f fVar) {
            this(fVar.getId(), fVar.Io(), fVar.Ip());
        }

        public byte Gq() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Io() {
            return this.aIG;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Ip() {
            return this.aIF;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aIG);
            parcel.writeInt(this.aIF);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$g.class */
    public static final class g extends h {
        private final int aIG;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i, int i2) {
            super(i);
            this.aIG = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Parcel parcel) {
            super(parcel);
            this.aIG = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Io() {
            return this.aIG;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aIG);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$h.class */
    public static final class C0592h extends d {
        private final int aHZ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0592h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.aHZ = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0592h(Parcel parcel) {
            super(parcel);
            this.aHZ = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Gu() {
            return this.aHZ;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aHZ);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$i.class */
    public static final class i extends j implements com.kwai.filedownloader.message.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/message/h$j.class */
    public static class j extends f implements MessageSnapshot.a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -4;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot Iu() {
            return new f(this);
        }
    }

    h(int i2) {
        super(i2);
        this.aIv = false;
    }

    h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final long Iq() {
        return Ip();
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final long Is() {
        return Io();
    }
}
