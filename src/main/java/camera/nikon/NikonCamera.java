package camera.nikon;

import camera.Camera;
import camera.FilmOperations;
import camera.MirrorOperations;
import camera.ShutterOperations;

public class NikonCamera extends Camera {
    public NikonCamera(FilmOperations filmOps, ShutterOperations shutterOps, MirrorOperations mirrorOps) {
        super(filmOps, shutterOps, mirrorOps);
    }


    public String getName() {
        return "Nikon";
    }
}
