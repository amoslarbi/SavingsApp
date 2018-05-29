package morelifeinc.savingsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

/**
 * Created by kh$y on 11/5/2017.
 *
 * aroma.gameitx.com
 *
 */

public class Terms extends AppCompatActivity {

    private Button back;
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms);

//        back  = (Button) findViewById(R.id.back);
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent StartIntent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(StartIntent);
//
//            }
//        });

        pdfView = (PDFView)findViewById(R.id.pdfView);

        pdfView.fromAsset("powertxt.pdf").load();


    }

}