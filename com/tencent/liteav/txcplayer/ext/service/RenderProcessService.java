package com.tencent.liteav.txcplayer.ext.service;

import android.content.Context;
import android.view.Surface;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcplayer.ext.host.EngineConst;
import com.tencent.liteav.txcplayer.ext.host.HostEngine;
import java.util.HashMap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcplayer/ext/service/RenderProcessService.class */
public class RenderProcessService {
    private static final String TAG = "HostEngine-RenderProcessService";
    private static RenderProcessService mInstance;
    private boolean mEnableRenderProcess = true;

    private RenderProcessService() {
    }

    public static RenderProcessService getInstance() {
        if (mInstance == null) {
            synchronized (RenderProcessService.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new RenderProcessService();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mInstance;
    }

    public boolean canRenderProcessWork() {
        if (!isEnableRenderProcess()) {
            LiteavLog.i(TAG, "[canRenderProcessWork],isEnableRenderProcess == false !!!");
            return false;
        } else if (!HostEngine.getInstance().checkAndLoadPlugin(2)) {
            LiteavLog.i(TAG, "[canRenderProcessWork],isEnableRenderProcess == false !!!");
            return false;
        } else {
            HashMap hashMap = new HashMap();
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 104, null, hashMap);
            V v = hashMap.get("KEY_RET_PARAM1");
            if ((v == 0 || !(v instanceof Boolean)) ? false : ((Boolean) v).booleanValue()) {
                LiteavLog.i(TAG, "[canRenderProcessWork], finally return true");
                return true;
            }
            LiteavLog.i(TAG, "[canRenderProcessWork],IS_SUPPORT_RESOLUTION == false !!!");
            return false;
        }
    }

    public void checkInit(Context context) {
        HostEngine.getInstance().init(context);
    }

    public boolean connectPlayer(ITXVCubePlayer iTXVCubePlayer, Surface surface) {
        if (iTXVCubePlayer == null || surface == null) {
            LiteavLog.w(TAG, "connectPlayer invalid param player or surface is null !!!");
            return false;
        } else if (!canRenderProcessWork()) {
            LiteavLog.w(TAG, "connectPlayer，postProcessService does not need to work");
            return false;
        } else {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM2, surface);
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 100, hashMap, hashMap2);
            Boolean bool = Boolean.FALSE;
            V v = hashMap2.get("KEY_RET_PARAM1");
            Boolean bool2 = bool;
            if (v != 0) {
                bool2 = bool;
                if (v instanceof Boolean) {
                    bool2 = (Boolean) v;
                }
            }
            return bool2.booleanValue();
        }
    }

    public int getVodLicenseFeature() {
        if (HostEngine.getInstance().getAppContext() == null) {
            LiteavLog.w(TAG, "Host engine not init!!");
            return 0;
        }
        boolean z = LicenseChecker.getInstance().valid(LicenseChecker.a.PLAYER_MONET) == LicenseChecker.d.OK;
        LiteavLog.i("VodLicenseCheck", "checkValidForPlayerMonet = ".concat(String.valueOf(z)));
        return z ? 1 : 0;
    }

    public boolean isEnableRenderProcess() {
        return this.mEnableRenderProcess;
    }

    public void setEnableRenderProcess(boolean z) {
        LiteavLog.d(TAG, "setEnableRenderProcess: ".concat(String.valueOf(z)));
        this.mEnableRenderProcess = z;
    }

    public boolean setSurfaceBufferSize(ITXVCubePlayer iTXVCubePlayer) {
        if (iTXVCubePlayer == null) {
            LiteavLog.w(TAG, "setSurfaceBufferSize invalid param player is null !!!");
            return false;
        } else if (!canRenderProcessWork()) {
            LiteavLog.w(TAG, "setSurfaceBufferSize，postProcessService does not need to work");
            return false;
        } else {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 101, hashMap, hashMap2);
            Boolean bool = Boolean.FALSE;
            V v = hashMap2.get("KEY_RET_PARAM1");
            Boolean bool2 = bool;
            if (v != 0) {
                bool2 = bool;
                if (v instanceof Boolean) {
                    bool2 = (Boolean) v;
                }
            }
            return bool2.booleanValue();
        }
    }

    public void stopRenderProcess(ITXVCubePlayer iTXVCubePlayer) {
        if (canRenderProcessWork()) {
            if (iTXVCubePlayer == null) {
                LiteavLog.w(TAG, "stopRenderProcess invalid param player is null !!!");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 103, hashMap, null);
        }
    }

    public void updateRenderProcessMode(ITXVCubePlayer iTXVCubePlayer, int i) {
        if (!canRenderProcessWork()) {
            LiteavLog.w(TAG, "updatePostProcessMode，postProcessService does not need to work");
        } else if (iTXVCubePlayer == null) {
            LiteavLog.w(TAG, "updatePostProcessMode invalid param player is null !!!");
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM2, Integer.valueOf(i));
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 102, hashMap, null);
        }
    }
}
