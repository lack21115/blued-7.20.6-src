package com.airbnb.lottie.model;

import com.android.internal.telephony.PhoneConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/KeyPath.class */
public class KeyPath {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f4323a;
    private KeyPathElement b;

    private KeyPath(KeyPath keyPath) {
        this.f4323a = new ArrayList(keyPath.f4323a);
        this.b = keyPath.b;
    }

    public KeyPath(String... strArr) {
        this.f4323a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.f4323a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    public KeyPath a(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.b = keyPathElement;
        return keyPath;
    }

    public KeyPath a(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f4323a.add(str);
        return keyPath;
    }

    public KeyPathElement a() {
        return this.b;
    }

    public boolean a(String str, int i) {
        if (b(str)) {
            return true;
        }
        if (i >= this.f4323a.size()) {
            return false;
        }
        return this.f4323a.get(i).equals(str) || this.f4323a.get(i).equals("**") || this.f4323a.get(i).equals(PhoneConstants.APN_TYPE_ALL);
    }

    public int b(String str, int i) {
        if (b(str)) {
            return 0;
        }
        if (this.f4323a.get(i).equals("**")) {
            return (i != this.f4323a.size() - 1 && this.f4323a.get(i + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        if (b() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e8, code lost:
        if (b() != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(java.lang.String r5, int r6) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.KeyPath.c(java.lang.String, int):boolean");
    }

    public boolean d(String str, int i) {
        boolean z = true;
        if ("__container".equals(str)) {
            return true;
        }
        if (i >= this.f4323a.size() - 1) {
            if (this.f4323a.get(i).equals("**")) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f4323a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }
}
