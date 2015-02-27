package dragutin.dare.chatapp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    // UI references.
    EditText mUsernameView;
    EditText mPasswordView;

    public static Context mContext;

    public static String sessionId = null;
    public static String id = "jH1FFdXlsxkwYSXYGGvXh8yEKRQ=";

   // public static String prosao = "ne";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;

        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);
    }

    public void signIn(View view){
//        if(!isConnected(this)) {
//            Toast.makeText(this, "NBema konekcije", Toast.LENGTH_LONG).show();
//        }
//        else {
//            Toast.makeText(this, "Ima konekcije", Toast.LENGTH_LONG).show();
//        }
        String user  = mUsernameView.getText().toString();
        String pass = mPasswordView.getText().toString();

        new LoginTask().execute(user,pass);

//        while(prosao.equals("ne")) Log.v("prosao: ", prosao);
//        if(prosao.equals("fail")) Login(false);
//        else Login(true);
    }






}



