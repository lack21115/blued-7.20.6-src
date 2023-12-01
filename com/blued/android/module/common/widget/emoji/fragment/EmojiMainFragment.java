package com.blued.android.module.common.widget.emoji.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.emoji.fragment.EmojiFragment;
import com.blued.android.module.common.widget.emoji.manager.Emoji;
import com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/EmojiMainFragment.class */
public class EmojiMainFragment extends Fragment implements EmojiFragment.OnEmojiClickedListener {
    private View a;
    private ViewPager b;
    private EmoticonsIndicatorView c;
    private List<Fragment> e;
    private OnMainEmojiClickedListener f;
    private EmojiPagerAdapter g;
    private List<Emoji> d = new ArrayList();
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/EmojiMainFragment$EmojiPagerAdapter.class */
    public class EmojiPagerAdapter extends FragmentPagerAdapter {
        public EmojiPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return EmojiMainFragment.this.e.size();
        }

        public Fragment getItem(int i) {
            return (Fragment) EmojiMainFragment.this.e.get(i);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/EmojiMainFragment$OnMainEmojiClickedListener.class */
    public interface OnMainEmojiClickedListener {
        void a(Emoji emoji);
    }

    private void a() {
        if (!this.i && this.j && this.h) {
            this.i = true;
            c();
        }
    }

    private void b() {
        this.b = this.a.findViewById(R.id.fragment_emoji_main_pager);
        this.c = (EmoticonsIndicatorView) this.a.findViewById(R.id.fragment_emoji_main_indicator);
    }

    private void c() {
        this.e = new ArrayList();
        if (this.d.size() <= 35) {
            EmojiFragment emojiFragment = new EmojiFragment();
            emojiFragment.a(this.d);
            emojiFragment.a(this);
            this.e.add(emojiFragment);
        } else {
            int size = this.d.size() / 35;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ArrayList arrayList = new ArrayList();
                EmojiFragment emojiFragment2 = new EmojiFragment();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < 35) {
                        arrayList.add(this.d.get((i2 * 35) + i4));
                        i3 = i4 + 1;
                    }
                }
                emojiFragment2.a(arrayList);
                emojiFragment2.a(this);
                this.e.add(emojiFragment2);
                i = i2 + 1;
            }
            if (this.d.size() % 35 != 0) {
                ArrayList arrayList2 = new ArrayList();
                EmojiFragment emojiFragment3 = new EmojiFragment();
                int i5 = size * 35;
                while (true) {
                    int i6 = i5;
                    if (i6 >= this.d.size()) {
                        break;
                    }
                    arrayList2.add(this.d.get(i6));
                    i5 = i6 + 1;
                }
                emojiFragment3.a(arrayList2);
                emojiFragment3.a(this);
                this.e.add(emojiFragment3);
            }
        }
        this.c.a(this.e.size());
        EmojiPagerAdapter emojiPagerAdapter = this.g;
        if (emojiPagerAdapter != null) {
            emojiPagerAdapter.notifyDataSetChanged();
            return;
        }
        EmojiPagerAdapter emojiPagerAdapter2 = new EmojiPagerAdapter(getChildFragmentManager());
        this.g = emojiPagerAdapter2;
        this.b.setAdapter(emojiPagerAdapter2);
        this.b.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.common.widget.emoji.fragment.EmojiMainFragment.1
            public void onPageScrollStateChanged(int i7) {
            }

            public void onPageScrolled(int i7, float f, int i8) {
            }

            public void onPageSelected(int i7) {
                EmojiMainFragment.this.c.b(i7);
            }
        });
    }

    public void a(OnMainEmojiClickedListener onMainEmojiClickedListener) {
        this.f = onMainEmojiClickedListener;
    }

    @Override // com.blued.android.module.common.widget.emoji.fragment.EmojiFragment.OnEmojiClickedListener
    public void a(Emoji emoji) {
        this.f.a(emoji);
    }

    public void a(List<Emoji> list) {
        this.d = list;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.a == null) {
            this.j = true;
            this.a = layoutInflater.inflate(R.layout.fragment_emoji_main, viewGroup, false);
            b();
            a();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.a.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.a);
        }
        return this.a;
    }

    public void onDetach() {
        super.onDetach();
        List<Fragment> list = this.e;
        if (list == null) {
            return;
        }
        list.clear();
    }

    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
        this.h = z;
        a();
    }
}
