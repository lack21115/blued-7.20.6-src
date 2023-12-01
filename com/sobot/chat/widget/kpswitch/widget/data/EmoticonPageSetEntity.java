package com.sobot.chat.widget.kpswitch.widget.data;

import com.sobot.chat.widget.kpswitch.widget.data.EmoticonPageEntity;
import com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity;
import com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/EmoticonPageSetEntity.class */
public class EmoticonPageSetEntity<T> extends PageSetEntity<EmoticonPageEntity> {
    final EmoticonPageEntity.DelBtnStatus mDelBtnStatus;
    final ArrayList<T> mEmoticonList;
    final int mLine;
    final int mRow;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/EmoticonPageSetEntity$Builder.class */
    public static class Builder<T> extends PageSetEntity.Builder {
        protected EmoticonPageEntity.DelBtnStatus delBtnStatus = EmoticonPageEntity.DelBtnStatus.GONE;
        protected ArrayList<T> emoticonList;
        protected int line;
        protected PageViewInstantiateListener pageViewInstantiateListener;
        protected int row;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public EmoticonPageSetEntity<T> build() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public Builder setEmoticonList(ArrayList<T> arrayList) {
            this.emoticonList = arrayList;
            return this;
        }

        public Builder setIPageViewInstantiateItem(PageViewInstantiateListener pageViewInstantiateListener) {
            this.pageViewInstantiateListener = pageViewInstantiateListener;
            return this;
        }

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public Builder setIconUri(int i) {
            this.iconUri = "" + i;
            return this;
        }

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public Builder setIconUri(String str) {
            this.iconUri = str;
            return this;
        }

        public Builder setLine(int i) {
            this.line = i;
            return this;
        }

        public Builder setRow(int i) {
            this.row = i;
            return this;
        }

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public Builder setSetName(String str) {
            this.setName = str;
            return this;
        }

        public Builder setShowDelBtn(EmoticonPageEntity.DelBtnStatus delBtnStatus) {
            this.delBtnStatus = delBtnStatus;
            return this;
        }

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public Builder setShowIndicator(boolean z) {
            this.isShowIndicator = z;
            return this;
        }
    }

    public EmoticonPageSetEntity(Builder builder) {
        super(builder);
        this.mLine = builder.line;
        this.mRow = builder.row;
        this.mDelBtnStatus = builder.delBtnStatus;
        this.mEmoticonList = builder.emoticonList;
    }

    public EmoticonPageEntity.DelBtnStatus getDelBtnStatus() {
        return this.mDelBtnStatus;
    }

    public ArrayList<T> getEmoticonList() {
        return this.mEmoticonList;
    }

    public int getLine() {
        return this.mLine;
    }

    public int getRow() {
        return this.mRow;
    }
}
