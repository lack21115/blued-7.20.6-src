package com.opos.cmn.biz.ststrategy;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.biz.requeststatistic.InitParams;
import com.opos.cmn.biz.requeststatistic.RequestStatisticManager;
import com.opos.cmn.biz.ststrategy.b.a;
import com.opos.cmn.biz.ststrategy.c.b;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import com.opos.cmn.g.a.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/StStrategyManager.class */
public class StStrategyManager {
    private static StStrategyManager b;

    /* renamed from: c  reason: collision with root package name */
    private Context f24690c;
    private a d;

    /* renamed from: a  reason: collision with root package name */
    private static final String f24689a = StStrategyManager.class.getSimpleName();
    private static int e = 310;
    public static final String BRAND_OF_O = com.opos.cmn.biz.a.a.f24601c;
    public static final String BRAND_OF_P = com.opos.cmn.biz.a.a.f24600a;
    public static final String BRAND_OF_R = com.opos.cmn.biz.a.a.b;

    private StStrategyManager(Context context) {
        this.f24690c = null;
        this.d = null;
        this.f24690c = context;
        RequestStatisticManager.getInstance().init(this.f24690c, new InitParams.Builder().build());
        this.d = new com.opos.cmn.biz.ststrategy.a.a(this.f24690c);
    }

    public static StStrategyManager getInstance(Context context) {
        StStrategyManager stStrategyManager;
        StStrategyManager stStrategyManager2 = b;
        if (stStrategyManager2 != null) {
            return stStrategyManager2;
        }
        synchronized (StStrategyManager.class) {
            try {
                if (b != null) {
                    stStrategyManager = b;
                } else if (context == null) {
                    com.opos.cmn.an.f.a.b(f24689a, "StStrategyManager init context can not be null !");
                    throw new NullPointerException("StStrategyManager init context can not be null !");
                } else {
                    stStrategyManager = new StStrategyManager(context.getApplicationContext());
                    b = stStrategyManager;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return stStrategyManager;
    }

    public static int getStVerCode() {
        return e;
    }

    public static void setStVerCode(int i) {
        e = i;
    }

    @Deprecated
    public String getAnId(Context context) {
        return getCryptValueByKey("anId", b.a(context));
    }

    @Deprecated
    public String getCryptValueByKey(String str, String str2) {
        return str2;
    }

    @Deprecated
    public String getGUID() {
        return getCryptValueByKey("guId", com.opos.cmn.g.a.b.c(this.f24690c));
    }

    @Deprecated
    public String getImei() {
        return getCryptValueByKey("imei", c.a(this.f24690c));
    }

    public STConfigEntity getSTConfigEntity() {
        return this.d.a();
    }

    public void updateSTConfigsByDataType(String str, UpdateSTConfigListener updateSTConfigListener) {
        if (!TextUtils.isEmpty(str)) {
            this.d.a(str, updateSTConfigListener);
            return;
        }
        com.opos.cmn.an.f.a.b(f24689a, "updateParams dataType can not be null !");
        if (updateSTConfigListener != null) {
            updateSTConfigListener.onFail();
        }
        throw new Exception("please check your updateParams dataType");
    }

    public void updateSTConfigsByPkgName(UpdateParams updateParams, UpdateSTConfigListener updateSTConfigListener) {
        if (updateParams == null) {
            com.opos.cmn.an.f.a.b(f24689a, "updateParams can not be null !");
            if (updateSTConfigListener != null) {
                updateSTConfigListener.onFail();
            }
            throw new NullPointerException("updateParams can not be null !");
        } else if (!TextUtils.isEmpty(updateParams.pkgName)) {
            this.d.a(updateParams, updateSTConfigListener);
        } else {
            com.opos.cmn.an.f.a.b(f24689a, "updateParams pkgName can not be null !");
            if (updateSTConfigListener != null) {
                updateSTConfigListener.onFail();
            }
            throw new Exception("please check your updateParams pkgName");
        }
    }
}
