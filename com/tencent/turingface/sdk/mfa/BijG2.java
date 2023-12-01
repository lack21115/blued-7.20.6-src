package com.tencent.turingface.sdk.mfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/BijG2.class */
public final class BijG2 {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f26170a = new ArrayList();

    public static String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        try {
            for (String str : set) {
                if (sb.length() > 0) {
                    sb.append("|");
                }
                sb.append(str);
            }
        } catch (Throwable th) {
        }
        return sb.toString();
    }
}
