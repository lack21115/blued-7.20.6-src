package com.cdo.oaps.ad.wrapper.download;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.ai;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/download/DownloadRespWrapper.class */
public class DownloadRespWrapper extends ai {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7943a = "dl_st";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7944c = "dl_tlen";
    private static final String d = "dl_perc";
    private static final String e = "dl_sp";
    private static final String f = "dl_error_code";

    protected DownloadRespWrapper(Map<String, Object> map) {
        super(map);
    }

    public static DownloadRespWrapper wrapper(Map<String, Object> map) {
        return new DownloadRespWrapper(map);
    }

    public int getErrorCode() {
        try {
            return getInt(f);
        } catch (ag e2) {
            return -1;
        }
    }

    public float getPercent() {
        try {
            return getFloat(d);
        } catch (ag e2) {
            return -1.0f;
        }
    }

    public String getPkgName() {
        try {
            return (String) get("pkg");
        } catch (ag e2) {
            return "";
        }
    }

    public long getSpeed() {
        try {
            return getLong(e);
        } catch (ag e2) {
            return -1L;
        }
    }

    public int getStatus() {
        try {
            return getInt(f7943a);
        } catch (ag e2) {
            return -1;
        }
    }

    public long getTotalLength() {
        try {
            return getLong(f7944c);
        } catch (ag e2) {
            return -1L;
        }
    }

    public DownloadRespWrapper setErrorCode(int i) {
        return (DownloadRespWrapper) set(f, Integer.valueOf(i));
    }

    public DownloadRespWrapper setPercent(float f2) {
        return (DownloadRespWrapper) set(d, Float.valueOf(f2));
    }

    public DownloadRespWrapper setPkgName(String str) {
        return (DownloadRespWrapper) set("pkg", str);
    }

    public DownloadRespWrapper setSpeed(long j) {
        return (DownloadRespWrapper) set(e, Long.valueOf(j));
    }

    public DownloadRespWrapper setStatus(int i) {
        return (DownloadRespWrapper) set(f7943a, Integer.valueOf(i));
    }

    public DownloadRespWrapper setTotalLength(long j) {
        return (DownloadRespWrapper) set(f7944c, Long.valueOf(j));
    }
}
