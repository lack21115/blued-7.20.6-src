package com.huawei.openalliance.ad.ipc;

import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.utils.z;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/i.class */
public abstract class i {
    private static final String Code = "RemoteCallUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T Code(String str, Class<T> cls) {
        if (cls != null && cls != String.class) {
            if (cls.isPrimitive()) {
                String str2 = "Response type: " + cls + " not supported!";
                ge.I(Code, str2);
                throw new IllegalArgumentException(str2);
            }
            return (T) z.V(str, cls, new Class[0]);
        }
        return str;
    }
}
