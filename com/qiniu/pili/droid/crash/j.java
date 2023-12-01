package com.qiniu.pili.droid.crash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f13798a = Pattern.compile("^(.*):\\s'(.*?)'$");
    private static final Pattern b = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f13799c = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    private static final Set<String> d = new HashSet(Arrays.asList("Crash type"));
    private static final Set<String> e = new HashSet(Arrays.asList("backtrace", "build id", "stack", "java stacktrace"));

    /* renamed from: com.qiniu.pili.droid.crash.j$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/j$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13800a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            f13800a = iArr;
            try {
                iArr[a.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13800a[a.HEAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13800a[a.SECTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/crash/j$a.class */
    enum a {
        UNKNOWN,
        HEAD,
        SECTION
    }
}
