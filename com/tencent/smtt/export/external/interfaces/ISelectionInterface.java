package com.tencent.smtt.export.external.interfaces;

import android.graphics.Rect;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/ISelectionInterface.class */
public interface ISelectionInterface {
    public static final int CARETSELECTION = 1;
    public static final int EDITABLESELECTION = 4;
    public static final short HELD_FIRST_WIDGET = 0;
    public static final short HELD_NOTHING = -1;
    public static final short HELD_SECOND_WIDGET = 1;
    public static final int INPUTSELECTION = 2;
    public static final int NONESELECTION = 0;
    public static final int NORMALSELECTION = 3;

    @Deprecated
    String getText();

    void hideSelectionView();

    void onRetrieveFingerSearchContextResponse(String str, String str2, int i);

    @Deprecated
    void onSelectCancel();

    @Deprecated
    void onSelectionBegin(Rect rect, Rect rect2, int i, int i2, short s);

    @Deprecated
    void onSelectionBeginFailed(int i, int i2);

    @Deprecated
    void onSelectionChange(Rect rect, Rect rect2, int i, int i2, short s);

    void onSelectionDone(Rect rect, boolean z);

    @Deprecated
    void setText(String str, boolean z);

    void updateHelperWidget(Rect rect, Rect rect2);
}
