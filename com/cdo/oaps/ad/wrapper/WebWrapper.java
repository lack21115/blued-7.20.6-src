package com.cdo.oaps.ad.wrapper;

import android.net.Uri;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/WebWrapper.class */
public class WebWrapper extends BaseWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7940a = "wtic";

    protected WebWrapper(Map<String, Object> map) {
        super(map);
    }

    public static WebWrapper wrapper(Map<String, Object> map) {
        return new WebWrapper(map);
    }

    public String getHybrid() {
        try {
            return Uri.decode((String) get("hb"));
        } catch (ag e) {
            return "";
        }
    }

    public String getTitle() {
        try {
            return (String) get("t");
        } catch (ag e) {
            return "";
        }
    }

    public String getUrl() {
        try {
            return Uri.decode((String) get("u"));
        } catch (ag e) {
            return "";
        }
    }

    public int getWebTitleIconColor() {
        try {
            return getInt(f7940a);
        } catch (ag e) {
            return 0;
        }
    }

    public WebWrapper setHybrid(String str) {
        return (WebWrapper) set("hb", Uri.encode(str));
    }

    public WebWrapper setTitle(String str) {
        return (WebWrapper) set("t", str);
    }

    public WebWrapper setUrl(String str) {
        return (WebWrapper) set("u", Uri.encode(str));
    }

    public WebWrapper setWebTitleIconColor(int i) {
        return (WebWrapper) set(f7940a, Integer.valueOf(i));
    }
}
