package viewModel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModel;

import com.example.projet.Camera;
import com.example.projet.profile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraModel extends ViewModel {

    /*private static final int RETURN_PHOTO =1;
    private Camera camera;
    private String photoPath;
    private Bitmap image;
    private String photoToken;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String linkOfImage = null;
    private static String EXTRA_CAMERA_IMAGE = "EXTRA_CAMERA_IMAGE";


    public void init(){
        sharedPreferences = camera.getSharedPreferences("myapp",camera.MODE_PRIVATE);
        photoToken = sharedPreferences.getString("photoToken",null);

        image = BitmapFactory.decodeFile(photoToken);
        camera.getImgPhoto().setImageBitmap(image);
    }

    public void save(){
        MediaStore.Images.Media.insertImage(camera.getContentResolver(),image,"FitnessBattle","Profile photo");
        photoToken = photoPath;
        editor = sharedPreferences.edit();
        editor.putString("photoToken",photoToken);
        editor.apply();
        Intent intent = new Intent(camera, profile.class);
        intent.putExtra("EXTRA_CAMERA_IMAGE",photoToken);
        camera.startActivity(intent);
    }


    public void takePhoto(){
        //creee un intent pour ouvrir une fenetre pour prendre la photo
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //test pour controle que l'intent peut etre gere si pas d'appareil photo
        if(intent.resolveActivity(camera.getPackageManager()) != null){
            //creer un nom de fichier unique grace a la date
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File photoDir = camera.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            try {
                File photoFile = File.createTempFile("photo"+time,".jpg",photoDir);
                //enregistrer le chemin complet
                photoPath = photoFile.getAbsolutePath();
                //creer l'uri
                Uri photoUri = FileProvider.getUriForFile(camera,
                        camera.getApplicationContext().getPackageName()+".provider",photoFile);
                //transfert uri vers l'intent pour enregistrer photo dans fichier temporaire

                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                //ouvrir l'activity par rapport à l'intent
                camera.startActivityForResult(intent,RETURN_PHOTO);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPhotoPath() {
        return photoPath;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }*/
}
