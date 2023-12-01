package com.soft.blued.ui.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.ImageLoadEngine;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.constants.PhotoConstants;
import com.blued.android.module.common.utils.ComplianceUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.click.SingleTouchProxy;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.OapsWrapper;
import com.soft.blued.R;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.customview.SelectPhotoBarView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.common_contract.ISelectPhotoBarCallback;
import com.soft.blued.ui.feed.model.GroupImageInfo;
import com.soft.blued.ui.live.utils.FormatUtils;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.msg.util.LocalMediaLoader;
import com.soft.blued.utils.BluedPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoSelectFragment.class */
public class MsgPhotoSelectFragment extends BaseFragment implements MemoryRequest.MemoryListener, ISelectPhotoBarCallback {

    /* renamed from: a  reason: collision with root package name */
    private Context f16225a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16226c;
    private ImageView d;
    private View e;
    private TextView f;
    private TextView g;
    private SelectPhotoBarView h;
    private LayoutInflater i;
    private Dialog l;
    private GridView m;
    private MsgPhotoAdapter n;
    private PopMenu o;
    private PopAdapter p;
    private String y;
    private LinkedHashMap<String, List<ChildImageInfo>> j = new LinkedHashMap<>();
    private List<GroupImageInfo> k = new ArrayList();
    private ArrayList<String> q = new ArrayList<>();
    private ArrayList<Integer> r = new ArrayList<>();
    private ArrayList<Integer> s = new ArrayList<>();
    private boolean t = false;
    private int u = 0;
    private boolean v = false;
    private boolean w = false;
    private List<ViewHolder> x = new ArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoSelectFragment$MsgPhotoAdapter.class */
    public class MsgPhotoAdapter extends BaseAdapter {
        public MsgPhotoAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ChildImageInfo childImageInfo) {
            ShortVideoProxy e = ShortVideoProxy.e();
            MsgPhotoSelectFragment msgPhotoSelectFragment = MsgPhotoSelectFragment.this;
            String str = childImageInfo.mImagePath;
            int i = MsgPhotoSelectFragment.this.v ? 7 : 1;
            e.a(msgPhotoSelectFragment, str, i, 1000, MsgPhotoSelectFragment.this.f16225a.getString(R.string.msg_look_burn) + FlashPhotoManager.a().b().flash_prompt, FlashPhotoManager.a().b().flash_left_times, new DeleteAutoCheckedListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.MsgPhotoAdapter.3
                public void a(final CheckBox checkBox) {
                    checkBox.setOnTouchListener(new SingleTouchProxy(new SingleTouchProxy.TouchListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.MsgPhotoAdapter.3.1
                        public boolean a() {
                            if (ComplianceUtils.a.a(checkBox.getContext())) {
                                return true;
                            }
                            if (FlashPhotoManager.a().b().flash_left_times < 1) {
                                PayVIPPopupWindow.c.a(MsgPhotoSelectFragment.this.f16225a, SelectPhotoManager.a().b(), (DialogInterface.OnDismissListener) null);
                                return true;
                            }
                            return false;
                        }
                    }));
                }
            });
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
                view = MsgPhotoSelectFragment.this.i.inflate(R.layout.fragment_msg_photo_select, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.f16257a = view;
                viewHolder.b = (ImageView) view.findViewById(2131364232);
                viewHolder.f16258c = (ImageView) view.findViewById(R.id.select_view);
                viewHolder.e = (TextView) view.findViewById(R.id.tv_duration);
                viewHolder.f = view.findViewById(R.id.shade);
                view.setTag(viewHolder);
                MsgPhotoSelectFragment.this.x.add(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final ChildImageInfo a2 = ChildPhotoManager.a().a(i);
            if (a2 != null) {
                viewHolder.f16258c.setVisibility(0);
                viewHolder.b.setVisibility(0);
                viewHolder.d = a2.mSelect;
                try {
                    ((TextUtils.isEmpty(a2.imgUri) || !LocalMediaLoader.a(a2.imgUri)) ? ImageLoader.d(MsgPhotoSelectFragment.this.getFragmentActive(), a2.mImagePath) : ImageLoader.b(MsgPhotoSelectFragment.this.getFragmentActive(), a2.imgUri)).b(2131231620).a(viewHolder.b);
                } catch (Throwable th) {
                }
                if (LocalMediaLoader.MediaType.a(a2.mediaType)) {
                    viewHolder.e.setVisibility(0);
                    viewHolder.e.setText(FormatUtils.a(a2.duration / 1000));
                } else {
                    viewHolder.e.setVisibility(8);
                }
                if (SelectPhotoManager.a().b() < PhotoConstants.CONFIG.a || a2.mSelect) {
                    viewHolder.f16257a.setAlpha(1.0f);
                } else {
                    viewHolder.f16257a.setAlpha(0.5f);
                }
                viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.MsgPhotoAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        if (LocalMediaLoader.MediaType.b(a2.mediaType)) {
                            MsgPhotoPagerFragment.a(MsgPhotoSelectFragment.this, i, MsgPhotoSelectFragment.this.u, MsgPhotoSelectFragment.this.h.a(), MsgPhotoSelectFragment.this.v);
                        } else if (SelectPhotoManager.a().b() > 0) {
                        } else {
                            MsgPhotoAdapter.this.a(a2);
                        }
                    }
                });
                if (LocalMediaLoader.MediaType.a(a2.mediaType)) {
                    viewHolder.f16258c.setVisibility(8);
                    if (SelectPhotoManager.a().b() > 0) {
                        viewHolder.f.setVisibility(0);
                    } else {
                        viewHolder.f.setVisibility(8);
                    }
                } else {
                    viewHolder.f.setVisibility(8);
                    viewHolder.f16258c.setVisibility(0);
                    if (a2.mSelect) {
                        viewHolder.f16258c.setImageResource(R.drawable.msg_photo_select);
                    } else {
                        viewHolder.f16258c.setImageResource(R.drawable.msg_photo_unselect);
                    }
                }
                final ViewHolder viewHolder2 = viewHolder;
                viewHolder.f16258c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.MsgPhotoAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        if (a2.mSelect) {
                            a2.mSelect = false;
                            viewHolder2.d = a2.mSelect;
                            SelectPhotoManager.a().b(a2);
                            viewHolder2.f16258c.setImageResource(R.drawable.msg_photo_unselect);
                            MsgPhotoSelectFragment.this.d();
                        } else if (SelectPhotoManager.a().b() >= PhotoConstants.CONFIG.a) {
                            AppMethods.a(String.format(MsgPhotoSelectFragment.this.getResources().getString(R.string.max_select_num), Integer.valueOf(PhotoConstants.CONFIG.a)));
                        } else if (MsgPhotoSelectFragment.this.w && SelectPhotoManager.a().b() + 1 > FlashPhotoManager.a().b().flash_left_times) {
                            PayVIPPopupWindow.c.a(MsgPhotoSelectFragment.this.f16225a, SelectPhotoManager.a().b(), new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.MsgPhotoAdapter.2.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    SelectPhotoBarView selectPhotoBarView = MsgPhotoSelectFragment.this.h;
                                    selectPhotoBarView.setBurnBtnText(MsgPhotoSelectFragment.this.f16225a.getString(R.string.msg_look_burn) + "\n" + FlashPhotoManager.a().b().flash_prompt);
                                }
                            });
                        } else {
                            MsgPhotoSelectFragment.this.a(viewHolder2.f16258c);
                            a2.mSelect = true;
                            viewHolder2.d = a2.mSelect;
                            SelectPhotoManager.a().a(a2);
                            MsgPhotoSelectFragment.this.d();
                        }
                    }
                });
            }
            return view;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoSelectFragment$PopAdapter.class */
    public class PopAdapter extends BaseAdapter {

        /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoSelectFragment$PopAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            ImageView f16255a;
            TextView b;

            private ViewHolder() {
            }
        }

        public PopAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (MsgPhotoSelectFragment.this.k == null) {
                return 0;
            }
            return MsgPhotoSelectFragment.this.k.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return MsgPhotoSelectFragment.this.k.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(MsgPhotoSelectFragment.this.f16225a).inflate(R.layout.fragment_photo_select_list_item, viewGroup, false);
                viewHolder = new ViewHolder();
                view.setTag(viewHolder);
                viewHolder.f16255a = (ImageView) view.findViewById(2131364232);
                viewHolder.b = (TextView) view.findViewById(R.id.name_view);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final GroupImageInfo groupImageInfo = (GroupImageInfo) MsgPhotoSelectFragment.this.k.get(i);
            ImageLoader.d(MsgPhotoSelectFragment.this.getFragmentActive(), groupImageInfo.getTopImagePath()).b(2131231620).c().a(viewHolder.f16255a);
            if (TextUtils.isEmpty(groupImageInfo.getFolderName())) {
                viewHolder.b.setText("");
            } else {
                viewHolder.b.setText(groupImageInfo.getFolderName());
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.PopAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    ChildPhotoManager.a().a((List) MsgPhotoSelectFragment.this.j.get(groupImageInfo.getFolderName()));
                    MsgPhotoSelectFragment.this.f16226c.setText(groupImageInfo.getFolderName());
                    BluedPreferences.C(groupImageInfo.getFolderName());
                    MsgPhotoSelectFragment.this.o.d();
                    MsgPhotoSelectFragment.this.n.notifyDataSetChanged();
                }
            });
            return view;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/MsgPhotoSelectFragment$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f16257a;
        public ImageView b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16258c;
        public boolean d;
        public TextView e;
        public View f;

        public ViewHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GroupImageInfo> a(LinkedHashMap<String, List<ChildImageInfo>> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<ChildImageInfo>> entry : linkedHashMap.entrySet()) {
            GroupImageInfo groupImageInfo = new GroupImageInfo();
            String key = entry.getKey();
            List<ChildImageInfo> value = entry.getValue();
            groupImageInfo.setFolderName(key);
            groupImageInfo.setImageCounts(value.size());
            if (value.size() > 0) {
                groupImageInfo.setTopImagePath(value.get(0).mImagePath);
            }
            arrayList.add(groupImageInfo);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5f, 1.1f, 0.5f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100L);
        final ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation3.setDuration(50L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.11
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.setImageResource(R.drawable.msg_photo_select);
                imageView.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        scaleAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.12
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

    public static void a(final BaseFragment baseFragment, final int i, final boolean z, final int i2) {
        PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.1
            public void U_() {
                Bundle bundle = new Bundle();
                bundle.putInt("select_photo", i);
                bundle.putBoolean("photo_from_group", z);
                TerminalActivity.a(baseFragment, MsgPhotoSelectFragment.class, bundle, i2);
            }

            public void a(String[] strArr) {
            }
        });
    }

    private void a(String str) {
        int i;
        int i2 = 0;
        if (new File(str).exists()) {
            int[] b = ImageUtils.b(str);
            i = b[0];
            i2 = b[1];
        } else {
            i = 0;
        }
        this.s.add(Integer.valueOf(i2));
        this.r.add(Integer.valueOf(i));
    }

    private void f() {
        this.t = AppUtils.b();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.u = arguments.getInt("select_photo");
            this.v = arguments.getBoolean("photo_from_group", false);
        }
        PhotoConstants.CONFIG.a = 9;
        SelectPhotoManager.a().d();
        j();
    }

    private void g() {
        this.i = LayoutInflater.from(this.f16225a);
        this.m = (GridView) this.b.findViewById(R.id.gird_view);
        this.l = DialogUtils.a(this.f16225a);
        this.n = new MsgPhotoAdapter();
        this.m.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ImageLoadEngine.b();
                } else if (i == 1) {
                    ImageLoadEngine.a();
                } else if (i != 2) {
                } else {
                    ImageLoadEngine.a();
                }
            }
        });
        SelectPhotoBarView selectPhotoBarView = (SelectPhotoBarView) this.b.findViewById(R.id.bottom_bar_view);
        this.h = selectPhotoBarView;
        selectPhotoBarView.setOperationCallback(this);
        this.h.findViewById(R.id.photo_album_tv).setVisibility(4);
        if (this.v) {
            this.h.b();
        } else {
            this.h.c();
        }
    }

    private void h() {
        ListView listView = new ListView(this.f16225a);
        listView.setDivider(null);
        PopAdapter popAdapter = new PopAdapter();
        this.p = popAdapter;
        listView.setAdapter((ListAdapter) popAdapter);
        this.o = new PopMenu(this.f16225a, listView);
    }

    private void i() {
        this.e = this.b.findViewById(2131370694);
        TextView textView = (TextView) this.b.findViewById(2131363120);
        this.f = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SelectPhotoManager.a().d();
                MsgPhotoSelectFragment.this.getActivity().finish();
            }
        });
        TextView textView2 = (TextView) this.b.findViewById(2131363126);
        this.g = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (SelectPhotoManager.a().b() > 0) {
                    if (MsgPhotoSelectFragment.this.v) {
                        InstantLog.a("chat_preview_pic_click", (Object) 1);
                    } else {
                        InstantLog.a("chat_preview_pic_click", (Object) 0);
                    }
                    MsgPhotoSelectFragment msgPhotoSelectFragment = MsgPhotoSelectFragment.this;
                    MsgPhotoSelectedPagerFragment.a(msgPhotoSelectFragment, 0, 4, msgPhotoSelectFragment.h.a(), MsgPhotoSelectFragment.this.v);
                }
            }
        });
        this.f16226c = (TextView) this.b.findViewById(2131363108);
        this.d = (ImageView) this.b.findViewById(R.id.ctt_center_right);
        this.b.findViewById(R.id.lay_center).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MsgPhotoSelectFragment.this.o.a(MsgPhotoSelectFragment.this.e);
                MsgPhotoSelectFragment.this.d.setImageDrawable(BluedSkinUtils.b(MsgPhotoSelectFragment.this.f16225a, (int) R.drawable.live_icon_arrow_up));
            }
        });
        this.o.a(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.6
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MsgPhotoSelectFragment.this.d.setImageDrawable(BluedSkinUtils.b(MsgPhotoSelectFragment.this.f16225a, (int) R.drawable.live_icon_arrow_down));
            }
        });
    }

    private void j() {
        a(this.l);
        ThreadManager.a().a(new Runnable() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.7
            @Override // java.lang.Runnable
            public void run() {
                if (MsgPhotoSelectFragment.this.getContext() == null) {
                    return;
                }
                MsgPhotoSelectFragment.this.j.clear();
                MsgPhotoSelectFragment msgPhotoSelectFragment = MsgPhotoSelectFragment.this;
                msgPhotoSelectFragment.j = new LocalMediaLoader(msgPhotoSelectFragment.getContext(), 0).a();
                MsgPhotoSelectFragment msgPhotoSelectFragment2 = MsgPhotoSelectFragment.this;
                msgPhotoSelectFragment2.k = msgPhotoSelectFragment2.a(msgPhotoSelectFragment2.j);
                LogUtils.c("onLoadFinished subGroupOfImage end");
                AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MsgPhotoSelectFragment.this.k != null && MsgPhotoSelectFragment.this.k.size() > 0) {
                            MsgPhotoSelectFragment.this.f16226c.setText(((GroupImageInfo) MsgPhotoSelectFragment.this.k.get(0)).getFolderName());
                            ChildPhotoManager.a().a((List) MsgPhotoSelectFragment.this.j.get(((GroupImageInfo) MsgPhotoSelectFragment.this.k.get(0)).getFolderName()));
                        }
                        MsgPhotoSelectFragment.this.m.setAdapter((ListAdapter) MsgPhotoSelectFragment.this.n);
                        if (MsgPhotoSelectFragment.this.p != null) {
                            MsgPhotoSelectFragment.this.p.notifyDataSetChanged();
                        }
                        MsgPhotoSelectFragment.this.b(MsgPhotoSelectFragment.this.l);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void k() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        MsgPhotoAdapter msgPhotoAdapter = this.n;
        if (msgPhotoAdapter != null) {
            msgPhotoAdapter.notifyDataSetChanged();
        }
        d();
    }

    public void a() {
    }

    public void a(Dialog dialog) {
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        dialog.show();
    }

    @Override // com.soft.blued.ui.common_contract.ISelectPhotoBarCallback
    public void a(boolean z) {
        if (z && ComplianceUtils.a.a(getContext())) {
            this.h.setBurnBtnChecked(false);
            return;
        }
        this.w = z;
        if (this.v) {
            InstantLog.a("chat_burn_pic_click", (Object) 1);
        } else {
            InstantLog.a("chat_burn_pic_click", (Object) 0);
        }
        if (!z || SelectPhotoManager.a().b() <= 0 || FlashPhotoManager.a().b().flash_left_times >= SelectPhotoManager.a().b()) {
            return;
        }
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.8
            @Override // java.lang.Runnable
            public void run() {
                MsgPhotoSelectFragment.this.h.setBurnBtnChecked(false);
            }
        });
        this.w = false;
        PayVIPPopupWindow.c.a(this.f16225a, SelectPhotoManager.a().b(), new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.9
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                SelectPhotoBarView selectPhotoBarView = MsgPhotoSelectFragment.this.h;
                selectPhotoBarView.setBurnBtnText(MsgPhotoSelectFragment.this.f16225a.getString(R.string.msg_look_burn) + "\n" + FlashPhotoManager.a().b().flash_prompt);
            }
        });
    }

    @Override // com.soft.blued.ui.common_contract.ISelectPhotoBarCallback
    public void b() {
        ThreadManager.a().a(new ThreadExecutor("copy-file") { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.10
            public void execute() {
                MsgPhotoSelectFragment.this.k();
            }
        });
    }

    public void b(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.cancel();
    }

    @Override // com.soft.blued.ui.common_contract.ISelectPhotoBarCallback
    public void c() {
    }

    public void d() {
        int b = SelectPhotoManager.a().b();
        this.h.a(b);
        if (b == 0) {
            this.g.setTextColor(getResources().getColor(2131101204));
        } else {
            this.g.setTextColor(getResources().getColor(2131101190));
        }
        for (ViewHolder viewHolder : this.x) {
            if (b < PhotoConstants.CONFIG.a || viewHolder.d) {
                viewHolder.f16257a.setAlpha(1.0f);
            } else {
                viewHolder.f16257a.setAlpha(0.5f);
            }
        }
        this.n.notifyDataSetChanged();
    }

    public void e() {
        LinkedHashMap<String, List<ChildImageInfo>> linkedHashMap = this.j;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return;
        }
        this.j.clear();
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public void onActivityResult(final int i, final int i2, final Intent intent) {
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.feed.fragment.MsgPhotoSelectFragment.13
            @Override // java.lang.Runnable
            public void run() {
                Intent intent2;
                if (i2 == 0) {
                    MsgPhotoSelectFragment.this.l();
                    return;
                }
                int i3 = i;
                boolean z = false;
                if (i3 != 1) {
                    if (i3 == 1000 && (intent2 = intent) != null && intent2.getBooleanExtra("close_page", false)) {
                        intent.putExtra("isVideo", true);
                        MsgPhotoSelectFragment.this.getActivity().setResult(-1, intent);
                        MsgPhotoSelectFragment.this.getActivity().finish();
                        return;
                    }
                    return;
                }
                Intent intent3 = intent;
                if (intent3 != null) {
                    if (intent3.getBooleanExtra("close_page", false)) {
                        intent.putExtra("isVideo", true);
                        MsgPhotoSelectFragment.this.getActivity().setResult(-1, intent);
                        MsgPhotoSelectFragment.this.getActivity().finish();
                        return;
                    }
                    int intExtra = intent.getIntExtra("page_state", 0);
                    int intExtra2 = intent.getIntExtra("photo_destroy_switch", 0);
                    if (MsgPhotoSelectFragment.this.h != null) {
                        SelectPhotoBarView selectPhotoBarView = MsgPhotoSelectFragment.this.h;
                        if (intExtra2 == 1) {
                            z = true;
                        }
                        selectPhotoBarView.setBurnBtnChecked(z);
                    }
                    if (intExtra == 0) {
                        MsgPhotoSelectFragment.this.l();
                    } else if (intExtra == 1) {
                        if (MsgPhotoSelectFragment.this.u != 4) {
                            MsgPhotoSelectFragment.this.getActivity().finish();
                        } else {
                            MsgPhotoSelectFragment.this.k();
                        }
                    }
                }
            }
        });
        super.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        getActivity().setResult(-1);
        SelectPhotoManager.a().d();
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16225a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_msg_photo_select_gird, viewGroup, false);
            f();
            h();
            i();
            g();
            d();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        if (bundle != null) {
            this.y = bundle.getString(OapsWrapper.KEY_PATH);
        }
        return this.b;
    }

    public void onDestroy() {
        this.x.clear();
        MemoryRequest.a().b(this);
        super.onDestroy();
    }

    public void onDetach() {
        e();
        super.onDetach();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(OapsWrapper.KEY_PATH, this.y);
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        MemoryRequest.a().b(this);
    }

    public void onStop() {
        super.onStop();
        MemoryRequest.a().a(this);
    }
}
