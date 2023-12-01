package com.youzan.androidsdk.model.goods;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/model/goods/GoodsShareModel.class */
public class GoodsShareModel {
    private String desc;
    private int imgHeight;
    private String imgUrl;
    private int imgWidth;
    private String link;
    private String timeLineTitle;
    private String title;

    public GoodsShareModel() {
    }

    public GoodsShareModel(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        this.title = jSONObject.optString("title");
        this.link = jSONObject.optString("link");
        this.imgUrl = jSONObject.optString("img_url");
        this.desc = jSONObject.optString("desc");
        this.imgWidth = jSONObject.optInt("img_width");
        this.imgHeight = jSONObject.optInt("img_height");
        this.timeLineTitle = jSONObject.optString("timeLineTitle");
    }

    public String getDesc() {
        String str = this.desc;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public String getImgUrl() {
        String str = this.imgUrl;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public String getLink() {
        String str = this.link;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public String getTimeLineTitle() {
        String str = this.timeLineTitle;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public String getTitle() {
        String str = this.title;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setImgHeight(int i) {
        this.imgHeight = i;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setImgWidth(int i) {
        this.imgWidth = i;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setTimeLineTitle(String str) {
        this.timeLineTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toJson() {
        return "{\"title\":\"" + getTitle() + "\", \"link\":\"" + getLink() + "\", \"img_url\":\"" + getImgUrl() + "\", \"desc\":\"" + getDesc() + "\", \"img_width\":\"" + getImgWidth() + "\", \"img_height\":\"" + getImgHeight() + "\", \"timeLineTitle\":\"" + getTimeLineTitle() + "\"}";
    }
}
