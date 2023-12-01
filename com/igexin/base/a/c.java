package com.igexin.base.a;

import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/a/c.class */
public final class c implements a {
    public String e;
    public String f;

    /* renamed from: a  reason: collision with root package name */
    final List<String> f9598a = new CopyOnWriteArrayList();
    public int b = 10;

    /* renamed from: c  reason: collision with root package name */
    public long f9599c = 30000;
    private final Pattern g = Pattern.compile("(.+)?[$][{](.+)?[}].+");
    private final AtomicBoolean h = new AtomicBoolean(true);
    long d = SystemClock.elapsedRealtime();

    public c() {
        b a2 = b.a();
        if (a2.f9597a.contains(this)) {
            return;
        }
        a2.f9597a.add(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(String str) {
        try {
            Matcher matcher = this.g.matcher(str);
            if (matcher.find()) {
                return str.replaceFirst("[$][{](.+)?[}]", new SimpleDateFormat(matcher.group(2)).format(new Date()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    @Override // com.igexin.base.a.a
    public final void enableLog(boolean z) {
        this.h.set(z);
    }

    @Override // com.igexin.base.a.a
    public final boolean isEnabled() {
        return this.h.get();
    }

    @Override // com.igexin.base.a.a
    public final void log(String str) {
        if (isEnabled()) {
            this.f9598a.add(str);
        }
    }
}
