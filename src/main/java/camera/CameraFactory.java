package camera;

import camera.canon.CanonCamera;
import camera.canon.CanonFilm;
import camera.canon.CanonMirror;
import camera.canon.CanonShutter;
import camera.nikon.NikonCamera;
import camera.nikon.NikonFilm;
import camera.nikon.NikonMirror;
import camera.nikon.NikonShutter;

public class CameraFactory {
    public enum CameraManufacturer {
        NIKON_FILM("Nikon Film"),
        CANON_FILM("Canon Film");

        final String name;

        CameraManufacturer(String name) {
            this.name = name;
        }
    }

    public static Camera makeCamera(CameraManufacturer manufacturer) {
        if (manufacturer == CameraManufacturer.NIKON_FILM) {
            return new NikonCamera(new NikonFilm(), new NikonShutter(), new NikonMirror());
        } else if (manufacturer == CameraManufacturer.CANON_FILM) {
            return new
                    CanonCamera(new CanonFilm(), new CanonShutter(), new CanonMirror());
        }

        return null; // will never happen because we're using an enum but required to satisfy the compiler
    }
}
