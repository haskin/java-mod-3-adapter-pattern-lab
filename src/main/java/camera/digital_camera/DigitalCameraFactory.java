package camera.digital_camera;

import camera.CameraFactory;
import camera.canon.CanonCamera;
import camera.canon.CanonFilm;
import camera.canon.CanonMirror;
import camera.canon.CanonShutter;
import camera.nikon.NikonCamera;
import camera.nikon.NikonFilm;
import camera.nikon.NikonMirror;
import camera.nikon.NikonShutter;

public class DigitalCameraFactory {

    public enum CameraManufacturer {
        NIKON_FILM("Nikon Film"),
        CANON_FILM("Canon Film");

        final String name;

        CameraManufacturer(String name) {
            this.name = name;
        }
    }

    public static DigitalCameraAdapter makeCamera(CameraFactory.CameraManufacturer manufacturer) {
        if (manufacturer == CameraFactory.CameraManufacturer.NIKON_FILM) {
            return new NikonDigitalCamera(new NikonCamera(new NikonFilm(), new NikonShutter(), new NikonMirror()), new SdCard());
        } else if (manufacturer == CameraFactory.CameraManufacturer.CANON_FILM) {
            return new CanonDigitalCamera(new CanonCamera(new CanonFilm(), new CanonShutter(), new CanonMirror()), new SdCard());

        }

        return null; // will never happen because we're using an enum but required to satisfy the compiler
    }
}
