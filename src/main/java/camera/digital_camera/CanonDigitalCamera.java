package camera.digital_camera;

import camera.Camera;
import logger.Logger;

public class CanonDigitalCamera implements DigitalCameraAdapter {

//    x You will need access to the mirrorOps and shutterOps. Create accessor methods in the Camera class, so you can get those private members
//    Our digital camera still has a mirror and a shutter so all those operations should apply
//    Our photographer will now have a traditional camera as well as a digital camera

    private final Camera traditionalCamera;

    public CanonDigitalCamera(Camera camera) {
        this.traditionalCamera = camera;
    }

    public void takePhotograph(double shutterSpeed) {
        Logger.getInstance().log(getName() + " is taking a photograph");

        this.traditionalCamera.getFilmOps().engageFilmMechanism();
        this.traditionalCamera.getFilmOps().rollFilm();
        this.traditionalCamera.getFilmOps().releaseFilmMechanism();

        this.traditionalCamera.getMirrorOps().openMirror();

        this.traditionalCamera.getShutterOps().setShutterSpeedSetting(shutterSpeed);
        this.traditionalCamera.getShutterOps().initializeShutter();
        this.traditionalCamera.getShutterOps().activateShutter();
        this.traditionalCamera.getShutterOps().releaseShutter();

        this.traditionalCamera.getMirrorOps().closeMirror();

        Logger.getInstance().log(getName() + " is done taking this photograph");
    }

    private String getName() {
        return "Canon Digital Camera";
    }
}
