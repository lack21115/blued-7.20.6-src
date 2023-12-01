package com.zego.zegoliveroom.utils.zegoevent;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/utils/zegoevent/ZegoEventManager.class */
public class ZegoEventManager {
    public static String ZEGO_EVENT_ID_INITSDK = "EVENT_INITSDK";
    public static String ZEGO_EVENT_ID_LOGOUT_ROOM = "EVENT_LOGOUT_ROOM";
    public static String ZEGO_EVENT_ID_UNINITSDK = "EVENT_UNINITSDK";
    private static ZegoEventManager sInstance;
    private Map<String, List<IZegoEventListener>> mapListeners = new HashMap();

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/utils/zegoevent/ZegoEventManager$IZegoEventListener.class */
    public interface IZegoEventListener {
        void onActiveEvent(String str);
    }

    private ZegoEventManager() {
    }

    public static ZegoEventManager getInstance() {
        if (sInstance == null) {
            synchronized (ZegoEventManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ZegoEventManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void onActiveEvent(String str) {
        List<IZegoEventListener> list;
        if (TextUtils.isEmpty(str) || this.mapListeners.isEmpty() || (list = this.mapListeners.get(str)) == null) {
            return;
        }
        for (IZegoEventListener iZegoEventListener : list) {
            iZegoEventListener.onActiveEvent(str);
        }
    }

    public boolean registerEvent(String str, IZegoEventListener iZegoEventListener) {
        if (TextUtils.isEmpty(str) || iZegoEventListener == null) {
            return false;
        }
        List<IZegoEventListener> list = this.mapListeners.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iZegoEventListener);
            this.mapListeners.put(str, arrayList);
            return true;
        } else if (list.contains(iZegoEventListener)) {
            return false;
        } else {
            list.add(iZegoEventListener);
            return true;
        }
    }

    public void unregisterEvent(String str, IZegoEventListener iZegoEventListener) {
        List<IZegoEventListener> list;
        if (TextUtils.isEmpty(str) || iZegoEventListener == null || this.mapListeners.isEmpty() || (list = this.mapListeners.get(str)) == null) {
            return;
        }
        Iterator<IZegoEventListener> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == iZegoEventListener) {
                it.remove();
            }
        }
    }
}
