package com.blued.android.module.common.widget.emoticon.ui;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.emoticon.model.EmoticonPackageModel;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;
import skin.support.widget.SkinCompatBackgroundHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsToolBarView.class */
public class EmoticonsToolBarView extends LinearLayout implements BluedSkinSupportable {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f11184a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f11185c;
    private HorizontalScrollView d;
    private LinearLayout e;
    private List<EmoticonPackageModel> f;
    private int g;
    private ArrayList<View> h;
    private RelativeLayout i;
    private boolean j;
    private String k;
    private OnEmotionToolBarClickListener l;
    private SkinCompatBackgroundHelper m;
    private List<OnToolBarItemClickListener> n;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsToolBarView$OnEmotionToolBarClickListener.class */
    public interface OnEmotionToolBarClickListener {
        void a(View view);

        void b(View view);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsToolBarView$OnToolBarItemClickListener.class */
    public interface OnToolBarItemClickListener {
        void a(int i);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsToolBarView$ToolBarAdapter.class */
    public class ToolBarAdapter extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EmoticonsToolBarView f11190a;

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f11190a.f.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f11190a.f.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = this.f11190a.f11184a.inflate(R.layout.toolbar_item, (ViewGroup) null);
                viewHolder.f11192a = (ImageView) view2.findViewById(R.id.iv_icon);
                viewHolder.b = (FrameLayout) view2.findViewById(R.id.content_view);
                view2.setTag(viewHolder);
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.f11192a.setImageResource(this.f11190a.b.getResources().getIdentifier(((EmoticonPackageModel) this.f11190a.f.get(i)).icon, i.f7952c, this.f11190a.b.getPackageName()));
            viewHolder.f11192a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.ToolBarAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (ToolBarAdapter.this.f11190a.n == null || ToolBarAdapter.this.f11190a.n.isEmpty()) {
                        return;
                    }
                    for (OnToolBarItemClickListener onToolBarItemClickListener : ToolBarAdapter.this.f11190a.n) {
                        onToolBarItemClickListener.a(i);
                    }
                }
            });
            return view2;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsToolBarView$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f11192a;
        public FrameLayout b;

        ViewHolder() {
        }
    }

    public EmoticonsToolBarView(Context context) {
        super(context);
        this.h = new ArrayList<>();
    }

    public EmoticonsToolBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new ArrayList<>();
        this.b = context;
        this.m = new SkinCompatBackgroundHelper(this);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.f11184a = layoutInflater;
        layoutInflater.inflate(R.layout.emoticon_bottom_view, this);
        this.i = (RelativeLayout) findViewById(R.id.set_view);
        this.f11185c = (ImageView) findViewById(R.id.iv_icon);
        this.d = (HorizontalScrollView) findViewById(R.id.hsv_toolbar);
        this.e = (LinearLayout) findViewById(R.id.ly_tool);
        this.g = (int) TypedValue.applyDimension(1, 60.0f, getResources().getDisplayMetrics());
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (EmoticonsToolBarView.this.l != null) {
                    EmoticonsToolBarView.this.l.a(view);
                }
            }
        });
    }

    private void a(final int i) {
        if (i < this.e.getChildCount()) {
            this.d.post(new Runnable() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.4
                @Override // java.lang.Runnable
                public void run() {
                    int scrollX = EmoticonsToolBarView.this.d.getScrollX();
                    if (Build.VERSION.SDK_INT > 11) {
                        int x = (int) EmoticonsToolBarView.this.e.getChildAt(i).getX();
                        if (x < scrollX) {
                            EmoticonsToolBarView.this.d.scrollTo(x, 0);
                            return;
                        }
                        int width = EmoticonsToolBarView.this.e.getChildAt(i).getWidth();
                        int i2 = x + width;
                        int width2 = scrollX + EmoticonsToolBarView.this.d.getWidth();
                        if (i2 > width2) {
                            EmoticonsToolBarView.this.d.scrollTo(i2 - width2, 0);
                        }
                    }
                }
            });
        }
    }

    public void a(IRequestHost iRequestHost, List<EmoticonPackageModel> list) {
        this.f = list;
        this.e.removeAllViews();
        this.h.clear();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= this.f.size()) {
                break;
            }
            EmoticonPackageModel emoticonPackageModel = this.f.get(i3);
            View inflate = ((LayoutInflater) this.b.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.toolbar_item, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(this.g, -1));
            this.e.addView(inflate);
            if (emoticonPackageModel.emoticonType == 0) {
                imageView.setImageResource(this.b.getResources().getIdentifier(emoticonPackageModel.icon, i.f7952c, this.b.getPackageName()));
            } else if (emoticonPackageModel.icon.startsWith("assets://")) {
                ImageLoader.c(iRequestHost, emoticonPackageModel.icon.substring(9)).a(imageView);
            } else if (emoticonPackageModel.icon.startsWith("file://")) {
                ImageLoader.d(iRequestHost, emoticonPackageModel.icon.substring(7)).a(imageView);
            } else {
                ImageLoader.a(iRequestHost, emoticonPackageModel.icon).a(imageView);
            }
            inflate.setBackgroundResource(R.drawable.list_item_bg_selector);
            this.h.add(inflate);
            final int i4 = i;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (EmoticonsToolBarView.this.n == null || EmoticonsToolBarView.this.n.isEmpty()) {
                        return;
                    }
                    for (OnToolBarItemClickListener onToolBarItemClickListener : EmoticonsToolBarView.this.n) {
                        onToolBarItemClickListener.a(i4);
                    }
                }
            });
            i++;
            i2 = i3 + 1;
        }
        if (this.j) {
            this.i.setVisibility(8);
        } else {
            View inflate2 = ((LayoutInflater) this.b.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.toolbar_item_set, (ViewGroup) null);
            inflate2.setLayoutParams(new FrameLayout.LayoutParams(this.g, -1));
            this.e.addView(inflate2);
            inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsToolBarView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (EmoticonsToolBarView.this.l != null) {
                        EmoticonsToolBarView.this.l.b(view);
                    }
                }
            });
        }
        setToolBtnSelect(0);
    }

    public void a(OnToolBarItemClickListener onToolBarItemClickListener) {
        if (this.n == null) {
            this.n = new ArrayList();
        }
        this.n.add(onToolBarItemClickListener);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        Log.e("Skin", "EmoticonsToolBarView apply skin");
    }

    public void setModel(boolean z) {
        this.j = z;
    }

    public void setOnEmotionToolBarClickListener(OnEmotionToolBarClickListener onEmotionToolBarClickListener) {
        this.l = onEmotionToolBarClickListener;
    }

    public void setOnToolBarItemClickListener(OnToolBarItemClickListener onToolBarItemClickListener) {
        a(onToolBarItemClickListener);
    }

    public void setTargetUid(String str) {
        this.k = str;
    }

    public void setToolBtnSelect(int i) {
        a(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.h.size()) {
                return;
            }
            if (i == i3) {
                this.h.get(i3).setBackgroundColor(getResources().getColor(R.color.toolbar_item_bg_selected));
            } else {
                this.h.get(i3).setBackgroundResource(R.drawable.toolbar_item_bg_selector);
            }
            i2 = i3 + 1;
        }
    }
}
