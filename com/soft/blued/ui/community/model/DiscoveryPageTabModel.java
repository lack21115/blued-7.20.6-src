package com.soft.blued.ui.community.model;

import android.content.Context;
import com.blued.android.core.ui.BaseFragment;
import com.soft.blued.R;
import com.soft.blued.ui.community.fragment.AttentionFeedHomeFragment;
import com.soft.blued.ui.community.fragment.CircleHomeFragment;
import com.soft.blued.ui.community.fragment.RecommendFeedHomeFragment;
import com.soft.blued.user.BluedConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/model/DiscoveryPageTabModel.class */
public class DiscoveryPageTabModel {
    private static List<DiscoveryPageTabModel> tabs;
    public int tabid;
    public String title;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/model/DiscoveryPageTabModel$DISCOVERY_TAB_ID.class */
    public interface DISCOVERY_TAB_ID {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/model/DiscoveryPageTabModel$DiscoveryTabDef.class */
    public @interface DiscoveryTabDef {
    }

    public DiscoveryPageTabModel(int i, Context context) {
        this.tabid = i;
        if (i == 2) {
            this.title = context.getResources().getString(R.string.recommend_feed);
        } else if (i == 3) {
            this.title = context.getResources().getString(R.string.feed_attention);
        } else if (i != 4) {
        } else {
            this.title = context.getResources().getString(R.string.base);
        }
    }

    public static void clearTabs() {
        tabs = null;
    }

    public static List<DiscoveryPageTabModel> getDiscoveryTabs(Context context) {
        List<DiscoveryPageTabModel> list = tabs;
        if (list == null || list.size() <= 0) {
            ArrayList arrayList = new ArrayList();
            tabs = arrayList;
            arrayList.add(new DiscoveryPageTabModel(3, context));
            tabs.add(new DiscoveryPageTabModel(2, context));
            if (BluedConfig.a().V()) {
                tabs.add(new DiscoveryPageTabModel(4, context));
            }
            return tabs;
        }
        return tabs;
    }

    public static int getTabPosition(int i) {
        if (tabs == null) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= tabs.size()) {
                return -1;
            }
            if (tabs.get(i3).tabid == i) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    public BaseFragment getFragment() {
        int i = this.tabid;
        return i != 3 ? i != 4 ? new RecommendFeedHomeFragment() : new CircleHomeFragment() : new AttentionFeedHomeFragment();
    }
}
