package mtopsdk.mtop.features;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/features/MtopFeatureManager.class */
public final class MtopFeatureManager {

    /* renamed from: a  reason: collision with root package name */
    private static Map f43753a = new HashMap();

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/features/MtopFeatureManager$MtopFeatureEnum.class */
    public enum MtopFeatureEnum {
        SUPPORT_RELATIVE_URL(1),
        UNIT_INFO_FEATURE(2),
        DISABLE_WHITEBOX_SIGN(3),
        SUPPORT_UTDID_UNIT(4),
        DISABLE_X_COMMAND(5),
        SUPPORT_OPEN_ACCOUNT(6);
        
        long g;

        MtopFeatureEnum(long j) {
            this.g = j;
        }

        public final long a() {
            return this.g;
        }
    }

    static {
        a(MtopFeatureEnum.UNIT_INFO_FEATURE, true);
        a(MtopFeatureEnum.SUPPORT_UTDID_UNIT, true);
        a(MtopFeatureEnum.DISABLE_X_COMMAND, true);
    }

    public static long a() {
        long j;
        long j2 = 0;
        if (f43753a.isEmpty()) {
            return 0L;
        }
        long j3 = 0;
        try {
            Iterator it = f43753a.entrySet().iterator();
            while (true) {
                j3 = j2;
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                long j4 = j2;
                Map.Entry entry = (Map.Entry) it.next();
                long j5 = j2;
                if (((Boolean) entry.getValue()).booleanValue()) {
                    long j6 = j2;
                    j2 |= a((MtopFeatureEnum) entry.getKey());
                }
            }
        } catch (Exception e) {
            TBSdkLog.c("mtopsdk.MtopFeatureManager", "[getMtopTotalFeatures] get mtop total features error.---" + e.toString());
            j = j3;
        }
        return j;
    }

    public static long a(MtopFeatureEnum mtopFeatureEnum) {
        if (mtopFeatureEnum == null) {
            return 0L;
        }
        return 1 << ((int) (mtopFeatureEnum.a() - 1));
    }

    public static void a(MtopFeatureEnum mtopFeatureEnum, boolean z) {
        if (mtopFeatureEnum != null) {
            f43753a.put(mtopFeatureEnum, Boolean.valueOf(z));
            if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.b("mtopsdk.MtopFeatureManager", "[setMtopFeatureFlag] set feature=" + mtopFeatureEnum + " , openFlag=" + z);
            }
        }
    }
}
