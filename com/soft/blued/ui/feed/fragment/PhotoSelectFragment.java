package com.soft.blued.ui.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.ImageLoadEngine;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.module.common.constants.PhotoConstants;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.OapsWrapper;
import com.soft.blued.R;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.ui.feed.model.GroupImageInfo;
import com.soft.blued.ui.msg.ChatBgPicturePreFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CameraUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectFragment.class */
public class PhotoSelectFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<Cursor>, MemoryRequest.MemoryListener {

    /* renamed from: a  reason: collision with root package name */
    public static List<ChildImageInfo> f29974a = new ArrayList();
    private PauseOnScrollListener A;
    private LoaderManager B;
    private String D;

    /* renamed from: c  reason: collision with root package name */
    private Context f29975c;
    private View d;
    private View e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private LayoutInflater j;
    private Dialog m;
    private GridView n;
    private FeedPhotoAdapter o;
    private SinglePhotoAdapter p;
    private TextView q;
    private TextView r;
    private TextView s;
    private LinearLayout t;
    private PopMenu u;
    private PopAdapter v;
    private String x;
    private String y;
    private LinkedHashMap<String, List<ChildImageInfo>> k = new LinkedHashMap<>();
    private List<GroupImageInfo> l = new ArrayList();
    private int w = 0;
    private boolean z = false;
    private boolean C = false;
    String b = "http://a.hiphotos.baidu.com/image/pic/item/86d6277f9e2f070818f2fa06ea24b899a801f2c5.jpg";

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectFragment$CurrentAdapter.class */
    public class CurrentAdapter extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhotoSelectFragment f29987a;

        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectFragment$CurrentAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            ImageView f29988a;

            private ViewHolder() {
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return 4;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            if (view == null) {
                view2 = LayoutInflater.from(this.f29987a.f29975c).inflate(R.layout.fragment_drag_grid_item, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.f29988a = (ImageView) view2.findViewById(2131364232);
                view2.setTag(viewHolder);
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            ImageLoader.a(this.f29987a.getFragmentActive(), (int) R.drawable.photo_background).a(2.0f).a(viewHolder.f29988a);
            return view2;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectFragment$FeedPhotoAdapter.class */
    public class FeedPhotoAdapter extends BaseAdapter {
        public FeedPhotoAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ChildPhotoManager.a().b();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = PhotoSelectFragment.this.j.inflate(R.layout.fragment_photo_select_gird_item, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.f30001a = (ImageView) view.findViewById(2131364232);
                viewHolder.b = (LinearLayout) view.findViewById(R.id.take_photo_view);
                viewHolder.f30002c = (ImageView) view.findViewById(2131369696);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final ChildImageInfo a2 = ChildPhotoManager.a().a(i);
            if (a2 != null) {
                if (a2.mTakePhoto) {
                    viewHolder.b.setVisibility(0);
                    viewHolder.f30002c.setVisibility(8);
                    viewHolder.f30001a.setVisibility(8);
                    viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.FeedPhotoAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Tracker.onClick(view2);
                            PhotoSelectFragment.this.g();
                        }
                    });
                    return view;
                }
                viewHolder.f30002c.setVisibility(0);
                viewHolder.b.setVisibility(8);
                viewHolder.f30001a.setVisibility(0);
                (!TextUtils.isEmpty(a2.imgUri) ? ImageLoader.b(PhotoSelectFragment.this.getFragmentActive(), a2.imgUri) : ImageLoader.d(PhotoSelectFragment.this.getFragmentActive(), a2.mImagePath)).b(2131231620).a(viewHolder.f30001a);
                viewHolder.f30001a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.FeedPhotoAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        PhotoPagerFragment.a(PhotoSelectFragment.this, i, PhotoSelectFragment.this.w, PhotoSelectFragment.this.y);
                    }
                });
                if (a2.mSelect) {
                    viewHolder.f30002c.setImageResource(R.drawable.photo_selected);
                } else {
                    viewHolder.f30002c.setImageResource(R.drawable.photo_unselected);
                }
                final ViewHolder viewHolder2 = viewHolder;
                viewHolder.f30002c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.FeedPhotoAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        if (a2.mSelect) {
                            a2.mSelect = false;
                            SelectPhotoManager.a().b(a2);
                            viewHolder2.f30002c.setImageResource(R.drawable.photo_unselected);
                            if (SelectPhotoManager.a().b() > 0) {
                                PhotoSelectFragment.this.h();
                            } else {
                                PhotoSelectFragment.this.i();
                            }
                        } else if (SelectPhotoManager.a().b() + PhotoSelectFragment.f29974a.size() >= PhotoConstants.CONFIG.f10707a) {
                            AppMethods.a((CharSequence) String.format(PhotoSelectFragment.this.getResources().getString(2131890590), Integer.valueOf(PhotoConstants.CONFIG.f10707a)));
                        } else {
                            PhotoSelectFragment.this.a(viewHolder2.f30002c);
                            a2.mSelect = true;
                            SelectPhotoManager.a().a(a2);
                            PhotoSelectFragment.this.h();
                        }
                    }
                });
            }
            return view;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectFragment$PopAdapter.class */
    public class PopAdapter extends BaseAdapter {

        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectFragment$PopAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            ImageView f29996a;
            TextView b;

            private ViewHolder() {
            }
        }

        public PopAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (PhotoSelectFragment.this.l == null) {
                return 0;
            }
            return PhotoSelectFragment.this.l.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return PhotoSelectFragment.this.l.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(PhotoSelectFragment.this.f29975c).inflate(R.layout.fragment_photo_select_list_item, viewGroup, false);
                viewHolder = new ViewHolder();
                view.setTag(viewHolder);
                viewHolder.f29996a = (ImageView) view.findViewById(2131364232);
                viewHolder.b = (TextView) view.findViewById(2131368652);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final GroupImageInfo groupImageInfo = (GroupImageInfo) PhotoSelectFragment.this.l.get(i);
            (!TextUtils.isEmpty(groupImageInfo.topImgUri) ? ImageLoader.b(PhotoSelectFragment.this.getFragmentActive(), groupImageInfo.topImgUri) : ImageLoader.d(PhotoSelectFragment.this.getFragmentActive(), groupImageInfo.getTopImagePath())).b(2131231620).a(viewHolder.f29996a);
            if (TextUtils.isEmpty(groupImageInfo.getFolderName())) {
                viewHolder.b.setText("");
            } else {
                viewHolder.b.setText(groupImageInfo.getFolderName());
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.PopAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    ChildPhotoManager.a().a((List) PhotoSelectFragment.this.k.get(groupImageInfo.getFolderName()));
                    PhotoSelectFragment.this.f.setText(groupImageInfo.getFolderName());
                    BluedPreferences.C(groupImageInfo.getFolderName());
                    PhotoSelectFragment.this.u.d();
                    int i2 = PhotoSelectFragment.this.w;
                    if (i2 == 5) {
                        PhotoSelectFragment.this.o.notifyDataSetChanged();
                    } else if (i2 == 7) {
                        PhotoSelectFragment.this.o.notifyDataSetChanged();
                    } else if (i2 == 10 || i2 == 11) {
                        PhotoSelectFragment.this.o.notifyDataSetChanged();
                    } else {
                        PhotoSelectFragment.this.p.notifyDataSetChanged();
                    }
                }
            });
            return view;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectFragment$SinglePhotoAdapter.class */
    public class SinglePhotoAdapter extends BaseAdapter {
        public SinglePhotoAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ChildPhotoManager.a().b();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = PhotoSelectFragment.this.j.inflate(R.layout.fragment_photo_select_gird_item, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.f30001a = (ImageView) view.findViewById(2131364232);
                viewHolder.b = (LinearLayout) view.findViewById(R.id.take_photo_view);
                viewHolder.f30002c = (ImageView) view.findViewById(2131369696);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final ChildImageInfo a2 = ChildPhotoManager.a().a(i);
            if (a2 != null) {
                if (a2.mTakePhoto) {
                    viewHolder.b.setVisibility(0);
                    viewHolder.f30002c.setVisibility(8);
                    viewHolder.f30001a.setVisibility(8);
                    viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.SinglePhotoAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Tracker.onClick(view2);
                            PhotoSelectFragment.this.j();
                        }
                    });
                    return view;
                }
                viewHolder.f30002c.setVisibility(8);
                viewHolder.b.setVisibility(8);
                viewHolder.f30001a.setVisibility(0);
                (!TextUtils.isEmpty(a2.imgUri) ? ImageLoader.b(PhotoSelectFragment.this.getFragmentActive(), a2.imgUri) : ImageLoader.d(PhotoSelectFragment.this.getFragmentActive(), a2.mImagePath)).b(2131231620).a(viewHolder.f30001a);
                viewHolder.f30001a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.SinglePhotoAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        if (PhotoSelectFragment.this.z && !AppUtils.b(a2.mImagePath)) {
                            String e = RecyclingUtils.e("photo");
                            boolean a3 = FileUtils.a(a2.mImagePath, e);
                            a2.mImagePath = e;
                            LogUtils.c("SaveSelectPhoto: " + e + " " + a3);
                        }
                        int i2 = PhotoSelectFragment.this.w;
                        if (i2 == 6) {
                            Intent intent = new Intent();
                            intent.putExtra("photo_path", a2.mImagePath);
                            PhotoSelectFragment.this.getActivity().setResult(-1, intent);
                            PhotoSelectFragment.this.getActivity().finish();
                        } else if (i2 == 12) {
                            ChatBgPicturePreFragment.a(PhotoSelectFragment.this, a2.mImagePath, 4, null, false, 24);
                        } else if (i2 != 14) {
                            ClipPhotoFragment.a(PhotoSelectFragment.this, PhotoSelectFragment.this.w, a2.mImagePath, 22);
                        } else {
                            ClipBgFragment.a(PhotoSelectFragment.this, PhotoSelectFragment.this.w, a2.mImagePath, 22);
                        }
                    }
                });
            }
            return view;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/PhotoSelectFragment$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f30001a;
        public LinearLayout b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f30002c;

        public ViewHolder() {
        }
    }

    private List<GroupImageInfo> a(LinkedHashMap<String, List<ChildImageInfo>> linkedHashMap) {
        if (linkedHashMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<ChildImageInfo>> entry : linkedHashMap.entrySet()) {
            GroupImageInfo groupImageInfo = new GroupImageInfo();
            String key = entry.getKey();
            List<ChildImageInfo> value = entry.getValue();
            Collections.reverse(value);
            groupImageInfo.setFolderName(key);
            groupImageInfo.setImageCounts(value.size());
            if (value.size() > 0) {
                groupImageInfo.setTopImagePath(value.get(0).mImagePath);
                groupImageInfo.topImgUri = value.get(0).imgUri;
            }
            if (this.w != 16) {
                ChildImageInfo childImageInfo = new ChildImageInfo();
                childImageInfo.mTakePhoto = true;
                value.add(0, childImageInfo);
            }
            arrayList.add(groupImageInfo);
        }
        return arrayList;
    }

    public static void a(Context context, int i, int i2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("select_photo", i);
        bundle.putBoolean("IF_JUMP_TO_SHOOT", z);
        TerminalActivity.a(context, PhotoSelectFragment.class, bundle, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5f, 1.1f, 0.5f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100L);
        final ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation3.setDuration(50L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.setImageResource(R.drawable.photo_selected);
                imageView.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(scaleAnimation3);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        imageView.startAnimation(scaleAnimation);
    }

    public static void a(BaseFragment baseFragment, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("select_photo", i);
        TerminalActivity.a(baseFragment, PhotoSelectFragment.class, bundle, i2);
    }

    public static void a(BaseFragment baseFragment, int i, int i2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("select_photo", i);
        bundle.putBoolean("IF_JUMP_TO_SHOOT", z);
        TerminalActivity.a(baseFragment, PhotoSelectFragment.class, bundle, i2);
    }

    private void c() {
        this.z = com.blued.android.framework.utils.AppUtils.b();
        LoaderManager loaderManager = LoaderManager.getInstance(this);
        this.B = loaderManager;
        loaderManager.initLoader(100, null, this);
        this.A = new PauseOnScrollListener(false, true);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.w = arguments.getInt("select_photo");
            this.x = arguments.getString("msg_path");
            this.C = arguments.getBoolean("IF_JUMP_TO_SHOOT");
        }
        int i = this.w;
        if (i == 5) {
            PhotoConstants.CONFIG.f10707a = 9;
            f29974a.addAll(SelectPhotoManager.a().c());
            SelectPhotoManager.a().d();
        } else if (i != 7) {
            PhotoConstants.CONFIG.f10707a = 9;
        } else {
            PhotoConstants.CONFIG.f10707a = 6;
            f29974a.addAll(SelectPhotoManager.a().c());
            SelectPhotoManager.a().d();
        }
    }

    private void d() {
        this.j = LayoutInflater.from(this.f29975c);
        this.n = (GridView) this.d.findViewById(R.id.gird_view);
        this.m = DialogUtils.a(this.f29975c);
        this.q = (TextView) this.d.findViewById(R.id.pre_view);
        this.r = (TextView) this.d.findViewById(2131368751);
        this.s = (TextView) this.d.findViewById(R.id.next_view);
        this.t = (LinearLayout) this.d.findViewById(2131362490);
        int i = this.w;
        if (i == 5) {
            this.o = new FeedPhotoAdapter();
            if (SelectPhotoManager.a().b() > 0) {
                h();
            } else {
                i();
            }
        } else if (i == 7) {
            this.o = new FeedPhotoAdapter();
        } else if (i == 10 || i == 11) {
            this.o = new FeedPhotoAdapter();
        } else {
            this.p = new SinglePhotoAdapter();
            this.t.setVisibility(8);
        }
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                int i2 = PhotoSelectFragment.this.w;
                if (i2 == 5 || i2 == 7) {
                    SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.f29974a);
                }
                for (ChildImageInfo childImageInfo : SelectPhotoManager.a().c()) {
                    if (PhotoSelectFragment.this.z && !TextUtils.isEmpty(childImageInfo.imgUri) && !AppUtils.b(childImageInfo.mImagePath)) {
                        String e = RecyclingUtils.e("photo");
                        boolean a2 = FileUtils.a(childImageInfo.imgUri, e);
                        childImageInfo.mImagePath = e;
                        LogUtils.c("SaveSelectPhoto: " + e + " " + a2);
                    }
                }
                PhotoSelectFragment.this.getActivity().finish();
                int i3 = PhotoSelectFragment.this.w;
                if (i3 == 5 || i3 == 7) {
                    return;
                }
                FeedAddPostFragment.a(PhotoSelectFragment.this.f29975c);
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (SelectPhotoManager.a().b() > 0) {
                    PhotoSelectFragment photoSelectFragment = PhotoSelectFragment.this;
                    PhotoSelectedPagerFragment.a(photoSelectFragment, 0, photoSelectFragment.w);
                }
            }
        });
        this.n.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    ImageLoadEngine.b();
                } else if (i2 == 1) {
                    ImageLoadEngine.a();
                } else if (i2 != 2) {
                } else {
                    ImageLoadEngine.a();
                }
            }
        });
    }

    private void e() {
        ListView listView = new ListView(this.f29975c);
        listView.setDivider(null);
        PopAdapter popAdapter = new PopAdapter();
        this.v = popAdapter;
        listView.setAdapter((ListAdapter) popAdapter);
        this.u = new PopMenu(this.f29975c, listView);
    }

    private void f() {
        View findViewById = this.d.findViewById(2131370694);
        this.e = findViewById;
        ImageView imageView = (ImageView) findViewById.findViewById(2131363120);
        this.g = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                int i = PhotoSelectFragment.this.w;
                if (i == 5) {
                    SelectPhotoManager.a().d();
                    SelectPhotoManager.a().c().addAll(PhotoSelectFragment.f29974a);
                } else if (i != 7) {
                    SelectPhotoManager.a().d();
                } else {
                    SelectPhotoManager.a().d();
                    SelectPhotoManager.a().c().addAll(PhotoSelectFragment.f29974a);
                }
                PhotoSelectFragment.this.getActivity().finish();
            }
        });
        this.f = (TextView) this.e.findViewById(2131363108);
        this.h = (ImageView) this.e.findViewById(2131363126);
        this.i = (ImageView) this.e.findViewById(2131363113);
        this.h.setVisibility(4);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PhotoSelectFragment.this.u.a(PhotoSelectFragment.this.e);
                PhotoSelectFragment.this.i.setImageDrawable(BluedSkinUtils.b(PhotoSelectFragment.this.f29975c, 2131235082));
            }
        });
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PhotoSelectFragment.this.u.a(PhotoSelectFragment.this.e);
                PhotoSelectFragment.this.i.setImageDrawable(BluedSkinUtils.b(PhotoSelectFragment.this.f29975c, 2131235082));
            }
        });
        this.u.a(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.PhotoSelectFragment.7
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                PhotoSelectFragment.this.i.setImageDrawable(BluedSkinUtils.b(PhotoSelectFragment.this.f29975c, 2131235081));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (SelectPhotoManager.a().b() + f29974a.size() >= PhotoConstants.CONFIG.f10707a) {
            AppMethods.a((CharSequence) String.format(getResources().getString(2131890590), Integer.valueOf(PhotoConstants.CONFIG.f10707a)));
            return;
        }
        int i = this.w;
        if (i == 5) {
            TakePhotoFragment.a(this, 2, i, null);
        } else if (i == 7) {
            TakePhotoFragment.a(this, 2, i, null);
        } else if (i == 10 || i == 11) {
            TakePhotoFragment.a(this, 2, this.w, this.y);
        } else {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.r.setVisibility(0);
        this.q.setTextColor(getResources().getColor(2131100459));
        TextView textView = this.r;
        textView.setText(SelectPhotoManager.a().b() + "");
        this.s.setText(getString(2131891266));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.r.setVisibility(8);
        this.q.setTextColor(getResources().getColor(2131100458));
        this.s.setText(getString(2131888050));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.D = CameraUtils.a(this);
    }

    private void k() {
        FeedPhotoAdapter feedPhotoAdapter = this.o;
        if (feedPhotoAdapter != null) {
            feedPhotoAdapter.notifyDataSetChanged();
        }
        if (SelectPhotoManager.a().b() > 0) {
            h();
        } else {
            i();
        }
    }

    @Override // com.blued.android.core.imagecache.MemoryRequest.MemoryListener
    public void a() {
    }

    public void a(Dialog dialog) {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dialog.show();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    /* renamed from: a */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        String str;
        this.k.clear();
        LogUtils.c("onLoadFinished start");
        if (cursor != null) {
            this.k.put(this.f29975c.getResources().getString(R.string.all_photos), new ArrayList());
            while (cursor.moveToNext()) {
                try {
                    str = cursor.getString(cursor.getColumnIndex("_data"));
                } catch (Exception e) {
                    e.printStackTrace();
                    str = "";
                }
                long j = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                try {
                    String name = new File(str).getParentFile().getName();
                    ChildImageInfo childImageInfo = new ChildImageInfo();
                    if (!this.z || AppUtils.b(str)) {
                        childImageInfo.mImagePath = str;
                    } else {
                        childImageInfo.imgUri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(j)).toString();
                        childImageInfo.mImagePath = str;
                    }
                    if (this.k.containsKey(name)) {
                        this.k.get(name).add(childImageInfo);
                        this.k.get(this.f29975c.getResources().getString(R.string.all_photos)).add(childImageInfo);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(childImageInfo);
                        this.k.put(name, arrayList);
                        this.k.get(this.f29975c.getResources().getString(R.string.all_photos)).add(childImageInfo);
                    }
                } catch (Exception e2) {
                }
            }
        }
        LogUtils.c("onLoadFinished end");
        List<GroupImageInfo> a2 = a(this.k);
        this.l = a2;
        if (a2 == null || a2.size() <= 0) {
            ArrayList arrayList2 = new ArrayList();
            ChildImageInfo childImageInfo2 = new ChildImageInfo();
            childImageInfo2.mTakePhoto = true;
            arrayList2.add(childImageInfo2);
            this.k.put(ContactsContract.Contacts.QUERY_PARAMETER_VCARD_NO_PHOTO, arrayList2);
            ChildPhotoManager.a().a(this.k.get(ContactsContract.Contacts.QUERY_PARAMETER_VCARD_NO_PHOTO));
            this.i.setVisibility(8);
        } else {
            String aQ = BluedPreferences.aQ();
            List<ChildImageInfo> list = this.k.get(aQ);
            if (list == null || list.size() <= 0) {
                this.f.setText(this.l.get(0).getFolderName());
                ChildPhotoManager.a().a(this.k.get(this.l.get(0).getFolderName()));
            } else {
                this.f.setText(aQ);
                ChildPhotoManager.a().a(list);
            }
        }
        int i = this.w;
        if (i == 5) {
            this.n.setAdapter((ListAdapter) this.o);
        } else if (i == 7) {
            this.n.setAdapter((ListAdapter) this.o);
        } else if (i == 10 || i == 11) {
            this.n.setAdapter((ListAdapter) this.o);
        } else {
            this.n.setAdapter((ListAdapter) this.p);
        }
        PopAdapter popAdapter = this.v;
        if (popAdapter != null) {
            popAdapter.notifyDataSetChanged();
        }
        b(this.m);
        if (this.B.getLoader(100) != null) {
            this.B.destroyLoader(100);
        }
    }

    public void b() {
        LinkedHashMap<String, List<ChildImageInfo>> linkedHashMap = this.k;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return;
        }
        this.k.clear();
    }

    public void b(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.cancel();
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 0) {
            if (i != 22) {
                if (this.C) {
                    getActivity().finish();
                }
                k();
                return;
            } else if (intent == null || !intent.getBooleanExtra("finish", false)) {
                return;
            } else {
                getActivity().finish();
                return;
            }
        }
        if (i == 0) {
            int i3 = this.w;
            if (i3 != 6) {
                if (i3 != 14) {
                    switch (i3) {
                        case 10:
                        case 11:
                            Houyi.a().a(this.D).b();
                            ImageFileLoader.a(getFragmentActive()).c(this.D).a();
                            ChildImageInfo childImageInfo = new ChildImageInfo();
                            childImageInfo.mImagePath = this.D;
                            childImageInfo.mSelect = true;
                            ChildPhotoManager.a().a(1, childImageInfo);
                            SelectPhotoManager.a().a(childImageInfo);
                            List<ChildImageInfo> list = this.k.get(this.f.getText().toString());
                            List<ChildImageInfo> list2 = list;
                            if (list == null) {
                                list2 = this.k.get(ContactsContract.Contacts.QUERY_PARAMETER_VCARD_NO_PHOTO);
                            }
                            list2.add(1, childImageInfo);
                            k();
                            break;
                        case 12:
                            break;
                        default:
                            ClipPhotoFragment.a(this, i3, this.D, 22);
                            break;
                    }
                } else {
                    ClipBgFragment.a(this, i3, this.D, 22);
                }
            }
            Intent intent2 = new Intent();
            intent2.putExtra("photo_path", this.D);
            getActivity().setResult(-1, intent2);
            getActivity().finish();
        } else if (i != 1) {
            if (i == 2) {
                getActivity().finish();
            } else if (i != 22) {
                if (i == 24) {
                    getActivity().setResult(-1, intent);
                    getActivity().finish();
                }
            } else if (intent != null) {
                getActivity().setResult(-1, intent);
                getActivity().finish();
            }
        } else if (intent != null) {
            int intExtra = intent.getIntExtra("page_state", 0);
            if (intExtra == 0) {
                k();
            } else if (intExtra == 1) {
                getActivity().finish();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        getActivity().setResult(-1);
        int i = this.w;
        if (i == 5) {
            SelectPhotoManager.a().d();
            SelectPhotoManager.a().c().addAll(f29974a);
            return false;
        } else if (i != 7) {
            SelectPhotoManager.a().d();
            return false;
        } else {
            SelectPhotoManager.a().d();
            SelectPhotoManager.a().c().addAll(f29974a);
            return false;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        a(this.m);
        return new CursorLoader(this.f29975c, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f29975c = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_photo_select_gird, viewGroup, false);
            c();
            e();
            f();
            d();
            if (this.C) {
                g();
            }
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        if (bundle != null) {
            this.D = bundle.getString(OapsWrapper.KEY_PATH);
        }
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        f29974a.clear();
        MemoryRequest.a().b(this);
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        b();
        super.onDetach();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(OapsWrapper.KEY_PATH, this.D);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MemoryRequest.a().b(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MemoryRequest.a().a(this);
    }
}
