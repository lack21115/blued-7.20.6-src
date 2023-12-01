package com.sobot.chat.adapter.base;

import android.content.Context;
import android.widget.BaseAdapter;
import com.sobot.chat.utils.ResourceUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/base/SobotBaseAdapter.class */
public abstract class SobotBaseAdapter<T> extends BaseAdapter {
    public Context context;
    protected List<T> list;

    public SobotBaseAdapter(Context context, List<T> list) {
        this.list = list;
        this.context = context;
        if (list == null) {
            this.list = new ArrayList();
        }
    }

    public Context getContext() {
        return this.context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.list;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<T> getDatas() {
        return this.list;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<T> list = this.list;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public String getResString(String str) {
        return ResourceUtils.getResString(this.context, str);
    }

    public int getResStringId(String str) {
        return ResourceUtils.getIdByName(this.context, "string", str);
    }
}
