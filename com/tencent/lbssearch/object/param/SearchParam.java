package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.map.tools.Util;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/SearchParam.class */
public class SearchParam implements ParamObject {
    private static final String BOUNDARY = "boundary";
    private static final String DISTANCE_ASCE = "_distance";
    private static final String DISTANCE_DESC = "_distance desc";
    private static final String FILTER = "filter";
    private static final String GET_SUBPOIS = "get_subpois";
    private static final String KEYWORD = "keyword";
    private static final String NEARBY = "nearby";
    private static final String ORDERBY = "orderby";
    private static final String PAGE_INDEX = "page_index";
    private static final String PAGE_SIZE = "page_size";
    private static final String RECTANGLE = "rectangle";
    private static final String REGION = "region";
    private Boundary boundary;
    private String filter;
    private String keyword;
    private boolean distance_order = true;
    private int page_size = -1;
    private int page_index = 1;
    private int get_subpois = 0;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/SearchParam$Boundary.class */
    public interface Boundary {
        String toString();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/SearchParam$Nearby.class */
    public static class Nearby implements Boundary {
        private boolean autoExtend = true;
        private LatLng point;
        private int radius;

        public Nearby() {
        }

        public Nearby(LatLng latLng, int i) {
            this.point = latLng;
            this.radius = i;
        }

        public Nearby autoExtend(boolean z) {
            this.autoExtend = z;
            return this;
        }

        public Nearby point(LatLng latLng) {
            this.point = latLng;
            return this;
        }

        public Nearby r(int i) {
            this.radius = i;
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.tencent.lbssearch.object.param.SearchParam.Boundary
        public String toString() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/SearchParam$Rectangle.class */
    public static class Rectangle implements Boundary {
        private LatLng leftBottom;
        private LatLng rightTop;

        public Rectangle() {
        }

        public Rectangle(LatLng latLng, LatLng latLng2) {
            this.leftBottom = latLng;
            this.rightTop = latLng2;
        }

        public Rectangle point(LatLng latLng, LatLng latLng2) {
            this.leftBottom = latLng;
            this.rightTop = latLng2;
            return this;
        }

        @Override // com.tencent.lbssearch.object.param.SearchParam.Boundary
        public String toString() {
            return "rectangle(" + this.leftBottom.latitude + "," + this.leftBottom.longitude + "," + this.rightTop.latitude + "," + this.rightTop.longitude + ")";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/SearchParam$Region.class */
    public static class Region implements Boundary {
        private boolean autoExtend = false;
        private String city;
        private LatLng latLng;

        public Region() {
        }

        public Region(String str) {
            this.city = str;
        }

        public Region autoExtend(boolean z) {
            this.autoExtend = z;
            return this;
        }

        public Region center(LatLng latLng) {
            this.latLng = latLng;
            return this;
        }

        public Region poi(String str) {
            this.city = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.tencent.lbssearch.object.param.SearchParam.Boundary
        public String toString() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    public SearchParam() {
    }

    public SearchParam(String str, Boundary boundary) {
        this.keyword = str;
        this.boundary = boundary;
    }

    public SearchParam boundary(Boundary boundary) {
        this.boundary = boundary;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams requestParams = new RequestParams();
        if (!TextUtils.isEmpty(this.keyword)) {
            requestParams.add(KEYWORD, this.keyword);
        }
        Boundary boundary = this.boundary;
        if (boundary != null) {
            requestParams.add(BOUNDARY, boundary.toString());
        }
        if (!TextUtils.isEmpty(this.filter)) {
            requestParams.add(FILTER, this.filter);
        }
        requestParams.add(ORDERBY, this.distance_order ? DISTANCE_ASCE : DISTANCE_DESC);
        int i = this.page_size;
        if (i > 0) {
            requestParams.add(PAGE_SIZE, String.valueOf(i));
        }
        int i2 = this.page_index;
        if (i2 > 0) {
            requestParams.add(PAGE_INDEX, String.valueOf(i2));
        }
        requestParams.add(GET_SUBPOIS, String.valueOf(this.get_subpois));
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        return (TextUtils.isEmpty(this.keyword) || this.boundary == null) ? false : true;
    }

    public SearchParam filter(String... strArr) {
        this.filter = Util.filterBuilder(strArr);
        return this;
    }

    public SearchParam keyword(String str) {
        this.keyword = str;
        return this;
    }

    public SearchParam orderby(boolean z) {
        this.distance_order = z;
        return this;
    }

    public SearchParam pageIndex(int i) {
        this.page_index = i;
        return this;
    }

    public SearchParam pageSize(int i) {
        this.page_size = i;
        return this;
    }

    public SearchParam page_index(int i) {
        this.page_index = i;
        return this;
    }

    public SearchParam page_size(int i) {
        this.page_size = i;
        return this;
    }

    public SearchParam region(Region region) {
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public SearchParam subPois(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
