package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ChoicesView.class */
public class ChoicesView extends ImageView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.ads.ChoicesView$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ChoicesView$1.class */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String Code;

        /* renamed from: com.huawei.hms.ads.ChoicesView$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ChoicesView$1$1.class */
        class C03881 implements RemoteCallResultCallback<String> {
            C03881() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String data = callResult.getData();
                SourceParam sourceParam = new SourceParam();
                sourceParam.I(data);
                com.huawei.openalliance.ad.utils.y.Code(ChoicesView.this.getContext(), sourceParam, new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1
                    @Override // com.huawei.openalliance.ad.utils.aj
                    public void Code() {
                        ge.Code("ChoicesView", "download icon fail, use local icon");
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ChoicesView.this.I();
                            }
                        });
                    }

                    @Override // com.huawei.openalliance.ad.utils.aj
                    public void Code(String str2, final Drawable drawable) {
                        if (drawable != null) {
                            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ChoicesView.1.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ChoicesView.this.setImageDrawable(drawable);
                                }
                            });
                        }
                    }
                });
            }
        }

        AnonymousClass1(String str) {
            this.Code = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SourceParam sourceParam = new SourceParam();
            sourceParam.V(false);
            sourceParam.I(true);
            sourceParam.Code(com.huawei.openalliance.ad.constant.t.i);
            sourceParam.I(this.Code);
            sourceParam.I(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", com.huawei.openalliance.ad.utils.z.V(sourceParam));
                com.huawei.openalliance.ad.ipc.g.V(ChoicesView.this.getContext()).Code(com.huawei.openalliance.ad.constant.p.L, jSONObject.toString(), new C03881(), String.class);
            } catch (JSONException e) {
                ge.I("ChoicesView", "load ad choice icon jsonex");
            }
        }
    }

    public ChoicesView(Context context) {
        super(context, null);
        Code();
    }

    public ChoicesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code();
    }

    public ChoicesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code();
    }

    public ChoicesView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Code();
    }

    public void Code() {
        Resources resources = getContext().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_24_dp);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.hiad_24_dp);
        ge.Code("ChoicesView", "adChoiceViewWidth = %s", Integer.valueOf(dimensionPixelSize));
        setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
        setImageResource(R.drawable.hiad_hm_info);
    }

    public void Code(int i) {
        ge.Code("ChoicesView", "changeChoiceViewSize dp = %s", Integer.valueOf(i));
        Resources resources = getContext().getResources();
        setLayoutParams(new RelativeLayout.LayoutParams(resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(i)));
    }

    public void I() {
        setImageResource(R.drawable.hiad_choices_adchoice);
    }

    public void V() {
        setImageResource(R.drawable.hiad_hm_close_btn);
    }

    public void setAdChoiceIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ge.Code("ChoicesView", "updateIcon from server.");
        com.huawei.openalliance.ad.utils.f.V(new AnonymousClass1(str));
    }
}
