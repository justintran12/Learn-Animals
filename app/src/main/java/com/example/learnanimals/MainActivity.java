package com.example.learnanimals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

/* Issues to fix:
     Cleaner/faster way to create animal objects? Possible to iterate through folder? (style)
     Make UI more appealing (UI)

   Ideas for additions:
     Add picture and more dialogue in display response activity
 */

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "animal_name";
    public static final String AMOUNT_CORRECT = "amount_correct";
    public static final int SET_LENGTH = 10;
    private int curr;
    private String curr_name;
    private int numCorrect;
    Animal[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String startMessage = intent.getStringExtra(MainMenuActivity.EXTRA_MESSAGE);
        if (startMessage.equals("easy")) {
            images = createEasySet();
        } else if (startMessage.equals("hard")) {
            images = createHardSet();
        } else {
            images = createEasySet();
        }
        curr = 0;
        numCorrect = 0;
        setImage();
    }

    public void skipButton(View v) {
        next();
    }


    /** Called when the user taps the Enter button */
    public void enterButton(View view) {
        Intent intent = new Intent(this, DisplayResponseActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        String response;
        if (message.equalsIgnoreCase(curr_name) || message.contains(curr_name)) {
            response = "Correct the answer is " + curr_name;
            numCorrect++;
        } else {
            response = "Wrong, the correct answer is " + curr_name;
        }
        intent.putExtra(EXTRA_MESSAGE, response);
        startActivity(intent);
        // delay for transition to next image
        new CountDownTimer(1000, 1000) {
            public void onFinish() {
                // When timer is finished
                // Execute your code here
                next();
            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        }.start();
    }

    private void setImage() {
        ImageView imgview = findViewById(R.id.imageView2);
        curr = curr % images.length;
        Animal currAnimal = images[curr];
        int curr_img = currAnimal.getImage();
        curr_name = currAnimal.getName();
        imgview.setImageResource(curr_img);
    }

    private void next() {
        curr++;
        if (curr <= SET_LENGTH - 1) {
            setImage();
        } else {
            Intent intent = new Intent(this, ActivityComplete.class);
            intent.putExtra(AMOUNT_CORRECT, numCorrect);
            startActivity(intent);
            finish();
        }
    }

    private Animal[] randomize(Animal[] images) {
        Random rand = new Random();
        Animal[] randImages = new Animal[SET_LENGTH];
        ArrayList<Integer> known = new ArrayList<>();
        int rand_int = rand.nextInt(images.length);
        for (int i = 0; i < SET_LENGTH; i++) {
            known.add(rand_int);
            randImages[i] = images[rand_int];
            // get a new random number not used before
            while (known.contains(rand_int)) {
                rand_int = rand.nextInt(images.length);
            }
        }
        return randImages;
    }

    private Animal[] createEasySet() {
        Animal dog = new Animal(R.drawable.dog, "dog");
        Animal dolphin = new Animal(R.drawable.dolphin, "dolphin");
        Animal bear = new Animal(R.drawable.bear, "bear");
        Animal cat = new Animal(R.drawable.cat, "cat");
        Animal elephant = new Animal(R.drawable.elephant, "elephant");
        Animal lion = new Animal(R.drawable.lion, "lion");
        Animal monkey = new Animal(R.drawable.monkey, "monkey");
        Animal rabbit = new Animal(R.drawable.rabbit, "rabbit");
        Animal sheep = new Animal(R.drawable.sheep, "sheep");
        Animal wolf = new Animal(R.drawable.wolf, "wolf");
        Animal horse = new Animal(R.drawable.horse, "horse");
        Animal chicken = new Animal(R.drawable.chicken, "chicken");
        Animal cow = new Animal(R.drawable.cow, "cow");
        Animal crocodile = new Animal(R.drawable.crocodile, "crocodile");
        Animal deer = new Animal(R.drawable.deer, "deer");
        Animal eagle = new Animal(R.drawable.eagle, "eagle");
        Animal fox = new Animal(R.drawable.fox, "fox");
        Animal frog = new Animal(R.drawable.frog, "frog");
        Animal goose = new Animal(R.drawable.goose, "goose");
        Animal mouse = new Animal(R.drawable.mouse, "mouse");
        Animal owl = new Animal(R.drawable.owl, "owl");
        Animal parrot = new Animal(R.drawable.parrot, "parrot");
        Animal penguin = new Animal(R.drawable.penguin, "penguin");
        Animal pig = new Animal(R.drawable.pig, "pig");
        Animal raccoon = new Animal(R.drawable.raccoon, "raccoon");
        Animal shark = new Animal(R.drawable.shark, "shark");
        Animal skunk = new Animal(R.drawable.skunk, "skunk");
        Animal snake = new Animal(R.drawable.snake, "snake");
        Animal tiger = new Animal(R.drawable.tiger, "tiger");
        Animal whale = new Animal(R.drawable.whale, "whale");
        Animal zebra = new Animal(R.drawable.zebra, "zebra");
        Animal[] images = {dog, dolphin, bear, cat, elephant, lion, monkey, rabbit, sheep, wolf,
                horse, chicken, cow, crocodile, deer, eagle, fox, frog, goose, mouse, owl,
                parrot, penguin, pig, raccoon, shark, skunk, snake, tiger, whale, zebra};
        return randomize(images);

    }

    private Animal[] createHardSet() {
        Animal armadillo = new Animal(R.drawable.armadillo, "armadillo");
        Animal beaver = new Animal(R.drawable.beaver, "beaver");
        Animal cheetah = new Animal(R.drawable.cheetah, "cheetah");
        Animal kangaroo = new Animal(R.drawable.kangaroo, "kangaroo");
        Animal koala = new Animal(R.drawable.koala, "koala");
        Animal otter = new Animal(R.drawable.otter, "otter");
        Animal panda = new Animal(R.drawable.panda, "panda");
        Animal reindeer = new Animal(R.drawable.reindeer, "reindeer");
        Animal rhinoceros = new Animal(R.drawable.rhinoceros, "rhinoceros");
        Animal squirrel = new Animal(R.drawable.squirrel, "squirrel");
        Animal chameleon = new Animal(R.drawable.chameleon, "chameleon");
        Animal chimpanzee = new Animal(R.drawable.chimpanzee, "chimpanzee");
        Animal flamingo = new Animal(R.drawable.flamingo, "flamingo");
        Animal gorilla = new Animal(R.drawable.gorilla, "gorilla");
        Animal hippopotamus = new Animal(R.drawable.hippopotamus, "hippopotamus");
        Animal ibex = new Animal(R.drawable.ibex, "ibex");
        Animal manatee = new Animal(R.drawable.manatee, "manatee");
        Animal narwhal = new Animal(R.drawable.narwhal, "narwhal");
        Animal orangutan = new Animal(R.drawable.orangutan, "orangutan");
        Animal platypus = new Animal(R.drawable.platypus, "platypus");
        Animal[] images = {armadillo, beaver, cheetah, kangaroo, koala, otter, panda, reindeer,
            rhinoceros, squirrel, chameleon, chimpanzee, flamingo, gorilla, hippopotamus,
            ibex, manatee, narwhal, orangutan, platypus};
        return randomize(images);

    }

    /*
    Archive:
        Put Next button on display response activity instead of main (main still has skip button)
        Returned to main menu after finishing round
        Displayed total amount the user got correct (after finishing the round)
        ignored spaces and tabs in input (functionality)
        Randomized images to be shown each round (requires adding a lot more images)
        Added main menu with easy and hard option
        Added hard set of images
        Put animal object creations in separate function (style)
    */





}