package com.tencent.txcopyrightedmedia.impl.utils;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.net.URLEncoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/au.class */
public final class au extends bb {

    /* renamed from: a  reason: collision with root package name */
    public String f40073a;

    public au(ba baVar, String str) {
        super(baVar);
        this.f40073a = str;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.bb
    public final String b() {
        return this.f40073a;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.bb
    public final String c() {
        return "txcm://bgmSubtitles/" + URLEncoder.encode(i()) + BridgeUtil.SPLIT_MARK + URLEncoder.encode(j()) + "/default";
    }
}
