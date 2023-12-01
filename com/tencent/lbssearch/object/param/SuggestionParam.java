package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.map.tools.Util;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.umeng.analytics.pro.bh;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/SuggestionParam.class */
public class SuggestionParam implements ParamObject {
    private static final String FILTER = "filter";
    private static final String KEYWORD = "keyword";
    private static final String REGION = "region";
    private String addressFormat;
    private String filter;
    private int isGetSubPois;
    private String keyword;
    private LatLng location;
    private int pageIndex;
    private int pageSize;
    private int policy;
    private String region;
    private int regionFix;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/SuggestionParam$AddressFormat.class */
    public enum AddressFormat {
        SHORT(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT);
        
        public String value;

        AddressFormat(String str) {
            this.value = str;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/SuggestionParam$Policy.class */
    public enum Policy {
        DEF(0),
        O2O(1),
        TRIP_START(10),
        TRIP_END(11);
        
        public int value;

        Policy(int i) {
            this.value = i;
        }
    }

    public SuggestionParam() {
    }

    public SuggestionParam(String str, String str2) {
        this.keyword = str;
        this.region = str2;
    }

    public SuggestionParam addressFormat(AddressFormat addressFormat) {
        this.addressFormat = addressFormat.value;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        int i;
        RequestParams requestParams = new RequestParams();
        if (!TextUtils.isEmpty(this.keyword)) {
            requestParams.add(KEYWORD, this.keyword);
        }
        if (!TextUtils.isEmpty(this.region)) {
            requestParams.add("region", this.region);
        }
        if (!TextUtils.isEmpty(this.filter)) {
            requestParams.add(FILTER, this.filter);
        }
        requestParams.add("region_fix", this.regionFix + "");
        if (this.location != null) {
            requestParams.add("location", this.location.latitude + "," + this.location.longitude);
        }
        requestParams.add("get_subpois", this.isGetSubPois + "");
        requestParams.add(bh.bt, this.policy + "");
        if (!TextUtils.isEmpty(this.addressFormat)) {
            requestParams.add("address_format", this.addressFormat);
        }
        int i2 = this.pageIndex;
        if (i2 > 0 && i2 <= 20 && (i = this.pageSize) > 0 && i <= 20) {
            requestParams.add("page_index", this.pageIndex + "");
            requestParams.add("page_size", this.pageSize + "");
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return (TextUtils.isEmpty(this.keyword) || TextUtils.isEmpty(this.region)) ? false : true;
    }

    public SuggestionParam filter(String... strArr) {
        this.filter = Util.filterBuilder(strArr);
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public SuggestionParam getSubPois(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public SuggestionParam keyword(String str) {
        this.keyword = str;
        return this;
    }

    public SuggestionParam location(LatLng latLng) {
        this.location = latLng;
        return this;
    }

    public SuggestionParam pageIndex(int i) {
        this.pageIndex = i;
        return this;
    }

    public SuggestionParam pageSize(int i) {
        this.pageSize = i;
        return this;
    }

    public SuggestionParam policy(Policy policy) {
        this.policy = policy.value;
        return this;
    }

    public SuggestionParam region(String str) {
        this.region = str;
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public SuggestionParam regionFix(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
