package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.utils.au;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/data/RewardItem.class */
public class RewardItem implements Serializable {
    private static final long serialVersionUID = 30424300;
    int amount;
    String type;

    public RewardItem(String str, int i) {
        this.type = au.V(str);
        this.amount = i;
    }

    public String Code() {
        return this.type;
    }

    public void Code(int i) {
        this.amount = i;
    }

    public void Code(String str) {
        this.type = str;
    }

    public int V() {
        return this.amount;
    }
}
