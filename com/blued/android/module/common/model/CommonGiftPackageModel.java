package com.blued.android.module.common.model;

import com.blued.android.module.common.model.BaseGiftModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/model/CommonGiftPackageModel.class */
public class CommonGiftPackageModel<T extends BaseGiftModel> implements Serializable {
    public boolean hasNew;
    public int horizontalSpacing;
    public String index;
    public boolean isBag;
    public String name;
    public int packageType;
    public int red_point_cancel;
    public String red_point_word;
    public int tabIndex;
    public int verticalSpacing;
    public boolean deleteItemIfZeroCount = false;
    public boolean deletePackageIfEmpty = false;
    private int line = 2;
    private int column = 4;
    public final List<T> goods = new ArrayList();

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public void setColumn(int i) {
        if (i > 0) {
            this.column = i;
        }
    }

    public void setLine(int i) {
        if (i > 0) {
            this.line = i;
        }
    }
}
