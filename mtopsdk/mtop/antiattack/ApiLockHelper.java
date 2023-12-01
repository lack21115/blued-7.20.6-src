package mtopsdk.mtop.antiattack;

import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SwitchConfig;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/ApiLockHelper.class */
public class ApiLockHelper {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap f43699a = new ConcurrentHashMap();

    private static long a(String str) {
        long a2 = SwitchConfig.a().a(str);
        if (a2 > 0) {
            return a2;
        }
        long c2 = SwitchConfig.a().c();
        if (c2 > 0) {
            return c2;
        }
        return 10L;
    }

    private static String a(long j, LockedEntity lockedEntity) {
        StringBuilder sb = new StringBuilder();
        sb.append(", currentTime=");
        sb.append(j);
        sb.append(", lockentity=" + lockedEntity.toString());
        return sb.toString();
    }

    public static boolean a(String str, long j) {
        boolean z;
        boolean z2 = false;
        if (StringUtils.b(str)) {
            return false;
        }
        LockedEntity lockedEntity = (LockedEntity) f43699a.get(str);
        if (lockedEntity != null) {
            if (Math.abs(j - lockedEntity.b) < lockedEntity.f43705c) {
                z = true;
            } else {
                f43699a.remove(str);
                z = false;
                if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                    TBSdkLog.c("mtopsdk.ApiLockHelper", "[unLock]apiKey=" + str);
                    z = false;
                }
            }
            z2 = z;
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.c("mtopsdk.ApiLockHelper", "[iSApiLocked] isLocked=" + z + ", " + a(j, lockedEntity));
                z2 = z;
            }
        }
        return z2;
    }

    public static void b(String str, long j) {
        if (StringUtils.b(str)) {
            return;
        }
        LockedEntity lockedEntity = (LockedEntity) f43699a.get(str);
        if (lockedEntity == null) {
            lockedEntity = new LockedEntity(str, j, a(str));
        } else {
            lockedEntity.b = j;
            lockedEntity.f43705c = a(str);
        }
        f43699a.put(str, lockedEntity);
        if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
            TBSdkLog.c("mtopsdk.ApiLockHelper", "[lock]" + a(j, lockedEntity));
        }
    }
}
