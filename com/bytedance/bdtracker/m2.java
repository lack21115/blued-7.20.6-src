package com.bytedance.bdtracker;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/m2.class */
public class m2 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f21260a = new ArrayList<>();

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder a2 = a.a(str);
        a2.append(File.separator);
        a2.append(str2);
        a2.append(".dat");
        File file = new File(a2.toString());
        if (file.exists()) {
            file.delete();
        }
    }
}
