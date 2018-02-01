package com.adamnain.scoringbola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.LinkedList;

public class ListPertandingan extends AppCompatActivity {

	private final LinkedList<String> mWordList = new LinkedList<>();
	private int mCount = 0;
	String timkita[] = {"Persib", "Persib", "Persib"};
	String timlawan[] = {"PSM", "Persija", "Persipura"};

	private RecyclerView mRecyclerView;
	private WordListAdapter mAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_pertandingan);

		for (int i = 0; i < 3; i++) {
			mWordList.addLast(timkita[i]+" VS " +timlawan[i]);
			Log.d("WordList", mWordList.getLast());
		}

		//	Get	a	handle	to	the	RecyclerView.
		mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

		//	Create	an	adapter	and	supply	the	data	to	be	displayed.
		mAdapter = new WordListAdapter(this, mWordList);

		//	Connect	the	adapter	with	the	RecyclerView.
		mRecyclerView.setAdapter(mAdapter);

		//	Give	the	RecyclerView	a	default	layout	manager.
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

	}
}
