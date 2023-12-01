package com.blued.android.module.common.utils.freedom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.common.utils.freedom.clickcallback.OnLongClickCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/freedom/FreedomAdapter.class */
public class FreedomAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public List<FreedomItem> f10933a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10934c = false;
    private IRequestHost d;
    private OnClickCallback e;
    private OnLongClickCallback f;
    private Map<String, Object> g;

    public FreedomAdapter(Context context, IRequestHost iRequestHost, List list) {
        this.b = context;
        this.d = iRequestHost;
        this.f10933a = list;
    }

    public FreedomAdapter(Context context, IRequestHost iRequestHost, List list, OnClickCallback onClickCallback) {
        this.b = context;
        this.f10933a = list;
        this.d = iRequestHost;
        a(onClickCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, int i, BaseViewHolder baseViewHolder) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view, int i, BaseViewHolder baseViewHolder) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BaseViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false), this.d);
    }

    public OnClickCallback a() {
        if (this.e == null) {
            this.e = new OnClickCallback() { // from class: com.blued.android.module.common.utils.freedom.-$$Lambda$FreedomAdapter$-kzICRHKJazsziR3JVh3yeKr4ME
                @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
                public final void onClick(View view, int i, BaseViewHolder baseViewHolder) {
                    FreedomAdapter.b(view, i, baseViewHolder);
                }
            };
        }
        return this.e;
    }

    public <T> T a(String str, T t) {
        T t2;
        Map<String, Object> map = this.g;
        if (map != null && (t2 = (T) map.get(str)) != null) {
            return t2;
        }
        return t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onViewRecycled(BaseViewHolder baseViewHolder) {
        baseViewHolder.a();
        super.onViewRecycled(baseViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        List<FreedomItem> list = this.f10933a;
        if (list == null || list.isEmpty()) {
            return;
        }
        int adapterPosition = baseViewHolder.getAdapterPosition();
        int i2 = adapterPosition;
        if (this.f10934c) {
            i2 = adapterPosition % this.f10933a.size();
        }
        if (i2 >= this.f10933a.size() || this.f10933a.get(i2) == null) {
            return;
        }
        if (this.e != null) {
            baseViewHolder.b();
        }
        if (this.f != null) {
            baseViewHolder.c();
        }
        FreedomItem freedomItem = this.f10933a.get(i2);
        freedomItem.a(baseViewHolder);
        freedomItem.a(this.b, baseViewHolder, this.f10933a, i2);
    }

    public void a(OnClickCallback onClickCallback) {
        this.e = onClickCallback;
    }

    public OnLongClickCallback b() {
        if (this.f == null) {
            this.f = new OnLongClickCallback() { // from class: com.blued.android.module.common.utils.freedom.-$$Lambda$FreedomAdapter$D2nHSgLaSU3fQgsEzKLZxnr7ri0
                @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnLongClickCallback
                public final boolean onLongClick(View view, int i, BaseViewHolder baseViewHolder) {
                    boolean a2;
                    a2 = FreedomAdapter.a(view, i, baseViewHolder);
                    return a2;
                }
            };
        }
        return this.f;
    }

    public void b(String str, Object obj) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        this.g.put(str, obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f10934c) {
            return Integer.MAX_VALUE;
        }
        List<FreedomItem> list = this.f10933a;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.f10933a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<FreedomItem> list = this.f10933a;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i2 = i;
        if (this.f10934c) {
            i2 = i % this.f10933a.size();
        }
        if (i2 >= this.f10933a.size()) {
            return -1;
        }
        return this.f10933a.get(i2).b();
    }
}
