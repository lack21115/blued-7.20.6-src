package com.soft.blued.ui.user.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.UserInfo;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPCenterExpLvlRightAdapter.class */
public class VIPCenterExpLvlRightAdapter extends BaseQuickAdapter<VIPCenterForJsonParse._privilege_list, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public IRequestHost f33790a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33791c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ImageView imageView, View view) {
        Tracker.onClick(view);
        imageView.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(VIPCenterForJsonParse._privilege_list _privilege_listVar, View view) {
        Tracker.onClick(view);
        EventTrackVIP.a(UserInfo.getInstance().getLoginUserInfo().vip_grade, this.b, UserInfo.getInstance().getLoginUserInfo().vip_grade != 0, _privilege_listVar.privilege_type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ImageView imageView, View view) {
        Tracker.onClick(view);
        imageView.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final VIPCenterForJsonParse._privilege_list _privilege_listVar) {
        if (baseViewHolder == null || _privilege_listVar == null) {
            return;
        }
        final ImageView imageView = (ImageView) baseViewHolder.getView(2131364496);
        TextView textView = (TextView) baseViewHolder.getView(R.id.img_tag);
        TextView textView2 = (TextView) baseViewHolder.getView(2131372046);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_btm);
        if (this.b == 2) {
            shapeTextView.setTextColor(BluedSkinUtils.a(this.mContext, 2131099660));
        } else {
            shapeTextView.setTextColor(BluedSkinUtils.a(this.mContext, 2131099663));
        }
        ImageLoader.a(this.f33790a, _privilege_listVar.icon).a(imageView);
        if (StringUtils.d(_privilege_listVar.corner)) {
            textView.setVisibility(8);
        } else {
            textView.setText(_privilege_listVar.corner);
            textView.setVisibility(0);
        }
        if (StringUtils.d(_privilege_listVar.title)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(_privilege_listVar.title);
            textView2.setVisibility(0);
        }
        if (StringUtils.d(_privilege_listVar.unit)) {
            shapeTextView.setVisibility(8);
        } else {
            shapeTextView.setText(_privilege_listVar.unit);
            shapeTextView.setVisibility(0);
        }
        if (this.f33791c) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPCenterExpLvlRightAdapter$FcgHoruNgFUuyJg8HvQPsdOuzsQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterExpLvlRightAdapter.this.a(_privilege_listVar, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPCenterExpLvlRightAdapter$6-P_c2ChEF8VFVZrTYfBTS9Q9OI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterExpLvlRightAdapter.b(ImageView.this, view);
            }
        });
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPCenterExpLvlRightAdapter$jDQm9U1WkXWlw6KxnYPmoIugD_Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterExpLvlRightAdapter.a(ImageView.this, view);
            }
        });
    }
}
