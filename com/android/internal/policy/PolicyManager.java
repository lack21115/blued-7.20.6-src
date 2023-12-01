package com.android.internal.policy;

import android.content.Context;
import android.view.FallbackEventHandler;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManagerPolicy;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/policy/PolicyManager.class */
public final class PolicyManager {
    private static final String POLICY_IMPL_CLASS_NAME = "com.android.internal.policy.impl.Policy";
    private static final IPolicy sPolicy = null;

    static {
        try {
            Class.forName(POLICY_IMPL_CLASS_NAME);
            throw new VerifyError("bad dex opcode");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("com.android.internal.policy.impl.Policy could not be loaded", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("com.android.internal.policy.impl.Policy could not be instantiated", e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("com.android.internal.policy.impl.Policy could not be instantiated", e3);
        }
    }

    private PolicyManager() {
    }

    public static FallbackEventHandler makeNewFallbackEventHandler(Context context) {
        return sPolicy.makeNewFallbackEventHandler(context);
    }

    public static LayoutInflater makeNewLayoutInflater(Context context) {
        return sPolicy.makeNewLayoutInflater(context);
    }

    public static Window makeNewWindow(Context context) {
        return sPolicy.makeNewWindow(context);
    }

    public static WindowManagerPolicy makeNewWindowManager() {
        return sPolicy.makeNewWindowManager();
    }
}
