package com.huawei.openalliance.ad.fadata;

import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/fadata/PPSAbilityData.class */
public class PPSAbilityData {
    private List<PPSAbilityDataContent> abilityDataContent;
    private String displayForm;

    public String Code() {
        return this.displayForm;
    }

    public void Code(String str) {
        this.displayForm = str;
    }

    public void Code(List<PPSAbilityDataContent> list) {
        this.abilityDataContent = list;
    }

    public List<PPSAbilityDataContent> V() {
        return this.abilityDataContent;
    }
}
