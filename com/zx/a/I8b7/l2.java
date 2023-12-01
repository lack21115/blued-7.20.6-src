package com.zx.a.I8b7;

import android.text.TextUtils;
import com.zx.sdk.api.ZXIDChangedListener;
import java.util.LinkedList;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/l2.class */
public class l2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f42146a;
    public final /* synthetic */ ZXIDChangedListener b;

    public l2(e2 e2Var, String str, ZXIDChangedListener zXIDChangedListener) {
        this.f42146a = str;
        this.b = zXIDChangedListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            o2 a2 = e2.a();
            String str = this.f42146a;
            ZXIDChangedListener zXIDChangedListener = this.b;
            y1 y1Var = a2.f42156c;
            y1Var.getClass();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            LinkedList<ZXIDChangedListener> linkedList = y1Var.f42231a.get(str);
            LinkedList<ZXIDChangedListener> linkedList2 = linkedList;
            if (linkedList == null) {
                linkedList2 = new LinkedList<>();
            }
            linkedList2.add(zXIDChangedListener);
            y1Var.f42231a.put(str, linkedList2);
        } catch (Exception e) {
            StringBuilder a3 = m2.a("ZXManager.allowPermissionDialog failed: ");
            a3.append(e.getMessage());
            m.b(a3.toString());
        }
    }
}
