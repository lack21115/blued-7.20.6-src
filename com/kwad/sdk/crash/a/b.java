package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/a/b.class */
public final class b {
    private Set<String> arm = new HashSet();
    private Set<String> arn = new HashSet();

    public final void a(String[] strArr, String[] strArr2) {
        synchronized (this) {
            if (strArr != null) {
                if (strArr.length > 0) {
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        String str = strArr[i2];
                        if (!TextUtils.isEmpty(str)) {
                            this.arm.add(str);
                        }
                        i = i2 + 1;
                    }
                }
            }
            if (strArr2 != null && strArr2.length > 0) {
                int length2 = strArr2.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    String str2 = strArr2[i4];
                    if (!TextUtils.isEmpty(str2)) {
                        this.arn.add(str2);
                    }
                    i3 = i4 + 1;
                }
            }
        }
    }

    public final String[] zA() {
        String[] strArr;
        synchronized (this) {
            strArr = (String[]) this.arn.toArray(new String[this.arn.size()]);
        }
        return strArr;
    }

    public final String[] zM() {
        String[] strArr;
        synchronized (this) {
            strArr = (String[]) this.arm.toArray(new String[this.arm.size()]);
        }
        return strArr;
    }
}
