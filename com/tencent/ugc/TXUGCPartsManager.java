package com.tencent.ugc;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/TXUGCPartsManager.class */
public interface TXUGCPartsManager {
    void addClipInfo(PartInfo partInfo);

    void deleteAllParts();

    void deleteLastPart();

    void deletePart(int i);

    int getDuration();

    List<String> getPartsPathList();

    void insertPart(String str, int i);
}
