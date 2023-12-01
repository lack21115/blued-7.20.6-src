package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.internal.content.NativeLibraryHelper;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveUserinfoModel;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveManagerAdapter.class */
public class LiveManagerAdapter extends BaseAdapter {
    public Context a;
    public List<LiveUserinfoModel> b = new ArrayList();
    public LoadOptions c;
    public LayoutInflater d;
    public IRequestHost e;
    private String f;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveManagerAdapter$ViewHolder.class */
    class ViewHolder {
        private ImageView b;
        private ImageView c;
        private TextView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private ImageView h;
        private ProgressBar i;

        private ViewHolder() {
        }
    }

    public LiveManagerAdapter(Context context, String str, IRequestHost iRequestHost) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        int i = this.a.getResources().getDisplayMetrics().widthPixels;
        LoadOptions loadOptions = new LoadOptions();
        this.c = loadOptions;
        loadOptions.d = R.drawable.user_bg_round;
        this.c.b = R.drawable.user_bg_round;
        int i2 = i >> 1;
        this.c.a(i2, i2);
        this.f = str;
        this.e = iRequestHost;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public LiveUserinfoModel getItem(int i) {
        return this.b.get(i);
    }

    public void a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveUserinfoModel>>() { // from class: com.blued.android.module.live_china.adapter.LiveManagerAdapter.3
                boolean a = false;

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<LiveUserinfoModel> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData()) {
                        return;
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= LiveManagerAdapter.this.b.size()) {
                            return;
                        }
                        if (str.equalsIgnoreCase(LiveManagerAdapter.this.b.get(i2).uid)) {
                            LiveManagerAdapter.this.b.get(i2).is_manager = 1;
                            LiveManagerAdapter.this.b.get(i2).last_is_manager = 1;
                            LiveManagerAdapter.this.notifyDataSetChanged();
                            return;
                        }
                        i = i2 + 1;
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str2) {
                    this.a = true;
                    return super.onUIFailure(i, str2);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    if (this.a) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= LiveManagerAdapter.this.b.size()) {
                                break;
                            } else if (str.equalsIgnoreCase(LiveManagerAdapter.this.b.get(i2).uid)) {
                                LiveManagerAdapter.this.b.get(i2).is_manager = LiveManagerAdapter.this.b.get(i2).last_is_manager;
                                LiveManagerAdapter.this.notifyDataSetChanged();
                                break;
                            } else {
                                i = i2 + 1;
                            }
                        }
                        this.a = false;
                    }
                }
            }, this.e, this.f, str);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                return;
            }
            if (str.equalsIgnoreCase(this.b.get(i2).uid)) {
                this.b.get(i2).is_manager = this.b.get(i2).last_is_manager;
                notifyDataSetChanged();
                AppMethods.a((CharSequence) this.a.getResources().getString(R.string.common_net_error));
                return;
            }
            i = i2 + 1;
        }
    }

    public void a(List<LiveUserinfoModel> list) {
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                list.get(i2).is_manager = 1;
                list.get(i2).last_is_manager = 1;
                i = i2 + 1;
            }
            this.b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void b(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveUserinfoModel>>() { // from class: com.blued.android.module.live_china.adapter.LiveManagerAdapter.4
            boolean a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveUserinfoModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= LiveManagerAdapter.this.b.size()) {
                        return;
                    }
                    if (str.equalsIgnoreCase(LiveManagerAdapter.this.b.get(i2).uid)) {
                        LiveManagerAdapter.this.b.get(i2).is_manager = 0;
                        LiveManagerAdapter.this.b.get(i2).last_is_manager = 0;
                        LiveManagerAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    i = i2 + 1;
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                this.a = true;
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (this.a) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= LiveManagerAdapter.this.b.size()) {
                            break;
                        } else if (str.equalsIgnoreCase(LiveManagerAdapter.this.b.get(i2).uid)) {
                            LiveManagerAdapter.this.b.get(i2).is_manager = LiveManagerAdapter.this.b.get(i2).last_is_manager;
                            LiveManagerAdapter.this.notifyDataSetChanged();
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                    this.a = false;
                }
            }
        }, this.e, this.f, str);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.d.inflate(R.layout.item_live_manage_list, viewGroup, false);
            viewHolder.b = (ImageView) view2.findViewById(R.id.img_header);
            viewHolder.c = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.d = (TextView) view2.findViewById(R.id.tv_name);
            viewHolder.e = (TextView) view2.findViewById(R.id.tv_info);
            viewHolder.f = (TextView) view2.findViewById(R.id.tv_city);
            viewHolder.g = (TextView) view2.findViewById(R.id.tv_operate);
            viewHolder.h = (ImageView) view2.findViewById(R.id.img_vip_icon);
            viewHolder.i = (ProgressBar) view2.findViewById(R.id.loading_view);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final LiveUserinfoModel liveUserinfoModel = this.b.get(i);
        LiveRoomInfo.a().a(viewHolder.c, liveUserinfoModel.vbadge);
        ImageLoader.a((IRequestHost) null, AvatarUtils.a(0, liveUserinfoModel.avatar)).b(R.drawable.user_bg_round).c().a(viewHolder.b);
        LiveRoomInfo.a().a(viewHolder.h, liveUserinfoModel);
        if (!TextUtils.isEmpty(liveUserinfoModel.note)) {
            viewHolder.d.setText(liveUserinfoModel.note);
        } else if (TextUtils.isEmpty(liveUserinfoModel.name)) {
            viewHolder.d.setText("");
        } else {
            viewHolder.d.setText(liveUserinfoModel.name);
        }
        LiveRoomInfo.a().a(this.a, viewHolder.d, liveUserinfoModel, R.color.white);
        String str = liveUserinfoModel.age + "";
        String a = LiveRoomInfo.a().a(liveUserinfoModel.height, false);
        String b = LiveRoomInfo.a().b(liveUserinfoModel.weight, false);
        viewHolder.e.setText(str + BridgeUtil.SPLIT_MARK + a + BridgeUtil.SPLIT_MARK + b + NativeLibraryHelper.CLEAR_ABI_OVERRIDE + LiveRoomInfo.a().d(this.a, liveUserinfoModel.role));
        if (TextUtils.isEmpty(liveUserinfoModel.city_settled)) {
            viewHolder.f.setText("");
        } else {
            viewHolder.f.setText(LiveRoomInfo.a().a(liveUserinfoModel.city_settled));
        }
        LiveRoomInfo.a().a(this.a, viewHolder.f, liveUserinfoModel.is_hide_city_settled, 1);
        int i2 = liveUserinfoModel.is_manager;
        if (i2 == -1) {
            viewHolder.i.setVisibility(0);
            viewHolder.g.setVisibility(8);
            return view2;
        } else if (i2 != 0) {
            viewHolder.i.setVisibility(8);
            viewHolder.g.setVisibility(0);
            viewHolder.g.setText(this.a.getString(R.string.live_cancel_manage));
            viewHolder.g.setBackground(this.a.getResources().getDrawable(R.drawable.shape_user_card_cancel_manager));
            viewHolder.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveManagerAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    CommonAlertDialog.a(LiveManagerAdapter.this.a, (View) null, "", LiveManagerAdapter.this.a.getString(R.string.sure_to_remove_manager), "", "", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveManagerAdapter.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            Tracker.onClick(dialogInterface, i3);
                            LiveManagerAdapter.this.b(liveUserinfoModel.uid);
                            LiveManagerAdapter.this.b.get(i).is_manager = -1;
                            LiveManagerAdapter.this.notifyDataSetChanged();
                        }
                    }, (DialogInterface.OnClickListener) null, (DialogInterface.OnCancelListener) null, true);
                }
            });
            return view2;
        } else {
            viewHolder.i.setVisibility(8);
            viewHolder.g.setVisibility(0);
            viewHolder.g.setText(this.a.getString(R.string.live_set_manager));
            viewHolder.g.setBackground(this.a.getResources().getDrawable(R.drawable.shape_user_card_set_manager));
            viewHolder.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveManagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    LiveManagerAdapter.this.a(liveUserinfoModel.uid);
                    LiveManagerAdapter.this.b.get(i).is_manager = -1;
                    LiveManagerAdapter.this.notifyDataSetChanged();
                }
            });
            return view2;
        }
    }
}
