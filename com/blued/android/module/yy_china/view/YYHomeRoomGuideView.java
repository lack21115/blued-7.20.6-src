package com.blued.android.module.yy_china.view;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYHomeRoomGuideAdapter;
import com.blued.android.module.yy_china.databinding.DialogHomeRoomsGuideBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYChatRoomGuideMode;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHomeRoomGuideView.class */
public class YYHomeRoomGuideView extends CommonDialogFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private DialogHomeRoomsGuideBinding b;
    private YYHomeRoomGuideAdapter c;
    private boolean d;
    private List<YYChatRoomGuideMode> e;
    private int f;

    public static void a(BaseFragment baseFragment, List<YYChatRoomGuideMode> list, boolean z) {
        YYHomeRoomGuideView yYHomeRoomGuideView = new YYHomeRoomGuideView();
        yYHomeRoomGuideView.a(list, z);
        yYHomeRoomGuideView.show(baseFragment.getChildFragmentManager(), yYHomeRoomGuideView.getClass().getName());
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public void a(View view) {
        this.b = DialogHomeRoomsGuideBinding.a(view);
        this.c = new YYHomeRoomGuideAdapter(this.e, this, this.d);
        this.b.e.setAdapter(this.c);
        this.b.e.addOnPageChangeListener(this);
        this.b.f.setViewPager(this.b.e);
        this.b.d.setOnClickListener(this);
        this.b.b.setOnClickListener(this);
        this.b.a.setOnClickListener(this);
        this.b.c.setOnClickListener(this);
        this.c.notifyDataSetChanged();
    }

    public void a(List<YYChatRoomGuideMode> list, boolean z) {
        this.d = z;
        this.e = list;
    }

    @Override // com.blued.android.module.common.base.dialog.CommonDialogFragment
    public int d() {
        return R.layout.dialog_home_rooms_guide;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.fl_con) {
            List<YYChatRoomGuideMode> list = this.e;
            if (list != null && this.f < list.size()) {
                this.e.get(this.f);
            }
            dismissAllowingStateLoss();
        } else if (view.getId() != R.id.tv_join_room) {
            if (view.getId() == R.id.iv_backs) {
                List<YYChatRoomGuideMode> list2 = this.e;
                if (list2 != null && this.f < list2.size()) {
                    this.e.get(this.f);
                }
                dismissAllowingStateLoss();
            }
        } else {
            List<YYChatRoomGuideMode> list3 = this.e;
            if (list3 == null || list3.size() <= this.f) {
                return;
            }
            dismissAllowingStateLoss();
            YYChatRoomGuideMode yYChatRoomGuideMode = this.e.get(this.f);
            YYRoomInfoManager.e().a((BaseFragmentActivity) getActivity(), yYChatRoomGuideMode.getRoom_id(), "hall_guide_pop");
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_GUIDE_POP_JOIN_CLICK, yYChatRoomGuideMode.getRoom_id(), this.f + 1, this.d);
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, yYChatRoomGuideMode.getRoom_id(), yYChatRoomGuideMode.getUid(), "-2", yYChatRoomGuideMode.getType_id(), false, "", "guide_pop", yYChatRoomGuideMode.label_link);
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.f = i;
        List<YYChatRoomGuideMode> list = this.e;
        if (list == null || i >= list.size() || this.e.get(i).is_Pow) {
            return;
        }
        this.e.get(i).is_Pow = true;
    }
}
