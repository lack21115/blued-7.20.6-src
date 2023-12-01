package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/c.class */
public class c extends a {
    public c(Context context) {
        super(context);
        this.V.Code(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal_hm));
        this.V.Code(context.getResources().getColor(R.color.hiad_emui_white));
        LayerDrawable layerDrawable = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_processing_hm);
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        if (findDrawableByLayerId instanceof ClipDrawable) {
            h hVar = new h(findDrawableByLayerId, 17, 1);
            layerDrawable.mutate();
            layerDrawable.setDrawableByLayerId(android.R.id.progress, hVar);
            this.I.Code(layerDrawable);
        } else {
            ge.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
        }
        this.I.Code(context.getResources().getColor(R.color.hiad_emui_black));
        LayerDrawable layerDrawable2 = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_installing_hm);
        if (layerDrawable2.findDrawableByLayerId(android.R.id.progress) instanceof ClipDrawable) {
            f fVar = new f(v.V(context, 18.0f));
            layerDrawable2.mutate();
            layerDrawable2.setDrawableByLayerId(android.R.id.progress, fVar);
            this.Z.Code(layerDrawable2);
            fVar.Code();
        } else {
            ge.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.Z.Code(Code(context, R.drawable.hiad_app_down_btn_installing));
        }
        this.Z.Code(context.getResources().getColor(R.color.hiad_emui_white));
    }
}
