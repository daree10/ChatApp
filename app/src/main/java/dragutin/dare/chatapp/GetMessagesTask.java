package dragutin.dare.chatapp;


import android.annotation.TargetApi;
import android.graphics.Color;

import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;

import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;


public class GetMessagesTask extends AsyncTask<String, Void, String> {


    protected String doInBackground(String... params) {
            StringBuilder content = new StringBuilder();

            try
            {
                // create a url object
                URL url = new URL(params[0]);

                // create a urlconnection object
                URLConnection urlConnection = url.openConnection();

                // wrap the urlconnection in a bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                String line;

                // read from the urlconnection via the bufferedreader
                while ((line = bufferedReader.readLine()) != null)
                {
                    content.append(line);
                }
                bufferedReader.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return content.toString();
        }

    @Override
    protected void onPostExecute(String string) {

        String[]messages = string.split(":");
        String txt_below = "textView_name";

        LinearLayout.LayoutParams paramsDarijan = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramsDarijan.gravity= Gravity.RIGHT;
        paramsDarijan.topMargin = 10;

        LinearLayout.LayoutParams paramsDragutin = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        paramsDragutin.gravity= Gravity.LEFT;
        paramsDragutin.topMargin = 10;

        boolean Darijan = false;

        for(int i = 0;i<messages.length;i++){

            TextView textViewDarijan = new TextView(DisplayMessageActivity.mContext);
            textViewDarijan.setTextColor(Color.BLACK);
            textViewDarijan.setTextSize(30);
            textViewDarijan.setBackground(new ColorDrawable(Color.WHITE));

            TextView textViewDragutin = new TextView(DisplayMessageActivity.mContext);
            textViewDragutin.setTextColor(Color.BLACK);
            textViewDragutin.setBackground(new ColorDrawable(Color.WHITE));
            textViewDragutin.setTextSize(30);

            if(messages[i].equals("jH1FFdXlsxkwYSXYBRvXh8yEKRQ=")){
            //    textView.setLayoutParams(paramsDradvertovn);
                Darijan = false;

            }

            else if(messages[i].equals("jH1FFdXlsxkwYSXYGGvXh8yEKRQ=")){
           //     textView.setLayoutParams(paramsDarijan);
                Darijan = true;

            }
            else{
             //   textView.setText(messages[i]);
                //if(textView.getParent() != null)
                  //  ((RelativeLayout)textView.getParent()).removeView(textView);
                if(Darijan){
                    textViewDarijan.setText(messages[i]);
                    DisplayMessageActivity.layout.addView(textViewDarijan, paramsDarijan);
              //      textViewDarijan.setGravity(Gravity.RIGHT);
                }
                else {
                    textViewDragutin.setText(messages[i]);
                    DisplayMessageActivity.layout.addView(textViewDragutin, paramsDragutin);
               //     textViewDarijan.setGravity(Gravity.TOP);
                }
          //      if(left)textView.setGravity(Gravity.LEFT);
             //   textView.setGravity(Gravity.TOP);
            }

            //textView.setBackground(new ColorDrawable(Color.WHITE));



        }

    }



}
