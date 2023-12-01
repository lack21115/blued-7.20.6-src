package com.soft.blued.ui.find.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.soft.blued.ui.community.fragment.NearbyFeedHomeFragment;
import com.soft.blued.ui.find.fragment.NearbyPeopleFragment;
import com.soft.blued.ui.find.model.HomeTopTabModel;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/NearbyHomePagerAdapter.class */
public class NearbyHomePagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<HomeTopTabModel> f30076a;
    private NearbyPeopleFragment b;

    public NearbyHomePagerAdapter(FragmentManager fragmentManager, List<HomeTopTabModel> list) {
        super(fragmentManager);
        this.f30076a = list;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f30076a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        int i2 = this.f30076a.get(i).tab_id;
        if (i2 != 1) {
            return i2 != 2 ? new NearbyPeopleFragment() : new NearbyFeedHomeFragment();
        }
        NearbyPeopleFragment nearbyPeopleFragment = new NearbyPeopleFragment();
        this.b = nearbyPeopleFragment;
        return nearbyPeopleFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.f30076a.get(i).tab_title;
    }
}
