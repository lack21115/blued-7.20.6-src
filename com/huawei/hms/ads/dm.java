package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.template.dtimageview.DTImageView;
import com.huawei.hms.ads.template.view.DTAppDownloadButton;
import com.huawei.hms.ads.template.view.DTFrameLayout;
import com.huawei.hms.ads.template.view.DTLinearLayout;
import com.huawei.hms.ads.template.view.DTNativeVideoView;
import com.huawei.hms.ads.template.view.DTRelativeLayout;
import com.huawei.hms.ads.template.view.DTTextView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dm.class */
public class dm extends dl {
    private static final Map<String, String> V;

    static {
        HashMap hashMap = new HashMap();
        V = hashMap;
        hashMap.put("fl", DTFrameLayout.class.getName());
        V.put("rl", DTRelativeLayout.class.getName());
        V.put("ll", DTLinearLayout.class.getName());
        V.put("text", DTTextView.class.getName());
        V.put("image", DTImageView.class.getName());
        V.put("native_pps_video", DTNativeVideoView.class.getName());
        V.put("native_pps_button", DTAppDownloadButton.class.getName());
    }

    public dm(Context context) {
        super(context);
    }

    @Override // com.huawei.hms.ads.dl
    protected String V(String str) {
        return V.get(str);
    }
}
