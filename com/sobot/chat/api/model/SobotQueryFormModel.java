package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotQueryFormModel.class */
public class SobotQueryFormModel implements Serializable {
    private ArrayList<SobotFieldModel> field;
    private String formDoc;
    private String formSafety;
    private String formTitle;
    private boolean openFlag;

    public ArrayList<SobotFieldModel> getField() {
        return this.field;
    }

    public String getFormDoc() {
        return this.formDoc;
    }

    public String getFormSafety() {
        return this.formSafety;
    }

    public String getFormTitle() {
        return this.formTitle;
    }

    public boolean isOpenFlag() {
        return this.openFlag;
    }

    public void setField(ArrayList<SobotFieldModel> arrayList) {
        this.field = arrayList;
    }

    public void setFormDoc(String str) {
        this.formDoc = str;
    }

    public void setFormSafety(String str) {
        this.formSafety = str;
    }

    public void setFormTitle(String str) {
        this.formTitle = str;
    }

    public void setOpenFlag(boolean z) {
        this.openFlag = z;
    }
}
