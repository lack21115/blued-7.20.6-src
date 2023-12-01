package com.tencent.ugc;

import android.content.Context;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.datereport.UGCDataReportDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXUGCBase.class */
public class TXUGCBase {
    private static TXUGCBaseListener mListener;
    private static TXUGCBase sInstance;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXUGCBase$TXUGCBaseListener.class */
    public static abstract class TXUGCBaseListener {
        public abstract void onLicenceLoaded(int i, String str);
    }

    static {
        com.tencent.liteav.base.util.o.a();
    }

    private TXUGCBase() {
    }

    public static TXUGCBase getInstance() {
        if (sInstance == null) {
            synchronized (TXUGCBase.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new TXUGCBase();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setListener$0(int i, String str) {
        TXUGCBaseListener tXUGCBaseListener = mListener;
        if (tXUGCBaseListener != null) {
            tXUGCBaseListener.onLicenceLoaded(i, str);
        }
        if (i == 0) {
            UGCDataReport.reportDAU(1016);
        } else {
            UGCDataReport.reportDAU(1017, i, str);
        }
    }

    public static void setListener(TXUGCBaseListener tXUGCBaseListener) {
        mListener = tXUGCBaseListener;
        LicenseChecker.getInstance().setListener(a.a());
    }

    public String getLicenceInfo(Context context) {
        return LicenseChecker.getInstance().getLicense(LicenseChecker.c.UGC);
    }

    public void setLicence(Context context, String str, String str2) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        LicenseChecker.getInstance().setLicense(LicenseChecker.c.UGC, str, str2);
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_UGCKIT);
    }
}
