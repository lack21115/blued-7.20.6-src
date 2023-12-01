package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.template.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/DynamicTemplateView.class */
public class DynamicTemplateView extends DTFrameLayout implements a {
    private DTRelativeLayout B;
    private DTTextView C;
    private List<View> Code;
    private DTAppDownloadButton I;
    private DTNativeVideoView V;
    private static final int S = com.huawei.hms.ads.template.util.a.Code(-608895943);
    private static final int F = com.huawei.hms.ads.template.util.a.Code(-1152660984);

    public DynamicTemplateView(Context context) {
        super(context);
        this.Code = new ArrayList();
    }

    public DynamicTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = new ArrayList();
    }

    private void Code(ViewGroup viewGroup, JSONObject jSONObject) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getTag(R.id.hiad_pps_view_store_click_event) instanceof String) {
                this.Code.add(childAt);
            }
            if (childAt instanceof DTNativeVideoView) {
                this.V = (DTNativeVideoView) childAt;
            }
            if (childAt instanceof DTAppDownloadButton) {
                this.I = (DTAppDownloadButton) childAt;
            }
            if (childAt instanceof a) {
                ((a) childAt).Code(jSONObject);
            }
            if ((childAt instanceof DTRelativeLayout) && childAt.getId() == S) {
                this.B = (DTRelativeLayout) childAt;
            }
            if ((childAt instanceof DTTextView) && childAt.getId() == F) {
                this.C = (DTTextView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                Code((ViewGroup) childAt, jSONObject);
            }
            i = i2 + 1;
        }
    }

    @Override // com.huawei.hms.ads.template.view.DTFrameLayout, com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        Code(this, jSONObject);
    }

    public DTTextView getAdSignTextView() {
        return this.C;
    }

    public List<View> getClickableViews() {
        return this.Code;
    }

    public DTAppDownloadButton getNativeButton() {
        return this.I;
    }

    public DTNativeVideoView getNativeVideoView() {
        return this.V;
    }

    public DTRelativeLayout getRelativeLayout() {
        return this.B;
    }
}
