package com.example.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;
    String wordClicked = "";
    boolean DBSblack = true;
    boolean OCBCblack = true;
    boolean UOBblack = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);

        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);

        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, "Website");
        menu.add(0,1,0, "Contact");
        menu.add(0,2,0, "Toggle Favourite");

        if(v == tvDBS) {
            wordClicked = "DBS";
        }
        else if (v == tvOCBC) {
            wordClicked = "OCBC";
        }
        else if (v == tvUOB) {
            wordClicked = "UOB";
        }
    }
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.DBS)));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.DBSnum)));
                startActivity(intentContact);
                return true;
            }
            else if (item.getItemId() == 2 && DBSblack) {
                tvDBS.setTextColor(Color.parseColor("#FF0000"));
                DBSblack = false;
            }
            else if (item.getItemId() == 2 && !DBSblack) {
                tvDBS.setTextColor(Color.parseColor("#000000"));
            }
        }
        if(wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.OCBC)));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.OCBCnum)));
                startActivity(intentContact);
                return true;
            }
            else if (item.getItemId() == 2 && OCBCblack) {
                tvDBS.setTextColor(Color.parseColor("#FF0000"));
                OCBCblack = false;
            }
            else if (item.getItemId() == 2 && !OCBCblack) {
                tvDBS.setTextColor(Color.parseColor("#000000"));
            }
        }
        if(wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.UOB)));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.UOBnum)));
                startActivity(intentContact);
                return true;
            }
            else if (item.getItemId() == 2 && UOBblack) {
                tvDBS.setTextColor(Color.parseColor("#FF0000"));
                UOBblack = false;
            }
            else if (item.getItemId() == 2 && !UOBblack) {
                tvDBS.setTextColor(Color.parseColor("#000000"));
            }
        }
            return super.onContextItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(R.string.DBSName);
            tvOCBC.setText(R.string.OCBCName);
            tvUOB.setText(R.string.UOBName);
        }
        else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        }

        return super.onOptionsItemSelected(item);
    }
}