package com.soft.blued.utils;

import android.content.Context;
import com.huawei.hms.ads.AppDownloadButtonStyle;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/HWAppDownloadStyle.class */
public class HWAppDownloadStyle extends AppDownloadButtonStyle {
    public HWAppDownloadStyle(Context context) {
        super(context);
        this.normalStyle.setTextColor(context.getResources().getColor(R.color.syc_dark_4671FE));
        this.normalStyle.setBackground(context.getResources().getDrawable(R.drawable.native_button_rounded_corners_shape));
        this.processingStyle.setTextColor(context.getResources().getColor(R.color.syc_dark_4671FE));
    }
}
