package com.soft.blued.ui.live.adapter;

import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huawei.openalliance.ad.constant.s;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.model.LiveGrabModel;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveGrabAdapter.class */
public final class LiveGrabAdapter extends BaseMultiItemQuickAdapter<LiveGrabModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f17384a;

    public LiveGrabAdapter() {
        super(null);
        addItemType(0, R.layout.item_live_grab);
        addItemType(1, R.layout.item_live_grab_title);
        addItemType(2, R.layout.item_live_grab_empty);
        this.f17384a = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGrabModel liveGrabModel, View view) {
        Tracker.onClick(view);
        LiveRoomInfoChannel.a(AppInfo.d(), new LiveRoomData((liveGrabModel == null ? null : Long.valueOf(liveGrabModel.lid)).longValue(), 0, s.B, (liveGrabModel == null ? null : Long.valueOf(liveGrabModel.uid)).toString(), "", "", 0));
    }

    public final ArrayList<String> a() {
        return this.f17384a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final LiveGrabModel liveGrabModel) {
        BaseViewHolder text;
        BaseViewHolder text2;
        View view;
        if (liveGrabModel == null) {
            return;
        }
        boolean z = true;
        if (liveGrabModel.getItemType() == 1 || liveGrabModel.getItemType() == 2) {
            if (liveGrabModel.getItemType() != 1 || baseViewHolder == null) {
                return;
            }
            baseViewHolder.setText(R.id.item_live_grab_title_name, liveGrabModel.name);
            return;
        }
        if (!a().contains(String.valueOf(liveGrabModel.lid))) {
            a().add(String.valueOf(liveGrabModel.lid));
            EventTrackLive.c(LiveProtos.Event.LIVE_ROOM_SHOW, liveGrabModel.contentType == 2 ? "bag_list" : "bag_now", String.valueOf(liveGrabModel.lid), String.valueOf(liveGrabModel.uid));
        }
        ImageLoader.a((IRequestHost) null, liveGrabModel.cover).b(2131231620).a(baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.item_live_grab_avatar));
        if (baseViewHolder == null || (text = baseViewHolder.setText(R.id.item_live_grab_name, liveGrabModel.name)) == null || (text2 = text.setText(R.id.item_live_grab_beans_tv, String.valueOf(liveGrabModel.beans))) == null) {
            return;
        }
        if (liveGrabModel.contentType != 0) {
            z = false;
        }
        BaseViewHolder gone = text2.setGone(R.id.item_live_grab_beans_layout, z);
        if (gone == null || (view = gone.itemView) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.-$$Lambda$LiveGrabAdapter$8ogBzhsnsWqHy2XWi7FCUgQOuW4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveGrabAdapter.a(LiveGrabModel.this, view2);
            }
        });
    }
}
