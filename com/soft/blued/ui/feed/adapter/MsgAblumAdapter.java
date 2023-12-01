package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/MsgAblumAdapter.class */
public class MsgAblumAdapter extends RecyclerView.Adapter<AblumHolder> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f29865a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private int f29866c;
    private List<ChildImageInfo> d = new ArrayList();
    private List<AblumHolder> e = new ArrayList();
    private RecyclerView f;
    private OnItemClickListener g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/MsgAblumAdapter$AblumHolder.class */
    public class AblumHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        ImageView f29868a;
        View b;

        /* renamed from: c  reason: collision with root package name */
        String f29869c;

        public AblumHolder(View view) {
            super(view);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/MsgAblumAdapter$OnItemClickListener.class */
    public interface OnItemClickListener {
        void a(ChildImageInfo childImageInfo);
    }

    public MsgAblumAdapter(Context context, IRequestHost iRequestHost, RecyclerView recyclerView, ChildImageInfo childImageInfo) {
        this.f29866c = -1;
        this.f29865a = context;
        this.b = iRequestHost;
        this.f = recyclerView;
        this.d.addAll(SelectPhotoManager.a().c());
        if (childImageInfo != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.d.size()) {
                    break;
                } else if (TextUtils.equals(this.d.get(i2).mImagePath, childImageInfo.mImagePath)) {
                    this.f29866c = i2;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
        }
        if (this.d.size() == 0) {
            recyclerView.setVisibility(8);
        } else {
            recyclerView.setVisibility(0);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public AblumHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.f29865a).inflate(R.layout.msg_ablum_item, viewGroup, false);
        AblumHolder ablumHolder = new AblumHolder(inflate);
        ablumHolder.f29868a = (ImageView) inflate.findViewById(R.id.msg_thumb_image);
        ablumHolder.b = inflate.findViewById(R.id.msg_thumb_stoke);
        this.e.add(ablumHolder);
        return ablumHolder;
    }

    public void a(ChildImageInfo childImageInfo) {
        if (childImageInfo == null) {
            return;
        }
        this.d.add(new ChildImageInfo(childImageInfo));
        this.f29866c = this.d.size() - 1;
        if (this.d.size() == 1) {
            notifyDataSetChanged();
        } else {
            notifyItemInserted(this.d.size() - 1);
            d(childImageInfo);
        }
        if (this.f.getVisibility() != 0) {
            this.f.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(AblumHolder ablumHolder, int i) {
        if (i >= this.d.size()) {
            return;
        }
        if (i == this.f29866c) {
            ablumHolder.b.setVisibility(0);
        } else {
            ablumHolder.b.setVisibility(8);
        }
        ablumHolder.f29869c = this.d.get(i).mImagePath;
        ImageLoader.d(this.b, this.d.get(i).mImagePath).b(2131231620).a(6.0f).a(ablumHolder.f29868a);
        final String str = this.d.get(i).mImagePath;
        ablumHolder.f29868a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.adapter.MsgAblumAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= MsgAblumAdapter.this.d.size()) {
                        break;
                    } else if (TextUtils.equals(((ChildImageInfo) MsgAblumAdapter.this.d.get(i3)).mImagePath, str)) {
                        MsgAblumAdapter.this.f29866c = i3;
                        break;
                    } else {
                        i2 = i3 + 1;
                    }
                }
                if (MsgAblumAdapter.this.f29866c < 0 || MsgAblumAdapter.this.f29866c >= MsgAblumAdapter.this.d.size()) {
                    return;
                }
                MsgAblumAdapter msgAblumAdapter = MsgAblumAdapter.this;
                msgAblumAdapter.d((ChildImageInfo) msgAblumAdapter.d.get(MsgAblumAdapter.this.f29866c));
                if (MsgAblumAdapter.this.g != null) {
                    MsgAblumAdapter.this.g.a((ChildImageInfo) MsgAblumAdapter.this.d.get(MsgAblumAdapter.this.f29866c));
                }
            }
        });
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.g = onItemClickListener;
    }

    public void b(ChildImageInfo childImageInfo) {
        int i;
        if (childImageInfo == null) {
            return;
        }
        this.f29866c = -1;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.d.size()) {
                i = -1;
                break;
            } else if (TextUtils.equals(this.d.get(i).mImagePath, childImageInfo.mImagePath)) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i != -1) {
            this.d.remove(i);
            notifyItemRemoved(i);
            d(childImageInfo);
        }
        if (this.d.size() == 0 && this.f.getVisibility() == 0) {
            this.f.setVisibility(8);
        }
    }

    public void c(ChildImageInfo childImageInfo) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                break;
            } else if (TextUtils.equals(this.d.get(i2).mImagePath, childImageInfo.mImagePath)) {
                this.f29866c = i2;
                this.f.scrollToPosition(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        d(childImageInfo);
    }

    public void d(ChildImageInfo childImageInfo) {
        for (AblumHolder ablumHolder : this.e) {
            if (TextUtils.equals(ablumHolder.f29869c, childImageInfo.mImagePath)) {
                ablumHolder.b.setVisibility(0);
            } else {
                ablumHolder.b.setVisibility(8);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ChildImageInfo> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
