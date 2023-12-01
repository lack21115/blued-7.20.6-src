package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/i.class */
public class i extends BaseAdapter {
    private static final int Code = 2;
    private List<PermissionEntity> I;
    private Context V;
    private LayoutInflater Z;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/i$a.class */
    static class a {
        TextView Code;

        public a(View view) {
            this.Code = (TextView) view.findViewById(R.id.hiad_permissions_dialog_child_tv);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/i$b.class */
    static class b {
        TextView Code;

        public b(View view) {
            this.Code = (TextView) view.findViewById(R.id.hiad_permissions_dialog_parent_tv);
        }
    }

    public i(Context context, List<PermissionEntity> list) {
        this.V = context;
        this.I = list;
        this.Z = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (aa.Code(this.I)) {
            return 0;
        }
        return this.I.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (aa.Code(this.I)) {
            return null;
        }
        return this.I.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (aa.Code(this.I)) {
            return 0L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (aa.Code(this.I) || this.I.get(i) == null) {
            return 0;
        }
        return this.I.get(i).V();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        String str;
        View view2;
        TextView textView;
        String str2;
        a aVar;
        PermissionEntity permissionEntity = this.I.get(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            if (view == null) {
                view = this.Z.inflate(R.layout.hiad_permission_dialog_parent_item, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            String Code2 = permissionEntity != null ? permissionEntity.Code() : "";
            TextView textView2 = bVar.Code;
            str = Code2;
            view2 = view;
            textView = textView2;
            if (TextUtils.isEmpty(Code2)) {
                str2 = "";
                textView = textView2;
                textView.setText(str2);
            }
            view = view2;
            str2 = str;
            textView.setText(str2);
        } else if (itemViewType == 1) {
            if (view == null) {
                view = this.Z.inflate(R.layout.hiad_permission_dialog_child_item, viewGroup, false);
                aVar = new a(view);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            String Code3 = permissionEntity != null ? permissionEntity.Code() : "";
            TextView textView3 = aVar.Code;
            str = Code3;
            view2 = view;
            textView = textView3;
            if (TextUtils.isEmpty(Code3)) {
                str2 = "";
                textView = textView3;
                textView.setText(str2);
            }
            view = view2;
            str2 = str;
            textView.setText(str2);
        }
        ge.Code("AppPermissionsDialog", "getView, time:%s, position:%s", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }
}
