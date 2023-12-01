package com.igexin.assist.sdk;

import android.content.Context;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.config.d;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;
import com.igexin.push.f.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/sdk/AssistPushManager.class */
public class AssistPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9580a = "Assist_OtherPushManager";
    private AbstractPushManager b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f9581c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/sdk/AssistPushManager$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final AssistPushManager f9582a = new AssistPushManager((byte) 0);

        private a() {
        }
    }

    private AssistPushManager() {
        this.f9581c = new AtomicBoolean(false);
    }

    /* synthetic */ AssistPushManager(byte b) {
        this();
    }

    public static boolean checkSupportDevice(Context context) {
        return (d.U && b.a(context.getApplicationContext(), AssistUtils.BRAND_HON)) || b.a(context.getApplicationContext(), AssistUtils.BRAND_HW) || b.a(context.getApplicationContext(), AssistUtils.BRAND_XIAOMI) || b.a(context.getApplicationContext(), AssistUtils.BRAND_OPPO) || b.a(context.getApplicationContext(), AssistUtils.BRAND_MZ) || b.a(context.getApplicationContext(), AssistUtils.BRAND_VIVO) || b.a(context);
    }

    public static AssistPushManager getInstance() {
        return a.f9582a;
    }

    public static String getToken() {
        return e.I;
    }

    public void initialize(Context context) {
        this.b = com.igexin.assist.sdk.a.a().a(context);
    }

    public void register(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.register(context);
        }
    }

    public void saveToken(String str) {
        f.a().b(str);
    }

    public void setSilentTime(Context context, int i, int i2) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.setSilentTime(context, i, i2);
        }
    }

    public void turnOffPush(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.turnOffPush(context);
        }
    }

    public void turnOnPush(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.turnOnPush(context);
        }
    }

    public void unregister(Context context) {
        AbstractPushManager abstractPushManager = this.b;
        if (abstractPushManager != null) {
            abstractPushManager.unregister(context);
        }
    }
}
