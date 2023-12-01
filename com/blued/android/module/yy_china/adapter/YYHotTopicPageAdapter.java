package com.blued.android.module.yy_china.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.fragment.YYHotTopicALlFragment;
import com.blued.android.module.yy_china.fragment.YYHotTopicItemFragment;
import com.blued.android.module.yy_china.model.HotTopicModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYHotTopicPageAdapter.class */
public class YYHotTopicPageAdapter extends BaseFragmentPagerAdapter {
    private List<HotTopicModel> b;

    public YYHotTopicPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.b = new ArrayList();
    }

    public void b(List<HotTopicModel> list) {
        List<Fragment> arrayList = new ArrayList<>();
        for (HotTopicModel hotTopicModel : list) {
            Bundle bundle = new Bundle();
            bundle.putString("topic_type", hotTopicModel.getTopic_id() + "");
            bundle.putString("topic_name", hotTopicModel.getTopic() + "");
            if (StringUtils.a("0", hotTopicModel.getTopic_id())) {
                YYHotTopicALlFragment yYHotTopicALlFragment = new YYHotTopicALlFragment();
                yYHotTopicALlFragment.setArguments(bundle);
                arrayList.add(yYHotTopicALlFragment);
            } else {
                YYHotTopicItemFragment yYHotTopicItemFragment = new YYHotTopicItemFragment();
                yYHotTopicItemFragment.setArguments(bundle);
                arrayList.add(yYHotTopicItemFragment);
            }
        }
        a(arrayList);
    }

    public CharSequence getPageTitle(int i) {
        return this.b.get(i).getTopic();
    }
}
