package com.soft.blued.ui.setting.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.setting.Contract.LoginDeviceListContract;
import com.soft.blued.ui.setting.model.DeviceModel;
import com.soft.blued.utils.UserRelationshipUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/LoginDeviceListAdapter.class */
public class LoginDeviceListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f19604a;
    private LoginDeviceListContract.IPresenter b;

    /* renamed from: c  reason: collision with root package name */
    private List<DeviceModel> f19605c;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/adapter/LoginDeviceListAdapter$ViewHolder.class */
    class ViewHolder {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f19610c;
        private TextView d;
        private TextView e;

        public ViewHolder(View view) {
            if (view != null) {
                this.b = (TextView) view.findViewById(R.id.tv_exit);
                this.f19610c = (TextView) view.findViewById(R.id.tv_item_divider);
                this.d = (TextView) view.findViewById(R.id.tv_device_name);
                this.e = (TextView) view.findViewById(R.id.tv_last_login_time);
            }
        }
    }

    public LoginDeviceListAdapter(Context context, LoginDeviceListContract.IPresenter iPresenter, List<DeviceModel> list) {
        this.f19604a = context;
        this.b = iPresenter;
        this.f19605c = list;
    }

    private String a(int i) {
        long j = i * 1000;
        if (TimeAndDateUtils.g(j)) {
            if (TimeAndDateUtils.f(j)) {
                return ((SimpleDateFormat) TimeAndDateUtils.f.get()).format(new Date(j));
            }
            if (TimeAndDateUtils.h(j)) {
                return this.f19604a.getResources().getString(R.string.biao_msg_yesterday) + " " + ((SimpleDateFormat) TimeAndDateUtils.f.get()).format(new Date(j));
            }
            return ((SimpleDateFormat) TimeAndDateUtils.h.get()).format(new Date(j));
        }
        return ((SimpleDateFormat) TimeAndDateUtils.e.get()).format(new Date(j));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<DeviceModel> list = this.f19605c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f19605c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return Long.parseLong(this.f19605c.get(i).id);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f19604a).inflate(R.layout.item_login_device, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final DeviceModel deviceModel = this.f19605c.get(i);
        if (deviceModel != null) {
            if (i == getCount() - 1) {
                viewHolder.f19610c.setVisibility(8);
            } else {
                viewHolder.f19610c.setVisibility(0);
            }
            final String str = deviceModel.id;
            if (deviceModel.is_self == 1) {
                TextView textView = viewHolder.d;
                textView.setText(deviceModel.dev_name + this.f19604a.getResources().getString(R.string.local_device));
            } else {
                viewHolder.d.setText(deviceModel.dev_name);
            }
            TextView textView2 = viewHolder.e;
            textView2.setText(this.f19604a.getResources().getString(R.string.last_login_time) + a(deviceModel.last_login));
            viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.LoginDeviceListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    CommonAlertDialog.a(LoginDeviceListAdapter.this.f19604a, (String) null, String.format(LoginDeviceListAdapter.this.f19604a.getResources().getString(R.string.quit_login_device_desc), deviceModel.dev_name), LoginDeviceListAdapter.this.f19604a.getResources().getString(R.string.quit_device), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.adapter.LoginDeviceListAdapter.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                            LoginDeviceListAdapter.this.b.a("delete", str);
                            if (deviceModel.is_self == 1) {
                                UserRelationshipUtils.a("", new int[0]);
                            }
                        }
                    }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                }
            });
        }
        return view;
    }
}
