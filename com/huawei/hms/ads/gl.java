package com.huawei.hms.ads;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gl.class */
public class gl {
    private static final String Code = "HA";
    private String C;
    private String I;
    private int S;
    private String V;
    private int Z;
    private long B = 0;
    private final StringBuilder F = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public gl(String str, int i, String str2) {
        this.V = null;
        this.I = Code;
        this.Z = 0;
        this.V = str;
        this.Z = i;
        if (str2 != null) {
            this.I = str2;
        }
        I();
    }

    private StringBuilder Code(StringBuilder sb) {
        SimpleDateFormat Code2 = com.huawei.openalliance.ad.utils.v.Code("yyyy-MM-dd HH:mm:ss.SSS");
        sb.append('[');
        sb.append(Code2.format(Long.valueOf(this.B)));
        String Code3 = gi.Code(this.Z);
        sb.append(' ');
        sb.append(Code3);
        sb.append('/');
        sb.append(this.V);
        sb.append('/');
        sb.append(this.I);
        sb.append(' ');
        sb.append(this.S);
        sb.append(':');
        sb.append(this.C);
        sb.append(']');
        return sb;
    }

    private gl I() {
        this.B = System.currentTimeMillis();
        this.C = Thread.currentThread().getName();
        this.S = Process.myPid();
        return this;
    }

    private StringBuilder V(StringBuilder sb) {
        sb.append(' ');
        sb.append((CharSequence) this.F);
        return sb;
    }

    public <T> gl Code(T t) {
        this.F.append(t);
        return this;
    }

    public gl Code(Throwable th) {
        if (th != null) {
            Code((gl) '\n').Code((gl) Log.getStackTraceString(th));
        }
        return this;
    }

    public String Code() {
        StringBuilder sb = new StringBuilder();
        Code(sb);
        return sb.toString();
    }

    public String V() {
        StringBuilder sb = new StringBuilder();
        V(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Code(sb);
        V(sb);
        return sb.toString();
    }
}
