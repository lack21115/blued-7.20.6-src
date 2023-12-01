package com.soft.blued.ui.msg.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/HelloListQuickAdapter.class */
public class HelloListQuickAdapter extends HelloGridQuickAdapter {
    @Override // com.soft.blued.ui.msg.adapter.HelloGridQuickAdapter, com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        if (baseViewHolder != null) {
            baseViewHolder.getItemViewType();
            b(baseViewHolder, userFindResult);
        }
    }

    @Override // com.soft.blued.ui.msg.adapter.HelloGridQuickAdapter, com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void b(final BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        final ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView = (TextView) baseViewHolder.getView(R.id.name_view);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.distance_view);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.online_time_view);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.age_view);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.height_view);
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.weight_view);
        TextView textView7 = (TextView) baseViewHolder.getView(R.id.sign_view);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_verify);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.img_online);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.list_call_icon);
        ImageView imageView5 = (ImageView) baseViewHolder.getView(R.id.img_blued_medal);
        View view = baseViewHolder.getView(R.id.layout_friend);
        ImageView imageView6 = (ImageView) baseViewHolder.getView(R.id.img_live_new_icon);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_personal_info);
        imageView2.setVisibility(0);
        UserInfoHelper.b(imageView2, userFindResult.vbadge, 4, 8);
        imageView3.setVisibility(0);
        imageView6.setVisibility(8);
        if (userFindResult.call_tip == 1) {
            imageView4.setVisibility(0);
        } else {
            imageView4.setVisibility(8);
        }
        if (userFindResult.live > 0) {
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
            imageView6.setVisibility(0);
        } else if (userFindResult.online_state == 1) {
            imageView3.setImageDrawable(BluedSkinUtils.b(this.v, 2131233953));
        } else {
            imageView3.setImageDrawable(BluedSkinUtils.b(this.v, 2131233951));
        }
        ImageLoader.a(this.z, userFindResult.is_invisible_half == 1 ? userFindResult.avatar : AvatarUtils.a(0, userFindResult.avatar)).b(2131237310).c().a(imageView);
        UserRelationshipUtils.a(imageView5, userFindResult);
        String str = StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr;
        if (TextUtils.isEmpty(str)) {
            textView2.setText("");
        } else {
            textView2.setText(str);
        }
        DistanceUtils.a(this.v, textView2, userFindResult, 1);
        if (!TextUtils.isEmpty(userFindResult.note)) {
            textView.setText(userFindResult.note);
        } else if (TextUtils.isEmpty(userFindResult.name)) {
            textView.setText("");
        } else {
            textView.setText(userFindResult.name);
        }
        UserRelationshipUtils.a(this.v, textView, userFindResult);
        if (userFindResult.online_state == 1 && BluedConfig.a().D() == 0) {
            textView3.setText(R.string.friends_actice);
        } else {
            String str2 = StringUtils.d(userFindResult.last_operate_str) ? userFindResult.last_operate : userFindResult.last_operate_str;
            if (TextUtils.isEmpty(str2)) {
                textView3.setText("");
            } else {
                textView3.setText(str2);
            }
        }
        TypefaceUtils.a(this.v, textView3, userFindResult.is_hide_last_operate, 1);
        if (userFindResult.vbadge == 5) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            if (TextUtils.isEmpty(userFindResult.age)) {
                textView4.setText("");
            } else {
                textView4.setText(userFindResult.age + this.v.getResources().getString(2131886374));
            }
            if (TextUtils.isEmpty(userFindResult.height)) {
                textView5.setText("");
            } else {
                textView5.setText(userFindResult.height);
            }
            if (TextUtils.isEmpty(userFindResult.weight)) {
                textView6.setText("");
            } else {
                textView6.setText(userFindResult.weight);
            }
        }
        if (TextUtils.isEmpty(userFindResult.description)) {
            textView7.setText("");
            textView7.setVisibility(8);
        } else {
            textView7.setVisibility(0);
            textView7.setText(userFindResult.description);
        }
        view.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.HelloListQuickAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                LiveEventBus.get(EventBusConstant.KEY_EVENT_IS_CLICK_ON_HEADER).post(true);
                HelloListQuickAdapter.this.a(userFindResult, baseViewHolder.getAdapterPosition());
                HelloListQuickAdapter.this.a(imageView, userFindResult);
            }
        }));
        f(baseViewHolder, userFindResult);
    }

    @Override // com.soft.blued.ui.msg.adapter.HelloGridQuickAdapter, com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void d() {
        addItemType(10, R.layout.hello_list_single_item);
    }
}
