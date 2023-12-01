package com.qiniu.pili.droid.shortvideo;

import com.igexin.push.config.c;
import com.qiniu.pili.droid.shortvideo.f.e;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLComposeItem.class */
public class PLComposeItem {
    private static String TAG = "PLComposeItem";
    private String mFilePath;
    private long mDurationMs = 5000;
    private long mTransitionTimeMs = c.j;
    private ItemType mItemType = ItemType.IMAGE;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLComposeItem$ItemType.class */
    public enum ItemType {
        IMAGE,
        VIDEO,
        GIF
    }

    public PLComposeItem(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Illegal path: filePath is wrong!");
        }
        this.mFilePath = str;
    }

    public long getDurationMs() {
        return this.mDurationMs;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public ItemType getItemType() {
        return this.mItemType;
    }

    public long getTransitionTimeMs() {
        return this.mTransitionTimeMs;
    }

    public PLComposeItem setDurationMs(long j) {
        if (this.mItemType == ItemType.VIDEO) {
            e.t.e(TAG, "The item type is video, needn't to set duration, because the duration is the video's duration.");
            return this;
        } else if (j > 0) {
            this.mDurationMs = j;
            return this;
        } else {
            throw new IllegalArgumentException("durationMs must be greater than 0!");
        }
    }

    public PLComposeItem setFilePath(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Illegal path: filePath is wrong!");
        }
        this.mFilePath = str;
        return this;
    }

    public void setItemType(ItemType itemType) {
        this.mItemType = itemType;
        if (itemType == ItemType.VIDEO) {
            PLMediaFile pLMediaFile = new PLMediaFile(this.mFilePath);
            this.mDurationMs = pLMediaFile.getDurationMs();
            pLMediaFile.release();
            e eVar = e.t;
            String str = TAG;
            eVar.c(str, "the item type is video, duration is " + this.mDurationMs);
        }
    }

    public PLComposeItem setTransitionTimeMs(long j) {
        if (j >= 0) {
            this.mTransitionTimeMs = j;
            return this;
        }
        throw new IllegalArgumentException("transitionTimeMs must be greater than or equal to 0!");
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("FilePath", this.mFilePath);
            jSONObject.put("DurationMs", this.mDurationMs);
            jSONObject.put("TransitionTimeMs", this.mTransitionTimeMs);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
