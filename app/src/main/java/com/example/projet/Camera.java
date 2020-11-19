package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera extends AppCompatActivity {

        private static final int RETURN_PHOTO =1;

        private Button btnPhoto;
        private Button btnSave;

        private ImageView imgPhoto;
        private String photoPath;
        private Bitmap image;
        private String photoToken;
        private SharedPreferences sharedPreferences;
        private SharedPreferences.Editor editor;
        private String linkOfImage = null;
        private static String EXTRA_CAMERA_IMAGE = "EXTRA_CAMERA_IMAGE";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_camera);
            initActivity();

        }


        private void initActivity() {
            btnPhoto = (Button)findViewById(R.id.btnPhoto);
            btnSave = (Button)findViewById(R.id.btnSave);
            imgPhoto = (ImageView)findViewById(R.id.imgPhoto);

            createOnClickBtnPhoto();
            createOnClickBtnSave();

            sharedPreferences = getSharedPreferences("myapp",MODE_PRIVATE);
            photoToken = sharedPreferences.getString("photoToken",null);

            image = BitmapFactory.decodeFile(photoToken);
            imgPhoto.setImageBitmap(image);
        }


        private void createOnClickBtnSave(){
            btnSave.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //save photo
                    MediaStore.Images.Media.insertImage(getContentResolver(),image,"FitnessBattle","Profile photo");
                    photoToken = photoPath;
                    editor = sharedPreferences.edit();
                    editor.putString("photoToken",photoToken);
                    editor.apply();
                }
            });
        }


        private void createOnClickBtnPhoto() {
            btnPhoto.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    takePhoto();
                }
            });
        }

        //acces a l'appareil + memorise dans un fichier
        private void takePhoto(){
            //creee un intent pour ouvrir une fenetre pour prendre la photo
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //test pour controle que l'intent peut etre gere si pas d'appareil photo
            if(intent.resolveActivity(getPackageManager()) != null){
                //creer un nom de fichier unique grace a la date
                String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File photoDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                try {
                    File photoFile = File.createTempFile("photo"+time,".jpg",photoDir);
                    //enregistrer le chemin complet
                    photoPath = photoFile.getAbsolutePath();
                    //creer l'uri
                    Uri photoUri = FileProvider.getUriForFile(Camera.this,
                            Camera.this.getApplicationContext().getPackageName()+".provider",photoFile);
                    //transfert uri vers l'intent pour enregistrer photo dans fichier temporaire

                    intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                    //ouvrir l'activity par rapport à l'intent
                    startActivityForResult(intent,RETURN_PHOTO);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            //verifie le bon code de retour et l'etat du retour
            if(requestCode==RETURN_PHOTO && resultCode ==RESULT_OK){
                //recup photo
                image = BitmapFactory.decodeFile(photoPath);
                imgPhoto.setImageBitmap(image);
            }
        }

    public void gotoMenu(View view) {
        Intent intent = new Intent(this,Menu.class);
        intent.putExtra("EXTRA_CAMERA_IMAGE",photoToken);
        startActivity(intent);
    }

    public String getPhotoToken(){
            return photoToken;
    }
}