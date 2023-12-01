package com.blued.android.module.yy_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemHomeRoomGuideBinding;
import com.blued.android.module.yy_china.model.YYChatRoomGuideMode;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYHomeRoomGuideAdapter.class */
public class YYHomeRoomGuideAdapter extends PagerAdapter {
    private List<YYChatRoomGuideMode> a;
    private CommonDialogFragment b;
    private boolean c;

    public YYHomeRoomGuideAdapter(List<YYChatRoomGuideMode> list, CommonDialogFragment commonDialogFragment, boolean z) {
        this.a = list;
        this.b = commonDialogFragment;
        this.c = z;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        List<YYChatRoomGuideMode> list = this.a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ItemHomeRoomGuideBinding a = ItemHomeRoomGuideBinding.a(LayoutInflater.from(viewGroup.getContext()), viewGroup, true);
        if (this.a.size() > i) {
            YYChatRoomGuideMode yYChatRoomGuideMode = this.a.get(i);
            ImageLoader.a(this.b.a(), yYChatRoomGuideMode.getAvatar()).b(R.drawable.user_bg_round).c().a(a.e);
            a.i.setText(yYChatRoomGuideMode.getRoom_name());
            ArrayList arrayList = new ArrayList();
            arrayList.add(a.a);
            arrayList.add(a.b);
            arrayList.add(a.c);
            if (!yYChatRoomGuideMode.isUpload) {
                yYChatRoomGuideMode.isUpload = true;
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, yYChatRoomGuideMode.getRoom_id(), yYChatRoomGuideMode.getUid(), "-2", yYChatRoomGuideMode.getType_id(), false, "", "guide_pop", yYChatRoomGuideMode.label_link);
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_GUIDE_POP_SHOW, yYChatRoomGuideMode.getRoom_id(), i + 1, this.c);
            }
            if (yYChatRoomGuideMode.mem_count <= 3 || yYChatRoomGuideMode.others_avatar == null) {
                a.f.setVisibility(4);
                a.h.setVisibility(4);
            } else {
                TextView textView = a.h;
                textView.setText(yYChatRoomGuideMode.mem_count + "人在线");
                a.f.setVisibility(0);
                a.h.setVisibility(0);
                for (int i2 = 0; i2 < yYChatRoomGuideMode.others_avatar.size() && i2 < arrayList.size(); i2++) {
                    ImageLoader.a(this.b.a(), yYChatRoomGuideMode.others_avatar.get(i2)).b(R.drawable.user_bg_round).c().a((ImageView) arrayList.get(i2));
                }
            }
        }
        return a.getRoot();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
