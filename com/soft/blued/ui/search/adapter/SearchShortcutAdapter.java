package com.soft.blued.ui.search.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.search.model.SearchGlobalInfo;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/adapter/SearchShortcutAdapter.class */
public final class SearchShortcutAdapter extends BaseQuickAdapter<SearchGlobalInfo.SearchShortcutModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f19467a;

    public SearchShortcutAdapter(IRequestHost iRequestHost) {
        super((int) R.layout.item_search_global_shortcut);
        this.f19467a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, SearchGlobalInfo.SearchShortcutModel searchShortcutModel) {
        if (baseViewHolder == null || searchShortcutModel == null) {
            return;
        }
        ImageLoader.a(this.f19467a, searchShortcutModel.getIcon_url()).b(BluedSkinUtils.c() ? 2131233787 : 2131233788).a((ImageView) baseViewHolder.getView(R.id.iv_shortcut_icon));
        ((TextView) baseViewHolder.getView(R.id.tv_shortcut_name)).setText(searchShortcutModel.getName());
    }
}
