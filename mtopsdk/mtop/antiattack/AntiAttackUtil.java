package mtopsdk.mtop.antiattack;

import com.taobao.tao.remotebusiness.listener.c;
import java.net.SocketOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import mtopsdk.a.b.g;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.antiattack.CheckCodeDO;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.util.Result;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/AntiAttackUtil.class */
public final class AntiAttackUtil {
    protected static final ConcurrentMap a = new ConcurrentHashMap(1);

    private AntiAttackUtil() {
    }

    private static CheckCodeDO a(Map map) {
        if (map == null) {
            return null;
        }
        CheckCodeDO checkCodeDO = new CheckCodeDO();
        checkCodeDO.a = c.a(map, "image");
        checkCodeDO.b = c.a(map, "check");
        HashMap hashMap = new HashMap();
        CheckCodeDO.CheckCodeFieldEnum[] values = CheckCodeDO.CheckCodeFieldEnum.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                checkCodeDO.c = hashMap;
                return checkCodeDO;
            }
            CheckCodeDO.CheckCodeFieldEnum checkCodeFieldEnum = values[i2];
            hashMap.put(checkCodeFieldEnum.a(), c.a(map, checkCodeFieldEnum.a()));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Result a(String str) {
        Result result = new Result();
        g b = b(str);
        if (b == null || 200 != b.a()) {
            result.a(false);
            return result;
        }
        result.a(a(b.b()));
        return result;
    }

    public static void a() {
        a.remove("mtopsdk.mtop.antiattack.checkcode.validate.activity_action");
        TBSdkLog.b("mtopsdk.AntiAttackUtil", "[removeLoadedFlag] remove AntiAttack loadFlag succeed.");
    }

    private static g b(String str) {
        if (StringUtils.b(str)) {
            TBSdkLog.d("mtopsdk.AntiAttackUtil", "[syncloadRemoteData] url is blank.url=" + str);
            return null;
        }
        try {
            return SDKConfig.a().m().a(new mtopsdk.a.b.c().a(str).c(1).d(SocketOptions.SO_OOBINLINE).a()).b();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
