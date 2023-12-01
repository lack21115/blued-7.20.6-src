package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.p0003sl.hv;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/trans/b.class */
public final class b extends hv {

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f9269a = null;
    Map<String, String> b = null;
    String g = "";
    byte[] h = null;
    private String i = null;

    public final void a(String str) {
        this.g = str;
    }

    public final void a(Map<String, String> map) {
        this.f9269a = map;
    }

    public final void a(byte[] bArr) {
        this.h = bArr;
    }

    public final void b(String str) {
        this.i = str;
    }

    public final void b(Map<String, String> map) {
        this.b = map;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final byte[] getEntityBytes() {
        return this.h;
    }

    @Override // com.amap.api.col.p0003sl.hv, com.amap.api.col.p0003sl.kb
    public final String getIPV6URL() {
        return !TextUtils.isEmpty(this.i) ? this.i : super.getIPV6URL();
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        return this.b;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final Map<String, String> getRequestHead() {
        return this.f9269a;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return this.g;
    }
}
