package com.tencent.ugc;

import com.tencent.ugc.TXRecordCommon;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ef.class */
final /* synthetic */ class ef implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f40349a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40350c;
    private final String d;
    private final TXRecordCommon.ITXVideoRecordListener e;

    private ef(int i, String str, String str2, String str3, TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.f40349a = i;
        this.b = str;
        this.f40350c = str2;
        this.d = str3;
        this.e = iTXVideoRecordListener;
    }

    public static Runnable a(int i, String str, String str2, String str3, TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        return new ef(i, str, str2, str3, iTXVideoRecordListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCRecorderJni.lambda$onRecordComplete$1(this.f40349a, this.b, this.f40350c, this.d, this.e);
    }
}
