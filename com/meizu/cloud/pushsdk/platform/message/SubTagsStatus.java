package com.meizu.cloud.pushsdk.platform.message;

import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/platform/message/SubTagsStatus.class */
public class SubTagsStatus extends BasicPushStatus {
    private String pushId;
    private List<Tag> tagList;

    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/platform/message/SubTagsStatus$Tag.class */
    public class Tag implements Serializable {
        private int tagId;
        private String tagName;

        public Tag() {
        }

        public int getTagId() {
            return this.tagId;
        }

        public String getTagName() {
            return this.tagName;
        }

        public void setTagId(int i) {
            this.tagId = i;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }

        public String toString() {
            return "Tag{tagId=" + this.tagId + ", tagName='" + this.tagName + "'}";
        }
    }

    public SubTagsStatus() {
    }

    public SubTagsStatus(String str) {
        super(str);
    }

    public String getPushId() {
        return this.pushId;
    }

    public List<Tag> getTagList() {
        return this.tagList;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.isNull(PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(PushConstants.KEY_PUSH_ID));
        }
        if (jSONObject.isNull("tags")) {
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("tags");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                DebugLogger.e(BasicPushStatus.TAG, "tags " + arrayList);
                setTagList(arrayList);
                return;
            }
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            Tag tag = new Tag();
            if (!jSONObject2.isNull("tagId")) {
                tag.tagId = jSONObject2.getInt("tagId");
            }
            if (!jSONObject2.isNull("tagName")) {
                tag.tagName = jSONObject2.getString("tagName");
            }
            arrayList.add(tag);
            i = i2 + 1;
        }
    }

    public void setPushId(String str) {
        this.pushId = str;
    }

    public void setTagList(List<Tag> list) {
        this.tagList = list;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public String toString() {
        return super.toString() + " SubTagsStatus{pushId='" + this.pushId + "', tagList=" + this.tagList + '}';
    }
}
