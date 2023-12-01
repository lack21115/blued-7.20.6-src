package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.model.JoyEntryModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/GameHallAdapter.class */
public class GameHallAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<JoyEntryModel> f16358a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public int f16359c;
    public LayoutInflater d;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/GameHallAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16361a;

        public ViewHolder() {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f16358a == null) {
            this.f16358a = new ArrayList();
        }
        return this.f16358a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f16358a == null) {
            this.f16358a = new ArrayList();
        }
        return this.f16358a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = this.d.inflate(R.layout.item_game_hall, (ViewGroup) null);
            viewHolder.f16361a = (ImageView) view.findViewById(R.id.img_cover);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.f16361a.getLayoutParams();
            layoutParams.height = this.f16359c;
            viewHolder.f16361a.setLayoutParams(layoutParams);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final JoyEntryModel joyEntryModel = this.f16358a.get(i);
        ImageLoader.a((IRequestHost) null, joyEntryModel.icon).a(viewHolder.f16361a);
        viewHolder.f16361a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.GameHallAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (StringUtils.d(joyEntryModel.url)) {
                    return;
                }
                InstantLog.a("game_hall_item_click", joyEntryModel.url);
                WebViewShowInfoFragment.show(GameHallAdapter.this.b, joyEntryModel.url, -1);
            }
        });
        return view;
    }
}
