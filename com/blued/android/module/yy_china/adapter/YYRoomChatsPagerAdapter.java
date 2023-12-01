package com.blued.android.module.yy_china.adapter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.yy_china.fragment.YYChatRoomItemFragment;
import com.blued.android.module.yy_china.fragment.YYHomeMineFragment;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.model.HomeThemeModel;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRoomChatsPagerAdapter.class */
public class YYRoomChatsPagerAdapter extends BaseFragmentPagerAdapter {
    private List<HomeThemeModel> b;
    private String c;
    private OnCLickRoomItemToGoRoomListener d;
    private YYRoomExtraModel e;

    public YYRoomChatsPagerAdapter(FragmentManager fragmentManager, String str, OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
        super(fragmentManager, 1);
        this.b = new ArrayList();
        this.c = str;
        this.d = onCLickRoomItemToGoRoomListener;
    }

    private boolean c(List<HomeThemeModel> list) {
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
            } else if (this.b.get(i2).getId() != list.get(i2).getId()) {
                this.b = list;
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    public void a(YYRoomExtraModel yYRoomExtraModel) {
        this.e = yYRoomExtraModel;
    }

    public void b() {
        this.a = new ArrayList();
    }

    public void b(List<HomeThemeModel> list) {
        if (c(list)) {
            List<Fragment> arrayList = new ArrayList<>();
            for (HomeThemeModel homeThemeModel : this.b) {
                Bundle bundle = new Bundle();
                bundle.putString("room_type", homeThemeModel.getId() + "");
                bundle.putString("from_source", this.c);
                String str = homeThemeModel.getId() + "";
                boolean z = true;
                if (str.hashCode() == 1444 && str.equals(YYGiftPackageModel.YY_GIFT_BAG_TYPE_ID)) {
                    z = false;
                }
                if (z) {
                    YYChatRoomItemFragment yYChatRoomItemFragment = new YYChatRoomItemFragment();
                    yYChatRoomItemFragment.a(this.d);
                    yYChatRoomItemFragment.setArguments(bundle);
                    arrayList.add(yYChatRoomItemFragment);
                } else {
                    bundle.putBoolean("is_need_ref", true);
                    YYHomeMineFragment yYHomeMineFragment = new YYHomeMineFragment();
                    yYHomeMineFragment.a(this.d);
                    yYHomeMineFragment.setArguments(bundle);
                    arrayList.add(yYHomeMineFragment);
                }
            }
            a(arrayList);
        }
    }

    public CharSequence getPageTitle(int i) {
        return this.b.get(i).getName();
    }
}
