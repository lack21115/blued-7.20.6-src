package com.blued.android.module.common.widget.emoticon.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.emoji.view.EmojiTextView;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsAdapter.class */
public class EmoticonsAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f11171a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private PopupWindow f11172c;
    private IRequestHost d;
    private List<EmoticonModel> e;
    private int f = 0;
    private int g = 0;
    private IViewStateListener h;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f11177a;
        public RelativeLayout b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f11178c;
        public TextView d;
        public EmojiTextView e;

        ViewHolder() {
        }
    }

    public EmoticonsAdapter(Context context, List<EmoticonModel> list, IRequestHost iRequestHost) {
        this.b = context;
        this.d = iRequestHost;
        this.f11171a = LayoutInflater.from(context);
        this.e = list;
    }

    public void a(int i, int i2) {
        this.f = i;
        this.g = i - i2;
        notifyDataSetChanged();
    }

    public void a(IViewStateListener iViewStateListener) {
        this.h = iViewStateListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            view2 = this.f11171a.inflate(R.layout.item_emoticon, viewGroup, false);
            view2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f));
            viewHolder2.f11177a = (ImageView) view2.findViewById(R.id.item_iv_face);
            viewHolder2.f11178c = (RelativeLayout) view2.findViewById(R.id.rl_content);
            viewHolder2.b = (RelativeLayout) view2.findViewById(R.id.rl_parent);
            viewHolder2.d = (TextView) view2.findViewById(R.id.item_tv_face);
            viewHolder2.e = (EmojiTextView) view2.findViewById(R.id.emojicon_icon);
            view2.setTag(viewHolder2);
            viewHolder = viewHolder2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
            view2 = view;
        }
        final EmoticonModel emoticonModel = this.e.get(i);
        if (emoticonModel != null) {
            if (emoticonModel.emoticonType != 0) {
                viewHolder.b.setBackgroundResource(0);
                int i2 = this.g;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
                layoutParams.addRule(14);
                viewHolder.f11177a.setLayoutParams(layoutParams);
                (emoticonModel.url.startsWith("assets://") ? ImageLoader.c(this.d, emoticonModel.url.substring(9)) : emoticonModel.url.startsWith("file://") ? ImageLoader.d(this.d, emoticonModel.url.substring(7)) : ImageLoader.a(this.d, emoticonModel.url)).b(R.drawable.list_item_bg_selector).a(viewHolder.f11177a);
                viewHolder.d.setVisibility(0);
                if (!BlueAppLocal.d()) {
                    viewHolder.d.setText(emoticonModel.name);
                } else if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
                    viewHolder.d.setText(emoticonModel.name_zh);
                } else {
                    viewHolder.d.setText(emoticonModel.name_zh_tw);
                }
                viewHolder.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsAdapter.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view3, MotionEvent motionEvent) {
                        if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && EmoticonsAdapter.this.f11172c != null && EmoticonsAdapter.this.f11172c.isShowing()) {
                            EmoticonsAdapter.this.f11172c.dismiss();
                            EmoticonsAdapter.this.f11172c = null;
                            return false;
                        }
                        return false;
                    }
                });
                final ViewHolder viewHolder3 = viewHolder;
                viewHolder.b.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsAdapter.2
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view3) {
                        View inflate = EmoticonsAdapter.this.f11171a.inflate(R.layout.pop_emoticon_item, (ViewGroup) null);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.image_view);
                        if (emoticonModel.url_original.startsWith("assets://")) {
                            ImageLoader.c(EmoticonsAdapter.this.d, emoticonModel.url_original.substring(9)).a(imageView);
                        } else if (emoticonModel.url_original.startsWith("file://")) {
                            ImageLoader.d(EmoticonsAdapter.this.d, emoticonModel.url_original.substring(7)).a(imageView);
                        } else {
                            ImageLoader.a(EmoticonsAdapter.this.d, emoticonModel.url_original).a(imageView);
                        }
                        int i3 = AppInfo.l / 3;
                        EmoticonsAdapter.this.f11172c = new PopupWindow(inflate, i3, i3, false);
                        EmoticonsAdapter.this.f11172c.setBackgroundDrawable(new BitmapDrawable());
                        EmoticonsAdapter.this.f11172c.setOutsideTouchable(true);
                        EmoticonsAdapter.this.f11172c.setFocusable(true);
                        EmoticonsAdapter.this.f11172c.update();
                        int[] iArr = new int[2];
                        viewHolder3.b.getLocationOnScreen(iArr);
                        int i4 = iArr[0] < 100 ? iArr[0] + (EmoticonsAdapter.this.g / 4) : (iArr[0] + (EmoticonsAdapter.this.f / 2)) - (i3 / 2);
                        int i5 = i4;
                        if (iArr[0] > AppInfo.l - i3) {
                            i5 = i4 - (EmoticonsAdapter.this.g / 2);
                        }
                        EmoticonsAdapter.this.f11172c.showAtLocation(viewHolder3.f11178c, 0, i5, (iArr[1] - EmoticonsAdapter.this.f11172c.getHeight()) - DensityUtils.b(EmoticonsAdapter.this.b, 88.0f));
                        return false;
                    }
                });
            } else if (emoticonModel.emoji != null) {
                viewHolder.d.setVisibility(8);
                viewHolder.e.setVisibility(0);
                viewHolder.e.setText(emoticonModel.emoji.a());
            } else {
                viewHolder.e.setVisibility(8);
                viewHolder.f11177a.setBackgroundResource(0);
                viewHolder.b.setBackgroundResource(R.drawable.list_item_bg_selector);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(13);
                viewHolder.f11177a.setLayoutParams(layoutParams2);
                viewHolder.f11177a.setImageResource(this.b.getResources().getIdentifier(emoticonModel.original, i.f7952c, this.b.getPackageName()));
                viewHolder.d.setVisibility(8);
            }
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (EmoticonsAdapter.this.h != null) {
                        EmoticonsAdapter.this.h.a(emoticonModel);
                    }
                }
            });
        }
        return view2;
    }
}
