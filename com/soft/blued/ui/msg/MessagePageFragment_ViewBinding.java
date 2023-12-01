package com.soft.blued.ui.msg;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.soft.blued.R;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MessagePageFragment_ViewBinding.class */
public class MessagePageFragment_ViewBinding implements Unbinder {
    private MessagePageFragment b;

    public MessagePageFragment_ViewBinding(MessagePageFragment messagePageFragment, View view) {
        this.b = messagePageFragment;
        messagePageFragment.vpIndicator = (TabPageIndicatorWithDot) Utils.a(view, R.id.vp_indicator, "field 'vpIndicator'", TabPageIndicatorWithDot.class);
        messagePageFragment.cttLeft = (ImageView) Utils.a(view, 2131363120, "field 'cttLeft'", ImageView.class);
        messagePageFragment.cttRight = (ImageView) Utils.a(view, 2131363126, "field 'cttRight'", ImageView.class);
        messagePageFragment.mainMsgViewpager = (CustomViewPager) Utils.a(view, R.id.main_msg_viewpager, "field 'mainMsgViewpager'", CustomViewPager.class);
        messagePageFragment.findBadgeContainer = (QBadgeContainer) Utils.a(view, R.id.find_badge_container, "field 'findBadgeContainer'", QBadgeContainer.class);
        messagePageFragment.title = Utils.a(view, R.id.top_title, "field 'title'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MessagePageFragment messagePageFragment = this.b;
        if (messagePageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        messagePageFragment.vpIndicator = null;
        messagePageFragment.cttLeft = null;
        messagePageFragment.cttRight = null;
        messagePageFragment.mainMsgViewpager = null;
        messagePageFragment.findBadgeContainer = null;
        messagePageFragment.title = null;
    }
}
