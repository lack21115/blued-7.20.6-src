package com.blued.android.module.shortvideo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.ConfigData;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.model.FilterItem;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/ConfigAdapter.class */
public class ConfigAdapter extends RecyclerView.Adapter<MyViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15687a = ConfigAdapter.class.getSimpleName();
    private ConfigData b;

    /* renamed from: c  reason: collision with root package name */
    private CommonModel f15688c;
    private int d;
    private int e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/adapter/ConfigAdapter$MyViewHolder.class */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f15690c;
        private int d;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.b = (ImageView) view.findViewById(R.id.stv_config_item_image);
            this.f15690c = (TextView) view.findViewById(R.id.stv_config_item_text);
        }

        public void a(int i, int i2, int i3, float f, boolean z) {
            this.d = i;
            this.b.setAlpha(f);
            if (i2 != -1) {
                this.b.setImageResource(i2);
            }
            this.b.setActivated(z);
            int i4 = this.d;
            if (i4 == 1) {
                TextView textView = this.f15690c;
                if (!z) {
                    i3 = R.string.stv_config_close_beauty_name;
                }
                textView.setText(i3);
            } else if (i4 != 2) {
                this.f15690c.setText(i3);
            } else {
                this.f15690c.setText(i3);
                if (i3 != ConfigAdapter.this.b.getDefaultFilterNameId()) {
                    StvViewUtils.g(this.itemView.getContext(), this.itemView);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            StvViewUtils.a(view);
            int i = this.d;
            if (i == 0) {
                if (this.b.isActivated()) {
                    ObserverMgr.a().a(EventType.VALUE.CONFIG_MUSIC);
                }
            } else if (i == 1) {
                boolean z = !this.b.isActivated();
                if (z) {
                    this.f15690c.setText(R.string.stv_config_open_beauty_name);
                } else {
                    this.f15690c.setText(R.string.stv_config_close_beauty_name);
                }
                this.b.setActivated(z);
                ObserverMgr.a().a(EventType.VALUE.CONFIG_BEAUTY);
            } else if (i == 2) {
                ObserverMgr.a().a(EventType.VALUE.CONFIG_FILTER);
            } else if (i == 3) {
                if (ConfigAdapter.this.d < 60) {
                    StatisticsProxy.a().a("sv_coutdown_click");
                }
                ObserverMgr.a().a(EventType.VALUE.START_TIMEDOWN);
            } else if (i == 4) {
                ObserverMgr.a().a(EventType.VALUE.CONFIG_VOLUME);
            } else if (i != 5) {
            } else {
                ObserverMgr.a().a(EventType.VALUE.CONFIG_COVER);
            }
        }
    }

    public ConfigAdapter(CommonModel commonModel) {
        this.f15688c = commonModel;
        this.b = new ConfigData(commonModel);
    }

    public int a(boolean z) {
        ConfigData configData = this.b;
        if (configData != null) {
            return configData.setCoverActivated(z);
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.config_view_item, viewGroup, false));
    }

    public void a() {
        notifyItemChanged(this.b.setCoverActivated(true));
    }

    public void a(int i, int i2, int i3) {
        this.d = i;
        this.f = i2;
        this.e = i3;
        this.b.switchPage(i, i2, i3);
    }

    public void a(int i, long j) {
        boolean z = true;
        if (this.e == 1) {
            int musicAlphas = this.b.setMusicAlphas(i > 0 ? 0.4f : 1.0f);
            ConfigData configData = this.b;
            if (i > 0) {
                z = false;
            }
            configData.setMusicActivated(z);
            notifyItemChanged(musicAlphas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        if (this.b.ids.size() - 1 >= i) {
            myViewHolder.a(this.b.ids.get(i).intValue(), this.b.iconids.get(i).intValue(), this.b.nameids.get(i).intValue(), this.b.alphas.get(i).floatValue(), this.b.activateds.get(i).booleanValue());
            return;
        }
        StvLogUtils.a(f15687a + "ConfigAdapter onBindViewHolder() (mData.ids.length-1)<position", new Object[0]);
    }

    public void b() {
        FilterItem selectedFilter = (this.e == 4 && this.f == 3) ? this.f15688c.getSelectedFilter() : this.f15688c.getSelectedFilter();
        notifyItemChanged((selectedFilter == null || selectedFilter.b() == null) ? this.b.setFilter(R.string.stv_config_filter_name, R.drawable.config_filter_icon) : this.b.setFilter(selectedFilter.b, selectedFilter.f15755c));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ConfigData configData = this.b;
        if (configData != null) {
            return configData.ids.size();
        }
        return 0;
    }
}
