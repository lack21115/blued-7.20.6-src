package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewHostUpBinding;
import com.blued.android.module.yy_china.model.YYHostUpMode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/HostUpView.class */
public final class HostUpView extends FrameLayout {
    private ViewHostUpBinding a;
    private ArrayList<Integer> b;

    public HostUpView(Context context) {
        this(context, null);
    }

    public HostUpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HostUpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.a(context);
        ViewHostUpBinding a = ViewHostUpBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        this.b = CollectionsKt.d(Integer.valueOf(R.drawable.yy_icon_host_up_0), Integer.valueOf(R.drawable.yy_icon_host_up_1), Integer.valueOf(R.drawable.yy_icon_host_up_2), Integer.valueOf(R.drawable.yy_icon_host_up_3), Integer.valueOf(R.drawable.yy_icon_host_up_4), Integer.valueOf(R.drawable.yy_icon_host_up_5), Integer.valueOf(R.drawable.yy_icon_host_up_6), Integer.valueOf(R.drawable.yy_icon_host_up_7), Integer.valueOf(R.drawable.yy_icon_host_up_8), Integer.valueOf(R.drawable.yy_icon_host_up_9));
    }

    public final ViewHostUpBinding getBinding() {
        return this.a;
    }

    public final ArrayList<Integer> getIms() {
        return this.b;
    }

    public final void setBinding(ViewHostUpBinding viewHostUpBinding) {
        Intrinsics.e(viewHostUpBinding, "<set-?>");
        this.a = viewHostUpBinding;
    }

    public final void setIms(ArrayList<Integer> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.b = arrayList;
    }

    public final void setNum(YYHostUpMode yYHostUpMode) {
        if (yYHostUpMode == null) {
            return;
        }
        String anchor_level = yYHostUpMode.getAnchor_level();
        int length = anchor_level.length();
        int i = 0;
        while (i < length) {
            char charAt = anchor_level.charAt(i);
            i++;
            ImageView imageView = new ImageView(getContext());
            Integer num = getIms().get(Integer.parseInt(String.valueOf(charAt)));
            Intrinsics.c(num, "ims[i.toString().toInt()]");
            imageView.setImageResource(num.intValue());
            getBinding().c.addView(imageView);
        }
        ImageLoader.a((IRequestHost) null, yYHostUpMode.getAvatar()).a((ImageView) getBinding().a);
        if (yYHostUpMode.getName().length() > 6) {
            getBinding().d.setText("恭喜" + ((Object) yYHostUpMode.getName().subSequence(0, 5)) + "...主播");
            return;
        }
        getBinding().d.setText("恭喜" + yYHostUpMode.getName() + "主播");
    }
}
