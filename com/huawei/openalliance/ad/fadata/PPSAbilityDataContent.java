package com.huawei.openalliance.ad.fadata;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/fadata/PPSAbilityDataContent.class */
public class PPSAbilityDataContent {
    private String abilityId;
    private String abilityName;
    private String appName;
    private String brief;
    private String faParams;
    private String logoUrl;
    private String moduleName;
    private String packageName;
    private String serviceName;

    public String Code() {
        return this.faParams;
    }

    public void Code(String str) {
        this.faParams = str;
    }
}
