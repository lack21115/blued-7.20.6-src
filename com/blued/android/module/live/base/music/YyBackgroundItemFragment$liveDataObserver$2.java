package com.blued.android.module.live.base.music;

import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/YyBackgroundItemFragment$liveDataObserver$2.class */
final /* synthetic */ class YyBackgroundItemFragment$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<List<? extends YYKtvMusicModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YyBackgroundItemFragment$liveDataObserver$2(Object obj) {
        super(1, obj, YyBackgroundItemFragment.class, "showMusicSheetSongsAdd", "showMusicSheetSongsAdd(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends YYKtvMusicModel> list) {
        ((YyBackgroundItemFragment) this.receiver).a(list);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends YYKtvMusicModel> list) {
        a(list);
        return Unit.a;
    }
}
