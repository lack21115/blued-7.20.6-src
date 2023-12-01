package com.youzan.x5web.event;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.tencent.smtt.sdk.WebView;
import com.youzan.jsbridge.jsondata.JsonDataValue;
import com.youzan.jsbridge.method.JsMethod;
import com.youzan.x5web.JsSubscriber;
import com.youzan.x5web.JsTrigger;
import com.youzan.x5web.YZWebSDK;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/event/PreviewImageSubscriber.class */
public class PreviewImageSubscriber extends JsSubscriber {
    private static final String PREVIEW_WEB_IMAGES = "previewWebImages";

    @Override // com.youzan.x5web.JsSubscriber
    public void onCall(WebView webView, JsMethod jsMethod, JsTrigger jsTrigger) {
        Map<String, JsonDataValue> map;
        if (!PREVIEW_WEB_IMAGES.equals(jsMethod.name) || (map = jsMethod.params) == null || map.size() == 0) {
            return;
        }
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setIndex(Integer.valueOf(map.get("index").getStringValueNotNull()).intValue());
        List<JsonDataValue> arrayValueNotNull = map.get("images").getArrayValueNotNull();
        String[] strArr = new String[arrayValueNotNull.size()];
        int size = arrayValueNotNull.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                imageEntity.setImages(strArr);
                Intent intent = new Intent();
                intent.setData(Uri.parse("youzan://imagebrowser"));
                intent.putExtra("index", imageEntity.getIndex());
                intent.putExtra("urls", imageEntity.getImages());
                intent.putExtra("project_img_dir", YZWebSDK.getProjectImgDir());
                try {
                    webView.getContext().startActivity(intent);
                    return;
                } catch (ActivityNotFoundException e) {
                    throw new RuntimeException("未接入图片浏览库", new Throwable());
                }
            }
            strArr[i2] = arrayValueNotNull.get(i2).stringValue;
            i = i2 + 1;
        }
    }

    @Override // com.youzan.jsbridge.subscriber.Subscriber
    public String subscribe() {
        return PREVIEW_WEB_IMAGES;
    }
}
