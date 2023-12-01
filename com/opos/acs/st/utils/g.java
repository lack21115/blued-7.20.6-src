package com.opos.acs.st.utils;

import android.content.Context;
import com.opos.cmn.biz.ststrategy.StStrategyManager;
import com.opos.cmn.biz.ststrategy.UpdateParams;
import com.opos.cmn.biz.ststrategy.entity.STConfigEntity;
import com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/utils/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile StStrategyManager f10782a;
    private static final byte[] b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static AtomicBoolean f10783c = new AtomicBoolean(false);

    public static void a(Context context) {
        if (context != null) {
            try {
                a(context, context.getPackageName());
            } catch (Exception e) {
                d.b("StrategyUtil", "", e);
            }
        }
    }

    public static void a(final Context context, final String str) {
        if (context != null) {
            try {
                f10783c.set(true);
                StStrategyManager.setStVerCode(330);
                c(context).updateSTConfigsByPkgName(new UpdateParams.Builder().setPkgName(str).build(), new UpdateSTConfigListener() { // from class: com.opos.acs.st.utils.g.1
                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onFail() {
                        g.f10783c.set(false);
                        d.a("StrategyUtil", "onFail pkgName:" + str);
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onNotNeedUpdate() {
                        g.f10783c.set(false);
                        d.a("StrategyUtil", "onNotNeedUpdate pkgName:" + str);
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onSuccess() {
                        d.a("StrategyUtil", "onSuccess pkgName:" + str);
                        g.f10783c.set(false);
                        h.h(context);
                        h.g(context);
                    }
                });
            } catch (Exception e) {
                f10783c.set(false);
                d.b("StrategyUtil", "", e);
            }
        }
    }

    public static STConfigEntity b(Context context) {
        STConfigEntity sTConfigEntity;
        STConfigEntity sTConfigEntity2 = null;
        if (context != null) {
            try {
                sTConfigEntity = c(context).getSTConfigEntity();
            } catch (Exception e) {
                d.b("StrategyUtil", "", e);
                sTConfigEntity = null;
            }
            sTConfigEntity2 = sTConfigEntity;
            if (sTConfigEntity == null) {
                d.a("StrategyUtil", "get stConfigEntity == null");
                sTConfigEntity2 = sTConfigEntity;
            }
        }
        return sTConfigEntity2;
    }

    public static void b(final Context context, final String str) {
        d.a("StrategyUtil", "update STConfigs By DataType");
        if (context != null) {
            try {
                if (f10783c.get()) {
                    d.a("StrategyUtil", "is not init success");
                    return;
                }
                StStrategyManager.setStVerCode(330);
                c(context).updateSTConfigsByDataType(str, new UpdateSTConfigListener() { // from class: com.opos.acs.st.utils.g.2
                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onFail() {
                        d.a("StrategyUtil", "onFail dataType:" + str);
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onNotNeedUpdate() {
                        d.a("StrategyUtil", "onNotNeedUpdate dataType:" + str);
                    }

                    @Override // com.opos.cmn.biz.ststrategy.listener.UpdateSTConfigListener
                    public final void onSuccess() {
                        d.a("StrategyUtil", "onSuccess dataType:" + str);
                        h.h(context);
                        h.g(context);
                    }
                });
            } catch (Exception e) {
                d.c("StrategyUtil", "", e);
            }
        }
    }

    private static StStrategyManager c(Context context) {
        if (f10782a == null) {
            synchronized (b) {
                if (f10782a == null) {
                    f10782a = StStrategyManager.getInstance(context);
                }
            }
        }
        return f10782a;
    }
}
