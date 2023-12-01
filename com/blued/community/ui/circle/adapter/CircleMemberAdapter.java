package com.blued.community.ui.circle.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleBaseMember;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleMemberAdapter.class */
public class CircleMemberAdapter extends BaseMultiItemQuickAdapter<CircleBaseMember.Member, BaseViewHolder> implements StickyHeaderHandler {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f19119a;
    private int b;

    public CircleMemberAdapter(IRequestHost iRequestHost, int i) {
        super(null);
        this.f19119a = iRequestHost;
        this.b = i;
        addItemType(1, R.layout.item_circle_base_member_header);
        addItemType(2, R.layout.item_circle_base_member_header);
        addItemType(0, R.layout.item_circle_base_member);
    }

    private void b(BaseViewHolder baseViewHolder, CircleBaseMember.Member member) {
        baseViewHolder.setText(R.id.tv_header, member.name);
        baseViewHolder.setText(R.id.tv_number, String.valueOf(member.number));
        baseViewHolder.setTextColor(R.id.tv_number, BluedSkinUtils.a(this.mContext, R.color.syc_a));
    }

    private void c(BaseViewHolder baseViewHolder, CircleBaseMember.Member member) {
        baseViewHolder.setText(R.id.tv_header, member.name);
        baseViewHolder.setText(R.id.tv_number, String.valueOf(member.number));
        baseViewHolder.setTextColor(R.id.tv_number, BluedSkinUtils.a(this.mContext, R.color.syc_h));
    }

    private void d(BaseViewHolder baseViewHolder, CircleBaseMember.Member member) {
        CircleMethods.a((ImageView) baseViewHolder.getView(R.id.iv_level), member.admin_level);
        baseViewHolder.setGone(R.id.tv_mute, member.is_mute_tag == 1);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_mute);
        shapeTextView.getBackground().setAlpha(30);
        int i = member.mute_type;
        if (i == 1) {
            shapeTextView.setText("已禁1次");
        } else if (i == 2) {
            shapeTextView.setText("已禁2次");
        } else if (i == 1009) {
            shapeTextView.setText("本圈子永久");
        } else if (i == 1010) {
            shapeTextView.setText("全圈子永久");
        }
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_icon);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_name);
        if (member.is_locked == 1) {
            textView.setText(R.string.circle_member_list_removed_account);
            ImageLoader.a(this.f19119a, R.drawable.user_bg_round).c().a(imageView);
        } else {
            textView.setText(member.name);
            ImageLoader.a(this.f19119a, member.avatar).b(R.drawable.user_bg_round).c().a(imageView);
        }
        baseViewHolder.setGone(R.id.iv_anonymous, member.is_anonym == 1);
        baseViewHolder.addOnClickListener(R.id.cl_root);
        baseViewHolder.addOnClickListener(R.id.iv_more);
        View view = baseViewHolder.getView(R.id.iv_more);
        if (this.b == 1) {
            if (member.isOwner()) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
        if (this.b == 2) {
            if (member.isOwner()) {
                view.setVisibility(8);
            } else if (member.isManager()) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    @Override // com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler
    public List<?> a() {
        return getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, CircleBaseMember.Member member) {
        int i = member.adapterType;
        if (i == 0) {
            d(baseViewHolder, member);
        } else if (i == 1) {
            b(baseViewHolder, member);
        } else if (i != 2) {
        } else {
            c(baseViewHolder, member);
        }
    }

    public void a(boolean z) {
        for (CircleBaseMember.Member member : this.mData) {
            if (member.adapterType == 1) {
                if (z) {
                    member.number++;
                } else {
                    member.number--;
                }
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void b(boolean z) {
        for (CircleBaseMember.Member member : this.mData) {
            if (member.adapterType == 2) {
                if (z) {
                    member.number++;
                } else {
                    member.number--;
                }
                notifyDataSetChanged();
                return;
            }
        }
    }
}
