package camera.digital_camera;

import camera.Camera;
import logger.Logger;

public class NikonDigitalCamera implements DigitalCameraAdapter{
    private final Camera traditionalCamera;

    public NikonDigitalCamera(Camera traditionalCamera) {
        this.traditionalCamera = traditionalCamera;
    }

    @Override
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
        return "Nikon Digital Camera";
    }
}
