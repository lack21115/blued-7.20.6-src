package com.blued.android.module.common.widget.emoji.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.emoji.category.ActivityCategory;
import com.blued.android.module.common.widget.emoji.category.FlagsCategory;
import com.blued.android.module.common.widget.emoji.category.FoodsCategory;
import com.blued.android.module.common.widget.emoji.category.NatureCategory;
import com.blued.android.module.common.widget.emoji.category.ObjectsCategory;
import com.blued.android.module.common.widget.emoji.category.PeopleCategory;
import com.blued.android.module.common.widget.emoji.category.PlacesCategory;
import com.blued.android.module.common.widget.emoji.category.SymbolsCategory;
import com.blued.android.module.common.widget.emoji.fragment.EmojiMainFragment;
import com.blued.android.module.common.widget.emoji.fragment.RecentEmojiFragment;
import com.blued.android.module.common.widget.emoji.manager.Emoji;
import com.blued.android.module.common.widget.emoji.manager.RecentEmojiManager;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/view/EmojiKeyboardLayout.class */
public class EmojiKeyboardLayout extends LinearLayout implements EmojiMainFragment.OnMainEmojiClickedListener, RecentEmojiFragment.OnRecentEmojiClickedListener {
    public static final int a = R.color.black;
    public static final int b = R.color.black;
    public static final int c = R.color.white;
    public static final int d = R.color.white;
    private ViewPager e;
    private LinearLayout f;
    private View g;
    private List<FragmentEntity> h;
    private RecentEmojiFragment i;
    private EmojiCallback j;
    private RecentEmojiManager k;
    private FragmentManager l;
    private EmojiPagerAdapter m;
    private int n;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/view/EmojiKeyboardLayout$EmojiCallback.class */
    public interface EmojiCallback {
        void a();

        void a(Emoji emoji);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/view/EmojiKeyboardLayout$EmojiPagerAdapter.class */
    public class EmojiPagerAdapter extends FragmentPagerAdapter {
        public EmojiPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return EmojiKeyboardLayout.this.h.size();
        }

        public Fragment getItem(int i) {
            FragmentEntity fragmentEntity = (FragmentEntity) EmojiKeyboardLayout.this.h.get(i);
            Fragment instantiate = Fragment.instantiate(EmojiKeyboardLayout.this.getContext(), fragmentEntity.a.getName(), (Bundle) null);
            if (instantiate instanceof EmojiMainFragment) {
                EmojiMainFragment emojiMainFragment = (EmojiMainFragment) instantiate;
                emojiMainFragment.a(fragmentEntity.c);
                emojiMainFragment.a(EmojiKeyboardLayout.this);
                return instantiate;
            }
            if (instantiate instanceof RecentEmojiFragment) {
                RecentEmojiFragment recentEmojiFragment = (RecentEmojiFragment) instantiate;
                recentEmojiFragment.a(fragmentEntity.b);
                recentEmojiFragment.a(EmojiKeyboardLayout.this);
                EmojiKeyboardLayout.this.i = recentEmojiFragment;
            }
            return instantiate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/view/EmojiKeyboardLayout$FragmentEntity.class */
    public static class FragmentEntity {
        public Class<?> a;
        public Collection<Emoji> b;
        public List<Emoji> c;

        public FragmentEntity(Class<?> cls, List<Emoji> list, Collection<Emoji> collection) {
            this.a = cls;
            this.c = list;
            this.b = collection;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/view/EmojiKeyboardLayout$OnTabClickedListener.class */
    public class OnTabClickedListener implements View.OnClickListener {
        private int b;

        public OnTabClickedListener(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            EmojiKeyboardLayout.this.e.setCurrentItem(this.b, true);
        }
    }

    public EmojiKeyboardLayout(Context context) {
        this(context, null);
    }

    public EmojiKeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 0;
        setOrientation(1);
        this.k = new RecentEmojiManager(context);
    }

    private void a() {
        EmojiPagerAdapter emojiPagerAdapter;
        if (isInEditMode()) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.g != null) {
            RecentEmojiFragment recentEmojiFragment = this.i;
            if (recentEmojiFragment != null) {
                recentEmojiFragment.a(this.k.a());
            }
            addView(this.g, layoutParams);
            return;
        }
        View inflate = View.inflate(getContext(), R.layout.layout_emoji_keyboard, null);
        this.g = inflate;
        addView(inflate, layoutParams);
        this.e = findViewById(R.id.fragment_emoji_keyboard_pager);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fragment_emoji_keyboard_tab);
        this.f = linearLayout;
        linearLayout.getChildAt(0).setSelected(true);
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        arrayList.add(new FragmentEntity(RecentEmojiFragment.class, null, this.k.a()));
        this.h.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(PeopleCategory.a), null));
        this.h.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(NatureCategory.a), null));
        this.h.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(FoodsCategory.a), null));
        this.h.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(ActivityCategory.a), null));
        this.h.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(PlacesCategory.a), null));
        this.h.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(ObjectsCategory.a), null));
        this.h.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(SymbolsCategory.a), null));
        this.h.add(new FragmentEntity(EmojiMainFragment.class, Arrays.asList(FlagsCategory.a), null));
        FragmentManager fragmentManager = this.l;
        if (fragmentManager != null) {
            this.m = new EmojiPagerAdapter(fragmentManager);
        }
        ViewPager viewPager = this.e;
        if (viewPager != null && (emojiPagerAdapter = this.m) != null) {
            viewPager.setAdapter(emojiPagerAdapter);
        }
        this.e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.2
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                ((ViewGroup) EmojiKeyboardLayout.this.f.getChildAt(i)).getChildAt(0).setSelected(true);
                ((ViewGroup) EmojiKeyboardLayout.this.f.getChildAt(i)).getChildAt(0).setBackgroundResource(R.drawable.emoji_circle_bg);
                ((ViewGroup) EmojiKeyboardLayout.this.f.getChildAt(EmojiKeyboardLayout.this.n)).getChildAt(0).setSelected(false);
                ((ViewGroup) EmojiKeyboardLayout.this.f.getChildAt(EmojiKeyboardLayout.this.n)).getChildAt(0).setBackgroundResource(0);
                EmojiKeyboardLayout.this.n = i;
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f.getChildCount() - 1) {
                LinearLayout linearLayout2 = this.f;
                linearLayout2.getChildAt(linearLayout2.getChildCount() - 1).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (EmojiKeyboardLayout.this.j == null) {
                            return;
                        }
                        EmojiKeyboardLayout.this.j.a();
                    }
                });
                return;
            }
            ((ViewGroup) this.f.getChildAt(i2)).getChildAt(0).setOnClickListener(new OnTabClickedListener(i2));
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.common.widget.emoji.fragment.EmojiMainFragment.OnMainEmojiClickedListener
    public void a(Emoji emoji) {
        this.k.a(emoji);
        EmojiCallback emojiCallback = this.j;
        if (emojiCallback == null) {
            return;
        }
        emojiCallback.a(emoji);
    }

    @Override // com.blued.android.module.common.widget.emoji.fragment.RecentEmojiFragment.OnRecentEmojiClickedListener
    public void b(Emoji emoji) {
        this.k.a(emoji);
        EmojiCallback emojiCallback = this.j;
        if (emojiCallback == null) {
            return;
        }
        emojiCallback.a(emoji);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k.b();
        removeView(this.g);
    }

    public void setEmojiCallback(EmojiCallback emojiCallback) {
        this.j = emojiCallback;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.l = fragmentManager;
        if (fragmentManager != null) {
            EmojiPagerAdapter emojiPagerAdapter = new EmojiPagerAdapter(fragmentManager);
            this.m = emojiPagerAdapter;
            ViewPager viewPager = this.e;
            if (viewPager != null) {
                viewPager.setAdapter(emojiPagerAdapter);
            }
        }
    }

    public void setKeyboardColor(final int i) {
        post(new Runnable() { // from class: com.blued.android.module.common.widget.emoji.view.EmojiKeyboardLayout.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int i3;
                int i4 = EmojiKeyboardLayout.a;
                int i5 = EmojiKeyboardLayout.b;
                if (i != 2) {
                    i2 = EmojiKeyboardLayout.a;
                    i3 = EmojiKeyboardLayout.b;
                } else {
                    i2 = EmojiKeyboardLayout.c;
                    i3 = EmojiKeyboardLayout.d;
                }
                if (EmojiKeyboardLayout.this.e != null) {
                    EmojiKeyboardLayout.this.e.setBackgroundColor(EmojiKeyboardLayout.this.getResources().getColor(i2));
                }
                if (EmojiKeyboardLayout.this.f != null) {
                    EmojiKeyboardLayout.this.f.setBackgroundColor(EmojiKeyboardLayout.this.getResources().getColor(i3));
                }
            }
        });
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        RecentEmojiFragment recentEmojiFragment = this.i;
        if (recentEmojiFragment != null && i == 0) {
            recentEmojiFragment.a(this.k.a());
        }
    }
}
