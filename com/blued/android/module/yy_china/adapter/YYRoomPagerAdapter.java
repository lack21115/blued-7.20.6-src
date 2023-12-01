package com.blued.android.module.yy_china.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.yy_china.fragment.YYHomeMineFragment;
import com.blued.android.module.yy_china.fragment.YYRoomListItemFragment;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.model.HomeTopicModel;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRoomPagerAdapter.class */
public class YYRoomPagerAdapter extends BaseFragmentPagerAdapter {
    private List<HomeTopicModel> b;
    private String c;
    private OnCLickRoomItemToGoRoomListener d;
    private YYRoomExtraModel e;

    public YYRoomPagerAdapter(FragmentManager fragmentManager, String str, OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
        super(fragmentManager, 1);
        this.b = new ArrayList();
        this.c = str;
        this.d = onCLickRoomItemToGoRoomListener;
    }

    private boolean c(List<HomeTopicModel> list) {
        if (list.size() != this.b.size()) {
            this.b = list;
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.b = list;
                return false;
            } else if (this.b.get(i2).getLabel_id() != list.get(i2).getLabel_id()) {
                this.b = list;
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    public String a(int i) {
        if (i >= this.b.size()) {
            return "";
        }
        return this.b.get(i).getLabel_id() + "";
    }

    public void a(YYRoomExtraModel yYRoomExtraModel) {
        this.e = yYRoomExtraModel;
    }

    public void b() {
        this.a = new ArrayList();
    }

    public void b(List<HomeTopicModel> list) {
        Fragment fragment;
        if (!c(list)) {
            if (this.a != null && this.a.size() >= 2 && (fragment = this.a.get(1)) != null && (fragment instanceof YYRoomListItemFragment)) {
                ((YYRoomListItemFragment) fragment).a(this.e);
                return;
            }
            return;
        }
        List<Fragment> arrayList = new ArrayList<>();
        for (HomeTopicModel homeTopicModel : this.b) {
            Bundle bundle = new Bundle();
            bundle.putString("room_type", homeTopicModel.getLabel_id() + "");
            bundle.putString("from_source", this.c);
            String str = homeTopicModel.getLabel_id() + "";
            boolean z = true;
            if (str.hashCode() == 1444 && str.equals(YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID)) {
                z = false;
            }
            if (z) {
                YYRoomListItemFragment yYRoomListItemFragment = new YYRoomListItemFragment();
                yYRoomListItemFragment.a(this.e);
                yYRoomListItemFragment.a(this.d);
                yYRoomListItemFragment.setArguments(bundle);
                arrayList.add(yYRoomListItemFragment);
            } else {
                bundle.putBoolean("is_need_ref", false);
                YYHomeMineFragment yYHomeMineFragment = new YYHomeMineFragment();
                yYHomeMineFragment.a(this.d);
                yYHomeMineFragment.setArguments(bundle);
                arrayList.add(yYHomeMineFragment);
            }
        }
        a(arrayList);
    }

    public CharSequence getPageTitle(int i) {
        return this.b.get(i).getLabel_name();
    }
}
