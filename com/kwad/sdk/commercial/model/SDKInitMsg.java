package com.kwad.sdk.commercial.model;

import android.os.Looper;
import com.blued.das.live.LiveProtos;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/commercial/model/SDKInitMsg.class */
public class SDKInitMsg extends a implements Serializable {
    private static final int CHILD_PROCESS = 2;
    private static final int DYNAMIC_DISABLE = 2;
    private static final int DYNAMIC_ENABLE = 1;
    public static final int FAIL = 2;
    public static final int FINISH = 1;
    private static final int MAIN_PROCESS = 1;
    private static final int MAIN_THREAD = 1;
    public static final int START = 0;
    private static final int WORK_THREAD = 2;
    private static final long serialVersionUID = 368743526206619387L;
    public String errorReason;
    public int initCount;
    public int initProcess;
    public int initStatus;
    public int initThread;
    public int intBuildNumber;
    public int intDynamicSDK;
    public long launchIntervalTime;
    public long totalDurationTime;

    public SDKInitMsg() {
        this.initProcess = ap.isInMainProcess(ServiceProvider.getContext()) ? 1 : 2;
        this.initThread = Looper.getMainLooper() == Looper.myLooper() ? 1 : 2;
        this.intDynamicSDK = com.kwad.b.kwai.a.Yg.booleanValue() ? 1 : 2;
        this.intBuildNumber = LiveProtos.Event.LIVE_LIST_CONFIG_POP_SHOW_VALUE;
    }

    public SDKInitMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public SDKInitMsg setInitCount(int i) {
        this.initCount = i;
        return this;
    }

    public SDKInitMsg setInitStatus(int i) {
        this.initStatus = i;
        return this;
    }

    public SDKInitMsg setLaunchIntervalTime(long j) {
        this.launchIntervalTime = j;
        return this;
    }

    public SDKInitMsg setTotalDurationTime(long j) {
        this.totalDurationTime = j;
        return this;
    }
}
