package camera.canon;

import camera.FilmOperations;
import logger.Logger;

public class CanonFilm implements FilmOperations {
    public void engageFilmMechanism() {
        Logger.getInstance().log(getName() + " has engaged");
    }

    public void rollFilm() {
        Logger.getInstance().log(getName() + " has rolled");
    }

    public void releaseFilmMechanism() {
        Logger.getInstance().log(getName() + " has been released");
    }


    public String getName() {
        return "Canon Film";
    }
}
