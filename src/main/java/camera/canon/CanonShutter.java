package camera.canon;

import camera.ShutterOperations;
import logger.Logger;

public class CanonShutter implements ShutterOperations {

    public void setShutterSpeedSetting(double shutterSpeed) {
        Logger.getInstance().log(getName() + " has set its speed to " + shutterSpeed + " seconds");
    }


    public void initializeShutter() {
        Logger.getInstance().log(getName() + " has been initialized");
    }


    public void activateShutter() {
        Logger.getInstance().log(getName() + " has been activated");
    }


    public void releaseShutter() {
        Logger.getInstance().log(getName() + " has been released");
    }


    public String getName() {
        return "Canon Shutter";
    }
}