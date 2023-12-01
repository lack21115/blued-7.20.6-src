package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.bm;
import com.huawei.openalliance.ad.constant.p;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.y;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLabelView.class */
public class PPSLabelView extends TextView {
    public static final String Code = " ";
    private static final String I = "PPSLabelView";
    public static final int V = 4;
    private boolean B;
    private Drawable C;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLabelView$a.class */
    static class a implements aj {
        private final WeakReference<PPSLabelView> Code;
        private String V;

        a(PPSLabelView pPSLabelView, String str) {
            this.Code = new WeakReference<>(pPSLabelView);
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.utils.aj
        public void Code() {
            ge.V(PPSLabelView.I, "start - dspLogo load failed");
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.a.2
                @Override // java.lang.Runnable
                public void run() {
                    PPSLabelView pPSLabelView = (PPSLabelView) a.this.Code.get();
                    if (pPSLabelView != null) {
                        pPSLabelView.setTextWhenImgLoadFail(a.this.V);
                    }
                }
            });
        }

        @Override // com.huawei.openalliance.ad.utils.aj
        public void Code(String str, final Drawable drawable) {
            ge.V(PPSLabelView.I, "start - dspLogo load onSuccess");
            if (drawable != null) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSLabelView pPSLabelView = (PPSLabelView) a.this.Code.get();
                        if (pPSLabelView != null) {
                            pPSLabelView.Code(a.this.V, drawable);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSLabelView$b.class */
    public static class b implements RemoteCallResultCallback<String> {
        private final WeakReference<PPSLabelView> Code;
        private String V;

        b(PPSLabelView pPSLabelView, String str) {
            this.Code = new WeakReference<>(pPSLabelView);
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            String data = callResult.getData();
            PPSLabelView pPSLabelView = this.Code.get();
            if (pPSLabelView != null) {
                if (TextUtils.isEmpty(data) || !data.startsWith(bm.CONTENT.toString())) {
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLabelView.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLabelView pPSLabelView2 = (PPSLabelView) b.this.Code.get();
                            if (pPSLabelView2 != null) {
                                pPSLabelView2.setTextWhenImgLoadFail(b.this.V);
                            }
                        }
                    });
                    return;
                }
                SourceParam sourceParam = new SourceParam();
                sourceParam.V(false);
                sourceParam.I(true);
                sourceParam.I(data);
                y.Code(pPSLabelView.getContext(), sourceParam, new a(pPSLabelView, this.V));
            }
        }
    }

    public PPSLabelView(Context context) {
        super(context);
        this.B = true;
        Code(context);
    }

    public PPSLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = true;
        Code(context);
    }

    public PPSLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = true;
        Code(context);
    }

    private void Code(Context context) {
        try {
            this.C = context.getResources().getDrawable(R.drawable.hiad_default_dsp_logo);
        } catch (Throwable th) {
            ge.I(I, "init error");
        }
    }

    private String getDefaultAdSign() {
        return this.B ? getResources().getString(R.string.hiad_ad_label_new) : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageSpan Code(Drawable drawable, boolean z) {
        Bitmap Code2 = y.Code(drawable);
        float textSize = getTextSize();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(Code2, Math.round(textSize), Math.round(textSize), false));
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        return new com.huawei.openalliance.ad.views.b(bitmapDrawable, 2, 0, z ? v.V(getContext(), 4.0f) : 0);
    }

    protected void Code(AdSource adSource, String str) {
        if (adSource == null) {
            return;
        }
        String V2 = au.V(adSource.Code()) == null ? "" : au.V(adSource.Code());
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        String str3 = V2 + str2;
        String V3 = adSource.V();
        if (TextUtils.isEmpty(V2) && TextUtils.isEmpty(V3)) {
            ge.V(I, "displayTextWithDspInfo, use default adSign");
        } else if (TextUtils.isEmpty(V2) || !TextUtils.isEmpty(V3)) {
            Code(str3, V3);
        } else {
            ge.V(I, "displayTextWithDspInfo, use dspNameWithAdSign");
            setText(str3);
        }
    }

    protected void Code(String str, Drawable drawable) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
            String defaultAdSign = getDefaultAdSign();
            if (TextUtils.isEmpty(str)) {
                str = defaultAdSign;
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(Code(drawable, !isEmpty), 0, 1, 33);
            setText(spannableStringBuilder);
        } catch (Throwable th) {
            ge.I(I, "setTextWhenImgLoaded error");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code(String str, String str2) {
        ge.V(I, "loadAndSetDspInfo, start");
        Code(str, this.C);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(at.z, str2);
            com.huawei.openalliance.ad.ipc.g.V(getContext()).Code(p.h, jSONObject.toString(), new b(this, str), String.class);
        } catch (Throwable th) {
            ge.I(I, "loadAndSetDspInfo error");
        }
    }

    public void Code(String str, String str2, String str3) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str3)) {
            ge.V(I, "dspInfo all empty or logo2Text is empty");
            ge.V(I, "setTextWithDspInfo, use default adSign");
            return;
        }
        String str4 = str;
        if (str == null) {
            str4 = "";
        }
        String str5 = str3;
        if (str3 == null) {
            str5 = "";
        }
        String str6 = str4 + str5;
        if (TextUtils.isEmpty(str6) && TextUtils.isEmpty(str2)) {
            ge.V(I, "setTextWithDspInfo, use default adSign");
        } else if (TextUtils.isEmpty(str6) || !TextUtils.isEmpty(str2)) {
            Code(str6, str2);
        } else {
            ge.V(I, "setTextWithDspInfo, use dspNameWithAdSign");
            setText(str6);
        }
    }

    public void V(AdSource adSource, String str) {
        if (adSource == null || TextUtils.isEmpty(str)) {
            ge.V(I, "setTextWithDspInfo, use default adSign");
        } else {
            Code(adSource, str);
        }
    }

    public void setTextForAppDetailView(AdSource adSource) {
        if (adSource == null) {
            ge.V(I, "setTextWithDspInfo, use default adSign");
            return;
        }
        this.B = false;
        Code(adSource, "");
    }

    protected void setTextWhenImgLoadFail(String str) {
        String defaultAdSign = getDefaultAdSign();
        if (TextUtils.isEmpty(str)) {
            str = defaultAdSign;
        }
        if (TextUtils.isEmpty(str) && !this.B) {
            setVisibility(8);
        }
        setText(str);
    }
}
