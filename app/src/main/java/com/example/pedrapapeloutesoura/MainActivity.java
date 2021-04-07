package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectStone(View view){
        this.selectedOption("Stone");

    }

    public void selectScissors(View view){
        this.selectedOption("Scissors");
    }

    public void selectPaper(View view){
        this.selectedOption("Paper");

    }

    public void selectedOption(String selectOption){

        ImageView imageResult = findViewById(R.id.imageResult);
        TextView finalResult = findViewById(R.id.finalResult);

        int number = new Random().nextInt(3);
        String[] option = {"Stone", "Scissors", "Paper" };
        String appOptions = option [number];

        switch (appOptions){
            case "Stone":
                imageResult.setImageResource(R.drawable.pedra);
                break;
            case "Scissors":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
            case "Paper":
                imageResult.setImageResource(R.drawable.papel);
                break;
        }

        if (
        (appOptions == "Paper" && selectOption == "Stone")||
        (appOptions == "Stone" && selectOption == "Scissors")||
        (appOptions == "Scissors" && selectOption == "Paper")
        ){//App Winner
            finalResult.setText("Você perdeu !");

        }else if (
                (selectOption == "Paper" && appOptions == "Stone")||
                (selectOption == "Stone" && appOptions == "Scissors")||
                (selectOption == "Scissors" && appOptions == "Paper")
        ){//User Winner
            finalResult.setText("Você Ganhou !");
        }else{// Draw
            finalResult.setText("Empatou !");
        }

        System.out.println("item selecionado: "+ finalResult);
    }
}
