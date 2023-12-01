package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/LiveRecyclerAdapter.class */
public class LiveRecyclerAdapter extends BaseQuickAdapter<UserFindResult, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f30056a;

    public LiveRecyclerAdapter(Context context) {
        super(R.layout.item_nearby_live_recycler_view, new ArrayList());
        this.f30056a = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        if (baseViewHolder != null) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_head);
            ImageLoader.a((IRequestHost) null, userFindResult.avatar).b(2131237310).a(1.5f, -9411593).a(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.LiveRecyclerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    InstantLog.b("nearby_model", 0);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < LiveRecyclerAdapter.this.mData.size(); i++) {
                        arrayList.add(new LiveRoomData(((UserFindResult) LiveRecyclerAdapter.this.mData.get(i)).live, 0, ((UserFindResult) LiveRecyclerAdapter.this.mData.get(i)).source, ((UserFindResult) LiveRecyclerAdapter.this.mData.get(i)).uid, ((UserFindResult) LiveRecyclerAdapter.this.mData.get(i)).name, ((UserFindResult) LiveRecyclerAdapter.this.mData.get(i)).avatar, ((UserFindResult) LiveRecyclerAdapter.this.mData.get(i)).vbadge));
                    }
                    LiveRoomInfoChannel.a(LiveRecyclerAdapter.this.f30056a, new LiveRoomData(userFindResult.live, 0, userFindResult.source, userFindResult.uid, userFindResult.name, userFindResult.avatar, userFindResult.vbadge), -1, arrayList);
                }
            });
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_live_frame);
            if (userFindResult.live_type == 1) {
                imageView2.setImageResource(R.drawable.frame_nearby_live_head_game);
            } else {
                int i = userFindResult.link_type;
                if (i == 1) {
                    imageView2.setImageResource(R.drawable.live_pk_list_header_bg);
                } else if (i != 2) {
                    imageView2.setImageResource(R.drawable.frame_nearby_live_head);
                } else {
                    imageView2.setImageResource(R.drawable.frame_nearby_live_group);
                }
            }
            if (userFindResult.isShowUrlVisited) {
                return;
            }
            String str = userFindResult.uid;
            InstantLog.a(0, str, userFindResult.live + "", userFindResult.source, userFindResult.link_type == 1 ? "1" : "0", String.valueOf(userFindResult.realtime_count));
            userFindResult.isShowUrlVisited = true;
        }
    }
}
