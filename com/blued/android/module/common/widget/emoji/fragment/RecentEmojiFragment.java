package com.blued.android.module.common.widget.emoji.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.emoji.category.PeopleCategory;
import com.blued.android.module.common.widget.emoji.manager.Emoji;
import com.blued.android.module.common.widget.emoji.view.EmoticonsIndicatorView;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/RecentEmojiFragment.class */
public class RecentEmojiFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private View f11132a;
    private GridView b;
    private OnRecentEmojiClickedListener d;
    private EmojiAdapter e;

    /* renamed from: c  reason: collision with root package name */
    private List<Emoji> f11133c = new ArrayList();
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/RecentEmojiFragment$EmojiAdapter.class */
    public class EmojiAdapter extends ArrayAdapter<Emoji> {

        /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/RecentEmojiFragment$EmojiAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            TextView f11136a;

            ViewHolder() {
            }
        }

        public EmojiAdapter(Context context, List<Emoji> list) {
            super(context, R.layout.emojicon_item, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = view;
            if (view == null) {
                view2 = View.inflate(getContext(), R.layout.emojicon_item, null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.f11136a = (TextView) view2.findViewById(R.id.emojicon_icon);
                view2.setTag(viewHolder);
            }
            final Emoji item = getItem(i);
            ViewHolder viewHolder2 = (ViewHolder) view2.getTag();
            if (item == null) {
                viewHolder2.f11136a.setVisibility(4);
                return view2;
            }
            viewHolder2.f11136a.setVisibility(0);
            viewHolder2.f11136a.setText(item.a());
            viewHolder2.f11136a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.emoji.fragment.RecentEmojiFragment.EmojiAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    RecentEmojiFragment.this.d.b(item);
                }
            });
            return view2;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/RecentEmojiFragment$OnRecentEmojiClickedListener.class */
    public interface OnRecentEmojiClickedListener {
        void b(Emoji emoji);
    }

    private void a() {
        this.b = (GridView) this.f11132a.findViewById(R.id.fragment_recent_emoji_grid);
        ((EmoticonsIndicatorView) this.f11132a.findViewById(R.id.fragment_recent_emoji_indicator)).a(1);
    }

    private void b() {
        if (!this.g && this.h && this.f) {
            this.g = true;
            c();
        }
    }

    private void c() {
        EmojiAdapter emojiAdapter = this.e;
        if (emojiAdapter != null) {
            emojiAdapter.notifyDataSetChanged();
            return;
        }
        EmojiAdapter emojiAdapter2 = new EmojiAdapter(getContext(), this.f11133c);
        this.e = emojiAdapter2;
        this.b.setAdapter((ListAdapter) emojiAdapter2);
    }

    public void a(OnRecentEmojiClickedListener onRecentEmojiClickedListener) {
        this.d = onRecentEmojiClickedListener;
    }

    public void a(Collection<Emoji> collection) {
        this.f11133c.clear();
        Emoji[] emojiArr = (Emoji[]) collection.toArray(new Emoji[collection.size()]);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= emojiArr.length) {
                break;
            }
            this.f11133c.add(emojiArr[i2]);
            i = i2 + 1;
        }
        if (collection.size() < 35) {
            int size = collection.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 35 - size) {
                    break;
                }
                this.f11133c.add(PeopleCategory.f11120a[i4]);
                i3 = i4 + 1;
            }
        }
        EmojiAdapter emojiAdapter = this.e;
        if (emojiAdapter != null) {
            emojiAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f11132a == null) {
            this.h = true;
            this.f11132a = layoutInflater.inflate(R.layout.fragment_recent_emoji, viewGroup, false);
            a();
            b();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f11132a.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f11132a);
        }
        return this.f11132a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
        this.f = z;
        b();
    }
}
