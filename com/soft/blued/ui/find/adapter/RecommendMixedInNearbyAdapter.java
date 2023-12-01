package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.model.FindRecommendData;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.StringUtils;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendMixedInNearbyAdapter.class */
public class RecommendMixedInNearbyAdapter extends BaseQuickAdapter<FindRecommendData, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f16436a;

    public RecommendMixedInNearbyAdapter(Context context, IRequestHost iRequestHost, RecyclerView recyclerView) {
        super((int) R.layout.item_find_recommend);
        this.f16436a = iRequestHost;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ImageSize imageSize, ImageView imageView, FindRecommendData findRecommendData, BaseViewHolder baseViewHolder, File file, Exception exc) {
        int a2 = (int) ((imageSize.a() / imageSize.b()) * DensityUtils.a(this.mContext, 15.0f));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = a2;
        layoutParams.height = DensityUtils.a(this.mContext, 15.0f);
        imageView.setLayoutParams(layoutParams);
        ImageLoader.a(this.f16436a, findRecommendData.type_pic).e(baseViewHolder.hashCode()).g(-1).a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final FindRecommendData findRecommendData) {
        if (baseViewHolder == null || findRecommendData == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.getView(R.id.rl_header);
        ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView = (TextView) baseViewHolder.getView(2131372046);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_live_type);
        RelativeLayout relativeLayout2 = (RelativeLayout) baseViewHolder.getView(R.id.rl_header_new);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.header_view_new);
        final ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.iv_live_type_new);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_name_new);
        if (BluedConfig.a().B()) {
            textView2.setText(findRecommendData.title);
            ImageLoader.a(this.f16436a, findRecommendData.pic).b(2131237314).a(imageView3);
            if (TextUtils.isEmpty(findRecommendData.type_pic) || findRecommendData.live_type == -1) {
                imageView4.setVisibility(8);
            } else {
                imageView4.setVisibility(0);
                final ImageSize imageSize = new ImageSize();
                ImageFileLoader.a(this.f16436a).a(findRecommendData.type_pic).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$RecommendMixedInNearbyAdapter$G0x9ySje8gat5Z4lk-6nULuWDjg
                    public final void onUIFinish(File file, Exception exc) {
                        RecommendMixedInNearbyAdapter.this.a(imageSize, imageView4, findRecommendData, baseViewHolder, file, exc);
                    }
                }).a();
            }
            relativeLayout.setVisibility(8);
            textView.setVisibility(8);
            relativeLayout2.setVisibility(0);
            textView2.setVisibility(0);
            imageView2.setVisibility(8);
        } else {
            textView.setText(findRecommendData.title);
            ImageLoader.a(this.f16436a, findRecommendData.pic).b(2131237310).c().a(imageView);
            if (findRecommendData.live_type == 0) {
                imageView2.setImageResource(R.drawable.icon_live_type_0);
                imageView2.setVisibility(0);
            } else if (findRecommendData.live_type == 1) {
                imageView2.setImageResource(R.drawable.icon_live_type_1);
                imageView2.setVisibility(0);
            } else if (findRecommendData.live_type == 2) {
                imageView2.setImageResource(R.drawable.icon_live_type_2);
                imageView2.setVisibility(0);
            } else if (findRecommendData.live_type == 3) {
                imageView2.setImageResource(R.drawable.icon_live_type_3);
                imageView2.setVisibility(0);
            } else if (findRecommendData.live_type == 4) {
                imageView2.setImageResource(R.drawable.icon_live_type_4);
                imageView2.setVisibility(0);
            } else if (findRecommendData.live_type == 5) {
                imageView2.setImageResource(R.drawable.icon_live_type_5);
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            relativeLayout.setVisibility(0);
            textView.setVisibility(8);
            relativeLayout2.setVisibility(8);
            textView2.setVisibility(8);
        }
        baseViewHolder.getView(R.id.cl_root).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.RecommendMixedInNearbyAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (findRecommendData.type != 1 && findRecommendData.type == 2) {
                    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_LIVE_USER_CLICK, findRecommendData.live, findRecommendData.uid + "", findRecommendData.live_type + "", findRecommendData.recommend_type, baseViewHolder.getAdapterPosition() - RecommendMixedInNearbyAdapter.this.getHeaderLayoutCount());
                }
                LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(findRecommendData.live, 0L), 0, "nearby_mix_recommend", String.valueOf(findRecommendData.uid), findRecommendData.title, "", 0);
                liveRoomData.liveFrom = UserFindResult.USER_SORT_BY.HOME_LIVE;
                liveRoomData.recommendType = findRecommendData.recommend_type;
                liveRoomData.livePosition = baseViewHolder.getLayoutPosition() + 1;
                LiveRoomInfoChannel.a(RecommendMixedInNearbyAdapter.this.mContext, liveRoomData, baseViewHolder.getAdapterPosition(), LiveRoomInfoChannel.b(RecommendMixedInNearbyAdapter.this.getData(), "nearby_mix_recommend"));
            }
        });
        if (findRecommendData.isShowUrlVisited) {
            return;
        }
        findRecommendData.isShowUrlVisited = true;
        if (findRecommendData.type != 1 && findRecommendData.type == 2) {
            EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_LIVE_USER_SHOW, findRecommendData.live, findRecommendData.uid + "", findRecommendData.live_type + "", findRecommendData.recommend_type, baseViewHolder.getAdapterPosition() - getHeaderLayoutCount());
        }
    }
}
