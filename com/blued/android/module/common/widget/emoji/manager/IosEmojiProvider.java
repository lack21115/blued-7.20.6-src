package com.blued.android.module.common.widget.emoji.manager;

import com.blued.android.module.common.widget.emoji.category.ActivityCategory;
import com.blued.android.module.common.widget.emoji.category.FlagsCategory;
import com.blued.android.module.common.widget.emoji.category.FoodsCategory;
import com.blued.android.module.common.widget.emoji.category.NatureCategory;
import com.blued.android.module.common.widget.emoji.category.ObjectsCategory;
import com.blued.android.module.common.widget.emoji.category.PeopleCategory;
import com.blued.android.module.common.widget.emoji.category.PlacesCategory;
import com.blued.android.module.common.widget.emoji.category.SymbolsCategory;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/IosEmojiProvider.class */
public final class IosEmojiProvider implements EmojiProvider {
    @Override // com.blued.android.module.common.widget.emoji.manager.EmojiProvider
    public EmojiCategory[] a() {
        return new EmojiCategory[]{new PeopleCategory(), new NatureCategory(), new FoodsCategory(), new ActivityCategory(), new PlacesCategory(), new ObjectsCategory(), new SymbolsCategory(), new FlagsCategory()};
    }
}
