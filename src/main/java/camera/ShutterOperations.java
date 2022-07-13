package camera;

public interface ShutterOperations {
    public void setShutterSpeedSetting(double shutterSpeed);
    public void initializeShutter();
    public void activateShutter();
    public void releaseShutter();
    public String getName();
}
