package com.blued.community.ui.video.adapter;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.ui.video.model.MusicListItem;
import com.blued.community.ui.video.observer.MusicChoosedObserver;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/MusicListAdapter.class */
public class MusicListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<MusicListItem> f20281a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f20282c;
    public ViewHolder d;
    public int e;
    public ListView f;
    public int g;
    public int h;
    public String i;
    public IRequestHost j;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/MusicListAdapter$ViewHolder.class */
    public class ViewHolder {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f20289c;
        private TextView d;
        private TextView e;
        private TextView f;
        private TextView g;

        public ViewHolder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(View view) {
            this.b = (ImageView) view.findViewById(R.id.img_cover);
            this.f20289c = (ImageView) view.findViewById(R.id.img_cover_icon);
            this.d = (TextView) view.findViewById(R.id.tv_music_name);
            this.e = (TextView) view.findViewById(R.id.tv_music_composer);
            this.f = (TextView) view.findViewById(R.id.tv_music_time);
            this.g = (TextView) view.findViewById(R.id.tv_use_btn);
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public MusicListItem getItem(int i) {
        return this.f20281a.get(i);
    }

    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f20281a.size()) {
                return;
            }
            this.f20281a.get(i2).isChoosed = false;
            i = i2 + 1;
        }
    }

    public void a(final int i, ViewHolder viewHolder) {
        if (i != c()) {
            a();
            this.f20281a.get(i).isChoosed = true;
            ListView listView = this.f;
            if (listView != null && this.d != null && this.e <= listView.getLastVisiblePosition() - 1 && this.e >= this.f.getFirstVisiblePosition() - 1) {
                a(this.d.g, this.h, this.g, -1);
                this.d.f20289c.setImageResource(R.drawable.icon_music_play);
                this.d.b.clearAnimation();
            }
            a(viewHolder.g, this.g, this.h, i);
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.ui.video.adapter.MusicListAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (MusicListAdapter.this.f20281a.get(i).isPlaying) {
                    MusicListAdapter.this.f20281a.get(i).isPlaying = false;
                    MusicChoosedObserver.a().b();
                } else {
                    MusicListAdapter.this.b();
                    MusicListAdapter.this.f20281a.get(i).isPlaying = true;
                    MusicChoosedObserver a2 = MusicChoosedObserver.a();
                    String str = MusicListAdapter.this.f20281a.get(i).download;
                    a2.b(str, MusicListAdapter.this.f20281a.get(i).id + "");
                }
                MusicListAdapter.this.notifyDataSetChanged();
            }
        }, 120L);
        this.e = i;
        this.d = viewHolder;
    }

    public void a(final View view, int i, int i2, int i3) {
        new ObjectAnimator();
        ValueAnimator ofInt = ObjectAnimator.ofInt(i, i2);
        ofInt.setDuration(100L);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.video.adapter.MusicListAdapter.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.rightMargin = intValue;
                view.setLayoutParams(layoutParams);
            }
        });
        ofInt.start();
    }

    public void a(TextView textView, String str, int i) {
        int indexOf;
        if (TextUtils.isEmpty(str) || textView == null) {
            return;
        }
        String lowerCase = textView.getText().toString().toLowerCase();
        String lowerCase2 = str.toLowerCase();
        if (!lowerCase.contains(lowerCase2)) {
            textView.setText(lowerCase);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(lowerCase);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= lowerCase.length() - 1 || (indexOf = lowerCase.indexOf(lowerCase2, i3)) < 0) {
                break;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), indexOf, lowerCase2.length() + indexOf, 33);
            i2 = Math.max(i3 + 1, indexOf);
        }
        textView.setText(spannableStringBuilder);
    }

    public String b(int i) {
        if (i >= 60) {
            return (i / 60) + ":" + (i % 60);
        } else if (i > 0) {
            return "0:" + i;
        } else {
            return "";
        }
    }

    public void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f20281a.size()) {
                return;
            }
            this.f20281a.get(i2).isPlaying = false;
            i = i2 + 1;
        }
    }

    public int c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f20281a.size()) {
                return -1;
            }
            if (this.f20281a.get(i2).isChoosed) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f20281a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f20281a.get(i).id;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.f20282c.inflate(R.layout.item_music_list, viewGroup, false);
            viewHolder.a(view2);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final MusicListItem musicListItem = this.f20281a.get(i);
        if (musicListItem != null) {
            if (!TextUtils.isEmpty(musicListItem.cover)) {
                ImageLoader.a(this.j, musicListItem.cover).b(R.drawable.icon_music_default_cover).c().a(viewHolder.b);
            }
            if (this.f20281a.get(i).isPlaying) {
                viewHolder.f20289c.setImageResource(R.drawable.icon_music_pause);
                Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.anim_music_cover_rotate_repeat);
                loadAnimation.setInterpolator(new LinearInterpolator());
                viewHolder.b.startAnimation(loadAnimation);
            } else {
                viewHolder.f20289c.setImageResource(R.drawable.icon_music_play);
                viewHolder.b.clearAnimation();
            }
            viewHolder.d.setText(musicListItem.subject);
            a(viewHolder.d, this.i, this.b.getResources().getColor(R.color.nafio_g));
            viewHolder.e.setText(musicListItem.composer);
            a(viewHolder.e, this.i, this.b.getResources().getColor(R.color.nafio_g));
            viewHolder.f.setText(b(musicListItem.duration));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.g.getLayoutParams();
            if (musicListItem.isChoosed) {
                layoutParams.rightMargin = this.h;
            } else {
                layoutParams.rightMargin = this.g;
            }
            viewHolder.g.setLayoutParams(layoutParams);
            viewHolder.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.MusicListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    MusicChoosedObserver a2 = MusicChoosedObserver.a();
                    String str = musicListItem.download;
                    a2.a(str, musicListItem.id + "");
                }
            });
            final ViewHolder viewHolder2 = viewHolder;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.MusicListAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    MusicListAdapter.this.a(i, viewHolder2);
                }
            });
        }
        return view2;
    }
}
