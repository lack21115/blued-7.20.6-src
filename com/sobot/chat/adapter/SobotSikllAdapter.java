package com.sobot.chat.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.model.ZhiChiGroupBase;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.horizontalgridpage.SobotRecyclerCallBack;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotSikllAdapter.class */
public class SobotSikllAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int STYLE_DEF = 0;
    private static final int STYLE_PIC_TEXT = 1;
    private static final int STYLE_PIC_TEXT_DES = 2;
    private SobotRecyclerCallBack callBack;
    private List<ZhiChiGroupBase> list;
    private Context mContext;
    private int msgFlag;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotSikllAdapter$ViewHolder.class */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView sobot_iv_group_img;
        private TextView sobot_tv_group_desc;
        private TextView sobot_tv_group_name;

        public ViewHolder(Context context, View view) {
            super(view);
            this.sobot_iv_group_img = (ImageView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_iv_group_img"));
            this.sobot_tv_group_name = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_group_name"));
            this.sobot_tv_group_desc = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_tv_group_desc"));
        }
    }

    public SobotSikllAdapter(Context context, List<ZhiChiGroupBase> list, int i, SobotRecyclerCallBack sobotRecyclerCallBack) {
        this.mContext = context;
        this.msgFlag = i;
        this.list = list;
        this.callBack = sobotRecyclerCallBack;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ZhiChiGroupBase> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        ZhiChiGroupBase zhiChiGroupBase = this.list.get(i);
        if (zhiChiGroupBase != null) {
            return zhiChiGroupBase.getGroupStyle();
        }
        return 0;
    }

    public List<ZhiChiGroupBase> getList() {
        return this.list;
    }

    public int getMsgFlag() {
        return this.msgFlag;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String resString;
        viewHolder.itemView.setTag(Integer.valueOf(i));
        ZhiChiGroupBase zhiChiGroupBase = this.list.get(i);
        if (zhiChiGroupBase != null) {
            if (zhiChiGroupBase.getGroupStyle() == 1) {
                viewHolder.sobot_tv_group_name.setText(zhiChiGroupBase.getGroupName());
                if (TextUtils.isEmpty(zhiChiGroupBase.getGroupPic())) {
                    return;
                }
                SobotBitmapUtil.display(this.mContext, zhiChiGroupBase.getGroupPic(), viewHolder.sobot_iv_group_img);
            } else if (zhiChiGroupBase.getGroupStyle() == 2) {
                viewHolder.sobot_tv_group_name.setText(zhiChiGroupBase.getGroupName());
                viewHolder.sobot_tv_group_desc.setText(zhiChiGroupBase.getDescription());
                if (TextUtils.isEmpty(zhiChiGroupBase.getGroupPic())) {
                    return;
                }
                SobotBitmapUtil.display(this.mContext, zhiChiGroupBase.getGroupPic(), viewHolder.sobot_iv_group_img);
            } else {
                viewHolder.sobot_tv_group_name.setText(zhiChiGroupBase.getGroupName());
                if ("true".equals(zhiChiGroupBase.isOnline())) {
                    viewHolder.sobot_tv_group_desc.setVisibility(8);
                    viewHolder.sobot_tv_group_name.setTextSize(14.0f);
                    return;
                }
                viewHolder.sobot_tv_group_name.setTextSize(12.0f);
                TextView textView = viewHolder.sobot_tv_group_name;
                Context context = this.mContext;
                textView.setTextColor(ContextCompat.getColor(context, ResourceUtils.getResColorId(context, "sobot_common_gray2")));
                if (this.msgFlag == 0) {
                    resString = ResourceUtils.getResString(this.mContext, "sobot_no_access") + " " + ResourceUtils.getResString(this.mContext, "sobot_can") + "<font color='#0DAEAF'>" + ResourceUtils.getResString(this.mContext, "sobot_str_bottom_message") + "</a>";
                } else {
                    resString = ResourceUtils.getResString(this.mContext, "sobot_no_access");
                }
                viewHolder.sobot_tv_group_desc.setText(Html.fromHtml(resString));
                viewHolder.sobot_tv_group_desc.setVisibility(0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = new ViewHolder(this.mContext, i == 1 ? LayoutInflater.from(this.mContext).inflate(ResourceUtils.getResLayoutId(this.mContext, "sobot_list_item_skill_second_style"), viewGroup, false) : i == 2 ? LayoutInflater.from(this.mContext).inflate(ResourceUtils.getResLayoutId(this.mContext, "sobot_list_item_skill_third_style"), viewGroup, false) : LayoutInflater.from(this.mContext).inflate(ResourceUtils.getResLayoutId(this.mContext, "sobot_list_item_skill"), viewGroup, false));
        setListener(viewHolder);
        return viewHolder;
    }

    public void setList(List<ZhiChiGroupBase> list) {
        this.list = list;
    }

    public void setListener(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.adapter.SobotSikllAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SobotSikllAdapter.this.callBack.onItemClickListener(view, ((Integer) view.getTag()).intValue());
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sobot.chat.adapter.SobotSikllAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SobotSikllAdapter.this.callBack.onItemLongClickListener(view, ((Integer) view.getTag()).intValue());
                return true;
            }
        });
    }

    public void setMsgFlag(int i) {
        this.msgFlag = i;
    }
}
