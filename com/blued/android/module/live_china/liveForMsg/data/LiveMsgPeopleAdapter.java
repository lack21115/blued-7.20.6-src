package com.blued.android.module.live_china.liveForMsg.data;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/data/LiveMsgPeopleAdapter.class */
public class LiveMsgPeopleAdapter extends BaseQuickAdapter<ProfileData, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f13540a;
    private Boolean b;

    public LiveMsgPeopleAdapter(Context context) {
        super(R.layout.item_live_msg_people, new ArrayList());
        this.f13540a = context;
    }

    private void b() {
        if (LiveRoomManager.a().w() == null || LiveRoomManager.a().w().size() <= 50) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 50) {
                LiveRoomManager.a().w().clear();
                LiveRoomManager.a().w().addAll(arrayList);
                return;
            }
            arrayList.add(LiveRoomManager.a().w().get(i2));
            i = i2 + 1;
        }
    }

    public void a() {
        b();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(LiveRoomManager.a().x());
        arrayList.addAll(LiveRoomManager.a().w());
        setNewData(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final ProfileData profileData) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.live_user_avatar_decorate);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.item_avatar);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.item_avatar_v);
        ImageLoader.a((IRequestHost) null, AvatarUtils.a(1, profileData.avatar)).b(R.drawable.user_bg_round).c().a(imageView2);
        imageView3.setVisibility(8);
        LiveRoomInfo.a().a(imageView3, profileData.vBadge);
        if (TextUtils.isEmpty(profileData.avatar_frame)) {
            if (profileData.liveViewerRank == 1) {
                imageView.setImageResource(R.drawable.live_viewer_rank_1);
            } else if (profileData.liveViewerRank == 2) {
                imageView.setImageResource(R.drawable.live_viewer_rank_2);
            } else if (profileData.liveViewerRank == 3) {
                imageView.setImageResource(R.drawable.live_viewer_rank_3);
            } else {
                imageView.setImageResource(R.color.transparent);
            }
        } else if (profileData.avatar_frame_type == 1) {
            ImageLoader.a((IRequestHost) null, profileData.avatar_frame).f(imageView.hashCode()).g(-1).a(imageView);
        } else if (profileData.avatar_frame_type == 2) {
            ImageLoader.a((IRequestHost) null, profileData.avatar_frame).e(imageView.hashCode()).g(-1).a(imageView);
        } else {
            ImageLoader.a((IRequestHost) null, profileData.avatar_frame).a(imageView);
        }
        if (this.b.booleanValue()) {
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.liveForMsg.data.LiveMsgPeopleAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ProfileData profileData2 = profileData;
                    if (profileData2 == null || profileData2.privilege == 1) {
                        return;
                    }
                    LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
                    liveRoomUserModel.uid = String.valueOf(profileData.uid);
                    liveRoomUserModel.avatar = profileData.avatar;
                    LiveSetDataObserver.a().a(liveRoomUserModel);
                }
            });
        }
    }

    public void a(Boolean bool) {
        this.b = bool;
    }
}
