package com.android.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/AccountViewAdapter.class */
public class AccountViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<AccountElements> mData;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/AccountViewAdapter$AccountElements.class */
    public static class AccountElements {
        private Drawable mDrawable;
        private int mIcon;
        private String mName;
        private String mNumber;

        private AccountElements(int i, Drawable drawable, String str, String str2) {
            this.mIcon = i;
            this.mDrawable = drawable;
            this.mName = str;
            this.mNumber = str2;
        }

        public AccountElements(int i, String str, String str2) {
            this(i, null, str, str2);
        }

        public AccountElements(Drawable drawable, String str, String str2) {
            this(0, drawable, str, str2);
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public String getName() {
            return this.mName;
        }

        public String getNumber() {
            return this.mNumber;
        }
    }

    public AccountViewAdapter(Context context, List<AccountElements> list) {
        this.mContext = context;
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        AccountItemView accountItemView = view == null ? new AccountItemView(this.mContext) : (AccountItemView) view;
        accountItemView.setViewItem((AccountElements) getItem(i));
        return accountItemView;
    }

    public void updateData(List<AccountElements> list) {
        this.mData = list;
        notifyDataSetChanged();
    }
}
