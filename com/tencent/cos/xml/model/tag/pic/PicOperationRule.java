package com.tencent.cos.xml.model.tag.pic;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.IntentConstant;
import com.tencent.cos.xml.BeaconService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/PicOperationRule.class */
public class PicOperationRule {
    private static final String TAG = "PicOperationRule";
    private String bucket;
    private String fileId;
    private String rule;

    public PicOperationRule(String str) {
        this.fileId = this.fileId;
        this.rule = str;
    }

    public PicOperationRule(String str, String str2) {
        this.fileId = str;
        this.rule = str2;
    }

    public PicOperationRule(String str, String str2, String str3) {
        this.bucket = str;
        this.fileId = str2;
        this.rule = str3;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.bucket)) {
                jSONObject.put("bucket", this.bucket);
            }
            if (!TextUtils.isEmpty(this.fileId)) {
                jSONObject.put("fileid", this.fileId);
            }
            jSONObject.put(IntentConstant.RULE, this.rule);
            return jSONObject;
        } catch (JSONException e) {
            BeaconService.getInstance().reportError(TAG, e);
            e.printStackTrace();
            return jSONObject;
        }
    }
}
