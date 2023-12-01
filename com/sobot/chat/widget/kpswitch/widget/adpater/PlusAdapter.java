package com.sobot.chat.widget.kpswitch.widget.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.kpswitch.view.ChattingPanelUploadView;
import com.sobot.chat.widget.kpswitch.widget.data.PlusPageEntity;
import com.sobot.chat.widget.kpswitch.widget.interfaces.PlusDisplayListener;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/adpater/PlusAdapter.class */
public class PlusAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected final int mDefalutItemHeight;
    protected LayoutInflater mInflater;
    protected int mItemHeight;
    protected int mItemHeightMax;
    protected int mItemHeightMin;
    protected PlusDisplayListener mOnDisPlayListener;
    protected ChattingPanelUploadView.SobotPlusClickListener mOnItemClickListener;
    protected PlusPageEntity mPlusPageEntity;
    protected final int DEF_HEIGHTMAXTATIO = 2;
    protected ArrayList<T> mData = new ArrayList<>();
    protected double mItemHeightMaxRatio = 2.0d;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/adpater/PlusAdapter$ViewHolder.class */
    public static class ViewHolder {
        public LinearLayout ly_root;
        public TextView mMenu;
        public View rootView;
    }

    public PlusAdapter(Context context, PlusPageEntity plusPageEntity, ChattingPanelUploadView.SobotPlusClickListener sobotPlusClickListener) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mPlusPageEntity = plusPageEntity;
        this.mOnItemClickListener = sobotPlusClickListener;
        int dimension = (int) context.getResources().getDimension(getResDimenId("sobot_item_plus_size_default"));
        this.mItemHeight = dimension;
        this.mDefalutItemHeight = dimension;
        this.mData.addAll(plusPageEntity.getDataList());
    }

    protected void bindView(int i, ViewGroup viewGroup, ViewHolder viewHolder) {
        PlusDisplayListener plusDisplayListener = this.mOnDisPlayListener;
        if (plusDisplayListener != null) {
            plusDisplayListener.onBindView(i, viewGroup, viewHolder, this.mData.get(i));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<T> arrayList = this.mData;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<T> arrayList = this.mData;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public int getResDimenId(String str) {
        return ResourceUtils.getIdByName(this.mContext, "dimen", str);
    }

    public int getResId(String str) {
        return ResourceUtils.getIdByName(this.mContext, "id", str);
    }

    public int getResLayoutId(String str) {
        return ResourceUtils.getIdByName(this.mContext, "layout", str);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = this.mInflater.inflate(getResLayoutId("sobot_list_item_plus_menu"), (ViewGroup) null);
            viewHolder.rootView = view;
            viewHolder.ly_root = (LinearLayout) view.findViewById(getResId("sobot_ly_root"));
            viewHolder.mMenu = (TextView) view.findViewById(getResId("sobot_plus_menu"));
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        bindView(i, viewGroup, viewHolder);
        updateUI(viewHolder, viewGroup);
        return view;
    }

    public void setItemHeight(int i) {
        this.mItemHeight = i;
    }

    public void setItemHeightMax(int i) {
        this.mItemHeightMax = i;
    }

    public void setItemHeightMaxRatio(double d) {
        this.mItemHeightMaxRatio = d;
    }

    public void setItemHeightMin(int i) {
        this.mItemHeightMin = i;
    }

    public void setOnDisPlayListener(PlusDisplayListener plusDisplayListener) {
        this.mOnDisPlayListener = plusDisplayListener;
    }

    protected void updateUI(ViewHolder viewHolder, ViewGroup viewGroup) {
        if (this.mDefalutItemHeight != this.mItemHeight) {
            viewHolder.mMenu.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mItemHeight));
        }
        int i = this.mItemHeightMax;
        if (i == 0) {
            i = (int) (this.mItemHeight * this.mItemHeightMaxRatio);
        }
        this.mItemHeightMax = i;
        int i2 = this.mItemHeightMin;
        if (i2 == 0) {
            i2 = this.mItemHeight;
        }
        this.mItemHeightMin = i2;
        viewHolder.ly_root.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.max(Math.min(((View) viewGroup.getParent()).getMeasuredHeight() / this.mPlusPageEntity.getLine(), this.mItemHeightMax), this.mItemHeightMin)));
    }
}
