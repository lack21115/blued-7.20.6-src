package com.kwai.filedownloader.c;

import android.content.ContentValues;
import android.net.http.Headers;
import android.os.Parcel;
import android.os.Parcelable;
import com.cdo.oaps.ad.OapsWrapper;
import com.kwai.filedownloader.e.f;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/c/c.class */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwai.filedownloader.c.c.1
        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        private static c[] dc(int i) {
            return new c[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i) {
            return dc(i);
        }
    };
    private String RZ;
    private boolean aII;
    private final AtomicInteger aIJ;
    private final AtomicLong aIK;
    private long aIL;
    private String aIM;
    private String aIN;
    private int aIO;
    private boolean aIv;
    private String filename;
    private int id;
    private String url;

    public c() {
        this.aIK = new AtomicLong();
        this.aIJ = new AtomicInteger();
    }

    protected c(Parcel parcel) {
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.RZ = parcel.readString();
        this.aII = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.aIJ = new AtomicInteger(parcel.readByte());
        this.aIK = new AtomicLong(parcel.readLong());
        this.aIL = parcel.readLong();
        this.aIM = parcel.readString();
        this.aIN = parcel.readString();
        this.aIO = parcel.readInt();
        this.aIv = parcel.readByte() != 0;
    }

    private String Ai() {
        return this.aIM;
    }

    public final boolean Gm() {
        return this.aII;
    }

    public final byte Gq() {
        return (byte) this.aIJ.get();
    }

    public final boolean Gw() {
        return this.aIv;
    }

    public final String HT() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.fB(getTargetFilePath());
    }

    public final long IB() {
        return this.aIK.get();
    }

    public final String IC() {
        return this.aIN;
    }

    public final int ID() {
        return this.aIO;
    }

    public final void IE() {
        this.aIO = 1;
    }

    public final ContentValues Iz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put(OapsWrapper.KEY_PATH, getPath());
        contentValues.put("status", Byte.valueOf(Gq()));
        contentValues.put("sofar", Long.valueOf(IB()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", Ai());
        contentValues.put(Headers.ETAG, IC());
        contentValues.put("connectionCount", Integer.valueOf(ID()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(Gm()));
        if (Gm() && getFilename() != null) {
            contentValues.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME, getFilename());
        }
        return contentValues;
    }

    public final void ao(long j) {
        this.aIK.set(j);
    }

    public final void ap(long j) {
        this.aIK.addAndGet(j);
    }

    public final void aq(long j) {
        this.aIv = j > 2147483647L;
        this.aIL = j;
    }

    public final void db(int i) {
        this.aIO = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(byte b) {
        this.aIJ.set(b);
    }

    public final void fv(String str) {
        this.aIN = str;
    }

    public final void fw(String str) {
        this.aIM = str;
    }

    public final void fx(String str) {
        this.filename = str;
    }

    public final void g(String str, boolean z) {
        this.RZ = str;
        this.aII = z;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.RZ;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), Gm(), getFilename());
    }

    public final long getTotal() {
        return this.aIL;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isChunked() {
        return this.aIL == -1;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String toString() {
        return f.j("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.RZ, Integer.valueOf(this.aIJ.get()), this.aIK, Long.valueOf(this.aIL), this.aIN, super.toString());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
