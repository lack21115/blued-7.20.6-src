package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.j.k;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/widget/KsAppTagsView.class */
public class KsAppTagsView extends LinearLayout {
    private int GU;

    public KsAppTagsView(Context context) {
        super(context);
        this.GU = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GU = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.GU = 3;
    }

    public KsAppTagsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.GU = 3;
    }

    private static void a(LinearLayout linearLayout, String str, int i) {
        TextView textView = (TextView) k.a(linearLayout.getContext(), i, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }

    public final void a(List<String> list, int i) {
        if (list == null) {
            return;
        }
        int i2 = 0;
        for (String str : list) {
            i2++;
            if (i2 > this.GU) {
                return;
            }
            a(this, str, i);
        }
    }

    public void setAppTags(List<String> list) {
        a(list, R.layout.ksad_reward_apk_info_card_tag_item);
    }

    public void setMaxCount(int i) {
        this.GU = i;
    }
}
