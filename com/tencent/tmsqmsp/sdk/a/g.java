package com.tencent.tmsqmsp.sdk.a;

import com.google.android.material.timepicker.TimeModel;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/a/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f25986a;
    private boolean b;

    public g() {
        a();
    }

    private void b() {
        b(",");
    }

    private void b(String str) {
        if (this.b) {
            this.f25986a.append(str);
        }
        this.b = true;
    }

    public g a() {
        this.f25986a = new StringBuilder();
        this.b = false;
        return this;
    }

    public g a(int i) {
        return a(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i)));
    }

    public g a(String str) {
        b();
        this.f25986a.append(str.replace(',', ';'));
        return this;
    }

    public String toString() {
        return this.f25986a.toString();
    }
}
