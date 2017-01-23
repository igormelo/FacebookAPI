package com.igormelo.myfbapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class MainActivity extends AppCompatActivity {
    private ShareDialog shareDialog;
    Bundle bundle;
    String name;
    String surname;
    String imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.content_main);
        shareDialog = new ShareDialog(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
 
        bundle = getIntent().getExtras();
        name = bundle.get("name").toString();
        surname = bundle.get("surname").toString();
        imageUrl = bundle.get("imageUrl").toString();
        TextView nameView = (TextView)findViewById(R.id.nameAndSurname);
        nameView.setText(""+name+""+surname);
        Button logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Intent login = new Intent(MainActivity.this, Login.class);
                startActivity(login);
                finish();
            }
        });
        new DownloadImage((ImageView)findViewById(R.id.profileImage)).execute(imageUrl);
    }
}
