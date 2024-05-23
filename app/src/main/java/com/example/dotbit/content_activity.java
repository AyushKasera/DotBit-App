package com.example.dotbit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class content_activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView basicAlgo;
    CardView array;
    CardView linkedlist;
    CardView doublyLL;
    CardView circularLL;
    CardView stack;
    CardView queue;
    CardView tree;
    CardView graph;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_content);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        basicAlgo=findViewById(R.id.basciAlgo);
        array=findViewById(R.id.array);
        linkedlist=findViewById(R.id.linkedList);
        doublyLL=findViewById(R.id.doublyLL);
        circularLL=findViewById(R.id.circulatLL);
        stack=findViewById(R.id.stack);
        queue=findViewById(R.id.queue);
        tree=findViewById(R.id.tree);
        graph=findViewById(R.id.graph);

        basicAlgo.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/algorithmbasics.html");
            }
        });
        array.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/arrays.html");
            }
        });
        linkedlist.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/linkedlist.html");
            }
        });
        doublyLL.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/doublylinkedlist.html");
            }
        });
        circularLL.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/circularlinkedlist.html");
            }
        });
        stack.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/stack.html");
            }
        });
        queue.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/queue.html");
            }
        });
        tree.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/trees.html");
            }
        });
        graph.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                openURL("file:///android_asset/content/graphdatastructure.html");
            }
        });




        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.content);
        bottomNavigationView.setOnItemSelectedListener( menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.main) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            } else if (itemId == R.id.content) {
               return true;

            } else if (itemId == R.id.note) {
                startActivity(new Intent(getApplicationContext(), notes_activity.class));
                finish();
            } else if (itemId == R.id.chatbot) {
                startActivity(new Intent(getApplicationContext(), chat_acitivity.class));
                finish();
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(getApplicationContext(), profile_activity.class));
                finish();
            }
            else {
                // Handle other menu items if needed
                return false;
            }
            return true;

        });
    }

    //Web View Activity intent
    private void openURL(String input)
    {

        Intent i = new Intent(getApplicationContext(), Web_view_Activity.class);
        i.putExtra("url",input);
        startActivity(i);
    }

}