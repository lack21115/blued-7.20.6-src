package com.tencent.cos.xml.model.tag.pic;

import com.tencent.cos.xml.BeaconService;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/pic/PicOperations.class */
public class PicOperations {
    private static final String TAG = "PicOperations";
    private boolean isPicInfo;
    private List<PicOperationRule> rules;

    public PicOperations(boolean z, List<PicOperationRule> list) {
        this.isPicInfo = z;
        this.rules = list;
    }

    public String toJsonStr() {
        List<PicOperationRule> list = this.rules;
        if (list == null || list.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_pic_info", this.isPicInfo ? 1 : 0);
            JSONArray jSONArray = new JSONArray();
            for (PicOperationRule picOperationRule : this.rules) {
                jSONArray.put(picOperationRule.toJsonObject());
            }
            jSONObject.put("rules", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            BeaconService.getInstance().reportError(TAG, e);
            e.printStackTrace();
            return "{}";
        }
    }
}
