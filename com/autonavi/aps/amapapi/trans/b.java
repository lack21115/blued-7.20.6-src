package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.3sl.hv;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/trans/b.class */
public final class b extends hv {

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f6429a = null;
    Map<String, String> b = null;
    String g = "";
    byte[] h = null;
    private String i = null;

    public final void a(String str) {
        this.g = str;
    }

    public final void a(Map<String, String> map) {
        this.f6429a = map;
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

    public final byte[] getEntityBytes() {
        return this.h;
    }

    public final String getIPV6URL() {
        return !TextUtils.isEmpty(this.i) ? this.i : super.getIPV6URL();
    }

    public final Map<String, String> getParams() {
        return this.b;
    }

    public final Map<String, String> getRequestHead() {
        return this.f6429a;
    }

    public final String getURL() {
        return this.g;
    }
}
