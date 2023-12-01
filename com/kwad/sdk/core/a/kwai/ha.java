package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ha.class */
public final class ha implements com.kwad.sdk.core.d<RewardMonitorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardMonitorInfo.loadType = jSONObject.optInt("load_type");
        rewardMonitorInfo.loadStatus = jSONObject.optInt("load_status");
        rewardMonitorInfo.adCount = jSONObject.optInt("ad_count");
        rewardMonitorInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        rewardMonitorInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        rewardMonitorInfo.totalDuration = jSONObject.optLong("total_duration_ms");
        rewardMonitorInfo.downloadType = jSONObject.optInt("download_type");
        rewardMonitorInfo.downloadSize = jSONObject.optLong("download_size");
        rewardMonitorInfo.errorCode = jSONObject.optInt("error_code");
        rewardMonitorInfo.errorMsg = jSONObject.optString("error_msg");
        if (rewardMonitorInfo.errorMsg == JSONObject.NULL) {
            rewardMonitorInfo.errorMsg = "";
        }
        rewardMonitorInfo.creativeId = jSONObject.optLong(com.anythink.expressad.foundation.d.c.l);
        rewardMonitorInfo.videoUrl = jSONObject.optString("video_url");
        if (rewardMonitorInfo.videoUrl == JSONObject.NULL) {
            rewardMonitorInfo.videoUrl = "";
        }
        rewardMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardMonitorInfo.dataDownloadInterval = jSONObject.optLong("data_download_interval_duration_ms");
        rewardMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        rewardMonitorInfo.currentDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.pageStatus = jSONObject.optInt("page_status");
        rewardMonitorInfo.rewardType = jSONObject.optInt("reward_type");
        rewardMonitorInfo.taskType = jSONObject.optInt("task_type");
        rewardMonitorInfo.taskStep = jSONObject.optInt("task_step");
        rewardMonitorInfo.posId = jSONObject.optLong("pos_Id");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (rewardMonitorInfo.loadType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_type", rewardMonitorInfo.loadType);
        }
        if (rewardMonitorInfo.loadStatus != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_status", rewardMonitorInfo.loadStatus);
        }
        if (rewardMonitorInfo.adCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "ad_count", rewardMonitorInfo.adCount);
        }
        if (rewardMonitorInfo.loadDataDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_data_duration_ms", rewardMonitorInfo.loadDataDuration);
        }
        if (rewardMonitorInfo.downloadDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "download_duration_ms", rewardMonitorInfo.downloadDuration);
        }
        if (rewardMonitorInfo.totalDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "total_duration_ms", rewardMonitorInfo.totalDuration);
        }
        if (rewardMonitorInfo.downloadType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "download_type", rewardMonitorInfo.downloadType);
        }
        if (rewardMonitorInfo.downloadSize != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "download_size", rewardMonitorInfo.downloadSize);
        }
        if (rewardMonitorInfo.errorCode != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_code", rewardMonitorInfo.errorCode);
        }
        if (rewardMonitorInfo.errorMsg != null && !rewardMonitorInfo.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_msg", rewardMonitorInfo.errorMsg);
        }
        if (rewardMonitorInfo.creativeId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.anythink.expressad.foundation.d.c.l, rewardMonitorInfo.creativeId);
        }
        if (rewardMonitorInfo.videoUrl != null && !rewardMonitorInfo.videoUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "video_url", rewardMonitorInfo.videoUrl);
        }
        if (rewardMonitorInfo.videoDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "video_duration_ms", rewardMonitorInfo.videoDuration);
        }
        if (rewardMonitorInfo.dataLoadInterval != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "data_load_interval_duration_ms", rewardMonitorInfo.dataLoadInterval);
        }
        if (rewardMonitorInfo.dataDownloadInterval != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "data_download_interval_duration_ms", rewardMonitorInfo.dataDownloadInterval);
        }
        if (rewardMonitorInfo.renderDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "render_duration_ms", rewardMonitorInfo.renderDuration);
        }
        if (rewardMonitorInfo.currentDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "video_duration_ms", rewardMonitorInfo.currentDuration);
        }
        if (rewardMonitorInfo.pageStatus != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "page_status", rewardMonitorInfo.pageStatus);
        }
        if (rewardMonitorInfo.rewardType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "reward_type", rewardMonitorInfo.rewardType);
        }
        if (rewardMonitorInfo.taskType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "task_type", rewardMonitorInfo.taskType);
        }
        if (rewardMonitorInfo.taskStep != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "task_step", rewardMonitorInfo.taskStep);
        }
        if (rewardMonitorInfo.posId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pos_Id", rewardMonitorInfo.posId);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        a2(rewardMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        return b2(rewardMonitorInfo, jSONObject);
    }
}
