package com.sobot.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.anythink.expressad.foundation.h.i;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.ZhiChiUploadAppFileModelResult;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.image.SobotRCImageView;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotPicListAdapter.class */
public class SobotPicListAdapter extends SobotBaseAdapter<ZhiChiUploadAppFileModelResult> {
    public static final int ADD = 0;
    public static final int DEL = 2;
    public static final int PIC = 1;
    ViewClickListener listener;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotPicListAdapter$SobotFileHolder.class */
    static class SobotFileHolder {
        private ViewClickListener listener;
        private Context mContext;
        private int position;
        SobotRCImageView sobot_iv_pic;
        ImageView sobot_iv_pic_add;
        LinearLayout sobot_iv_pic_add_ll;
        private ImageView sobot_remove;

        SobotFileHolder(Context context, View view) {
            this.mContext = context;
            this.sobot_iv_pic = (SobotRCImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_pic"));
            this.sobot_iv_pic_add = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_pic_add"));
            this.sobot_iv_pic_add_ll = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_pic_add_ll"));
            this.sobot_remove = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_pic_delete"));
        }

        void bindData(ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult) {
            if (zhiChiUploadAppFileModelResult.getViewState() == 0) {
                this.sobot_iv_pic.setVisibility(8);
                this.sobot_iv_pic_add_ll.setVisibility(0);
                this.sobot_remove.setVisibility(8);
            } else {
                this.sobot_iv_pic.setVisibility(0);
                this.sobot_iv_pic_add_ll.setVisibility(8);
                this.sobot_remove.setVisibility(0);
                SobotBitmapUtil.display(this.mContext, zhiChiUploadAppFileModelResult.getFileLocalPath(), this.sobot_iv_pic, ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_default_pic"), ResourceUtils.getIdByName(this.mContext, i.f5112c, "sobot_default_pic_err"));
            }
            this.sobot_iv_pic.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.adapter.SobotPicListAdapter.SobotFileHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SobotFileHolder.this.listener != null) {
                        SobotFileHolder.this.listener.clickView(view, SobotFileHolder.this.position, 1);
                    }
                }
            });
            this.sobot_iv_pic_add_ll.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.adapter.SobotPicListAdapter.SobotFileHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SobotFileHolder.this.listener != null) {
                        SobotFileHolder.this.listener.clickView(view, SobotFileHolder.this.position, 0);
                    }
                }
            });
            this.sobot_remove.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.adapter.SobotPicListAdapter.SobotFileHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SobotFileHolder.this.listener != null) {
                        SobotFileHolder.this.listener.clickView(view, SobotFileHolder.this.position, 2);
                    }
                }
            });
        }

        public void setListener(ViewClickListener viewClickListener) {
            this.listener = viewClickListener;
        }

        public void setPosition(int i) {
            this.position = i;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotPicListAdapter$ViewClickListener.class */
    public interface ViewClickListener {
        void clickView(View view, int i, int i2);
    }

    public SobotPicListAdapter(Context context, List<ZhiChiUploadAppFileModelResult> list) {
        super(context, list);
    }

    public void addData(ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult) {
        ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult2;
        if (this.list == null) {
            return;
        }
        int size = this.list.size() - 1 < 0 ? 0 : this.list.size() - 1;
        this.list.add(size, zhiChiUploadAppFileModelResult);
        if (this.list.size() >= 10 && (zhiChiUploadAppFileModelResult2 = (ZhiChiUploadAppFileModelResult) this.list.get(size)) != null && zhiChiUploadAppFileModelResult2.getViewState() == 0) {
            this.list.remove(size);
        }
        restDataView();
    }

    public void addDatas(List<ZhiChiUploadAppFileModelResult> list) {
        this.list.clear();
        this.list.addAll(list);
        restDataView();
    }

    @Override // com.sobot.chat.adapter.base.SobotBaseAdapter, android.widget.Adapter
    public int getCount() {
        if (this.list.size() <= 10) {
            return this.list.size();
        }
        return 10;
    }

    @Override // com.sobot.chat.adapter.base.SobotBaseAdapter, android.widget.Adapter
    public ZhiChiUploadAppFileModelResult getItem(int i) {
        if (i < 0 || i >= this.list.size()) {
            return null;
        }
        return (ZhiChiUploadAppFileModelResult) this.list.get(i);
    }

    public ArrayList<ZhiChiUploadAppFileModelResult> getPicList() {
        ArrayList<ZhiChiUploadAppFileModelResult> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.list.size()) {
                return arrayList;
            }
            ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult = (ZhiChiUploadAppFileModelResult) this.list.get(i2);
            if (zhiChiUploadAppFileModelResult.getViewState() != 0) {
                arrayList.add(zhiChiUploadAppFileModelResult);
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        SobotFileHolder sobotFileHolder;
        ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult = (ZhiChiUploadAppFileModelResult) this.list.get(i);
        if (view == null) {
            view2 = LayoutInflater.from(this.context).inflate(ResourceUtils.getIdByName(this.context, "layout", "sobot_piclist_item"), (ViewGroup) null);
            sobotFileHolder = new SobotFileHolder(this.context, view2);
            view2.setTag(sobotFileHolder);
        } else {
            view2 = view;
            sobotFileHolder = (SobotFileHolder) view.getTag();
        }
        sobotFileHolder.setPosition(i);
        sobotFileHolder.setListener(this.listener);
        sobotFileHolder.bindData(zhiChiUploadAppFileModelResult);
        return view2;
    }

    public void restDataView() {
        if (this.list.size() == 0) {
            ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult = new ZhiChiUploadAppFileModelResult();
            zhiChiUploadAppFileModelResult.setViewState(0);
            this.list.add(zhiChiUploadAppFileModelResult);
        } else {
            ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult2 = (ZhiChiUploadAppFileModelResult) this.list.get(this.list.size() - 1 < 0 ? 0 : this.list.size() - 1);
            if (this.list.size() < 10 && zhiChiUploadAppFileModelResult2.getViewState() != 0) {
                ZhiChiUploadAppFileModelResult zhiChiUploadAppFileModelResult3 = new ZhiChiUploadAppFileModelResult();
                zhiChiUploadAppFileModelResult3.setViewState(0);
                this.list.add(zhiChiUploadAppFileModelResult3);
            }
        }
        notifyDataSetChanged();
    }

    public void setOnClickItemViewListener(ViewClickListener viewClickListener) {
        this.listener = viewClickListener;
    }
}
