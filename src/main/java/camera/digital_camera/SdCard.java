package camera.digital_camera;

import logger.Logger;

public class SdCard implements MemoryCard {
    private static final Logger logger = Logger.getInstance();
    @Override
    public void accessMemory() {
        logger.log("SD Card open for write access");
    }

    @Override
    public void storeMemory() {
        logger.log("SD Card has been written to");
    }
}
