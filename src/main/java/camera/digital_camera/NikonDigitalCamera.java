package camera.digital_camera;

import camera.Camera;
import logger.Logger;

public class NikonDigitalCamera implements DigitalCameraAdapter{
    private final Camera traditionalCamera;
    private final MemoryCard memoryCard;

    public NikonDigitalCamera(Camera traditionalCamera, MemoryCard memoryCard) {
        this.traditionalCamera = traditionalCamera;
        this.memoryCard = memoryCard;
    }

    @Override
    public void takePhotograph(double shutterSpeed) {
        Logger.getInstance().log(getName() + " is taking a photograph");

        memoryCard.accessMemory();

        traditionalCamera.getMirrorOps().openMirror();

        traditionalCamera.getShutterOps().setShutterSpeedSetting(shutterSpeed);
        traditionalCamera.getShutterOps().initializeShutter();
        traditionalCamera.getShutterOps().activateShutter();
        traditionalCamera.getShutterOps().releaseShutter();

        traditionalCamera.getMirrorOps().closeMirror();

        memoryCard.storeMemory();

        Logger.getInstance().log(getName() + " is done taking this photograph");
    }

    private String getName() {
        return "Nikon Digital Camera";
    }
}
