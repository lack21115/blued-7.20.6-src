package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STEffectRenderOutParam.class */
public class STEffectRenderOutParam {
    STHumanAction humanAction;
    STImage image;
    STEffectTexture texture;

    public STEffectRenderOutParam(STEffectTexture sTEffectTexture, STImage sTImage, STHumanAction sTHumanAction) {
        this.texture = sTEffectTexture;
        this.image = sTImage;
        this.humanAction = sTHumanAction;
    }

    public STHumanAction getHumanAction() {
        return this.humanAction;
    }

    public STImage getImage() {
        return this.image;
    }

    public STEffectTexture getTexture() {
        return this.texture;
    }

    public void setHumanAction(STHumanAction sTHumanAction) {
        this.humanAction = sTHumanAction;
    }

    public void setImage(STImage sTImage) {
        this.image = sTImage;
    }

    public void setTexture(STEffectTexture sTEffectTexture) {
        this.texture = sTEffectTexture;
    }
}
