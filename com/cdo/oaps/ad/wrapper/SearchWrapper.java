package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/SearchWrapper.class */
public class SearchWrapper extends BaseWrapper {

    /* renamed from: a  reason: collision with root package name */
    private String f21542a;

    /* renamed from: c  reason: collision with root package name */
    private String f21543c;
    private String d;
    private String e;

    protected SearchWrapper(Map<String, Object> map) {
        super(map);
        this.f21542a = "sfl";
        this.f21543c = "shi";
        this.d = "sfr";
        this.e = "sfi";
    }

    public static SearchWrapper wrapper(Map<String, Object> map) {
        return new SearchWrapper(map);
    }

    public boolean getAutoDown() {
        try {
            return getBoolean("ad");
        } catch (ag e) {
            return false;
        }
    }

    public String getChannelPkg() {
        try {
            return (String) get(OapsKey.KEY_CHANEL_PKG);
        } catch (ag e) {
            return "";
        }
    }

    public String getKeyword() {
        try {
            return (String) get(OapsKey.KEY_KEYWORD);
        } catch (ag e) {
            return "";
        }
    }

    public String getPkgName() {
        try {
            return (String) get("pkg");
        } catch (ag e) {
            return "";
        }
    }

    public String getSearchFlag() {
        try {
            return (String) get(this.f21542a);
        } catch (ag e) {
            return "";
        }
    }

    public String getSearchFrom() {
        try {
            return (String) get(this.d);
        } catch (ag e) {
            return "";
        }
    }

    public String getSearchFromId() {
        try {
            return (String) get(this.e);
        } catch (ag e) {
            return "";
        }
    }

    public String getSearchHint() {
        try {
            return (String) get(this.f21543c);
        } catch (ag e) {
            return "";
        }
    }

    public String getTraceId() {
        try {
            return (String) get("traceId");
        } catch (ag e) {
            return "";
        }
    }

    public SearchWrapper setAutoDown(boolean z) {
        return (SearchWrapper) set("ad", Boolean.valueOf(z));
    }

    public SearchWrapper setChannelPkg(String str) {
        return (SearchWrapper) set(OapsKey.KEY_CHANEL_PKG, str);
    }

    public SearchWrapper setKeyword(String str) {
        return (SearchWrapper) set(OapsKey.KEY_KEYWORD, str);
    }

    public SearchWrapper setPkgName(String str) {
        return (SearchWrapper) set("pkg", str);
    }

    public SearchWrapper setSearchFlag(String str) {
        return (SearchWrapper) set(this.f21542a, str);
    }

    public SearchWrapper setSearchFrom(String str) {
        return (SearchWrapper) set(this.d, str);
    }

    public SearchWrapper setSearchFromId(String str) {
        return (SearchWrapper) set(this.e, str);
    }

    public SearchWrapper setSearchHint(String str) {
        return (SearchWrapper) set(this.f21543c, str);
    }

    public ResourceWrapper setTraceId(String str) {
        return (ResourceWrapper) set("traceId", str);
    }
}
