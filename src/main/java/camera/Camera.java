package camera;

import logger.Logger;

public abstract class Camera {
    private final FilmOperations filmOps;
    private final ShutterOperations shutterOps;
    private final MirrorOperations mirrorOps;

    public Camera(FilmOperations filmOps, ShutterOperations shutterOps, MirrorOperations mirrorOps) {
        this.filmOps = filmOps;
        this.shutterOps = shutterOps;
        this.mirrorOps = mirrorOps;
    }

    public void takePhotograph(double shutterSpeed) {
        Logger.getInstance().log(getName() + " is taking a photograph");

        filmOps.engageFilmMechanism();
        filmOps.rollFilm();
        filmOps.releaseFilmMechanism();

        mirrorOps.openMirror();

        shutterOps.setShutterSpeedSetting(shutterSpeed);
        shutterOps.initializeShutter();
        shutterOps.activateShutter();
        shutterOps.releaseShutter();

        mirrorOps.closeMirror();

        Logger.getInstance().log(getName() + " is done taking this photograph");
    }

    public FilmOperations getFilmOps() {
        return filmOps;
    }

    public ShutterOperations getShutterOps() {
        return shutterOps;
    }

    public MirrorOperations getMirrorOps() {
        return mirrorOps;
    }

    public abstract String getName() ;
}