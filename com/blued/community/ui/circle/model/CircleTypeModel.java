package com.blued.community.ui.circle.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleTypeModel.class */
public class CircleTypeModel implements Serializable {
    public int code;
    public List<DataBean> data;
    public String msg;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/model/CircleTypeModel$DataBean.class */
    public static class DataBean {
        public int id;
        public String name;
        public int weight;
    }
}
