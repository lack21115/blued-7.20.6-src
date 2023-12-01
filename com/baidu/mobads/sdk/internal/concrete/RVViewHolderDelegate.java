package com.baidu.mobads.sdk.internal.concrete;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/concrete/RVViewHolderDelegate.class */
public class RVViewHolderDelegate extends RecyclerView.ViewHolder implements a {

    /* renamed from: a  reason: collision with root package name */
    private final b f9393a;

    public RVViewHolderDelegate(IAdInterListener iAdInterListener, View view) {
        super(view);
        this.f9393a = b.a(iAdInterListener, this);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f9393a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f9393a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.f9393a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f9393a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f9393a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f9393a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f9393a.setTarget(obj);
    }
}
