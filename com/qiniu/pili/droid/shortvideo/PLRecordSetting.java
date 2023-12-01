package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.core.u;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLRecordSetting.class */
public class PLRecordSetting {
    private static final String DISPLAY_MODE = "displayMode";
    private static final String MAX_RECORD_DURATION = "maxRecordDuration";
    private static final String RECORD_FILE_PATH = "recordFilePath";
    public static final String TAG = "PLRecordSetting";
    private static final String VIDEO_CACHE_DIR = "videoCacheDir";
    private String mRecordFilepath;
    private File mVideoCacheDir;
    private long mMaxRecordDuration = 10000;
    private PLDisplayMode mDisplayMode = PLDisplayMode.FULL;
    private boolean mIsRecordSpeedVariable = false;

    public static PLRecordSetting fromJSON(JSONObject jSONObject) {
        PLRecordSetting pLRecordSetting = new PLRecordSetting();
        pLRecordSetting.setMaxRecordDuration(jSONObject.optInt(MAX_RECORD_DURATION, 10000));
        pLRecordSetting.setVideoCacheDir(jSONObject.optString(VIDEO_CACHE_DIR));
        pLRecordSetting.setVideoFilepath(jSONObject.optString(RECORD_FILE_PATH));
        pLRecordSetting.setDisplayMode(PLDisplayMode.valueOf(jSONObject.optString(DISPLAY_MODE, PLDisplayMode.FULL.name())));
        return pLRecordSetting;
    }

    public static PLRecordSetting fromSetting(PLRecordSetting pLRecordSetting) {
        PLRecordSetting pLRecordSetting2 = new PLRecordSetting();
        pLRecordSetting2.setMaxRecordDuration(pLRecordSetting.mMaxRecordDuration);
        pLRecordSetting2.setRecordSpeedVariable(pLRecordSetting.mIsRecordSpeedVariable);
        pLRecordSetting2.setDisplayMode(pLRecordSetting.mDisplayMode);
        pLRecordSetting2.setVideoCacheDir(pLRecordSetting.mVideoCacheDir);
        pLRecordSetting2.setVideoFilepath(pLRecordSetting.mRecordFilepath);
        return pLRecordSetting2;
    }

    public boolean IsRecordSpeedVariable() {
        return this.mIsRecordSpeedVariable;
    }

    public PLDisplayMode getDisplayMode() {
        return this.mDisplayMode;
    }

    public long getMaxRecordDuration() {
        return this.mMaxRecordDuration;
    }

    public File getVideoCacheDir() {
        return this.mVideoCacheDir;
    }

    public String getVideoFilepath() {
        return this.mRecordFilepath;
    }

    public PLRecordSetting setDisplayMode(PLDisplayMode pLDisplayMode) {
        this.mDisplayMode = pLDisplayMode;
        e eVar = e.e;
        eVar.c(TAG, "setDisplayMode: " + pLDisplayMode);
        return this;
    }

    public PLRecordSetting setMaxRecordDuration(long j) {
        if (u.a().a(b.a.record_duration_setting)) {
            this.mMaxRecordDuration = j;
            e eVar = e.d;
            eVar.c(TAG, "setMaxRecordDuration: " + j + " ms");
            return this;
        }
        return this;
    }

    public PLRecordSetting setRecordSpeedVariable(boolean z) {
        this.mIsRecordSpeedVariable = z;
        e eVar = e.d;
        eVar.c(TAG, "setRecordSpeedVariable: " + z);
        return this;
    }

    public PLRecordSetting setVideoCacheDir(File file) {
        this.mVideoCacheDir = file;
        e eVar = e.d;
        eVar.c(TAG, "setVideoCacheDir: " + file);
        return this;
    }

    public PLRecordSetting setVideoCacheDir(String str) {
        return setVideoCacheDir(new File(str));
    }

    public PLRecordSetting setVideoFilepath(String str) {
        this.mRecordFilepath = str;
        e eVar = e.d;
        eVar.c(TAG, "setVideoFilepath: " + str);
        return this;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MAX_RECORD_DURATION, this.mMaxRecordDuration);
            jSONObject.put(VIDEO_CACHE_DIR, this.mVideoCacheDir.getAbsolutePath());
            jSONObject.put(RECORD_FILE_PATH, this.mRecordFilepath);
            jSONObject.put(DISPLAY_MODE, this.mDisplayMode.name());
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
