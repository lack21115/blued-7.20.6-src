package com.soft.blued.ui.msg.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/SafeSensitiveContentListAdapter.class */
public class SafeSensitiveContentListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> f18494a;
    private List<String> b;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/SafeSensitiveContentListAdapter$SafeContentViewHolder.class */
    public class SafeContentViewHolder extends RecyclerView.ViewHolder {
        private ImageView b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f18496c;
        private TextView d;

        public SafeContentViewHolder(View view) {
            super(view);
            this.b = (ImageView) view.findViewById(R.id.safe_content_bg);
            this.f18496c = (TextView) view.findViewById(R.id.safe_content_title);
            this.d = (TextView) view.findViewById(R.id.safe_content_tv);
        }

        public void a(MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent, List<String> list) {
            if (secureContent == null || TextUtils.isEmpty(secureContent.body)) {
                return;
            }
            this.d.setText(secureContent.body);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> list = this.f18494a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent = this.f18494a.get(i);
        return (secureContent == null || TextUtils.isEmpty(secureContent.title)) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent = this.f18494a.get(i);
        SafeContentViewHolder safeContentViewHolder = (SafeContentViewHolder) viewHolder;
        if (safeContentViewHolder != null) {
            safeContentViewHolder.a(secureContent, this.b);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg_safe_sensitive_content_item, viewGroup, false);
        inflate.getLayoutParams().height = i == 1 ? DensityUtils.a(AppInfo.d(), 60.0f) : DensityUtils.a(AppInfo.d(), 49.0f);
        return new SafeContentViewHolder(inflate);
    }
}
