package dragutin.dare.chatapp;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DisplayMessageActivity extends ActionBarActivity {

 //   TextView poruke;

    public static LinearLayout layout;
    public static Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        layout = (LinearLayout) findViewById(R.id.lin_layout_display_message);
        mContext = this;

        //poruke = (TextView)findViewById(R.id.porukeContainer);
        new GetMessagesTask().execute("http://arka.foi.hr/~ddumic/Darijan/chat.txt");
        //poruke.setText(text);

    }

    public void sendMessage(View view){
        EditText editText = (EditText) findViewById(R.id.messageWritten);
        String message = editText.getText().toString();
        if(message.equals("")) Toast.makeText(this, "Blank message", Toast.LENGTH_LONG).show();
        else if(message.contains(":")) Toast.makeText(this, "Invalid message (contains ':')", Toast.LENGTH_LONG).show();
        else new SendMessageTask().execute(message, LoginActivity.sessionId, LoginActivity.id);
    }

}
