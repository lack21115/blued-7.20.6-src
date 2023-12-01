package com.qq.e.comm.util;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/util/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Boolean> f27930a = new HashMap();

    private static boolean a(Class cls, String str, Class... clsArr) {
        String sb;
        if (cls == null) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("#");
            sb2.append(str);
            int length = clsArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Class cls2 = clsArr[i2];
                sb2.append(BridgeUtil.UNDERLINE_STR);
                sb2.append(cls2.getName());
                i = i2 + 1;
            }
            sb = sb2.toString();
        }
        Boolean bool = f27930a.get(sb);
        if (bool == null) {
            try {
                cls.getDeclaredMethod(str, clsArr);
                f27930a.put(sb, Boolean.TRUE);
                return true;
            } catch (NoSuchMethodException e) {
                f27930a.put(sb, Boolean.FALSE);
                return false;
            }
        }
        return Boolean.TRUE.equals(bool);
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
