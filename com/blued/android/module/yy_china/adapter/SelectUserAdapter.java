package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.GiftMicModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/SelectUserAdapter.class */
public class SelectUserAdapter extends BaseQuickAdapter<GiftMicModel, BaseViewHolder> {
    private HashSet<YYSeatMemberModel> a;
    private boolean b;
    private View.OnClickListener c;

    public SelectUserAdapter() {
        super(R.layout.item_yy_select_user, new ArrayList());
        this.a = new HashSet<>();
        this.b = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GiftMicModel giftMicModel, BaseViewHolder baseViewHolder, View view) {
        if (this.b) {
            if (this.a.size() > 1) {
                this.a.remove(giftMicModel.getMic());
            } else {
                ToastUtils.a("必须选中至少一个麦位");
            }
            this.c.onClick(null);
            convert(baseViewHolder, giftMicModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(GiftMicModel giftMicModel, BaseViewHolder baseViewHolder, View view) {
        if (!this.b) {
            this.a.clear();
        }
        this.a.add(giftMicModel.getMic());
        this.c.onClick(null);
        convert(baseViewHolder, giftMicModel);
        if (this.b) {
            return;
        }
        notifyDataSetChanged();
    }

    public HashSet<YYSeatMemberModel> a() {
        return this.a;
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void a(YYSeatMemberModel yYSeatMemberModel) {
        this.a.add(yYSeatMemberModel);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final GiftMicModel giftMicModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_select_user);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_select_user_type);
        if ((YYRoomInfoManager.e().b() == null ? "" : YYRoomInfoManager.e().b().uid).equals(giftMicModel.getMic().getUid())) {
            textView.setText(R.string.yy_role_host);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(4);
            textView.setText(getParentPosition(giftMicModel) + "");
        }
        YYRoomInfoManager.e().a((IRequestHost) null, imageView, giftMicModel.getMic().getUid(), giftMicModel.getMic().getAvatar());
        imageView.setBackgroundResource(R.drawable.transparent);
        Iterator<YYSeatMemberModel> it = this.a.iterator();
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$SelectUserAdapter$caP0JC7vTPMP8fQeu95GGhYiQfU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectUserAdapter.this.b(giftMicModel, baseViewHolder, view);
            }
        });
        while (it.hasNext()) {
            if (giftMicModel.getMic() == it.next()) {
                imageView.setBackgroundResource(R.drawable.shape_gift_user_back);
                baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$SelectUserAdapter$CmQ0mqNCyUDs8jQOlShGj49LvlM
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SelectUserAdapter.this.a(giftMicModel, baseViewHolder, view);
                    }
                });
                return;
            }
        }
    }

    public boolean a(boolean z) {
        if (this.b == z) {
            return false;
        }
        this.b = z;
        c();
        return true;
    }

    public void b() {
        if (!this.b) {
            ToastUtils.a("该礼物不支持全麦赠送");
            return;
        }
        if (getData() != null && getData().size() > 0) {
            for (GiftMicModel giftMicModel : getData()) {
                this.a.add(giftMicModel.getMic());
            }
        }
        notifyDataSetChanged();
    }

    public void c() {
        this.a.clear();
        if (getData() != null && getData().size() > 0) {
            this.a.add(((GiftMicModel) getData().get(0)).getMic());
        }
        notifyDataSetChanged();
    }
}
