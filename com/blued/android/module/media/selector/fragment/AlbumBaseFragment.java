package com.blued.android.module.media.selector.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.contract.IAlbumBaseView;
import com.blued.android.module.media.selector.model.GroupImageInfo;
import com.blued.android.module.media.selector.present.AlbumBasePresenter;
import com.blued.android.module.media.selector.utils.ThumbLoader;
import com.blued.android.module.media.selector.utils.Tools;
import com.blued.android.module.media.selector.view.AlbumRecyclerView;
import com.blued.android.module.media.selector.view.NoDataAndLoadFailView;
import com.blued.android.module.media.selector.widget.PopMenu;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/fragment/AlbumBaseFragment.class */
public abstract class AlbumBaseFragment extends MediaBaseFragment<IAlbumBaseView, AlbumBasePresenter> implements MemoryRequest.MemoryListener, IAlbumBaseView {
    private Context a;
    private View d;
    private View e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private FrameLayout m;
    private FrameLayout n;
    private FrameLayout o;
    private AlbumRecyclerView p;
    private RecyclerView.Adapter q;
    private NoDataAndLoadFailView r;
    private PopMenu s;
    private PopAdapter t;
    private Dialog u;
    private int v = 6;
    private boolean w = true;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/fragment/AlbumBaseFragment$PopAdapter.class */
    public class PopAdapter extends BaseAdapter {

        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/fragment/AlbumBaseFragment$PopAdapter$ViewHolder.class */
        class ViewHolder {
            ImageView a;
            TextView b;

            private ViewHolder() {
            }
        }

        public PopAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AlbumBasePresenter.l();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return AlbumBasePresenter.b(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(AlbumBaseFragment.this.a).inflate(R.layout.select_catalog_item, (ViewGroup) null);
                viewHolder = new ViewHolder();
                view.setTag(viewHolder);
                viewHolder.a = (ImageView) view.findViewById(R.id.header_view);
                viewHolder.b = (TextView) view.findViewById(R.id.name_view);
            } else {
                viewHolder = (ViewHolder) view.getTag();
                viewHolder.a.setImageResource(R.drawable.defaultpicture);
            }
            final GroupImageInfo b = AlbumBasePresenter.b(i);
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.d = R.drawable.defaultpicture;
            loadOptions.b = R.drawable.defaultpicture;
            if (b.isVideoMediaType()) {
                ThumbLoader.a().a(b.getChildImageInfo(), viewHolder.a, loadOptions);
            } else if (TextUtils.isEmpty(b.topImageUri)) {
                ImageLoader.d(AlbumBaseFragment.this.getFragmentActive(), b.getTopImagePath()).b(R.drawable.defaultpicture).a(viewHolder.a);
            } else {
                ImageLoader.b(AlbumBaseFragment.this.getFragmentActive(), b.topImageUri).b(R.drawable.defaultpicture).a(viewHolder.a);
            }
            if (TextUtils.isEmpty(b.getFolderName())) {
                viewHolder.b.setText("");
            } else {
                viewHolder.b.setText(b.getFolderName());
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumBaseFragment.PopAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    AlbumBasePresenter.a(b.getFolderName(), AlbumBasePresenter.a(b.getFolderName()));
                    AlbumBaseFragment.this.h.setText(b.getFolderName());
                    AlbumBaseFragment.this.s.a();
                    AlbumBaseFragment.this.q.notifyDataSetChanged();
                }
            });
            return view;
        }
    }

    private void C() {
        ListView listView = new ListView(this.a);
        listView.setDivider(null);
        PopAdapter popAdapter = new PopAdapter();
        this.t = popAdapter;
        listView.setAdapter((ListAdapter) popAdapter);
        PopMenu popMenu = new PopMenu(this.a, listView);
        this.s = popMenu;
        popMenu.a(new PopupWindow.OnDismissListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumBaseFragment.5
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (AlbumBaseFragment.this.s() != null) {
                    AlbumBaseFragment.this.l.setImageDrawable(AlbumBaseFragment.this.s());
                } else {
                    AlbumBaseFragment.this.l.setImageDrawable(AlbumBaseFragment.this.a.getResources().getDrawable(R.drawable.media_arrow_down_icon));
                }
            }
        });
    }

    private void D() {
        if (TextUtils.isEmpty(n())) {
            return;
        }
        if (!this.w) {
            this.g.setVisibility(8);
            return;
        }
        this.g.setVisibility(0);
        this.g.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.photo_select_tips_in));
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.media.selector.fragment.AlbumBaseFragment.6
            @Override // java.lang.Runnable
            public void run() {
                if (AlbumBaseFragment.this.v == 0) {
                    AlbumBaseFragment.this.g.startAnimation(AnimationUtils.loadAnimation(AlbumBaseFragment.this.a, R.anim.photo_select_tips_out));
                    AlbumBaseFragment.this.g.setVisibility(8);
                    return;
                }
                AlbumBaseFragment.h(AlbumBaseFragment.this);
                if (AlbumBaseFragment.this.v == 0) {
                    AppInfo.n().post(this);
                } else {
                    AppInfo.n().postDelayed(this, 1000L);
                }
            }
        });
        this.w = false;
    }

    private void E() {
        this.o.setVisibility(0);
        TextView textView = this.j;
        textView.setText(((AlbumBasePresenter) this.b).b() + "");
        this.k.setAlpha(1.0f);
        this.k.setEnabled(true);
    }

    private void F() {
        this.o.setVisibility(8);
        this.k.setAlpha(0.3f);
        this.k.setEnabled(false);
    }

    static /* synthetic */ int h(AlbumBaseFragment albumBaseFragment) {
        int i = albumBaseFragment.v;
        albumBaseFragment.v = i - 1;
        return i;
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    protected void A() {
        if (q() == null) {
            if (w()) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumBaseFragment.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (AlbumBaseFragment.this.s != null) {
                            AlbumBaseFragment.this.s.a(AlbumBaseFragment.this.e);
                            if (AlbumBaseFragment.this.t() != null) {
                                AlbumBaseFragment.this.l.setImageDrawable(AlbumBaseFragment.this.t());
                            } else {
                                AlbumBaseFragment.this.l.setImageDrawable(AlbumBaseFragment.this.a.getResources().getDrawable(R.drawable.media_arrow_up_icon));
                            }
                        }
                    }
                });
            }
        }
        if (p() != null) {
            if (this.n.getChildCount() > 0) {
                this.n.removeAllViews();
            }
            this.n.setVisibility(0);
            this.n.addView(p());
            this.n.setBackgroundColor(v());
        } else {
            this.n.setVisibility(8);
        }
        RecyclerView.Adapter m = m();
        this.q = m;
        this.p.setAdapter(m);
    }

    @Override // com.blued.android.core.imagecache.MemoryRequest.MemoryListener
    public void a() {
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView, com.blued.android.module.media.selector.contract.IBaseView
    public void a(boolean z) {
        Dialog dialog = this.u;
        if (dialog != null) {
            if (z) {
                if (dialog.isShowing()) {
                    return;
                }
                this.u.show();
            } else if (dialog.isShowing()) {
                this.u.dismiss();
            }
        }
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public void a(boolean z, String str) {
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            return;
        }
        y();
        if (z) {
            this.r.a();
            this.p.setVisibility(8);
            if (q() == null) {
                this.f.setEnabled(false);
                return;
            }
            return;
        }
        D();
        this.r.b();
        this.p.setVisibility(0);
        this.q.notifyDataSetChanged();
        if (q() == null) {
            this.f.setEnabled(true);
            this.h.setText(str);
        }
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public boolean a(Activity activity, int i, int i2, Intent intent) {
        return false;
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public boolean a(Bundle bundle) {
        return false;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public BaseFragment b() {
        return this;
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    protected void b(Bundle bundle) {
        this.m = (FrameLayout) this.d.findViewById(R.id.vr_short_video_title_v);
        this.e = this.d.findViewById(R.id.vr_short_video_title);
        if (q() == null) {
            this.e.setVisibility(0);
            TextView textView = (TextView) this.e.findViewById(R.id.ctt_left_tv);
            this.i = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumBaseFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    ((AlbumBasePresenter) AlbumBaseFragment.this.b).j();
                    AlbumBaseFragment.this.c();
                }
            });
            this.f = this.e.findViewById(R.id.ctt_center_ll);
            TextView textView2 = (TextView) this.e.findViewById(R.id.ctt_center);
            this.h = textView2;
            textView2.setText(R.string.foudation_media_all_photos);
            this.l = (ImageView) this.e.findViewById(R.id.ctt_center_right);
            if (s() != null) {
                this.l.setImageDrawable(s());
            }
            this.o = (FrameLayout) this.e.findViewById(R.id.fl_num_view);
            this.j = (TextView) this.e.findViewById(R.id.num_view);
            TextView textView3 = (TextView) this.e.findViewById(R.id.ctt_right_tv);
            this.k = textView3;
            textView3.setEnabled(false);
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumBaseFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (AlbumBaseFragment.this.s != null) {
                        AlbumBaseFragment.this.s.a(AlbumBaseFragment.this.m);
                        if (AlbumBaseFragment.this.t() != null) {
                            AlbumBaseFragment.this.l.setImageDrawable(AlbumBaseFragment.this.t());
                        } else {
                            AlbumBaseFragment.this.l.setImageDrawable(AlbumBaseFragment.this.a.getResources().getDrawable(R.drawable.media_arrow_up_icon));
                        }
                    }
                }
            });
        } else {
            this.e.setVisibility(8);
            this.m.addView(q());
        }
        this.g = (TextView) this.d.findViewById(R.id.vr_tips_tv);
        AlbumRecyclerView albumRecyclerView = (AlbumRecyclerView) this.d.findViewById(R.id.vr_gird_view);
        this.p = albumRecyclerView;
        albumRecyclerView.setLayoutManager(l());
        this.n = (FrameLayout) this.d.findViewById(R.id.tabs);
        this.u = Tools.a(this.a);
        this.r = (NoDataAndLoadFailView) this.d.findViewById(R.id.vr_error_v);
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public void c() {
        getActivity().finish();
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public void d() {
        RecyclerView.Adapter adapter = this.q;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        e();
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public void e() {
        if (q() != null || this.b == 0) {
            return;
        }
        if (((AlbumBasePresenter) this.b).b() > 0) {
            E();
        } else {
            F();
        }
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public int f() {
        return 9;
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public long g() {
        return 2950L;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public long h() {
        return 60000L;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public int i() {
        return 3;
    }

    public abstract void j();

    public int k() {
        return 4;
    }

    public RecyclerView.LayoutManager l() {
        return new GridLayoutManager(getContext(), k());
    }

    public RecyclerView.Adapter m() {
        return ((AlbumBasePresenter) this.b).i();
    }

    public CharSequence n() {
        return null;
    }

    public int o() {
        return 6;
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.album_v, viewGroup, false);
            j();
            super.onCreateView(layoutInflater, viewGroup, bundle);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroyView() {
        MemoryRequest.a().b(this);
        super.onDestroyView();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStart() {
        super.onStart();
        MemoryRequest.a().b(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStop() {
        super.onStop();
        MemoryRequest.a().a(this);
    }

    public View p() {
        return null;
    }

    public View q() {
        return null;
    }

    public View r() {
        return this.m;
    }

    public Drawable s() {
        return null;
    }

    public Drawable t() {
        return null;
    }

    public TextView u() {
        return this.h;
    }

    public int v() {
        return getContext().getResources().getColor(R.color.black);
    }

    public boolean w() {
        return false;
    }

    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    public void x() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y() {
        this.v = o();
        C();
        e();
        if (q() == null) {
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.media.selector.fragment.AlbumBaseFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (AlbumBaseFragment.this.b != 0) {
                        ((AlbumBasePresenter) AlbumBaseFragment.this.b).a((Intent) null);
                    }
                }
            });
        }
        if (TextUtils.isEmpty(n())) {
            return;
        }
        this.g.setText(n());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.media.selector.fragment.MediaBaseFragment
    /* renamed from: z */
    public AlbumBasePresenter B() {
        return new AlbumBasePresenter();
    }
}
