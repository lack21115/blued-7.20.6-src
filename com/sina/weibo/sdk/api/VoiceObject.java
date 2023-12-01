package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/VoiceObject.class */
public class VoiceObject extends BaseMediaObject {
    public static final Parcelable.Creator<VoiceObject> CREATOR = new Parcelable.Creator<VoiceObject>() { // from class: com.sina.weibo.sdk.api.VoiceObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceObject createFromParcel(Parcel parcel) {
            return new VoiceObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceObject[] newArray(int i) {
            return new VoiceObject[i];
        }
    };
    public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
    public String dataHdUrl;
    public String dataUrl;
    public String defaultText;
    public int duration;
    public String h5Url;

    public VoiceObject() {
    }

    public VoiceObject(Parcel parcel) {
        super(parcel);
        this.h5Url = parcel.readString();
        this.dataUrl = parcel.readString();
        this.dataHdUrl = parcel.readString();
        this.duration = parcel.readInt();
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public boolean checkArgs() {
        if (super.checkArgs()) {
            String str = this.dataUrl;
            if (str != null && str.length() > 512) {
                LogUtil.e("Weibo.VoiceObject", "checkArgs fail, dataUrl is invalid");
                return false;
            }
            String str2 = this.dataHdUrl;
            if (str2 != null && str2.length() > 512) {
                LogUtil.e("Weibo.VoiceObject", "checkArgs fail, dataHdUrl is invalid");
                return false;
            } else if (this.duration <= 0) {
                LogUtil.e("Weibo.VoiceObject", "checkArgs fail, duration is invalid");
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public BaseMediaObject toExtraMediaObject(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.defaultText = new JSONObject(str).optString("extra_key_defaulttext");
            } catch (JSONException e) {
                return this;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public String toExtraMediaString() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.defaultText)) {
                jSONObject.put("extra_key_defaulttext", this.defaultText);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.h5Url);
        parcel.writeString(this.dataUrl);
        parcel.writeString(this.dataHdUrl);
        parcel.writeInt(this.duration);
    }
}
