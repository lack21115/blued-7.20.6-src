package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiverecommendListData;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveFinishRecommendAdapter.class */
public class LiveFinishRecommendAdapter extends BaseMultiItemQuickAdapter<LiverecommendListData, BaseViewHolder> {
    private LiveClickCallBack a;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveFinishRecommendAdapter$LiveClickCallBack.class */
    public interface LiveClickCallBack {
        void addDesireSuccess(LiverecommendListData liverecommendListData);
    }

    public LiveFinishRecommendAdapter(Context context, LiveClickCallBack liveClickCallBack) {
        super(new ArrayList());
        this.mContext = context;
        this.a = liveClickCallBack;
        addItemType(0, R.layout.item_live_finish_recommend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiverecommendListData liverecommendListData, View view) {
        LiveClickCallBack liveClickCallBack = this.a;
        if (liveClickCallBack != null) {
            liveClickCallBack.addDesireSuccess(liverecommendListData);
        }
    }

    private void a(LiverecommendListData liverecommendListData, BaseViewHolder baseViewHolder) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_pk);
        if (TextUtils.isEmpty(liverecommendListData.anchor_tag)) {
            imageView.setVisibility(8);
            return;
        }
        ImageLoader.a((IRequestHost) null, liverecommendListData.anchor_tag).a(imageView);
        imageView.setVisibility(0);
    }

    private void b(LiverecommendListData liverecommendListData, BaseViewHolder baseViewHolder) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_official_recommend);
        if (liverecommendListData.is_emperor_recommend == 1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.live_recommend_emperor);
        } else if (liverecommendListData.is_recommend == 1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.live_list_recommend_top);
        } else if (liverecommendListData.is_top == 1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.live_list_level_top);
        } else if (!TextUtils.isEmpty(liverecommendListData.top_icon)) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.live_list_official_top);
        } else if (!liverecommendListData.isPKStreamShow()) {
            if (liverecommendListData.is_hot == 1) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.live_icon_hot_select);
            } else if (liverecommendListData.is_exist_na_page != 1) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.live_new_user_icon);
            }
        } else {
            imageView.setVisibility(0);
            if (liverecommendListData.win_streak == 10) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_10);
            } else if (liverecommendListData.win_streak == 20) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_20);
            } else if (liverecommendListData.win_streak == 30) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_30);
            } else if (liverecommendListData.win_streak == 40) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_40);
            } else if (liverecommendListData.win_streak == 50) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_50);
            } else if (liverecommendListData.win_streak == 60) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_60);
            } else if (liverecommendListData.win_streak == 70) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_70);
            } else if (liverecommendListData.win_streak == 80) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_80);
            } else if (liverecommendListData.win_streak == 90) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_90);
            } else if (liverecommendListData.win_streak == 99) {
                imageView.setImageResource(R.drawable.live_pk_win_streak_99);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final LiverecommendListData liverecommendListData) {
        EventTrackLive.c(LiveProtos.Event.USER_END_PAGE_RECOMMEND_ROOM_SHOW, LiveRoomManager.a().g(), LiveRoomManager.a().e(), liverecommendListData.lid, liverecommendListData.uid);
        ImageLoader.a((IRequestHost) null, liverecommendListData.pic_url).b(R.drawable.live_recommend_item_placeholder).a((ImageView) baseViewHolder.getView(R.id.iv_pic));
        baseViewHolder.setText(R.id.tv_nickname, !TextUtils.isEmpty(liverecommendListData.title) ? liverecommendListData.title : (liverecommendListData.anchor == null || TextUtils.isEmpty(liverecommendListData.anchor.name)) ? "" : liverecommendListData.anchor.name);
        if (TextUtils.isEmpty(liverecommendListData.realtime_count)) {
            baseViewHolder.setVisible(R.id.tv_popularity, false);
        } else {
            baseViewHolder.setText(R.id.tv_popularity, new DecimalFormat("#,###").format(Float.parseFloat(liverecommendListData.realtime_count)));
            baseViewHolder.setVisible(R.id.tv_popularity, true);
        }
        if (liverecommendListData.anchor_level >= 80) {
            LiveUtils.a(this.mContext, (ImageView) baseViewHolder.getView(R.id.iv_level), liverecommendListData.anchor_level, false);
        } else {
            baseViewHolder.setVisible(R.id.iv_level, false);
        }
        a(liverecommendListData, baseViewHolder);
        b(liverecommendListData, baseViewHolder);
        baseViewHolder.getView(R.id.live_recommend_item).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveFinishRecommendAdapter$_5Qq2OiLzdXQOF1V8_JJdZt-hcc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFinishRecommendAdapter.this.a(liverecommendListData, view);
            }
        });
    }
}
