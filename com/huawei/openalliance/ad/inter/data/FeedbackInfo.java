package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/FeedbackInfo.class */
public class FeedbackInfo implements Serializable {
    private static final long serialVersionUID = 30456300;
    private long id;
    private String label;
    private int type;

    public String Code() {
        return this.label;
    }

    public void Code(int i) {
        this.type = i;
    }

    public void Code(long j) {
        this.id = j;
    }

    public void Code(String str) {
        this.label = str;
    }

    public long I() {
        return this.id;
    }

    public int V() {
        return this.type;
    }

    public boolean Z() {
        boolean z;
        if (!TextUtils.isEmpty(this.label)) {
            int i = this.type;
            z = true;
            if (i != 1) {
                z = true;
                if (i != 2) {
                    if (i == 3) {
                        return true;
                    }
                }
            }
            return z;
        }
        z = false;
        return z;
    }
}
