package learningandroid.com.cameraapi;

import android.hardware.Camera;
import android.media.audiofx.EnvironmentalReverb;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Camera camera;
    FrameLayout framelayout;
    ShowCamera showcamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        framelayout = (FrameLayout) findViewById(R.id.framelayout);

        //open the camera
        camera = Camera.open();

        showcamera = new ShowCamera(this, camera);
        framelayout.addView( showcamera );
    }

    Camera.PictureCallback mPictureCallback = new Camera.PictureCallback(){
        @Override
        public void onPictureTaken(byte[] data, Camera camera){
            File picture_file = getOutputMediaFile();

            if( picture_file == null) {
                return;
            }else{
                try {
                    FileOutputStream fos = new FileOutputStream(picture_file);
                    fos.write( data );
                    fos.close();

                    camera.startPreview();

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    };

    private File getOutputMediaFile() {
        String state  = Environment.getExternalStorageState();
        if(!state.equals(Environment.MEDIA_MOUNTED)) {
            return null;
        }else{
            File folder_gui = new File(Environment.getExternalStorageDirectory() + File.separator + "GUI");

            if(!folder_gui.exists()){
                folder_gui.mkdir();
            }

            File outputFile = new File( folder_gui, "temp.jpg");
            return outputFile;
        }
    }

    public void captureImage(View v){
        if(camera != null) {
            camera.takePicture(null,null, mPictureCallback);
        }
    }
}
