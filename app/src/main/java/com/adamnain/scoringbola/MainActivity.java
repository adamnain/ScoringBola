package com.adamnain.scoringbola;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	ImageButton btnPersib, btnPersija;
	Button btnScorePersija, btnScorePersib, btnScoreReset, btnScorePersijaDec, btnScorePersibDec, btnNews;
	TextView scorePersija, scorePersib, tvHome;
	int currentScorePersib = 0;
	int currentScorePersija = 0;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnPersib = findViewById(R.id.btn_persib);
		btnPersija = findViewById(R.id.btn_persija);
		btnScorePersib = findViewById(R.id.scorePersib);
		btnScorePersija = findViewById(R.id.scorePersija);
		btnScoreReset = findViewById(R.id.scoreReset);
		btnScorePersibDec = findViewById(R.id.scorePersibDec);
		btnScorePersijaDec = findViewById(R.id.scorePersijaDec);
		btnNews = findViewById(R.id.btn_news);

		tvHome = findViewById(R.id.tv_home);
		tvHome.setText(getIntent().getStringExtra("timHome"));

		btnPersib.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent iPersib = new Intent(getApplicationContext(), PersibActivity.class);
				startActivity(iPersib);
			}
		});

		btnPersija.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent iPersija = new Intent(getApplicationContext(), PersijaActivity.class);
				startActivity(iPersija);
			}
		});

		//score persib
		btnScorePersib.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				currentScorePersib = currentScorePersib + 1;
				setScorePersib(currentScorePersib);
			}
		});

		btnScorePersibDec.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (currentScorePersib == 0){
					Toast.makeText(getApplicationContext(), R.string.warning_negatif, Toast.LENGTH_SHORT).show();
				}
				else
					currentScorePersib = currentScorePersib - 1;
				setScorePersib(currentScorePersib);
			}
		});



		//score persija
		btnScorePersija.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				currentScorePersija = currentScorePersija + 1;
				setScorePersija(currentScorePersija);
			}
		});

		btnScorePersijaDec.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(currentScorePersija == 0){
					Toast.makeText(getApplicationContext(), R.string.warning_negatif, Toast.LENGTH_SHORT).show();
				}
				else
					currentScorePersija = currentScorePersija - 1;
				setScorePersija(currentScorePersija);
			}
		});

		//reset score
		btnScoreReset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				currentScorePersija = 0;
				currentScorePersib = 0;
				setScorePersija(currentScorePersija);
				setScorePersib(currentScorePersib);
			}
		});

		//intent news
		btnNews.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goal.com"));
				Intent browserChooserIntent = Intent.createChooser(browserIntent , "Choose browser of your choice");
				startActivity(browserChooserIntent );
			}
		});
	}

	//set text score persib
	private void setScorePersib(int score) {
		scorePersib = findViewById(R.id.tv_scorePersib);
		scorePersib.setText("" + score);
	}

	//set text score persija
	private void  setScorePersija(int score){
		scorePersija = findViewById(R.id.tv_scorePersija);
		scorePersija.setText(""+score);
	}
}
