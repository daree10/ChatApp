package dragutin.dare.chatapp;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dare on 2/26/2015.
 */
public class SendMessageTask extends AsyncTask<String, Void, String> {

protected String doInBackground(String... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://arka.foi.hr/~ddumic/Darijan/sendMessage.php");
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
        nameValuePair.add(new BasicNameValuePair("message", params[0]));
        nameValuePair.add(new BasicNameValuePair("session",params[1]));
        nameValuePair.add(new BasicNameValuePair("id",params[2]));

        try {
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

        } catch (UnsupportedEncodingException e)
        {
        }
        try {
        HttpResponse response = httpClient.execute(httpPost);

        if(response != null) {

            /**
             * response mora nesto vracati!!!
             */

        } else {

            /**
             * response mora nesto vracati!!!
             */

        }
        } catch (ClientProtocolException e) {
        // Toast.makeText(this, "Caught ClientProtocolException", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
        // Toast.makeText(this, "Caught Exception", Toast.LENGTH_SHORT).show();
        //  e.printStackTrace();
        }
        return null;
        }

//@Override
//protected void onPostExecute(HttpResponse httpResponse) {
//
//        }
}
