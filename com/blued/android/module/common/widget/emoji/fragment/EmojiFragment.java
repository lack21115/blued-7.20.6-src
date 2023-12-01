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
import com.blued.android.module.common.widget.emoji.manager.Emoji;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/EmojiFragment.class */
public class EmojiFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private View f11123a;
    private GridView b;
    private OnEmojiClickedListener d;
    private EmojiAdapter e;

    /* renamed from: c  reason: collision with root package name */
    private final List<Emoji> f11124c = new ArrayList();
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/EmojiFragment$EmojiAdapter.class */
    public class EmojiAdapter extends ArrayAdapter<Emoji> {

        /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/EmojiFragment$EmojiAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            TextView f11127a;

            ViewHolder() {
            }
        }

        public EmojiAdapter(Context context, List<Emoji> list) {
            super(context, R.layout.emojicon_item, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(getContext(), R.layout.emojicon_item, null);
                viewHolder = new ViewHolder();
                viewHolder.f11127a = (TextView) view.findViewById(R.id.emojicon_icon);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final Emoji item = getItem(i);
            if (item == null) {
                viewHolder.f11127a.setVisibility(4);
                return view;
            }
            viewHolder.f11127a.setVisibility(0);
            viewHolder.f11127a.setText(item.a());
            viewHolder.f11127a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.emoji.fragment.EmojiFragment.EmojiAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    EmojiFragment.this.d.a(item);
                }
            });
            return view;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/fragment/EmojiFragment$OnEmojiClickedListener.class */
    public interface OnEmojiClickedListener {
        void a(Emoji emoji);
    }

    private void a() {
        this.b = (GridView) this.f11123a.findViewById(R.id.fragment_emoji_grid);
    }

    private void b() {
        EmojiAdapter emojiAdapter = this.e;
        if (emojiAdapter != null) {
            emojiAdapter.notifyDataSetChanged();
            return;
        }
        EmojiAdapter emojiAdapter2 = new EmojiAdapter(getContext(), this.f11124c);
        this.e = emojiAdapter2;
        this.b.setAdapter((ListAdapter) emojiAdapter2);
    }

    private void c() {
        if (!this.g && this.h && this.f) {
            this.g = true;
            b();
        }
    }

    public void a(OnEmojiClickedListener onEmojiClickedListener) {
        this.d = onEmojiClickedListener;
    }

    public void a(List<Emoji> list) {
        this.f11124c.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 35) {
                break;
            }
            if (i2 < list.size()) {
                this.f11124c.add(list.get(i2));
            } else {
                this.f11124c.add(null);
            }
            i = i2 + 1;
        }
        EmojiAdapter emojiAdapter = this.e;
        if (emojiAdapter != null) {
            emojiAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f11123a == null) {
            this.h = true;
            this.f11123a = layoutInflater.inflate(R.layout.fragment_emoji, viewGroup, false);
            a();
            c();
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f11123a.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f11123a);
        }
        return this.f11123a;
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
        c();
    }
}
