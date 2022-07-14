package camera.digital_camera;

import camera.Camera;
import logger.Logger;

public class CanonDigitalCamera implements DigitalCameraAdapter {

//    x You will need access to the mirrorOps and shutterOps. Create accessor methods in the Camera class, so you can get those private members
//    Our digital camera still has a mirror and a shutter so all those operations should apply
//    Our photographer will now have a traditional camera as well as a digital camera

    private final Camera traditionalCamera;
    private final MemoryCard memoryCard;

    public CanonDigitalCamera(Camera camera, MemoryCard memoryCard) {
        this.traditionalCamera = camera;
        this.memoryCard = memoryCard;
    }

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
        return "Canon Digital Camera";
    }
}
