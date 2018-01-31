package com.adamnain.scoringbola;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersijaActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persija);

		Button btnSumberPersija = findViewById(R.id.btn_sumberPersija);
		Button btnLokasiPersija = findViewById(R.id.btn_lokPersija);

		btnSumberPersija.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Persija_Jakarta"));
				Intent browserChooserIntent = Intent.createChooser(browserIntent , "Choose browser of your choice");
				startActivity(browserChooserIntent );
			}
		});

		btnLokasiPersija.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Uri gmmIntentUri = Uri.parse("geo:-6.218753, 106.804542");
				Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
				mapIntent.setPackage("com.google.android.apps.maps");
				if (mapIntent.resolveActivity(getPackageManager()) != null) {
					startActivity(mapIntent);
				}
			}
		});
	}
}
