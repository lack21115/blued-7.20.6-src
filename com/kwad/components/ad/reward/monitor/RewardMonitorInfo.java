package com.kwad.components.ad.reward.monitor;

import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/monitor/RewardMonitorInfo.class */
public class RewardMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAIL = 4;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_LOCAL = 2;
    public static final int LOAD_TYPE_NET = 1;
    public static final int PAGE_STATUS_ENTRY = 1;
    public static final int PAGE_STATUS_SHOW = 2;
    public static final int PAGE_STATUS_SHOW_AD_CALL = 3;
    public static final int REWARD_TYPE_DEEP = 1;
    public static final int REWARD_TYPE_NORMAL = 0;
    public static final long serialVersionUID = 1080394611500009098L;
    public int adCount;
    public long creativeId;
    public long currentDuration;
    public long dataDownloadInterval;
    public long dataLoadInterval;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public int errorCode;
    public String errorMsg;
    public long loadDataDuration;
    public int loadStatus;
    public int loadType;
    public int pageStatus;
    public long posId;
    public long renderDuration;
    public long totalDuration;
    public long videoDuration;
    public String videoUrl;
    public int rewardType = -1;
    public int taskType = -1;
    public int taskStep = -1;

    public RewardMonitorInfo(long j) {
        this.posId = j;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        int i = this.rewardType;
        if (i != -1) {
            t.putValue(jSONObject, "reward_type", i);
        } else {
            jSONObject.remove("reward_type");
        }
        int i2 = this.taskType;
        if (i2 != -1) {
            t.putValue(jSONObject, "task_type", i2);
        } else {
            jSONObject.remove("task_type");
        }
        int i3 = this.taskStep;
        if (i3 != -1) {
            t.putValue(jSONObject, "task_step", i3);
        } else {
            jSONObject.remove("task_step");
        }
    }

    public RewardMonitorInfo setAdCount(int i) {
        this.adCount = i;
        return this;
    }

    public RewardMonitorInfo setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public RewardMonitorInfo setCurrentDuration(long j) {
        this.currentDuration = j;
        return this;
    }

    public RewardMonitorInfo setDataDownloadInterval(long j) {
        this.dataDownloadInterval = j;
        return this;
    }

    public RewardMonitorInfo setDataLoadInterval(long j) {
        this.dataLoadInterval = j;
        return this;
    }

    public RewardMonitorInfo setDownloadDuration(long j) {
        this.downloadDuration = j;
        return this;
    }

    public RewardMonitorInfo setDownloadSize(long j) {
        this.downloadSize = j;
        return this;
    }

    public RewardMonitorInfo setDownloadType(int i) {
        this.downloadType = i;
        return this;
    }

    public RewardMonitorInfo setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public RewardMonitorInfo setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public RewardMonitorInfo setLoadDataDuration(long j) {
        this.loadDataDuration = j;
        return this;
    }

    public RewardMonitorInfo setLoadStatus(int i) {
        this.loadStatus = i;
        return this;
    }

    public RewardMonitorInfo setLoadType(int i) {
        this.loadType = i;
        return this;
    }

    public RewardMonitorInfo setPageStatus(int i) {
        this.pageStatus = i;
        return this;
    }

    public RewardMonitorInfo setRenderDuration(long j) {
        this.renderDuration = j;
        return this;
    }

    public RewardMonitorInfo setRewardType(int i) {
        this.rewardType = i;
        return this;
    }

    public RewardMonitorInfo setTaskStep(int i) {
        this.taskStep = i;
        return this;
    }

    public RewardMonitorInfo setTaskType(int i) {
        this.taskType = i;
        return this;
    }

    public RewardMonitorInfo setTotalDuration(long j) {
        this.totalDuration = j;
        return this;
    }

    public RewardMonitorInfo setVideoDuration(long j) {
        this.videoDuration = j;
        return this;
    }

    public RewardMonitorInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }
}
