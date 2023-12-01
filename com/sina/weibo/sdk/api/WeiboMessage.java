package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/WeiboMessage.class */
public final class WeiboMessage {
    public BaseMediaObject mediaObject;

    public WeiboMessage() {
    }

    public WeiboMessage(Bundle bundle) {
        toBundle(bundle);
    }

    public boolean checkArgs() {
        BaseMediaObject baseMediaObject = this.mediaObject;
        if (baseMediaObject == null) {
            LogUtil.e("Weibo.WeiboMessage", "checkArgs fail, mediaObject is null");
            return false;
        } else if (baseMediaObject == null || baseMediaObject.checkArgs()) {
            return true;
        } else {
            LogUtil.e("Weibo.WeiboMessage", "checkArgs fail, mediaObject is invalid");
            return false;
        }
    }

    public Bundle toBundle(Bundle bundle) {
        BaseMediaObject baseMediaObject = this.mediaObject;
        if (baseMediaObject != null) {
            bundle.putParcelable(WBConstants.Msg.MEDIA, baseMediaObject);
            bundle.putString(WBConstants.Msg.MEDIA_EXTRA, this.mediaObject.toExtraMediaString());
        }
        return bundle;
    }

    public WeiboMessage toObject(Bundle bundle) {
        BaseMediaObject baseMediaObject = (BaseMediaObject) bundle.getParcelable(WBConstants.Msg.MEDIA);
        this.mediaObject = baseMediaObject;
        if (baseMediaObject != null) {
            baseMediaObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.MEDIA_EXTRA));
        }
        return this;
    }
}
