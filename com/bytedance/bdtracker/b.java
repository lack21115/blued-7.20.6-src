package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IAppLogInstance;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static InterfaceC0136b f7588a = new InterfaceC0136b() { // from class: com.bytedance.bdtracker.-$$Lambda$fCPBcfQn_Q1jR8BCfMXJjV3yKE8
        @Override // com.bytedance.bdtracker.b.InterfaceC0136b
        public final boolean a(c cVar) {
            return cVar.isBavEnabled();
        }
    };
    public static InterfaceC0136b b = new InterfaceC0136b() { // from class: com.bytedance.bdtracker.-$$Lambda$eohIrGB5vqcCz2oAIaZ7Iyz0yLk
        @Override // com.bytedance.bdtracker.b.InterfaceC0136b
        public final boolean a(c cVar) {
            return cVar.isH5BridgeEnable();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static InterfaceC0136b f7589c = new InterfaceC0136b() { // from class: com.bytedance.bdtracker.-$$Lambda$_6oZdoR4xXSD7-U0kgwJzLaZCDM
        @Override // com.bytedance.bdtracker.b.InterfaceC0136b
        public final boolean a(c cVar) {
            return cVar.isH5CollectEnable();
        }
    };
    public static InterfaceC0136b d = new InterfaceC0136b() { // from class: com.bytedance.bdtracker.-$$Lambda$7oyOBvDUO4sIpg119psVLvj_fqM
        @Override // com.bytedance.bdtracker.b.InterfaceC0136b
        public final boolean a(c cVar) {
            return b.a(cVar);
        }
    };

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/b$a.class */
    public interface a {
        void a(c cVar);
    }

    /* renamed from: com.bytedance.bdtracker.b$b  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/b$b.class */
    public interface InterfaceC0136b {
        boolean a(c cVar);
    }

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (c cVar : c.D) {
            if (str.equals(cVar.l)) {
                return cVar;
            }
        }
        return null;
    }

    public static String a(IAppLogInstance iAppLogInstance, String str) {
        if (AppLog.getInstance() == iAppLogInstance) {
            return str;
        }
        return str + "_" + iAppLogInstance.getAppId();
    }

    public static List<c> a(InterfaceC0136b interfaceC0136b) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : c.D) {
            if (interfaceC0136b.a(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static void a(t1 t1Var, InterfaceC0136b interfaceC0136b) {
        for (c cVar : c.D) {
            if (interfaceC0136b.a(cVar)) {
                cVar.receive(t1Var.m2745clone());
            }
        }
    }

    public static void a(String[] strArr) {
        for (c cVar : c.D) {
            cVar.receive((String[]) strArr.clone());
        }
    }

    public static /* synthetic */ boolean a(c cVar) {
        return cVar.getInitConfig() != null && cVar.getInitConfig().isHandleLifeCycle();
    }

    public static IAppLogInstance b(String str) {
        c a2 = a(str);
        return a2 != null ? a2 : AppLog.getInstance();
    }

    public static boolean b(InterfaceC0136b interfaceC0136b) {
        for (c cVar : c.D) {
            if (interfaceC0136b.a(cVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(final String str) {
        return !TextUtils.isEmpty(str) && b(new InterfaceC0136b() { // from class: com.bytedance.bdtracker.-$$Lambda$ZraJqSWsTFFrzmqyhrOaQHHDwQg
            @Override // com.bytedance.bdtracker.b.InterfaceC0136b
            public final boolean a(c cVar) {
                boolean equals;
                equals = str.equals(cVar.l);
                return equals;
            }
        });
    }
}
