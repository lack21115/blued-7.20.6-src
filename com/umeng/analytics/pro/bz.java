package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cj;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bz.class */
public class bz {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f26984a;
    private final db b;

    /* renamed from: c  reason: collision with root package name */
    private cp f26985c;

    public bz() {
        this(new cj.a());
    }

    public bz(cr crVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f26984a = byteArrayOutputStream;
        db dbVar = new db(byteArrayOutputStream);
        this.b = dbVar;
        this.f26985c = crVar.a(dbVar);
    }

    public String a(bq bqVar, String str) throws bw {
        try {
            return new String(a(bqVar), str);
        } catch (UnsupportedEncodingException e) {
            throw new bw("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public byte[] a(bq bqVar) throws bw {
        this.f26984a.reset();
        bqVar.write(this.f26985c);
        return this.f26984a.toByteArray();
    }

    public String b(bq bqVar) throws bw {
        return new String(a(bqVar));
    }
}
