package com.anythink.expressad.exoplayer.j.a;

import com.anythink.expressad.exoplayer.k.af;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/n.class */
public final class n extends e {
    private static final String g = ".v3.exo";
    private static final Pattern h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    private static final Pattern i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    private static final Pattern j = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private n(String str, long j2, long j3, long j4, File file) {
        super(str, j2, j3, j4, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x008a, code lost:
        if (r11.renameTo(r0) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0039, code lost:
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.exoplayer.j.a.n a(java.io.File r11, com.anythink.expressad.exoplayer.j.a.h r12) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.a.n.a(java.io.File, com.anythink.expressad.exoplayer.j.a.h):com.anythink.expressad.exoplayer.j.a.n");
    }

    public static n a(String str, long j2) {
        return new n(str, j2, -1L, com.anythink.expressad.exoplayer.b.b, null);
    }

    public static n a(String str, long j2, long j3) {
        return new n(str, j2, j3, com.anythink.expressad.exoplayer.b.b, null);
    }

    public static File a(File file, int i2, long j2, long j3) {
        return new File(file, i2 + "." + j2 + "." + j3 + g);
    }

    public static n b(String str, long j2) {
        return new n(str, j2, -1L, com.anythink.expressad.exoplayer.b.b, null);
    }

    private static File b(File file, h hVar) {
        String group;
        String name = file.getName();
        Matcher matcher = i.matcher(name);
        if (matcher.matches()) {
            String h2 = af.h(matcher.group(1));
            group = h2;
            if (h2 == null) {
                return null;
            }
        } else {
            matcher = h.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            group = matcher.group(1);
        }
        File a2 = a(file.getParentFile(), hVar.c(group), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (file.renameTo(a2)) {
            return a2;
        }
        return null;
    }

    public final n a(int i2) {
        com.anythink.expressad.exoplayer.k.a.b(this.d);
        long currentTimeMillis = System.currentTimeMillis();
        return new n(this.f7557a, this.b, this.f7558c, currentTimeMillis, a(this.e.getParentFile(), i2, this.b, currentTimeMillis));
    }
}
