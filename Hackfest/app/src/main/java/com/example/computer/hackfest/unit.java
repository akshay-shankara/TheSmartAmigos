package com.example.computer.hackfest;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import android.os.StrictMode;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class unit extends Fragment {
    View myView;
    Button button1;

    String myHTTPUrl = "http://sjbit.edu.in/app/course-material/CSE/I/ENGINEERING%20PHYSICS%20[15PHY12]/CSE-I-ENGINEERING%20PHYSICS%20[15PHY12]-NOTES.pdf";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.unit, container, false);

        button1 = (Button) myView.findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTask().execute();
            }
        });
        return myView;
    }

   public class MyTask extends AsyncTask<Void,Void,Void>{
       @Override
       protected Void doInBackground(Void...params){
           try {
               URL myurl = new URL(myHTTPUrl);

               HttpURLConnection connection = (HttpURLConnection)myurl.openConnection();
               connection.setDoOutput(true);
               connection.setRequestMethod("GET");
               connection.connect();

               File rootDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"sjbitnotes");
               if(!rootDirectory.exists()){
                   rootDirectory.mkdirs();
               }

               String nameOfFile = URLUtil.guessFileName(myHTTPUrl,null, MimeTypeMap.getFileExtensionFromUrl(myHTTPUrl));
               File file = new File(rootDirectory,nameOfFile);
               file.createNewFile();

               InputStream inputStream = connection.getInputStream();
               FileOutputStream outputStream = new FileOutputStream(file);

               byte[] buffer = new byte[50000000];
               int byteCount =0;

               while (((byteCount=inputStream.read(buffer))>0)){
                   outputStream.write(buffer,0,byteCount);
               }

               outputStream.close();
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(myHTTPUrl));
               getActivity().sendBroadcast(intent);

           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (ProtocolException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;
       }

       @Override
       protected void onPostExecute(Void result){
           super.onPostExecute(result);
           Toast.makeText(getActivity(),"Completed",Toast.LENGTH_SHORT).show();
       }
   }
}