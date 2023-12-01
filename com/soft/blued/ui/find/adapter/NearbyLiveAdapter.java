package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/NearbyLiveAdapter.class */
public class NearbyLiveAdapter extends BaseAdapter {
    private static final int[] h = {R.id.cv_live_red_one, R.id.cv_live_red_two, R.id.cv_live_red_three};
    public Context d;
    public LayoutInflater e;
    private IRequestHost f;

    /* renamed from: c  reason: collision with root package name */
    public int f30078c = -1;
    private HashSet<String> g = new HashSet<>();

    /* renamed from: a  reason: collision with root package name */
    public List<List<BluedLiveListData>> f30077a = new ArrayList();
    public List<BluedLiveListData> b = new ArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/NearbyLiveAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View[] f30082a;
        public View b;

        public ViewHolder() {
        }
    }

    public NearbyLiveAdapter(Context context, IRequestHost iRequestHost) {
        this.d = context;
        this.f = iRequestHost;
        this.e = LayoutInflater.from(context);
    }

    private void a(BluedLiveListData bluedLiveListData) {
        if (this.g.contains(bluedLiveListData.lid)) {
            return;
        }
        bluedLiveListData.sort = DistanceUtils.a(bluedLiveListData.sort, BlueAppLocal.c(), false);
        int i = this.f30078c;
        if (i == -1 || i >= this.f30077a.size()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(bluedLiveListData);
            this.g.add(bluedLiveListData.lid);
            this.f30077a.add(arrayList);
            this.f30078c = this.f30077a.size() - 1;
            return;
        }
        List<BluedLiveListData> list = this.f30077a.get(this.f30078c);
        if (list.size() <= 2) {
            list.add(bluedLiveListData);
            this.g.add(bluedLiveListData.lid);
            return;
        }
        this.f30078c = -1;
        a(bluedLiveListData);
    }

    public void a() {
        Iterator<BluedLiveListData> it = this.b.iterator();
        while (it.hasNext()) {
            a(it.next());
            it.remove();
        }
        notifyDataSetChanged();
    }

    public void a(List<BluedLiveListData> list) {
        if (list == null || list.size() <= 0 || this.f30077a == null) {
            return;
        }
        if (this.b.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    break;
                }
                a(this.b.get(i2));
                i = i2 + 1;
            }
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                break;
            }
            a(list.get(i4));
            i3 = i4 + 1;
        }
        if (this.f30078c != -1) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.f30077a.get(this.f30078c).size()) {
                    break;
                }
                this.b.add(this.f30077a.get(this.f30078c).get(i6));
                this.g.remove(this.f30077a.get(this.f30078c).get(i6).lid);
                i5 = i6 + 1;
            }
            this.f30077a.remove(this.f30078c);
            this.f30078c = -1;
        }
        notifyDataSetChanged();
    }

    public void b(List<BluedLiveListData> list) {
        if (this.f30077a != null) {
            this.g.clear();
            this.f30077a.clear();
            this.b.clear();
            this.f30078c = -1;
            a(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<List<BluedLiveListData>> list = this.f30077a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            View inflate = this.e.inflate(R.layout.item_nearby_live, viewGroup, false);
            viewHolder2.f30082a = new View[3];
            viewHolder2.b = inflate.findViewById(R.id.item_live_red);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 3) {
                    break;
                }
                viewHolder2.f30082a[i3] = inflate.findViewById(h[i3]);
                viewHolder2.f30082a[i3].findViewById(2131364726).setVisibility(8);
                i2 = i3 + 1;
            }
            inflate.setTag(viewHolder2);
            viewHolder = viewHolder2;
            view = inflate;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        List<BluedLiveListData> list = this.f30077a.get(i);
        if (i == 0) {
            viewHolder.b.setPadding(viewHolder.b.getPaddingLeft(), DensityUtils.a(this.d, 8.0f), viewHolder.b.getPaddingRight(), viewHolder.b.getPaddingBottom());
        } else {
            viewHolder.b.setPadding(viewHolder.b.getPaddingLeft(), 0, viewHolder.b.getPaddingRight(), viewHolder.b.getPaddingBottom());
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 3) {
                return view;
            }
            View view2 = viewHolder.f30082a[i5];
            ImageView imageView = (ImageView) view2.findViewById(2131361893);
            TextView textView = (TextView) view2.findViewById(2131370927);
            TextView textView2 = (TextView) view2.findViewById(2131372892);
            TextView textView3 = (TextView) view2.findViewById(2131371285);
            ImageView imageView2 = (ImageView) view2.findViewById(R.id.img_distance_icon);
            ImageView imageView3 = (ImageView) view2.findViewById(R.id.grab_reward_icon);
            ImageView imageView4 = (ImageView) view2.findViewById(2131364726);
            if (i5 >= list.size()) {
                viewHolder.f30082a[i5].setVisibility(4);
            } else {
                viewHolder.f30082a[i5].setVisibility(0);
                imageView2.setVisibility(0);
                final BluedLiveListData bluedLiveListData = list.get(i5);
                ImageLoader.a(this.f, bluedLiveListData.anchor.avatar).b(2131234804).a(2.0f).a(imageView);
                if (bluedLiveListData.hb > 0) {
                    imageView3.setVisibility(0);
                } else {
                    imageView3.setVisibility(8);
                }
                if (TextUtils.isEmpty(bluedLiveListData.realtime_count + "")) {
                    textView.setText("");
                } else {
                    textView.setText(DistanceUtils.a(this.d, bluedLiveListData.realtime_count));
                }
                if (bluedLiveListData.anchor == null || StringUtils.d(bluedLiveListData.anchor.name)) {
                    textView2.setText("");
                } else {
                    textView2.setText(bluedLiveListData.anchor.name);
                }
                UserRelationshipUtils.a(this.d, textView2, bluedLiveListData.anchor);
                if (bluedLiveListData.anchor.vip_grade == 0) {
                    imageView4.setVisibility(8);
                } else {
                    imageView4.setVisibility(0);
                    int i6 = bluedLiveListData.anchor.vip_grade;
                    if (i6 == 1) {
                        imageView4.setImageResource(R.drawable.icon_vip_grid);
                    } else if (i6 == 2) {
                        imageView4.setImageResource(2131233879);
                    }
                }
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.NearbyLiveAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        bluedLiveListData.anchor.uid = bluedLiveListData.uid;
                        UserInfoFragmentNew.a(NearbyLiveAdapter.this.d, bluedLiveListData.anchor, "module_detail0", false, (MsgSourceEntity) null);
                    }
                });
                textView3.setVisibility(0);
                if (StringUtils.d(bluedLiveListData.sort)) {
                    textView3.setText("");
                } else {
                    textView3.setText(bluedLiveListData.sort);
                }
                DistanceUtils.a(this.d, textView3, bluedLiveListData.anchor.is_hide_distance, 0);
                final int i7 = bluedLiveListData.screen_pattern;
                final String str = bluedLiveListData.anchor.avatar;
                String str2 = bluedLiveListData.pic_url;
                final String str3 = bluedLiveListData.lid;
                final String str4 = bluedLiveListData.anchor.name;
                final String str5 = bluedLiveListData.uid;
                final int i8 = bluedLiveListData.anchor.vbadge;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.NearbyLiveAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        ArrayList arrayList = new ArrayList();
                        for (List<BluedLiveListData> list2 : NearbyLiveAdapter.this.f30077a) {
                            for (BluedLiveListData bluedLiveListData2 : list2) {
                                arrayList.add(bluedLiveListData2);
                            }
                        }
                        InstantLog.b("nearby_model_detail", 0);
                        LiveRoomInfoChannel.a(NearbyLiveAdapter.this.d, new LiveRoomData(StringUtils.a(str3, 0L), i7, "module_detail0", str5, str4, str, i8), -1, LiveRoomInfoChannel.a(arrayList, "module_detail0"));
                    }
                });
            }
            i4 = i5 + 1;
        }
    }
}
