package com.huawei.openalliance.ad.fadata;

import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/fadata/PPSAbilityResult.class */
public class PPSAbilityResult {
    private ArrayList<PPSAbilityData> abilityDatas;
    private String intentSn;

    public String Code() {
        return this.intentSn;
    }

    public void Code(String str) {
        this.intentSn = str;
    }

    public void Code(ArrayList<PPSAbilityData> arrayList) {
        this.abilityDatas = arrayList;
    }

    public ArrayList<PPSAbilityData> V() {
        return this.abilityDatas;
    }
}
