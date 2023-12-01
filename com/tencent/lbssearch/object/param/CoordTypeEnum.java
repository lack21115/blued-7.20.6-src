package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.param.TranslateParam;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/CoordTypeEnum.class */
public enum CoordTypeEnum {
    NONE(TranslateParam.CoordType.NONE),
    GPS(TranslateParam.CoordType.GPS),
    SOGOU(TranslateParam.CoordType.SOGOU),
    BAIDU(TranslateParam.CoordType.BAIDU),
    MAPBAR(TranslateParam.CoordType.MAPBAR),
    DEFAULT(TranslateParam.CoordType.STANDARD),
    SOGOUMERCATOR(TranslateParam.CoordType.SOGOUMERCATOR);
    
    public TranslateParam.CoordType coordType;

    CoordTypeEnum(TranslateParam.CoordType coordType) {
        this.coordType = coordType;
    }
}
