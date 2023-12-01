package com.blued.community.ui.square.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.ChatRoom;
import com.blued.community.track.EventTrackFeed;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/adapter/RecommendChatRoomAdapter.class */
public class RecommendChatRoomAdapter extends BaseQuickAdapter<ChatRoom, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f20119a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private String f20120c;
    private long d;
    private int e;

    public RecommendChatRoomAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_recommend_chat_room, null);
        this.f20120c = "";
        this.f20119a = context;
        this.b = iRequestHost;
        this.f20120c = context.getString(R.string.community_in_chat_room);
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.d = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final ChatRoom chatRoom) {
        ImageLoader.a(this.b, chatRoom.yy_user_avatar).b(R.drawable.user_bg_round).c().a((ImageView) baseViewHolder.getView(R.id.header_view));
        ImageLoader.c(this.b, "anim_chat_list.png").e(baseViewHolder.hashCode()).g(-1).a((ImageView) baseViewHolder.getView(R.id.img_chat_room));
        BaseViewHolder text = baseViewHolder.setText(R.id.tv_chat_room_name, chatRoom.yy_room_name);
        int i = R.id.tv_chat_room_desc;
        text.setText(i, chatRoom.yy_mem_count + this.f20120c);
        baseViewHolder.getConvertView().setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.adapter.RecommendChatRoomAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.a(FeedProtos.Event.FEED_CHATROOM_CLICK, chatRoom.yy_room_id, chatRoom.yy_uid, RecommendChatRoomAdapter.this.e, RecommendChatRoomAdapter.this.d);
                CommunityServiceManager.b().c(RecommendChatRoomAdapter.this.f20119a, chatRoom.yy_room_id, "plaza_recommend_yy_room");
            }
        });
        if (chatRoom.isShowUrlVisited) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.FEED_CHATROOM_SHOW, chatRoom.yy_room_id, chatRoom.yy_uid, this.e, this.d);
        chatRoom.isShowUrlVisited = true;
    }
}
