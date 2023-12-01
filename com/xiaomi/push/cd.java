package com.xiaomi.push;

import com.xiaomi.push.ch;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cd.class */
public class cd extends ch.d {

    /* renamed from: a  reason: collision with root package name */
    protected String f41300a;

    public cd(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f41300a = "MessageDeleteJob";
        this.f41300a = str3;
    }

    public static cd a(String str) {
        return new cd(str, "status = ?", new String[]{"2"}, "a job build to delete uploaded job");
    }
}
