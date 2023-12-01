package com.cdo.oaps.ad.wrapper.download;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/wrapper/download/DownloadReqWrapper.class */
public class DownloadReqWrapper extends ResourceWrapper {
    public static final int TYPE_CANCEL = 3;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_PAUSE = 2;
    public static final int TYPE_QUERY = 4;
    public static final int TYPE_REGISTER_OBSERVER = 5;
    public static final int TYPE_RESERVE = 7;
    public static final int TYPE_UNREGISTER_OBSERVER = 6;

    /* renamed from: a  reason: collision with root package name */
    private static final String f21547a = "dtp";

    /* renamed from: c  reason: collision with root package name */
    private static final String f21548c = "dsp";
    private static final String d = "dada";
    private static final String e = "dmc";

    protected DownloadReqWrapper(Map<String, Object> map) {
        super(map);
    }

    public static DownloadReqWrapper wrapper(Map<String, Object> map) {
        return new DownloadReqWrapper(map);
    }

    public boolean getAutoDelApk() {
        try {
            return 1 == getInt(d);
        } catch (ag e2) {
            return true;
        }
    }

    public int getDownloadMaxCount() {
        try {
            return getInt(e);
        } catch (ag e2) {
            return 2;
        }
    }

    public int getDownloadType() {
        try {
            return getInt(f21547a);
        } catch (ag e2) {
            return -1;
        }
    }

    public String getSaveDir() {
        try {
            return (String) get(f21548c);
        } catch (ag e2) {
            return "";
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public DownloadReqWrapper setAutoDelApk(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public DownloadReqWrapper setDownloadMaxCount(int i) {
        return (DownloadReqWrapper) set(e, Integer.valueOf(i));
    }

    public DownloadReqWrapper setDownloadType(int i) {
        return (DownloadReqWrapper) set(f21547a, Integer.valueOf(i));
    }

    public DownloadReqWrapper setSaveDir(String str) {
        return (DownloadReqWrapper) set(f21548c, str);
    }
}
