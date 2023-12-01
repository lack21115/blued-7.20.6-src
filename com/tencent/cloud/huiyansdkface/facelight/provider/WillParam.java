package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/provider/WillParam.class */
public class WillParam implements Parcelable {
    public static final Parcelable.Creator<WillParam> CREATOR = new Parcelable.Creator<WillParam>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WillParam.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WillParam createFromParcel(Parcel parcel) {
            return new WillParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WillParam[] newArray(int i) {
            return new WillParam[i];
        }
    };
    private String A;
    private String B;

    /* renamed from: a  reason: collision with root package name */
    private int f21966a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f21967c;
    private int d;
    private int e;
    private float f;
    private float g;
    private float h;
    private float i;
    private boolean j;
    private boolean k;
    private boolean l;
    private float m;
    private float n;
    private float o;
    private double p;
    private long q;
    private long r;
    private long s;
    private float t;
    private int u;
    private int v;
    private int w;
    private int x;
    private String y;
    private String z;

    public WillParam() {
    }

    protected WillParam(Parcel parcel) {
        this.f21966a = parcel.readInt();
        this.b = parcel.readInt();
        this.f21967c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readFloat();
        this.g = parcel.readFloat();
        this.h = parcel.readFloat();
        this.i = parcel.readFloat();
        this.j = parcel.readByte() != 0;
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readFloat();
        this.n = parcel.readFloat();
        this.o = parcel.readFloat();
        this.p = parcel.readDouble();
        this.q = parcel.readLong();
        this.r = parcel.readLong();
        this.s = parcel.readLong();
        this.t = parcel.readFloat();
        this.u = parcel.readInt();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAnswer() {
        return this.A;
    }

    public int getAsrCurCount() {
        return this.w;
    }

    public int getAsrRequestRetryCount() {
        return this.v;
    }

    public int getAsrRequestTimeout() {
        return this.u;
    }

    public int getAsrRetryCount() {
        return this.x;
    }

    public String getAudio() {
        return this.B;
    }

    public float getBorderTop() {
        return this.h;
    }

    public int getCamHeight() {
        return this.b;
    }

    public int getCamRotate() {
        return this.f21967c;
    }

    public int getCamWidth() {
        return this.f21966a;
    }

    public float getLeft() {
        return this.f;
    }

    public float getLowestPlayVolThre() {
        return this.n;
    }

    public double getMuteThreshold() {
        return this.p;
    }

    public long getMuteTimeout() {
        return this.q;
    }

    public long getMuteWaitTime() {
        return this.r;
    }

    public long getPlayModeWaitTime() {
        return this.s;
    }

    public float getPlayVolThreshold() {
        return this.m;
    }

    public int getPreviewPicHeight() {
        return this.e;
    }

    public int getPreviewPicWidth() {
        return this.d;
    }

    public String getQuestion() {
        return this.z;
    }

    public float getScale() {
        return this.i;
    }

    public float getScreenshotTime() {
        return this.o;
    }

    public float getTop() {
        return this.g;
    }

    public String getWillType() {
        return this.y;
    }

    public float getWillVideoBitrateFactor() {
        return this.t;
    }

    public boolean isPassVolCheck() {
        return this.l;
    }

    public boolean isRecordWillVideo() {
        return this.j;
    }

    public boolean isScreenshot() {
        return this.k;
    }

    public WillParam setAnswer(String str) {
        this.A = str;
        return this;
    }

    public WillParam setAsrCurCount(int i) {
        this.w = i;
        return this;
    }

    public WillParam setAsrRequestRetryCount(int i) {
        this.v = i;
        return this;
    }

    public WillParam setAsrRequestTimeout(int i) {
        this.u = i;
        return this;
    }

    public WillParam setAsrRetryCount(int i) {
        this.x = i;
        return this;
    }

    public WillParam setAudio(String str) {
        this.B = str;
        return this;
    }

    public WillParam setBorderTop(float f) {
        this.h = f;
        return this;
    }

    public WillParam setCamHeight(int i) {
        this.b = i;
        return this;
    }

    public WillParam setCamRotate(int i) {
        this.f21967c = i;
        return this;
    }

    public WillParam setCamWidth(int i) {
        this.f21966a = i;
        return this;
    }

    public WillParam setLeft(float f) {
        this.f = f;
        return this;
    }

    public WillParam setLowestPlayVolThre(float f) {
        this.n = f;
        return this;
    }

    public WillParam setMuteThreshold(double d) {
        this.p = d;
        return this;
    }

    public WillParam setMuteTimeout(long j) {
        this.q = j;
        return this;
    }

    public WillParam setMuteWaitTime(long j) {
        this.r = j;
        return this;
    }

    public WillParam setPassVolCheck(boolean z) {
        this.l = z;
        return this;
    }

    public WillParam setPlayModeWaitTime(long j) {
        this.s = j;
        return this;
    }

    public WillParam setPlayVolThreshold(float f) {
        this.m = f;
        return this;
    }

    public WillParam setPreviewPicHeight(int i) {
        this.e = i;
        return this;
    }

    public WillParam setPreviewPicWidth(int i) {
        this.d = i;
        return this;
    }

    public WillParam setQuestion(String str) {
        this.z = str;
        return this;
    }

    public WillParam setRecordWillVideo(boolean z) {
        this.j = z;
        return this;
    }

    public WillParam setScale(float f) {
        this.i = f;
        return this;
    }

    public WillParam setScreenshot(boolean z) {
        this.k = z;
        return this;
    }

    public WillParam setScreenshotTime(float f) {
        this.o = f;
        return this;
    }

    public WillParam setTop(float f) {
        this.g = f;
        return this;
    }

    public WillParam setWillType(String str) {
        this.y = str;
        return this;
    }

    public WillParam setWillVideoBitrateFactor(float f) {
        this.t = f;
        return this;
    }

    public String toString() {
        return "WillParam{camWidth=" + this.f21966a + ", camHeight=" + this.b + ", camRotate=" + this.f21967c + ", previewPicWidth=" + this.d + ", previewPicHeight=" + this.e + ", left=" + this.f + ", top=" + this.g + ", borderTop=" + this.h + ", scale=" + this.i + ", isRecordWillVideo=" + this.j + ", screenshot=" + this.k + ", isPassVolCheck=" + this.l + ", playVolThreshold=" + this.m + ", lowestPlayVolThre=" + this.n + ", screenshotTime=" + this.o + ", muteThreshold=" + this.p + ", muteTimeout=" + this.q + ", muteWaitTime=" + this.r + ", playModeWaitTime=" + this.s + ", willVideoBitrateFactor=" + this.t + ", asrRequestTimeout=" + this.u + ", asrRequestRetryCount=" + this.v + ", asrCurCount=" + this.w + ", asrRetryCount=" + this.x + ", willType='" + this.y + "', question='" + this.z + "', answer='" + this.A + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f21966a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f21967c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeFloat(this.g);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.i);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.m);
        parcel.writeFloat(this.n);
        parcel.writeFloat(this.o);
        parcel.writeDouble(this.p);
        parcel.writeLong(this.q);
        parcel.writeLong(this.r);
        parcel.writeLong(this.s);
        parcel.writeFloat(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }
}
