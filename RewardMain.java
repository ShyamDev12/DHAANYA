package com.example.uzhavu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RewardMain extends AppCompatActivity implements OnScratchListener{

    // creat an obj of ArrayList to store cards and win amt
    private final List<CardsList> cardsLists = new ArrayList<>();
    private TextView coins;
    private RecyclerView cardsRecyclerView;

    private CardsAdapter cardsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_main);


        coins = findViewById(R.id.coins);
        cardsRecyclerView = findViewById(R.id.cardsRecyclerView);

        cardsRecyclerView.setHasFixedSize(true);

        MyConstants.onScratchListener = this;

        //setting GridLayoutManager to the recyclerview because we are showing cards in two columns like Google pay
        cardsRecyclerView.setLayoutManager(new GridLayoutManager(RewardMain.this,2));


        //adding some cards and win amt to the list
        //part 2 . from firebase database
        CardsList card1 = new CardsList("1",10,false);
        cardsLists.add(card1); // add 1st card to list

        CardsList card2 = new CardsList("1",10,false);
        cardsLists.add(card2); // add 1st card to list

        CardsList card3 = new CardsList("1",10,false);
        cardsLists.add(card3); // add 1st card to list

        CardsList card4 = new CardsList("1",10,false);
        cardsLists.add(card4); // add 1st card to list

        CardsList card5 = new CardsList("1",10,false);
        cardsLists.add(card5); // add 1st card to list

        CardsList card6 = new CardsList("1",10,false);
        cardsLists.add(card6); // add 1st card to list

        cardsAdapter = new CardsAdapter(cardsLists,RewardMain.this);
        cardsRecyclerView.setAdapter(cardsAdapter);
    }

    @Override
    public void onScratched(int scratchCardListPosition) {

        //set card status true
        cardsLists.get(scratchCardListPosition).setScratchStatus(true);
        cardsAdapter.updateData(cardsLists);

        MyConstants.userPoints = MyConstants.userPoints + cardsLists.get(scratchCardListPosition).getWinAmount();

        coins.setText(MyConstants.userPoints+"");
    }
}