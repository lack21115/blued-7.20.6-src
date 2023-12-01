package com.zego.zegoliveroom;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.zego.zegoliveroom.ZegoLiveRoomExtraInfoJNI;
import com.zego.zegoliveroom.callback.IZegoRoomExtraInfoCallback;
import com.zego.zegoliveroom.callback.IZegoSetRoomExtraInfoCallback;
import com.zego.zegoliveroom.entity.ZegoRoomExtraInfo;
import com.zego.zegoliveroom.utils.zegoevent.ZegoEventManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/ZegoLiveRoomExtraInfo.class */
public class ZegoLiveRoomExtraInfo implements ZegoLiveRoomExtraInfoJNI.IJniZegoRoomExtraInfoCallback {
    private static ZegoLiveRoomExtraInfo sInstance;
    private Map<Integer, IZegoSetRoomExtraInfoCallback> mMapRoomExtraInfoCallback;
    private IZegoRoomExtraInfoCallback mRoomExtraInfoCallback = null;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    private IZegoOnActiveEvent mZegoEventListener;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/ZegoLiveRoomExtraInfo$IZegoOnActiveEvent.class */
    class IZegoOnActiveEvent implements ZegoEventManager.IZegoEventListener {
        private IZegoOnActiveEvent() {
        }

        @Override // com.zego.zegoliveroom.utils.zegoevent.ZegoEventManager.IZegoEventListener
        public void onActiveEvent(String str) {
            ZegoLiveRoomExtraInfoJNI.logPrint("[Java_ZegoLiveRoomExtraInfo_onActiveEvent]event id: " + str);
            if (str == ZegoEventManager.ZEGO_EVENT_ID_UNINITSDK || str == ZegoEventManager.ZEGO_EVENT_ID_LOGOUT_ROOM) {
                ZegoLiveRoomExtraInfo.this.mMapRoomExtraInfoCallback.clear();
            }
        }
    }

    private ZegoLiveRoomExtraInfo() {
        this.mMapRoomExtraInfoCallback = null;
        this.mZegoEventListener = null;
        this.mMapRoomExtraInfoCallback = new HashMap();
        this.mZegoEventListener = new IZegoOnActiveEvent();
    }

    public static ZegoLiveRoomExtraInfo getInstance() {
        if (sInstance == null) {
            synchronized (ZegoLiveRoomExtraInfo.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ZegoLiveRoomExtraInfo();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomExtraInfoJNI.IJniZegoRoomExtraInfoCallback
    public void onRoomExtraInfoUpdated(final String str, final ZegoRoomExtraInfo[] zegoRoomExtraInfoArr) {
        final IZegoRoomExtraInfoCallback iZegoRoomExtraInfoCallback = this.mRoomExtraInfoCallback;
        if (iZegoRoomExtraInfoCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoomExtraInfo.2
                @Override // java.lang.Runnable
                public void run() {
                    iZegoRoomExtraInfoCallback.onRoomExtraInfoUpdated(str, zegoRoomExtraInfoArr);
                }
            });
        }
    }

    @Override // com.zego.zegoliveroom.ZegoLiveRoomExtraInfoJNI.IJniZegoRoomExtraInfoCallback
    public void onSetRoomExtraInfo(final int i, final String str, int i2, final String str2) {
        final IZegoSetRoomExtraInfoCallback iZegoSetRoomExtraInfoCallback = this.mMapRoomExtraInfoCallback.get(Integer.valueOf(i2));
        this.mMapRoomExtraInfoCallback.remove(Integer.valueOf(i2));
        if (iZegoSetRoomExtraInfoCallback != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.zego.zegoliveroom.ZegoLiveRoomExtraInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    iZegoSetRoomExtraInfoCallback.onSetRoomExtraInfo(i, str, str2);
                }
            });
        }
    }

    public boolean setRoomExtraInfo(String str, String str2, IZegoSetRoomExtraInfoCallback iZegoSetRoomExtraInfoCallback) {
        return setRoomExtraInfo(str, str2, null, iZegoSetRoomExtraInfoCallback);
    }

    public boolean setRoomExtraInfo(String str, String str2, String str3, IZegoSetRoomExtraInfoCallback iZegoSetRoomExtraInfoCallback) {
        int roomExtraInfo;
        if (TextUtils.isEmpty(str) || iZegoSetRoomExtraInfoCallback == null || (roomExtraInfo = ZegoLiveRoomExtraInfoJNI.setRoomExtraInfo(str, str2, str3)) < 0) {
            return false;
        }
        if (this.mMapRoomExtraInfoCallback.get(Integer.valueOf(roomExtraInfo)) != null) {
            ZegoLiveRoomExtraInfoJNI.logPrint("[Java_ZegoLiveRoomExtraInfo_setRoomExtraInfo], unfinished custom command, seq:" + roomExtraInfo);
        }
        this.mMapRoomExtraInfoCallback.put(Integer.valueOf(roomExtraInfo), iZegoSetRoomExtraInfoCallback);
        return true;
    }

    public void setRoomExtraInfoCallback(IZegoRoomExtraInfoCallback iZegoRoomExtraInfoCallback) {
        if (iZegoRoomExtraInfoCallback == null) {
            ZegoEventManager.getInstance().unregisterEvent(ZegoEventManager.ZEGO_EVENT_ID_INITSDK, this.mZegoEventListener);
            ZegoEventManager.getInstance().unregisterEvent(ZegoEventManager.ZEGO_EVENT_ID_UNINITSDK, this.mZegoEventListener);
            ZegoEventManager.getInstance().unregisterEvent(ZegoEventManager.ZEGO_EVENT_ID_LOGOUT_ROOM, this.mZegoEventListener);
            ZegoLiveRoomExtraInfoJNI.setRoomExtraInfoJNICallback(null);
        } else {
            ZegoEventManager.getInstance().registerEvent(ZegoEventManager.ZEGO_EVENT_ID_INITSDK, this.mZegoEventListener);
            ZegoEventManager.getInstance().registerEvent(ZegoEventManager.ZEGO_EVENT_ID_UNINITSDK, this.mZegoEventListener);
            ZegoEventManager.getInstance().registerEvent(ZegoEventManager.ZEGO_EVENT_ID_LOGOUT_ROOM, this.mZegoEventListener);
            ZegoLiveRoomExtraInfoJNI.setRoomExtraInfoJNICallback(this);
        }
        this.mRoomExtraInfoCallback = iZegoRoomExtraInfoCallback;
    }
}
