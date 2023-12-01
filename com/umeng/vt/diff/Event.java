package com.umeng.vt.diff;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.tunnel.UMChannelAgent;
import com.umeng.vt.diff.util.ClassLoadUtil;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/vt/diff/Event.class */
public class Event {
    private static final int MAX_PROPERTY_LENGTH = 128;

    public static void commit(Context context, View view, String str, Map<String, Object> map, Boolean bool) {
        if (!bool.booleanValue()) {
            if (view != null) {
                String textPropertyFromView = textPropertyFromView(view);
                if (!TextUtils.isEmpty(textPropertyFromView)) {
                    map.put(V.VISUAL_TRACK_TEXT, textPropertyFromView);
                }
                map.put(V.VISUAL_TRACK_PG, view.getContext().getClass().getName());
            } else {
                map.put(V.VISUAL_TRACK_PG, context.getClass().getName());
            }
            map.put(V.VISUAL_TRACK_STYLE, 1);
            map.put(V.VISUAL_TRACK_UAPP_PG, getPageName());
            UMRTLog.e(UMRTLog.RTLOG_TAG, "release:事件名: " + str);
            if (map.containsKey(V.VISUAL_TRACK_TEXT)) {
                String str2 = (String) map.get(V.VISUAL_TRACK_TEXT);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; 参数：" + str2);
            }
            if (map.containsKey(V.VISUAL_TRACK_PG)) {
                String str3 = (String) map.get(V.VISUAL_TRACK_PG);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; 页面：" + str3);
            }
            if (map.containsKey(V.VISUAL_TRACK_UAPP_PG)) {
                String str4 = (String) map.get(V.VISUAL_TRACK_UAPP_PG);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "release:事件名: " + str + "; UApp页面路径：" + str4);
            }
            MobclickAgent.onEventObject(context, str, map);
        } else if (UMChannelAgent.init()) {
            if (view != null) {
                String textPropertyFromView2 = textPropertyFromView(view);
                if (!TextUtils.isEmpty(textPropertyFromView2)) {
                    map.put(V.VISUAL_TRACK_TEXT, textPropertyFromView2);
                }
                map.put(V.VISUAL_TRACK_PG, view.getContext().getClass().getName());
            } else {
                map.put(V.VISUAL_TRACK_PG, context.getClass().getName());
            }
            map.put(V.VISUAL_TRACK_STYLE, 1);
            map.put(V.VISUAL_TRACK_UAPP_PG, getPageName());
            UMRTLog.e(UMRTLog.RTLOG_TAG, "config:事件名: " + str);
            if (map.containsKey(V.VISUAL_TRACK_TEXT)) {
                String str5 = (String) map.get(V.VISUAL_TRACK_TEXT);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; 参数：" + str5);
            }
            if (map.containsKey(V.VISUAL_TRACK_PG)) {
                String str6 = (String) map.get(V.VISUAL_TRACK_PG);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; 页面：" + str6);
            }
            if (map.containsKey(V.VISUAL_TRACK_UAPP_PG)) {
                String str7 = (String) map.get(V.VISUAL_TRACK_UAPP_PG);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "config:事件名: " + str + "; UApp页面路径：" + str7);
            }
            UMChannelAgent.onDebugEvent(context, str, map);
        }
    }

    public static String getActivityName(View view) {
        Context context;
        if (view == null || (context = view.getContext()) == null) {
            return null;
        }
        Context context2 = context;
        if (context instanceof ContextWrapper) {
            context2 = ((ContextWrapper) context).getBaseContext();
        }
        if (context2 instanceof Activity) {
            return context2.getClass().getCanonicalName();
        }
        return null;
    }

    public static String getPageName() {
        String currenPageName = PageNameMonitor.getInstance().getCurrenPageName();
        String str = currenPageName;
        if (TextUtils.isEmpty(currenPageName)) {
            str = "";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        if (r0.equals("VT") != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getPageName(android.view.View r3) {
        /*
            java.lang.String r0 = getPageName()
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L1c
            r0 = r5
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1c
            r0 = r5
            r4 = r0
            r0 = r5
            java.lang.String r1 = "VT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L33
        L1c:
            r0 = r3
            java.lang.String r0 = getActivityName(r0)
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L30
            r0 = r3
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L30
            r0 = r3
            return r0
        L30:
            java.lang.String r0 = "VT"
            r4 = r0
        L33:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.vt.diff.Event.getPageName(android.view.View):java.lang.String");
    }

    public static void init(Context context, String str, String str2, int i, String str3) {
    }

    public static void openDebug(String str) {
    }

    private static void reflectTrack(Context context, String str, Map<String, Object> map) {
        Method method;
        try {
            Class<?> findClass = ClassLoadUtil.findClass("com.umeng.analytics.MobclickAgent");
            if (findClass == null || (method = findClass.getMethod("onEvent", Context.class, String.class, Map.class)) == null) {
                return;
            }
            method.invoke(null, context, str, map);
        } catch (Exception e) {
        }
    }

    private static String textPropertyFromView(View view) {
        String str;
        boolean z;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            str = null;
            if (text != null) {
                return text.toString();
            }
        } else {
            str = null;
            if (view instanceof ViewGroup) {
                StringBuilder sb = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                int i = 0;
                boolean z2 = false;
                while (true) {
                    z = z2;
                    if (i >= childCount || sb.length() >= 128) {
                        break;
                    }
                    String textPropertyFromView = textPropertyFromView(viewGroup.getChildAt(i));
                    boolean z3 = z;
                    if (textPropertyFromView != null) {
                        z3 = z;
                        if (textPropertyFromView.length() > 0) {
                            if (z) {
                                sb.append(", ");
                            }
                            sb.append(textPropertyFromView);
                            z3 = true;
                        }
                    }
                    i++;
                    z2 = z3;
                }
                if (sb.length() > 128) {
                    return sb.substring(0, 128);
                }
                str = null;
                if (z) {
                    str = sb.toString();
                }
            }
        }
        return str;
    }
}
