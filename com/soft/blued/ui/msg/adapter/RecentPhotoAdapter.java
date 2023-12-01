package com.soft.blued.ui.msg.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/RecentPhotoAdapter.class */
public class RecentPhotoAdapter extends BaseQuickAdapter<MsgRecentPhotoInfo, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private LoadOptions f32177a;
    private IRecentPhotoAdapterCallback b;

    /* renamed from: c  reason: collision with root package name */
    private double f32178c;
    private IRequestHost d;
    private int e;

    public RecentPhotoAdapter(IRequestHost iRequestHost, IRecentPhotoAdapterCallback iRecentPhotoAdapterCallback) {
        super((int) R.layout.view_msg_chatting_recent_photo_item);
        this.f32177a = null;
        this.e = 0;
        this.d = iRequestHost;
        this.b = iRecentPhotoAdapterCallback;
        if (iRecentPhotoAdapterCallback == null) {
            return;
        }
        this.f32178c = KeyboardUtils.a() - DisplayUtil.a(AppInfo.d().getApplicationContext(), 50.0f);
        this.b.a(new IRecentPhotoAdapterCallback.IGetPhotoListCallback() { // from class: com.soft.blued.ui.msg.adapter.RecentPhotoAdapter.1
            @Override // com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback.IGetPhotoListCallback
            public void a(List<MsgRecentPhotoInfo> list) {
                RecentPhotoAdapter.this.setNewData(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, MsgRecentPhotoInfo msgRecentPhotoInfo) {
        double d;
        double d2;
        if (msgRecentPhotoInfo == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = baseViewHolder.itemView.getLayoutParams();
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.msg_recent_photos_item_iv);
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        int i = msgRecentPhotoInfo.isNormalImg;
        double d3 = 1.7777777910232544d;
        if (i != 1) {
            if (i != 2) {
                d2 = this.f32178c;
                d3 = (msgRecentPhotoInfo.width * 1.0f) / msgRecentPhotoInfo.height;
            } else {
                d2 = this.f32178c;
            }
            d = d2 * d3;
        } else {
            d = this.f32178c / 1.7777777910232544d;
        }
        int i2 = (int) d;
        layoutParams2.width = i2;
        layoutParams2.height = (int) this.f32178c;
        layoutParams.width = i2;
        imageView.setLayoutParams(layoutParams2);
        baseViewHolder.itemView.setLayoutParams(layoutParams);
        ImageLoader.d(this.d, msgRecentPhotoInfo.imgPath).a(imageView);
        ((ImageView) baseViewHolder.getView(R.id.msg_recent_photos_select_iv)).setSelected(msgRecentPhotoInfo.isSelected);
        baseViewHolder.setVisible(R.id.msg_recent_photos_pin_iv, msgRecentPhotoInfo.isPin);
    }

    public void a(MsgRecentPhotoInfo msgRecentPhotoInfo) {
        msgRecentPhotoInfo.isSelected = !msgRecentPhotoInfo.isSelected;
        notifyDataSetChanged();
        IRecentPhotoAdapterCallback iRecentPhotoAdapterCallback = this.b;
        if (iRecentPhotoAdapterCallback != null) {
            iRecentPhotoAdapterCallback.B();
        }
    }

    public boolean a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getData().size()) {
                break;
            }
            if (getData().get(i2).isSelected) {
                this.e++;
            }
            i = i2 + 1;
        }
        if (this.e + 1 > FlashPhotoManager.a().b().flash_left_times) {
            this.e = 0;
            return false;
        }
        this.e = 0;
        return true;
    }

    public int b() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= getData().size()) {
                return i3;
            }
            int i4 = i3;
            if (getData().get(i).isSelected) {
                i4 = i3 + 1;
            }
            i++;
            i2 = i4;
        }
    }
}
