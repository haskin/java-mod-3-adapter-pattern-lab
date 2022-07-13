import camera.CameraFactory;
import photographer.Photographer;

//  x PhotoStudio class to use the functionality we just created. We will create an instance of Photographer and call its takePhotograph() method.
public class PhotoStudio {

    public static void main(String[] args) {
//        new Photographer(CameraFactory.CameraManufacturer.CANON_FILM).takePhotograph(50.0);
        new Photographer(CameraFactory.CameraManufacturer.NIKON_FILM).takeDigitalPhotograph(100.0);
    }
}
