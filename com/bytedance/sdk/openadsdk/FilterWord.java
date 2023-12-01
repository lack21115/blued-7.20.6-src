package com.bytedance.sdk.openadsdk;

import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/FilterWord.class */
public interface FilterWord {
    void addOption(FilterWord filterWord);

    String getId();

    boolean getIsSelected();

    String getName();

    List<FilterWord> getOptions();

    boolean hasSecondOptions();

    boolean isValid();

    void setIsSelected(boolean z);
}
