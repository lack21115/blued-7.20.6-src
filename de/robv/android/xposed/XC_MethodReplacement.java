package de.robv.android.xposed;

import android.view.Window;
import de.robv.android.xposed.XC_MethodHook;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XC_MethodReplacement.class */
public abstract class XC_MethodReplacement extends XC_MethodHook {
    public static final XC_MethodReplacement DO_NOTHING = new XC_MethodReplacement(Window.PROGRESS_SECONDARY_START) { // from class: de.robv.android.xposed.XC_MethodReplacement.1
        @Override // de.robv.android.xposed.XC_MethodReplacement
        protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
            return null;
        }
    };

    public XC_MethodReplacement() {
    }

    public XC_MethodReplacement(int i) {
        super(i);
    }

    public static XC_MethodReplacement returnConstant(int i, final Object obj) {
        return new XC_MethodReplacement(i) { // from class: de.robv.android.xposed.XC_MethodReplacement.2
            @Override // de.robv.android.xposed.XC_MethodReplacement
            protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
                return obj;
            }
        };
    }

    public static XC_MethodReplacement returnConstant(Object obj) {
        return returnConstant(50, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // de.robv.android.xposed.XC_MethodHook
    public final void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // de.robv.android.xposed.XC_MethodHook
    public final void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable {
        try {
            methodHookParam.setResult(replaceHookedMethod(methodHookParam));
        } catch (Throwable th) {
            methodHookParam.setThrowable(th);
        }
    }

    protected abstract Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws Throwable;
}
