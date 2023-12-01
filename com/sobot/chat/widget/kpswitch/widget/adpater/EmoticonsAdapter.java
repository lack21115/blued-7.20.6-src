package com.sobot.chat.widget.kpswitch.widget.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.kpswitch.widget.data.EmoticonPageEntity;
import com.sobot.chat.widget.kpswitch.widget.interfaces.EmoticonClickListener;
import com.sobot.chat.widget.kpswitch.widget.interfaces.EmoticonDisplayListener;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/adpater/EmoticonsAdapter.class */
public class EmoticonsAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected final int mDefalutItemHeight;
    protected EmoticonPageEntity mEmoticonPageEntity;
    protected LayoutInflater mInflater;
    protected int mItemHeight;
    protected int mItemHeightMax;
    protected int mItemHeightMin;
    protected EmoticonDisplayListener mOnDisPlayListener;
    protected EmoticonClickListener mOnEmoticonClickListener;
    protected final int DEF_HEIGHTMAXTATIO = 2;
    protected ArrayList<T> mData = new ArrayList<>();
    protected double mItemHeightMaxRatio = 2.0d;
    protected int mDelbtnPosition = -1;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/adpater/EmoticonsAdapter$ViewHolder.class */
    public static class ViewHolder {
        public ImageView iv_emoticon;
        public LinearLayout ly_root;
        public View rootView;
        public TextView tv_emoticon;
    }

    public EmoticonsAdapter(Context context, EmoticonPageEntity emoticonPageEntity, EmoticonClickListener emoticonClickListener) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mEmoticonPageEntity = emoticonPageEntity;
        this.mOnEmoticonClickListener = emoticonClickListener;
        int dimension = (int) context.getResources().getDimension(getResDimenId("sobot_item_emoticon_size_default"));
        this.mItemHeight = dimension;
        this.mDefalutItemHeight = dimension;
        this.mData.addAll(emoticonPageEntity.getEmoticonList());
        checkDelBtn(emoticonPageEntity);
    }

    private void checkDelBtn(EmoticonPageEntity emoticonPageEntity) {
        EmoticonPageEntity.DelBtnStatus delBtnStatus = emoticonPageEntity.getDelBtnStatus();
        if (EmoticonPageEntity.DelBtnStatus.GONE.equals(delBtnStatus)) {
            return;
        }
        if (EmoticonPageEntity.DelBtnStatus.FOLLOW.equals(delBtnStatus)) {
            this.mDelbtnPosition = getCount();
            this.mData.add(null);
        } else if (EmoticonPageEntity.DelBtnStatus.LAST.equals(delBtnStatus)) {
            int line = emoticonPageEntity.getLine();
            int row = emoticonPageEntity.getRow();
            while (getCount() < line * row) {
                this.mData.add(null);
            }
            this.mDelbtnPosition = getCount() - 1;
        }
    }

    protected void bindView(int i, ViewGroup viewGroup, ViewHolder viewHolder) {
        EmoticonDisplayListener emoticonDisplayListener = this.mOnDisPlayListener;
        if (emoticonDisplayListener != null) {
            emoticonDisplayListener.onBindView(i, viewGroup, viewHolder, this.mData.get(i), i == this.mDelbtnPosition);
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
            view = this.mInflater.inflate(getResLayoutId("sobot_list_item_emoticon"), (ViewGroup) null);
            viewHolder.rootView = view;
            viewHolder.ly_root = (LinearLayout) view.findViewById(getResId("sobot_ly_root"));
            viewHolder.iv_emoticon = (ImageView) view.findViewById(getResId("sobot_iv_emoticon"));
            viewHolder.tv_emoticon = (TextView) view.findViewById(getResId("sobot_tv_emoticon"));
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        bindView(i, viewGroup, viewHolder);
        updateUI(viewHolder, viewGroup);
        return view;
    }

    protected boolean isDelBtn(int i) {
        return i == this.mDelbtnPosition;
    }

    public void setDelbtnPosition(int i) {
        this.mDelbtnPosition = i;
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

    public void setOnDisPlayListener(EmoticonDisplayListener emoticonDisplayListener) {
        this.mOnDisPlayListener = emoticonDisplayListener;
    }

    protected void updateUI(ViewHolder viewHolder, ViewGroup viewGroup) {
        if (this.mDefalutItemHeight != this.mItemHeight) {
            viewHolder.iv_emoticon.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mItemHeight));
            viewHolder.tv_emoticon.setLayoutParams(new LinearLayout.LayoutParams(-1, this.mItemHeight));
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
        viewHolder.ly_root.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.max(Math.min(((View) viewGroup.getParent()).getMeasuredHeight() / this.mEmoticonPageEntity.getLine(), this.mItemHeightMax), this.mItemHeightMin)));
    }
}
