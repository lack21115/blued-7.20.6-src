package com.sobot.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.StCategoryModel;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.SobotImageView;
import com.sobot.pictureframe.SobotBitmapUtil;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotHelpCenterAdapter.class */
public class SobotHelpCenterAdapter extends SobotBaseAdapter<StCategoryModel> {
    private LayoutInflater mInflater;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/adapter/SobotHelpCenterAdapter$ViewHolder.class */
    static class ViewHolder {
        private Context mContext;
        private int sobot_bg_default_pic;
        private LinearLayout sobot_container;
        private RelativeLayout sobot_rl;
        private TextView sobot_tv_descripe;
        private SobotImageView sobot_tv_icon;
        private TextView sobot_tv_title;

        public ViewHolder(Context context, View view) {
            this.mContext = context;
            this.sobot_container = (LinearLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_container"));
            this.sobot_rl = (RelativeLayout) view.findViewById(ResourceUtils.getResId(context, "sobot_rl"));
            this.sobot_tv_icon = (SobotImageView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_icon"));
            this.sobot_tv_title = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_title"));
            this.sobot_tv_descripe = (TextView) view.findViewById(ResourceUtils.getResId(context, "sobot_tv_descripe"));
            this.sobot_bg_default_pic = ResourceUtils.getDrawableId(context, "sobot_bg_default_pic_img");
        }

        public void bindData(int i, StCategoryModel stCategoryModel) {
            this.sobot_rl.setSelected(i % 2 == 0);
            Context context = this.mContext;
            String categoryUrl = stCategoryModel.getCategoryUrl();
            SobotImageView sobotImageView = this.sobot_tv_icon;
            int i2 = this.sobot_bg_default_pic;
            SobotBitmapUtil.display(context, categoryUrl, sobotImageView, i2, i2);
            this.sobot_tv_title.setText(stCategoryModel.getCategoryName());
            this.sobot_tv_descripe.setText(stCategoryModel.getCategoryDetail());
        }
    }

    public SobotHelpCenterAdapter(Context context, List<StCategoryModel> list) {
        super(context, list);
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(ResourceUtils.getResLayoutId(this.context, "sobot_list_item_help_center"), (ViewGroup) null);
            viewHolder = new ViewHolder(this.context, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.bindData(i, (StCategoryModel) this.list.get(i));
        return view;
    }
}
