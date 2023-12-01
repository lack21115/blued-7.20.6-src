package com.igexin.sdk.main;

import android.content.Context;
import com.igexin.push.core.stub.GtcCore;
import com.igexin.push.core.stub.PushCore;
import com.igexin.sdk.IPushCore;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/main/PushCoreLoader.class */
public class PushCoreLoader {
    private static String TAG = "PushSdk";
    private static PushCoreLoader instance;
    private IPushCore gtcCore;
    private IPushCore pushCore;

    private PushCoreLoader() {
    }

    public static PushCoreLoader getInstance() {
        if (instance == null) {
            instance = new PushCoreLoader();
        }
        return instance;
    }

    public IPushCore getGtcCore() {
        return this.gtcCore;
    }

    public IPushCore getPushCore() {
        return this.pushCore;
    }

    public boolean init(Context context) {
        setPushCore(new PushCore());
        setGtcCore(new GtcCore());
        return true;
    }

    public void onDestroy() {
    }

    public void setGtcCore(IPushCore iPushCore) {
        this.gtcCore = iPushCore;
    }

    public void setPushCore(IPushCore iPushCore) {
        this.pushCore = iPushCore;
    }
}
