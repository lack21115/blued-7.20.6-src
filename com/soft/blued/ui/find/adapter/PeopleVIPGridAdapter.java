package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.das.client.featured.FeaturedProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackFeatured;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/PeopleVIPGridAdapter.class */
public class PeopleVIPGridAdapter extends PeopleGridQuickAdapter {
    public PeopleVIPGridAdapter(List<UserFindResult> list, Activity activity, IRequestHost iRequestHost, String str, RecyclerView recyclerView) {
        super(list, activity, iRequestHost, str, recyclerView);
        this.d = 2;
        a();
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void b(final BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(2131363859);
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.width = this.f30085c;
        layoutParams.height = this.f30085c;
        layoutParams.bottomMargin = this.i;
        layoutParams.rightMargin = this.i;
        frameLayout.setLayoutParams(layoutParams);
        TextView textView = (TextView) baseViewHolder.getView(2131372046);
        TextView textView2 = (TextView) baseViewHolder.getView(2131371186);
        final ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_selected_tag);
        View view = baseViewHolder.getView(R.id.img_btm_bg);
        imageView.setVisibility(0);
        view.setVisibility(0);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f30085c));
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams2.height = (this.f30085c * 2) / 5;
        layoutParams2.width = -1;
        view.setLayoutParams(layoutParams2);
        if (!(BluedConfig.a().b().vip_grade == 2)) {
            ImageLoader.a(this.o, userFindResult.avatar).b(2131237314).a(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.PeopleVIPGridAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    PayUtils.a(PeopleVIPGridAdapter.this.f30084a, 2, "nearby_choice_for_you_buy", 26, VipProtos.FromType.UNKNOWN_FROM);
                }
            });
            baseViewHolder.setGone(R.id.img_btm_bg, false);
            return;
        }
        imageView.setVisibility(0);
        if (!userFindResult.isShowUrlVisited) {
            EventTrackFeatured.a(FeaturedProtos.Event.NEARBY_FEATURED_PHOTO_DRAW, userFindResult.uid, userFindResult.additional_tag_type, userFindResult.selected_tag);
            userFindResult.isShowUrlVisited = true;
        }
        if (TextUtils.isEmpty(userFindResult.selected_tag)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(userFindResult.selected_tag);
        }
        if (!TextUtils.isEmpty(userFindResult.note)) {
            textView.setText(userFindResult.note);
        } else if (TextUtils.isEmpty(userFindResult.name)) {
            textView.setText("");
        } else {
            textView.setText(userFindResult.name);
        }
        ImageLoader.a(this.o, userFindResult.is_invisible_half == 1 ? userFindResult.avatar : AvatarUtils.a(2, userFindResult.avatar)).b(2131237314).a(imageView);
        if (TextUtils.isEmpty(userFindResult.additional_tag_data)) {
            textView2.setText("");
        } else if (userFindResult.additional_tag_type == 0) {
            textView2.setText(userFindResult.distance);
            DistanceUtils.a(this.f30084a, textView2, userFindResult, 1);
        } else {
            textView2.setText(userFindResult.additional_tag_data);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.PeopleVIPGridAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (baseViewHolder.getAdapterPosition() != -1) {
                    LogData logData = new LogData();
                    logData.logService = "click_position";
                    logData.position = (baseViewHolder.getAdapterPosition() / PeopleVIPGridAdapter.this.d) + "";
                    logData.from = PeopleVIPGridAdapter.this.b;
                    logData.uid = userFindResult.uid;
                    logData.is_hello = userFindResult.is_call + "";
                    logData.type = "0";
                    InstantLog.a(logData);
                    EventTrackFeatured.a(FeaturedProtos.Event.NEARBY_FEATURED_PHOTO_CLICK, userFindResult.uid, userFindResult.additional_tag_type, userFindResult.selected_tag);
                    boolean z = true;
                    if (!BluedPreferences.aa().equals("0-max")) {
                        InstantLog.g("personal_page", "1");
                    } else {
                        InstantLog.g("personal_page", "0");
                    }
                    if (userFindResult.is_invisible_half == 1 && ((UserInfo.getInstance().getLoginUserInfo().vip_grade != 2 && UserInfo.getInstance().getLoginUserInfo().vip_grade != 1) || BluedConfig.a().g().is_invisible_half == 0)) {
                        PayUtils.a(PeopleVIPGridAdapter.this.f30084a, 3, "user_half_invisible");
                        return;
                    }
                    PeopleVIPGridAdapter peopleVIPGridAdapter = PeopleVIPGridAdapter.this;
                    UserFindResult userFindResult2 = userFindResult;
                    ImageView imageView2 = imageView;
                    if (userFindResult2.live <= 0) {
                        z = false;
                    }
                    peopleVIPGridAdapter.a(userFindResult2, imageView2, z, 0);
                }
            }
        });
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void d() {
        addItemType(10, R.layout.friends_grid_vip_single_item);
        addItemType(11, R.layout.item_people_ad_layout);
    }
}
