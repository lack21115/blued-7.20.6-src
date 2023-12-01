package com.huawei.openalliance.ad.uriaction;

import com.huawei.hag.abilitykit.entities.CallerInfo;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.fadata.PPSAbilityData;
import com.huawei.openalliance.ad.fadata.PPSAbilityDataContent;
import com.huawei.openalliance.ad.fadata.PPSAbilityResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/RequestMsgBuilder.class */
public class RequestMsgBuilder {
    private static String FA_VERSION = "2.0";
    private List<PPSAbilityResult> abilityInfos;
    private CallerInfo callerInfo;
    private String version;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/RequestMsgBuilder$a.class */
    public static class a {
        private static String Code;
        private static List<PPSAbilityResult> I = new ArrayList(1);
        private static String V;

        public a Code(PPSAbilityDataContent pPSAbilityDataContent) {
            PPSAbilityData pPSAbilityData = new PPSAbilityData();
            pPSAbilityData.Code(t.cB);
            pPSAbilityData.Code(new ArrayList(Arrays.asList(pPSAbilityDataContent)));
            PPSAbilityResult pPSAbilityResult = new PPSAbilityResult();
            pPSAbilityResult.Code("1");
            pPSAbilityResult.Code(new ArrayList<>(Arrays.asList(pPSAbilityData)));
            I.add(0, pPSAbilityResult);
            return this;
        }

        public a Code(String str) {
            Code = str;
            return this;
        }

        public RequestMsgBuilder Code() {
            return new RequestMsgBuilder(this);
        }

        public a V(String str) {
            V = str;
            return this;
        }
    }

    private RequestMsgBuilder(a aVar) {
        CallerInfo callerInfo = new CallerInfo();
        this.version = FA_VERSION;
        callerInfo.setPackageName(a.Code);
        callerInfo.setBusinessPkgName(a.V);
        this.callerInfo = callerInfo;
        this.abilityInfos = a.I;
    }
}
