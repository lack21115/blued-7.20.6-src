package com.soft.blued.ui.home;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewConfiguration;
import androidx.collection.ArrayMap;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeTabClick.class */
public class HomeTabClick {

    /* renamed from: a  reason: collision with root package name */
    private static int f31032a = ViewConfiguration.getDoubleTapTimeout();
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Class f31033c;
    private static Map<String, TabClickListener> d;
    private static Handler e;
    private static String f;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeTabClick$TabClickListener.class */
    public interface TabClickListener {
        void c(String str);

        void d(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeTabClick$UIHandler.class */
    public static class UIHandler extends Handler {
        public UIHandler() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TabClickListener tabClickListener;
            TabClickListener tabClickListener2;
            int i = message.what;
            if (i == 1) {
                String str = (String) message.obj;
                if (HomeTabClick.d != null && (tabClickListener = (TabClickListener) HomeTabClick.d.get(str)) != null) {
                    tabClickListener.c(str);
                }
                if ("live".equals(str)) {
                    LiveEventBus.get("live_tab_page").post(true);
                }
            } else if (i != 2) {
            } else {
                String str2 = (String) message.obj;
                if (HomeTabClick.d != null && (tabClickListener2 = (TabClickListener) HomeTabClick.d.get(str2)) != null) {
                    tabClickListener2.d(str2);
                }
                if ("live".equals(str2)) {
                    LiveEventBus.get("live_tab_page").post(true);
                }
            }
        }
    }

    public static void a() {
        Map<String, TabClickListener> map = d;
        if (map != null) {
            map.clear();
            d = null;
        }
        f31033c = null;
        b = false;
    }

    public static void a(Class cls) {
        f31033c = cls;
        d = new ArrayMap();
        b = true;
        e = new UIHandler();
    }

    public static void a(String str) {
        if (b) {
            if (e.hasMessages(1) && str.equals(f)) {
                e.removeMessages(1);
                Handler handler = e;
                handler.sendMessage(handler.obtainMessage(2, str));
                return;
            }
            f = str;
            Handler handler2 = e;
            handler2.sendMessageDelayed(handler2.obtainMessage(1, str), f31032a);
        }
    }

    public static void a(String str, TabClickListener tabClickListener) {
        if (b) {
            d.put(str, tabClickListener);
        }
    }

    public static void b(String str, TabClickListener tabClickListener) {
        TabClickListener tabClickListener2;
        if (b && (tabClickListener2 = d.get(str)) != null && tabClickListener2 == tabClickListener) {
            d.remove(str);
        }
    }
}
