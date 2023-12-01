package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.CommandFunctionModelClass;
import com.tencent.map.lib.models.CommonParamsModelClass;
import com.tencent.map.lib.models.ReturnInfoModelClass;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;
import com.tencent.mapsdk.internal.uc;
import com.tencent.tencentmap.mapsdk.maps.model.GeneralTranslateAnimator;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fd.class */
public class fd extends tc<ed> implements GLModelOverlay {
    private GeneralTranslateAnimator k;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fd$a.class */
    public class a implements Runnable {
        public final /* synthetic */ uc.a b;

        public a(uc.a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((ed) fd.this.j).getOutterVectorOverlayClickListener() != null) {
                ((ed) fd.this.j).getOutterVectorOverlayClickListener().onClicked(this.b.getPosition(), this.b.getIdentifier(), this.b.getName());
            }
        }
    }

    public fd(dd ddVar, ed edVar) {
        super(ddVar, edVar);
    }

    @Override // com.tencent.mapsdk.internal.tc
    public void a(long j) {
        this.h = j;
    }

    public void a(uc.a aVar) {
        ca.b(new a(aVar));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void enableClick(boolean z) {
        if (((ed) this.j).a() != null) {
            ((ed) this.j).a().enableClick(z);
        }
        ((ed) this.j).enableClick(z);
        a((fd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public ReturnInfoModelClass.ReturnStatus executeCommandFunction(CommandFunctionModelClass.BaseCommandFunction baseCommandFunction) {
        List<LatLng> list;
        if (baseCommandFunction == null) {
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
        }
        String name = baseCommandFunction.getClass().getName();
        if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetZoomLevelRangeCommand")) {
            CommonParamsModelClass.ZoomLevelRangeParams zoomLevelRangeParams = ((CommandFunctionModelClass.SetZoomLevelRangeCommand) baseCommandFunction).params;
            if (zoomLevelRangeParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            ((ed) this.j).setZoomLevelRange(zoomLevelRangeParams.minLevel, zoomLevelRangeParams.maxLevel);
            a((fd) this.j);
            return new ReturnInfoModelClass.ReturnStatus();
        } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$StartTranslateAnimationCommand")) {
            CommandFunctionModelClass.StartTranslateAnimationCommand startTranslateAnimationCommand = (CommandFunctionModelClass.StartTranslateAnimationCommand) baseCommandFunction;
            CommonParamsModelClass.StartTranslateAnimationParams startTranslateAnimationParams = startTranslateAnimationCommand.params;
            if (startTranslateAnimationParams != null && (list = startTranslateAnimationParams.positions) != null) {
                this.k = new GeneralTranslateAnimator.Builder(this, startTranslateAnimationParams.duration * 1000.0f, (LatLng[]) list.toArray(new LatLng[0])).rotateEnabled(startTranslateAnimationCommand.params.needRotate).modelType(GeneralTranslateAnimator.ModelType.MODEL_OVERLAY).initRotate(startTranslateAnimationCommand.params.initRotation).build();
                if (((ed) this.j).a().getTransAnimatorEndListener() != null) {
                    this.k.addAnimatorEndListener(((ed) this.j).a().getTransAnimatorEndListener());
                }
                this.k.startAnimation();
                return new ReturnInfoModelClass.ReturnStatus();
            }
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
        } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetRotationCommand")) {
            CommonParamsModelClass.RotationParams rotationParams = ((CommandFunctionModelClass.SetRotationCommand) baseCommandFunction).params;
            if (rotationParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            float f = rotationParams.rotationX;
            float f2 = rotationParams.rotationY;
            float f3 = rotationParams.rotationZ;
            if (((ed) this.j).a() != null) {
                ((ed) this.j).a().rotationX(f).rotationY(f2).rotationZ(f3);
            }
            ((ed) this.j).setRotationX(f);
            ((ed) this.j).setRotationY(f2);
            ((ed) this.j).setRotationZ(f3);
            a((fd) this.j);
            return new ReturnInfoModelClass.ReturnStatus();
        } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetExposureCommand")) {
            CommandFunctionModelClass.SetExposureCommand setExposureCommand = (CommandFunctionModelClass.SetExposureCommand) baseCommandFunction;
            if (setExposureCommand.params == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            if (((ed) this.j).a() != null) {
                ((ed) this.j).a().setExposure(setExposureCommand.params.exposure);
            }
            ((ed) this.j).setExposure(setExposureCommand.params.exposure);
            a((fd) this.j);
            return new ReturnInfoModelClass.ReturnStatus();
        } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetVisibleCommand")) {
            CommonParamsModelClass.VisibleParams visibleParams = ((CommandFunctionModelClass.SetVisibleCommand) baseCommandFunction).params;
            if (visibleParams == null) {
                return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
            }
            setVisibility(visibleParams.isVisible);
            return new ReturnInfoModelClass.ReturnStatus();
        } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$ErrorCommandFunction")) {
            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported);
        } else {
            if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetVisibleCommand")) {
                return new ReturnInfoModelClass.BaseBooleanReturnInfo(((ed) this.j).isVisible());
            }
            if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetPixelBoundCommand")) {
                CommandFunctionModelClass.SetPixelBoundCommand setPixelBoundCommand = (CommandFunctionModelClass.SetPixelBoundCommand) baseCommandFunction;
                if (setPixelBoundCommand.params == null) {
                    return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
                }
                if (((ed) this.j).a() != null) {
                    ((ed) this.j).a().coordType(GLModelOverlayProvider.CoordType.PixelType);
                    GLModelOverlayProvider a2 = ((ed) this.j).a();
                    CommonParamsModelClass.PixelBoundParams pixelBoundParams = setPixelBoundCommand.params;
                    a2.pixelBounds(pixelBoundParams.width, pixelBoundParams.height);
                }
                ed edVar = (ed) this.j;
                GLModelOverlayProvider.CoordType coordType = GLModelOverlayProvider.CoordType.PixelType;
                edVar.setCoordType(0);
                ed edVar2 = (ed) this.j;
                CommonParamsModelClass.PixelBoundParams pixelBoundParams2 = setPixelBoundCommand.params;
                edVar2.setPixelBound(pixelBoundParams2.width, pixelBoundParams2.height);
                a((fd) this.j);
                return new ReturnInfoModelClass.ReturnStatus();
            } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetPositionCommand")) {
                return new ReturnInfoModelClass.PositionReturnInfo(((ed) this.j).getPosition());
            } else {
                if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetClickEnabledCommand")) {
                    return new ReturnInfoModelClass.BaseBooleanReturnInfo(isClickEnabled());
                }
                if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetScaleCommand")) {
                    return new ReturnInfoModelClass.BaseFloatReturnInfo((float) ((ed) this.j).getScale());
                }
                if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetSkeletonAnimationInfoCommand")) {
                    return new ReturnInfoModelClass.SkeletonAnimationReturnInfo(getSkeletonAnimationProperties());
                }
                if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetPositionCommand")) {
                    CommandFunctionModelClass.SetPositionCommand setPositionCommand = (CommandFunctionModelClass.SetPositionCommand) baseCommandFunction;
                    if (setPositionCommand.params == null) {
                        return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
                    }
                    CommonParamsModelClass.PositionParams positionParams = setPositionCommand.params;
                    LatLng latLng = new LatLng(positionParams.lat, positionParams.lng, positionParams.altitude);
                    if (((ed) this.j).a() != null) {
                        ((ed) this.j).a().position(latLng);
                    }
                    ((ed) this.j).setModelPosition(latLng);
                    a((fd) this.j);
                    return new ReturnInfoModelClass.ReturnStatus();
                } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$EnableClickCommand")) {
                    CommonParamsModelClass.EnableClickParams enableClickParams = ((CommandFunctionModelClass.EnableClickCommand) baseCommandFunction).params;
                    if (enableClickParams == null) {
                        return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
                    }
                    enableClick(enableClickParams.enabled);
                    return new ReturnInfoModelClass.ReturnStatus();
                } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$SetScaleCommand")) {
                    CommonParamsModelClass.ScaleParams scaleParams = ((CommandFunctionModelClass.SetScaleCommand) baseCommandFunction).params;
                    if (scaleParams == null) {
                        return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
                    }
                    float f4 = scaleParams.scale;
                    if (((ed) this.j).a() != null) {
                        ((ed) this.j).a().coordType(GLModelOverlayProvider.CoordType.GeoGraphicType);
                        ((ed) this.j).a().scale(f4);
                    }
                    ed edVar3 = (ed) this.j;
                    GLModelOverlayProvider.CoordType coordType2 = GLModelOverlayProvider.CoordType.GeoGraphicType;
                    edVar3.setCoordType(1);
                    ((ed) this.j).setScale(f4);
                    a((fd) this.j);
                    return new ReturnInfoModelClass.ReturnStatus();
                } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetTypeCommand")) {
                    return new ReturnInfoModelClass.BaseStringReturnInfo(getType());
                } else {
                    if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$PlaySkeletonAnimationCommand")) {
                        CommonParamsModelClass.PlaySkeletonAnimationParams playSkeletonAnimationParams = ((CommandFunctionModelClass.PlaySkeletonAnimationCommand) baseCommandFunction).params;
                        if (playSkeletonAnimationParams == null) {
                            return new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.jsonparse);
                        }
                        playSkeletonAnimation(playSkeletonAnimationParams.index, playSkeletonAnimationParams.speed, playSkeletonAnimationParams.repeat);
                        return new ReturnInfoModelClass.ReturnStatus();
                    } else if (name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetRotationCommand")) {
                        return new ReturnInfoModelClass.RotationReturnInfo(((ed) this.j).getRotationX(), ((ed) this.j).getRotationY(), ((ed) this.j).getRotationZ());
                    } else {
                        if (!name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$StopSkeletonAnimationCommand")) {
                            return !name.equals("com.tencent.map.lib.models.CommandFunctionModelClass$GetExposureCommand") ? new ReturnInfoModelClass.ErrorReturnInfo(ReturnInfoModelClass.ErrorReturnInfo.ErrorMsg.unsupported) : new ReturnInfoModelClass.BaseFloatReturnInfo(((ed) this.j).getExposure());
                        }
                        stopSkeletonAnimation();
                        return new ReturnInfoModelClass.ReturnStatus();
                    }
                }
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel
    public float getRotation() {
        return ((ed) this.j).getRotationY();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public List<CommonParamsModelClass.AnimationInfo> getSkeletonAnimationProperties() {
        Object obj = this.i;
        if (obj instanceof dd) {
            return ((dd) obj).a(this.h);
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public String getType() {
        return a4.GLModel.a();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public boolean isClickEnabled() {
        return ((ed) this.j).isClickEnabled();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public void playSkeletonAnimation(int i, float f, boolean z) {
        ((dd) this.i).a(this.h, i, f, z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setLevel(int i) {
        if (((ed) this.j).a() != null) {
            ((ed) this.j).a().displayLevel(i);
        }
        ((ed) this.j).setLevel(i);
        a((fd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setOpacity(float f) {
        if (((ed) this.j).a() != null) {
            ((ed) this.j).a().opacity(f);
        }
        ((ed) this.j).setOpacity(f);
        a((fd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel
    public void setPosition(LatLng latLng) {
        if (((ed) this.j).a() != null) {
            ((ed) this.j).a().position(latLng);
        }
        ((ed) this.j).setModelPosition(latLng);
        a((fd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IAnimatorModel
    public void setRotation(float f) {
        if (((ed) this.j).a() != null) {
            ((ed) this.j).a().rotationY(f);
        }
        ((ed) this.j).setRotationY(f);
        a((fd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setVisibility(boolean z) {
        if (((ed) this.j).a() != null) {
            ((ed) this.j).a().visibility(z);
        }
        ((ed) this.j).setVisible(z);
        a((fd) this.j);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay
    public void setZIndex(int i) {
        if (((ed) this.j).a() != null) {
            ((ed) this.j).a().zIndex(i);
        }
        ((ed) this.j).setzIndex(i);
        a((fd) this.j);
    }

    @Override // com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlay
    public void stopSkeletonAnimation() {
        ((dd) this.i).b(this.h);
    }

    public void y() {
        GeneralTranslateAnimator generalTranslateAnimator = this.k;
        if (generalTranslateAnimator != null) {
            generalTranslateAnimator.cancelAnimation();
            this.k.removeAnimatorEndListener(((ed) this.j).a().getTransAnimatorEndListener());
        }
    }
}
