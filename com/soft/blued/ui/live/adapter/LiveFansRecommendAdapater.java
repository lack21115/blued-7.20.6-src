package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.model.LiveFansRecommendModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveFansRecommendAdapater.class */
public class LiveFansRecommendAdapater extends BaseQuickAdapter<LiveFansRecommendModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f17374a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private List<LiveFansRecommendModel> f17375c;
    private List<String> d;

    public LiveFansRecommendAdapater(IRequestHost iRequestHost, Context context) {
        super((int) R.layout.live_join_recommend_item_view);
        this.f17374a = context;
        this.b = iRequestHost;
        this.f17375c = new ArrayList();
        this.d = new ArrayList();
        setNewData(this.f17375c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final LiveFansRecommendModel liveFansRecommendModel) {
        String str;
        String str2;
        if (!this.d.contains(liveFansRecommendModel.lid)) {
            this.d.add(liveFansRecommendModel.lid);
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_SHOW, liveFansRecommendModel.lid, liveFansRecommendModel.uid);
        }
        if (liveFansRecommendModel.anchor != null) {
            str = liveFansRecommendModel.anchor.name;
            str2 = liveFansRecommendModel.anchor.avatar;
        } else {
            str = "";
            str2 = str;
        }
        ImageLoader.a(this.b, str2).a(3.0f).a((ImageView) baseViewHolder.getView(R.id.auto_avatar));
        TextView textView = (TextView) baseViewHolder.getView(R.id.fans_count);
        textView.setText(liveFansRecommendModel.fans_count + "");
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.atten_count);
        textView2.setText(liveFansRecommendModel.realtime_count + "");
        ((TextView) baseViewHolder.getView(2131372046)).setText(str);
        baseViewHolder.getView(2131368209).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveFansRecommendAdapater.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str3;
                String str4;
                String str5;
                String str6;
                Tracker.onClick(view);
                EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_JOIN_RECOMMEND_LIVE_CLICK, liveFansRecommendModel.lid, liveFansRecommendModel.uid);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= LiveFansRecommendAdapater.this.mData.size()) {
                        break;
                    }
                    if (((LiveFansRecommendModel) LiveFansRecommendAdapater.this.mData.get(i2)).anchor != null) {
                        str5 = ((LiveFansRecommendModel) LiveFansRecommendAdapater.this.mData.get(i2)).anchor.name;
                        str6 = ((LiveFansRecommendModel) LiveFansRecommendAdapater.this.mData.get(i2)).anchor.avatar;
                    } else {
                        str5 = "";
                        str6 = str5;
                    }
                    arrayList.add(new LiveRoomData(StringUtils.a(((LiveFansRecommendModel) LiveFansRecommendAdapater.this.mData.get(i2)).lid, 0L), liveFansRecommendModel.screen_pattern, "live_followed_grid_recommend", ((LiveFansRecommendModel) LiveFansRecommendAdapater.this.mData.get(i2)).uid, str5, str6, 0));
                    i = i2 + 1;
                }
                if (liveFansRecommendModel.anchor != null) {
                    str3 = liveFansRecommendModel.anchor.name;
                    str4 = liveFansRecommendModel.anchor.avatar;
                } else {
                    str3 = "";
                    str4 = str3;
                }
                LiveRoomInfoChannel.a(LiveFansRecommendAdapater.this.mContext, new LiveRoomData(StringUtils.a(liveFansRecommendModel.lid, 0L), liveFansRecommendModel.screen_pattern, "live_followed_grid_recommend", liveFansRecommendModel.uid, str3, str4, 0), -1, arrayList);
            }
        });
    }

    public void a(List<LiveFansRecommendModel> list) {
        if (list == null) {
            return;
        }
        this.d.clear();
        setNewData(list);
    }

    public void b(List<LiveFansRecommendModel> list) {
        if (list == null) {
            return;
        }
        addData((Collection) list);
    }
}
