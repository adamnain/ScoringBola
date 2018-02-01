package com.adamnain.scoringbola;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by MUL24 on 2/1/2018.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
	private final LinkedList<String> mWordList1;
	private final LinkedList<String> mWordList2;
	private LayoutInflater mInflater;
	private Context context;

	public WordListAdapter(Context context, LinkedList<String> wordList1, LinkedList<String> wordList2) {
		mInflater = LayoutInflater.from(context);
		this.mWordList1 = wordList1;
		this.mWordList2 = wordList2;
	}

	@Override
	public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View mItemView = mInflater.inflate(R.layout.item_team, parent, false);
		return new WordViewHolder(mItemView, this);
	}

	@Override
	public void onBindViewHolder(WordViewHolder holder, int position) {
		String mCurrent1 = mWordList1.get(position);
		String mCurrent2 = mWordList2.get(position);
		holder.wordItemView1.setText(mCurrent1);
		holder.wordItemView2.setText(mCurrent2);
	}

	@Override
	public int getItemCount() {
		return mWordList1.size();
	}

	public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		public final TextView wordItemView1, wordItemView2;
		final WordListAdapter mAdapter;

		public WordViewHolder(View itemView, WordListAdapter adapter) {
			super(itemView);
			wordItemView1 = (TextView) itemView.findViewById(R.id.word1);
			wordItemView2 = (TextView) itemView.findViewById(R.id.word2);

			this.mAdapter = adapter;
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			//	Get	the	position	of	the	item	that	was	clicked.
			int mPosition = getLayoutPosition();

			//	Use	that	to	access	the	affected	item	in	mWordList.
			String element = mWordList1.get(mPosition);

			//	Change	the	word	in	the	mWordList.
			//mWordList1.set(mPosition, "Clicked!	" + element);

			//put extra
			//Intent i = new Intent(context, MainActivity.class);
			//i.putExtra("timHome", element);

			//	Notify	the	adapter,	that	the	data	has	changed	so	it	can
			//	update	the	RecyclerView	to	display	the	data.
			mAdapter.notifyDataSetChanged();
		}
	}
}
