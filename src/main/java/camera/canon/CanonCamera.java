package camera.canon;

import camera.Camera;
import camera.FilmOperations;
import camera.MirrorOperations;
import camera.ShutterOperations;

public class CanonCamera extends Camera {
    public CanonCamera(FilmOperations filmOps, ShutterOperations shutterOps, MirrorOperations mirrorOps) {
        super(filmOps, shutterOps, mirrorOps);
    }


    public String getName() {
        return "Canon";
    }

}