package com.tencent.qmsp.sdk.a;

import com.google.android.material.timepicker.TimeModel;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/a/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f38518a;
    private boolean b;

    public g() {
        a();
    }

    private void b() {
        b(",");
    }

    private void b(String str) {
        if (this.b) {
            this.f38518a.append(str);
        }
        this.b = true;
    }

    public g a() {
        this.f38518a = new StringBuilder();
        this.b = false;
        return this;
    }

    public g a(int i) {
        return a(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i)));
    }

    public g a(String str) {
        b();
        this.f38518a.append(str.replace(',', ';'));
        return this;
    }

    public String toString() {
        return this.f38518a.toString();
    }
}
