package dragutin.dare.chatapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dare on 2/25/2015.
 */
public class LoginTask extends AsyncTask<String, Void, HttpResponse> {


    protected HttpResponse doInBackground(String... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://arka.foi.hr/~ddumic/Darijan/login.php");
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
        nameValuePair.add(new BasicNameValuePair("username", params[0]));
        nameValuePair.add(new BasicNameValuePair("password",params[1]));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

        } catch (UnsupportedEncodingException e)
        {
        }
        try {
            HttpResponse response = httpClient.execute(httpPost);
               if(response != null) {
                    return response;
            } else {
            }
        } catch (ClientProtocolException e) {
           // Toast.makeText(this, "Caught ClientProtocolException", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
           // Toast.makeText(this, "Caught Exception", Toast.LENGTH_SHORT).show();
          //  e.printStackTrace();
        }
    return null;
    }

    @Override
    protected void onPostExecute(HttpResponse httpResponse) {
        try {
            String line;
            InputStream inputstream = httpResponse.getEntity().getContent();
            line = convertStreamToString(inputstream);

            if(line.equals("00x000xx0")) {
                LoginActivity.sessionId = line;
                Login(true,LoginActivity.mContext);
            }
            else
               Login(false,LoginActivity.mContext);

        } catch (IOException e) {
            // Toast.makeText(this, "Caught IOException", Toast.LENGTH_SHORT).show();
        }
    }

    private String convertStreamToString(InputStream inputstream) {

        String line;
        StringBuilder total = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputstream));
        try {
            while ((line = rd.readLine()) != null) {
                total.append(line);
            }
        } catch (Exception e) {

        }
        return total.toString();
    }

    public void Login(boolean prosao, Context context){
        if(prosao){
            Toast.makeText(context, "Login successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(context, DisplayMessageActivity.class);
            context.startActivity(intent);
        }
        else  Toast.makeText(context, "Login failed", Toast.LENGTH_LONG).show();
    }

}
