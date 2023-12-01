package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyRoomBannerBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYBannerModel;
import com.blued.android.module.yy_china.model.YYBannerRankModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YyWealthModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.ban.BGABanner;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRoomAdBanner.class */
public class YYRoomAdBanner extends ShapeFrameLayout implements BGABanner.Adapter<ConstraintLayout, YYBannerModel>, BGABanner.Delegate<ConstraintLayout, YYBannerModel> {

    /* renamed from: a  reason: collision with root package name */
    private BGABanner f18443a;
    private KeyBoardFragment b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18444c;
    private List<YYBannerModel> d;
    private HashMap<String, ItemYyRoomBannerBinding> e;
    private int f;

    public YYRoomAdBanner(Context context) {
        this(context, null);
    }

    public YYRoomAdBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYRoomAdBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18444c = true;
        this.d = new ArrayList();
        this.e = new HashMap<>();
        this.f = 0;
        BGABanner bGABanner = new BGABanner(context, null);
        this.f18443a = bGABanner;
        bGABanner.setDelegate(this);
        this.f18443a.setmWantVisiNum(4);
        this.f18443a.setAdapter(this);
        addView(this.f18443a, new FrameLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 50.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KeyBoardFragment keyBoardFragment, final List<YYBannerModel> list) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.i(b.uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYBannerModel, YyWealthModel>>(keyBoardFragment.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYRoomAdBanner.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYBannerModel, YyWealthModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    return;
                }
                YYRoomAdBanner.this.setVisibility(0);
                YYRoomAdBanner.this.f18444c = true;
                list.addAll(bluedEntity.data);
                if (list.size() > 1) {
                    YYRoomAdBanner.this.f18443a.setAutoPlayAble(true);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DisplayUtil.a(YYRoomAdBanner.this.getContext(), YYRoomAdBanner.this.f18444c ? 80.0f : 53.0f));
                    YYRoomAdBanner.this.f18443a.setmContentBottomMargin(DisplayUtil.a(YYRoomAdBanner.this.getContext(), 10.0f));
                    YYRoomAdBanner.this.f18443a.setLayoutParams(layoutParams);
                } else {
                    YYRoomAdBanner.this.f18443a.setLayoutParams(new FrameLayout.LayoutParams(-1, DisplayUtil.a(YYRoomAdBanner.this.getContext(), YYRoomAdBanner.this.f18444c ? 70.0f : 43.0f)));
                    YYRoomAdBanner.this.f18443a.setAutoPlayAble(false);
                }
                YYRoomAdBanner.this.f18443a.a(R.layout.item_yy_room_banner, list, (List<String>) null);
            }
        }, (IRequestHost) keyBoardFragment.getFragmentActive());
    }

    public void a(final KeyBoardFragment keyBoardFragment) {
        this.b = keyBoardFragment;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.h(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<YYBannerModel, YyWealthModel>>(keyBoardFragment.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYRoomAdBanner.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYBannerModel, YyWealthModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    YYRoomAdBanner.this.setVisibility(8);
                } else {
                    YYRoomAdBanner.this.setVisibility(0);
                    YYRoomAdBanner.this.f18444c = false;
                    if (bluedEntity.data.size() > 1) {
                        YYRoomAdBanner.this.f18443a.setAutoPlayAble(true);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DisplayUtil.a(YYRoomAdBanner.this.getContext(), YYRoomAdBanner.this.f18444c ? 80.0f : 53.0f));
                        YYRoomAdBanner.this.f18443a.setmContentBottomMargin(DisplayUtil.a(YYRoomAdBanner.this.getContext(), 10.0f));
                        YYRoomAdBanner.this.f18443a.setLayoutParams(layoutParams);
                    } else {
                        YYRoomAdBanner.this.f18443a.setLayoutParams(new FrameLayout.LayoutParams(-1, DisplayUtil.a(YYRoomAdBanner.this.getContext(), YYRoomAdBanner.this.f18444c ? 70.0f : 43.0f)));
                        YYRoomAdBanner.this.f18443a.setAutoPlayAble(false);
                    }
                    YYRoomAdBanner.this.f18443a.a(R.layout.item_yy_room_banner, bluedEntity.data, (List<String>) null);
                }
                YYRoomAdBanner.this.d = new ArrayList();
                YYRoomAdBanner.this.d.addAll(bluedEntity.data);
                YYRoomAdBanner yYRoomAdBanner = YYRoomAdBanner.this;
                yYRoomAdBanner.a(keyBoardFragment, yYRoomAdBanner.d);
            }
        }, (IRequestHost) keyBoardFragment.getFragmentActive());
    }

    public void a(YYBannerRankModel yYBannerRankModel) {
        List<YYBannerModel> list = this.d;
        YYBannerRankModel yYBannerRankModel2 = yYBannerRankModel;
        if (list != null) {
            Iterator<YYBannerModel> it = list.iterator();
            while (true) {
                yYBannerRankModel2 = yYBannerRankModel;
                if (!it.hasNext()) {
                    break;
                }
                YYBannerModel next = it.next();
                YYBannerRankModel yYBannerRankModel3 = next.rank;
                if (yYBannerRankModel3 != null && yYBannerRankModel3.getActivity_type() != null && yYBannerRankModel3.getActivity_type().equals(yYBannerRankModel.getActivity_type())) {
                    next.rank.setRank_value(yYBannerRankModel.getRank_value());
                    next.rank.setScore_value(yYBannerRankModel.getScore_value());
                    yYBannerRankModel = next.rank;
                }
            }
        }
        ItemYyRoomBannerBinding itemYyRoomBannerBinding = this.e.get(yYBannerRankModel2.getActivity_type());
        if (itemYyRoomBannerBinding == null) {
            int i = this.f + 1;
            this.f = i;
            KeyBoardFragment keyBoardFragment = this.b;
            if (keyBoardFragment == null || i >= 5) {
                return;
            }
            a(keyBoardFragment);
            return;
        }
        if (!StringUtils.b(yYBannerRankModel2.getRank_title())) {
            TextView textView = itemYyRoomBannerBinding.g;
            textView.setText(yYBannerRankModel2.getRank_title() + ": ");
            itemYyRoomBannerBinding.f.setText(yYBannerRankModel2.getRank_value());
            itemYyRoomBannerBinding.g.setTextColor(Color.parseColor(yYBannerRankModel2.getRank_color()));
            itemYyRoomBannerBinding.f.setTextColor(Color.parseColor(yYBannerRankModel2.getRank_color()));
            itemYyRoomBannerBinding.g.setVisibility(0);
            itemYyRoomBannerBinding.f.setVisibility(0);
        }
        if (StringUtils.b(yYBannerRankModel2.getScore_title())) {
            return;
        }
        TextView textView2 = itemYyRoomBannerBinding.e;
        textView2.setText(yYBannerRankModel2.getScore_title() + ": ");
        itemYyRoomBannerBinding.d.setText(yYBannerRankModel2.getScore_value());
        itemYyRoomBannerBinding.e.setTextColor(Color.parseColor(yYBannerRankModel2.getScore_color()));
        itemYyRoomBannerBinding.d.setTextColor(Color.parseColor(yYBannerRankModel2.getScore_color()));
        itemYyRoomBannerBinding.e.setVisibility(0);
        itemYyRoomBannerBinding.d.setVisibility(0);
    }

    @Override // com.blued.android.module.yy_china.view.ban.BGABanner.Delegate
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(BGABanner bGABanner, ConstraintLayout constraintLayout, YYBannerModel yYBannerModel, int i) {
        if (yYBannerModel == null) {
            return;
        }
        List<String> list = yYBannerModel.click_url;
        if (list != null) {
            YYRoomInfoManager.e().c().a((String[]) list.toArray(new String[0]));
        }
        if (YYRoomInfoManager.e().b() != null) {
            if (yYBannerModel.rank == null || StringUtils.b(yYBannerModel.rank.getRank_title())) {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_ACTIVITY_CLICK, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid, yYBannerModel.target_url, "0");
            } else {
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_ACTIVITY_CLICK, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid, yYBannerModel.target_url, "1");
            }
        }
        LiveEventBus.get("event_yy_game").post(yYBannerModel.target_url);
    }

    @Override // com.blued.android.module.yy_china.view.ban.BGABanner.Adapter
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(BGABanner bGABanner, ConstraintLayout constraintLayout, YYBannerModel yYBannerModel, int i) {
        ItemYyRoomBannerBinding a2 = ItemYyRoomBannerBinding.a(constraintLayout);
        if (this.f18444c) {
            a2.f16808a.setVisibility(0);
        } else {
            a2.f16808a.setVisibility(8);
        }
        a2.g.setVisibility(4);
        a2.e.setVisibility(4);
        a2.f.setVisibility(4);
        a2.d.setVisibility(4);
        if (yYBannerModel.rank != null) {
            this.e.put(yYBannerModel.rank.getActivity_type(), a2);
            a2.b.setImageResource(R.color.transparent);
            ImageLoader.a(this.b.getFragmentActive(), yYBannerModel.ads_pics).a(a2.f16808a);
            a(yYBannerModel.rank);
        } else {
            a2.f16808a.setImageResource(R.color.transparent);
            ImageLoader.a(this.b.getFragmentActive(), yYBannerModel.ads_pics).a(a2.b);
            a2.b.setVisibility(0);
        }
        List<String> list = yYBannerModel.show_url;
        if (yYBannerModel.isShowUrlVisited || list == null) {
            return;
        }
        YYRoomInfoManager.e().c().a((String[]) list.toArray(new String[0]));
        yYBannerModel.isShowUrlVisited = true;
    }
}
