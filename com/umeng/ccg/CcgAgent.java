package com.umeng.ccg;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/ccg/CcgAgent.class */
public class CcgAgent {
    private static Map<String, ArrayList<String>> forbidSdkTable;
    private static Object lock = new Object();
    private static ArrayList<ConfigListener> callbacks = new ArrayList<>();
    private static Object actionInfoLock = new Object();
    private static Map<String, ActionInfo> actionInfoTable = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        forbidSdkTable = hashMap;
        hashMap.put(a.e, new ArrayList());
        forbidSdkTable.put(a.d, new ArrayList<>());
        forbidSdkTable.put(a.b, new ArrayList<>());
        forbidSdkTable.put(a.f40813c, new ArrayList<>());
    }

    public static ActionInfo getActionInfo(String str) {
        ActionInfo actionInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (actionInfoLock) {
            if (actionInfoTable.containsKey(str)) {
                actionInfo = actionInfoTable.get(str);
            }
        }
        return actionInfo;
    }

    public static String[] getCollectItemList() {
        return new String[]{a.e, a.d, a.b, a.f40813c};
    }

    public static ArrayList<String> getForbidSdkArray(String str) {
        if (forbidSdkTable.containsKey(str)) {
            return forbidSdkTable.get(str);
        }
        return null;
    }

    public static ArrayList<String> getRegistedModuleList() {
        ArrayList<String> arrayList;
        synchronized (actionInfoLock) {
            arrayList = new ArrayList<>(actionInfoTable.keySet());
        }
        return arrayList;
    }

    public static boolean hasRegistedActionInfo() {
        boolean z;
        synchronized (actionInfoLock) {
            z = actionInfoTable.size() > 0;
        }
        return z;
    }

    public static void init(Context context) {
        d.a().a(context);
    }

    public static void notifyConfigReady(JSONObject jSONObject) {
        synchronized (lock) {
            int size = callbacks.size();
            if (size > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    callbacks.get(i2).onConfigReady(jSONObject);
                    i = i2 + 1;
                }
            }
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        Context appContext = UMGlobalContext.getAppContext();
        if (actionInfo != null) {
            synchronized (actionInfoLock) {
                try {
                    String module = actionInfo.getModule(UMGlobalContext.getAppContext());
                    if (!TextUtils.isEmpty(module) && !actionInfoTable.containsKey(module)) {
                        String[] supportAction = actionInfo.getSupportAction(appContext);
                        if (supportAction != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= supportAction.length) {
                                    break;
                                }
                                String str = supportAction[i2];
                                boolean switchState = actionInfo.getSwitchState(appContext, str);
                                if (forbidSdkTable.containsKey(str)) {
                                    ArrayList<String> arrayList = forbidSdkTable.get(str);
                                    if (!switchState) {
                                        arrayList.add(module);
                                    }
                                }
                                i = i2 + 1;
                            }
                        }
                        actionInfoTable.put(module, actionInfo);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static void registerConfigListener(ConfigListener configListener) {
        if (configListener != null) {
            synchronized (lock) {
                callbacks.add(configListener);
            }
        }
    }
}
