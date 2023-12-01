package com.blued.android.module.yy_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.YYHomeChatsFragment;
import com.blued.android.module.yy_china.model.YyHomeChatItemDataInfoMode;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/HomeRotationPageAdapter.class */
public class HomeRotationPageAdapter extends PagerAdapter {
    public static int a = 500;
    public List<YyHomeChatItemDataInfoMode> b = new ArrayList();
    public YYHomeChatsFragment c;

    public HomeRotationPageAdapter(List<YyHomeChatItemDataInfoMode> list, YYHomeChatsFragment yYHomeChatsFragment) {
        if (list == null || list.size() != 1) {
            a = 500;
        } else {
            a = 1;
        }
        this.b.addAll(list);
        this.c = yYHomeChatsFragment;
    }

    private int a() {
        List<YyHomeChatItemDataInfoMode> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void a(ImageView imageView, int i) {
        YyHomeChatItemDataInfoMode yyHomeChatItemDataInfoMode = this.b.get(i);
        if (yyHomeChatItemDataInfoMode != null) {
            if (this.c != null) {
                if (StringUtils.b(yyHomeChatItemDataInfoMode.getCover())) {
                    ImageLoader.a(this.c.getFragmentActive(), yyHomeChatItemDataInfoMode.getUser_avatar()).b(R.drawable.user_bg_round).c().a(imageView);
                } else {
                    ImageLoader.a(this.c.getFragmentActive(), yyHomeChatItemDataInfoMode.getCover()).b(R.drawable.user_bg_round).c().a(imageView);
                }
            }
            if (yyHomeChatItemDataInfoMode.isDraw()) {
                return;
            }
            yyHomeChatItemDataInfoMode.setDraw(true);
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, yyHomeChatItemDataInfoMode.getRoom_id(), yyHomeChatItemDataInfoMode.getUid(), "0", yyHomeChatItemDataInfoMode.getRoom_type_id(), !StringUtils.b(yyHomeChatItemDataInfoMode.getThe_same_city()), "theme_room", "fast_room", yyHomeChatItemDataInfoMode.getLabel_link());
            EventTrackYY.d(ChatRoomProtos.Event.YY_HALL_TOP_FAST_ROOM_SHOW, yyHomeChatItemDataInfoMode.getRoom_id(), yyHomeChatItemDataInfoMode.getUid());
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return a() * a;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int a2 = i % a();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_rotetion_page, viewGroup, false);
        a((ImageView) inflate.findViewById(R.id.iv), a2);
        viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.b.size() > a2) {
            final YyHomeChatItemDataInfoMode yyHomeChatItemDataInfoMode = this.b.get(a2);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.HomeRotationPageAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (HomeRotationPageAdapter.this.c != null) {
                        HomeRotationPageAdapter.this.c.a(yyHomeChatItemDataInfoMode.getRoom_id(), "hall_fast_room");
                    }
                    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, yyHomeChatItemDataInfoMode.getRoom_id(), yyHomeChatItemDataInfoMode.getUid(), "0", yyHomeChatItemDataInfoMode.getRoom_type_id(), !StringUtils.b(yyHomeChatItemDataInfoMode.getThe_same_city()), "theme_room", "fast_room", yyHomeChatItemDataInfoMode.getLabel_link());
                    EventTrackYY.d(ChatRoomProtos.Event.YY_HALL_TOP_FAST_ROOM_CLICK, yyHomeChatItemDataInfoMode.getRoom_id(), yyHomeChatItemDataInfoMode.getUid());
                }
            });
        }
        return inflate;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
