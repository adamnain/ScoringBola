package com.adamnain.scoringbola;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersibActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persib);

		Button btnSumberPersib = findViewById(R.id.btn_sumberPersib);
		Button btnLokasiPersib = findViewById(R.id.btn_lokPersib);

		btnSumberPersib.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Persib_Bandung"));
				Intent browserChooserIntent = Intent.createChooser(browserIntent , "Choose browser of your choice");
				startActivity(browserChooserIntent );
			}
		});

		btnLokasiPersib.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Uri gmmIntentUri = Uri.parse("geo:-6.957467, 107.712491");
				Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
				mapIntent.setPackage("com.google.android.apps.maps");
				if (mapIntent.resolveActivity(getPackageManager()) != null) {
					startActivity(mapIntent);
				}
			}
		});
	}
}
