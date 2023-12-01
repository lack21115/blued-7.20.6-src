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
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYHomeRoomGuideAdapter.class */
public class YYHomeRoomGuideAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<YYChatRoomGuideMode> f16181a;
    private CommonDialogFragment b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16182c;

    public YYHomeRoomGuideAdapter(List<YYChatRoomGuideMode> list, CommonDialogFragment commonDialogFragment, boolean z) {
        this.f16181a = list;
        this.b = commonDialogFragment;
        this.f16182c = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<YYChatRoomGuideMode> list = this.f16181a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ItemHomeRoomGuideBinding a2 = ItemHomeRoomGuideBinding.a(LayoutInflater.from(viewGroup.getContext()), viewGroup, true);
        if (this.f16181a.size() > i) {
            YYChatRoomGuideMode yYChatRoomGuideMode = this.f16181a.get(i);
            ImageLoader.a(this.b.a(), yYChatRoomGuideMode.getAvatar()).b(R.drawable.user_bg_round).c().a(a2.e);
            a2.i.setText(yYChatRoomGuideMode.getRoom_name());
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2.f16621a);
            arrayList.add(a2.b);
            arrayList.add(a2.f16622c);
            if (!yYChatRoomGuideMode.isUpload) {
                yYChatRoomGuideMode.isUpload = true;
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_DRAW, yYChatRoomGuideMode.getRoom_id(), yYChatRoomGuideMode.getUid(), ErrorContants.NET_NO_CALLBACK, yYChatRoomGuideMode.getType_id(), false, "", "guide_pop", yYChatRoomGuideMode.label_link);
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_GUIDE_POP_SHOW, yYChatRoomGuideMode.getRoom_id(), i + 1, this.f16182c);
            }
            if (yYChatRoomGuideMode.mem_count <= 3 || yYChatRoomGuideMode.others_avatar == null) {
                a2.f.setVisibility(4);
                a2.h.setVisibility(4);
            } else {
                TextView textView = a2.h;
                textView.setText(yYChatRoomGuideMode.mem_count + "人在线");
                a2.f.setVisibility(0);
                a2.h.setVisibility(0);
                for (int i2 = 0; i2 < yYChatRoomGuideMode.others_avatar.size() && i2 < arrayList.size(); i2++) {
                    ImageLoader.a(this.b.a(), yYChatRoomGuideMode.others_avatar.get(i2)).b(R.drawable.user_bg_round).c().a((ImageView) arrayList.get(i2));
                }
            }
        }
        return a2.getRoot();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
