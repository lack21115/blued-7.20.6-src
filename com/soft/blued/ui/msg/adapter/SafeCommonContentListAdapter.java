package com.soft.blued.ui.msg.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.MsgExtraForTextTypeEntity;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/SafeCommonContentListAdapter.class */
public class SafeCommonContentListAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> f18490a;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/SafeCommonContentListAdapter$SafeContentViewHolder.class */
    public class SafeContentViewHolder extends RecyclerView.ViewHolder {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f18492c;

        public SafeContentViewHolder(View view) {
            super(view);
            this.b = (TextView) view.findViewById(R.id.safe_content_title);
            this.f18492c = (TextView) view.findViewById(R.id.safe_content_tv);
        }

        public void a(final MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent) {
            if (secureContent != null) {
                if (TextUtils.isEmpty(secureContent.title)) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                    this.b.setText(secureContent.title);
                }
                if (!TextUtils.isEmpty(secureContent.body)) {
                    this.f18492c.setText(StringUtils.a(secureContent.body, secureContent.link_title));
                }
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.SafeCommonContentListAdapter.SafeContentViewHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (TextUtils.isEmpty(secureContent.link)) {
                            return;
                        }
                        WebViewShowInfoFragment.show(SafeContentViewHolder.this.itemView.getContext(), secureContent.link, -1);
                    }
                });
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<MsgExtraForTextTypeEntity.SecureNotify.SecureContent> list = this.f18490a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        MsgExtraForTextTypeEntity.SecureNotify.SecureContent secureContent = this.f18490a.get(i);
        SafeContentViewHolder safeContentViewHolder = (SafeContentViewHolder) viewHolder;
        if (safeContentViewHolder != null) {
            safeContentViewHolder.a(secureContent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SafeContentViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg_safe_common_content_item, viewGroup, false));
    }
}
