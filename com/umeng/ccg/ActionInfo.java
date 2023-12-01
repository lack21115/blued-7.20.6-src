package com.umeng.ccg;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/ActionInfo.class */
public interface ActionInfo {
    String getModule(Context context);

    String[] getSupportAction(Context context);

    boolean getSwitchState(Context context, String str);

    void onCommand(Context context, String str, Object obj);
}
