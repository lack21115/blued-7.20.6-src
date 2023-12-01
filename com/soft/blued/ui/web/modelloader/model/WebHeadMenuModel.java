package com.soft.blued.ui.web.modelloader.model;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/model/WebHeadMenuModel.class */
public class WebHeadMenuModel {
    public String background;
    public CenterOption centerOption;
    public List<LeftOption> leftOption;
    public List<LeftOption> rightOption;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/model/WebHeadMenuModel$CenterOption.class */
    public class CenterOption {
        public String fontSize;
        public String optionImg;
        public boolean showTitleCenter = true;
        public String title;
        public String titleColor;
        public TitleImage titleImg;

        public CenterOption() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/model/WebHeadMenuModel$LeftOption.class */
    public class LeftOption {
        public boolean hidden;
        public String optionColor;
        public int optionHidden;
        public String optionImg;
        public String optionText;
        public String optionType;

        public LeftOption() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/model/WebHeadMenuModel$TitleImage.class */
    public class TitleImage {
        public String height;
        public String img;
        public String width;

        public TitleImage() {
        }
    }
}
