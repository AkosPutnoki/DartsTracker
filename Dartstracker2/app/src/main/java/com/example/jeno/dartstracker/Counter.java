package com.example.jeno.dartstracker;

import android.widget.TextView;

public class Counter {

    private TextView counter;

    public Counter(TextView counter) {
        this.counter = counter;
    }

    public void incrementCounter(){
        int currentCount = Integer.parseInt(counter.getText().toString());
        counter.setText(String.valueOf(currentCount + 1));
    }

}
