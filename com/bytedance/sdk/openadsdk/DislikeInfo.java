package com.bytedance.sdk.openadsdk;

import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/DislikeInfo.class */
public interface DislikeInfo {
    List<FilterWord> getFilterWords();

    @Deprecated
    PersonalizationPrompt getPersonalizationPrompt();
}
