package com.huawei.hms.ads.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.constant.p;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.f;
import com.huawei.openalliance.ad.utils.y;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/splash/ChoicesView.class */
public class ChoicesView extends ImageView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.ads.splash.ChoicesView$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/splash/ChoicesView$1.class */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String Code;

        /* renamed from: com.huawei.hms.ads.splash.ChoicesView$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/splash/ChoicesView$1$1.class */
        class C04191 implements RemoteCallResultCallback<String> {
            C04191() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                String data = callResult.getData();
                SourceParam sourceParam = new SourceParam();
                sourceParam.I(data);
                y.Code(ChoicesView.this.getContext(), sourceParam, new aj() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1
                    @Override // com.huawei.openalliance.ad.utils.aj
                    public void Code() {
                        ge.Code("ChoicesView", "download icon fail, use local icon");
                        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ChoicesView.this.I();
                            }
                        });
                    }

                    @Override // com.huawei.openalliance.ad.utils.aj
                    public void Code(String str2, final Drawable drawable) {
                        if (drawable != null) {
                            ba.Code(new Runnable() { // from class: com.huawei.hms.ads.splash.ChoicesView.1.1.1.1
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
            sourceParam.Code(t.i);
            sourceParam.I(this.Code);
            sourceParam.I(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("content", z.V(sourceParam));
                g.V(ChoicesView.this.getContext()).Code(p.L, jSONObject.toString(), new C04191(), String.class);
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
        int dimensionPixelSize = resources.getDimensionPixelSize(com.huawei.hms.ads.base.R.dimen.hiad_24_dp);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.huawei.hms.ads.base.R.dimen.hiad_24_dp);
        ge.Code("ChoicesView", "adChoiceViewWidth = %s", Integer.valueOf(dimensionPixelSize));
        setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2));
        setImageResource(com.huawei.hms.ads.base.R.drawable.hiad_hm_info);
    }

    public void I() {
        setImageResource(com.huawei.hms.ads.base.R.drawable.hiad_choices_adchoice);
    }

    public void setAdChoiceIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ge.Code("ChoicesView", "updateIcon from server.");
        f.V(new AnonymousClass1(str));
    }
}
