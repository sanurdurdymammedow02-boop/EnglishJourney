package com.englishjourney.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.BLACK);
        getWindow().setNavigationBarColor(Color.BLACK);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(28, 32, 28, 32);
        layout.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("ENGLISH JOURNEY");
        title.setTextSize(28);
        title.setTextColor(Color.BLACK);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView subtitle = new TextView(this);
        subtitle.setText("Your English. Your future.");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);

        layout.addView(title);
        layout.addView(subtitle);

        addSpace(30);
        addLevelButton("A1 — Beginner");
        addLevelButton("A2 — Elementary");
        addLevelButton("B1 — Intermediate");
        addLevelButton("B2 — Upper Intermediate");

        Button lessonButton = new Button(this);
        lessonButton.setText("START LESSON");
        lessonButton.setTextColor(Color.WHITE);
        lessonButton.setBackgroundColor(Color.rgb(255, 140, 0));

        lessonButton.setOnClickListener(v ->
            showLesson()
        );

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.setMargins(0, 24, 0, 0);
        layout.addView(lessonButton, params);

        setContentView(layout);
    }

    private void addSpace(int height) {
        View space = new View(this);
        layout.addView(space,
            new LinearLayout.LayoutParams(1, height));
    }

    private void addLevelButton(String level) {
        Button button = new Button(this);
        button.setText(level);
        button.setTextColor(Color.BLACK);
        button.setBackgroundColor(
            Color.rgb(245, 245, 245)
        );

        button.setOnClickListener(v ->
            Toast.makeText(
                this,
                "Selected: " + level,
                Toast.LENGTH_SHORT
            ).show()
        );

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            );

        params.setMargins(0, 6, 0, 6);
        layout.addView(button, params);
    }

    private void showLesson() {
        setContentView(createLessonScreen());
    }

    private View createLessonScreen() {
        LinearLayout lesson = new LinearLayout(this);
        lesson.setOrientation(LinearLayout.VERTICAL);
        lesson.setGravity(Gravity.CENTER);
        lesson.setPadding(24, 24, 24, 24);
        lesson.setBackgroundColor(Color.WHITE);

        TextView heading = new TextView(this);
        heading.setText("Lesson 1 — To be");
        heading.setTextSize(26);
        heading.setTypeface(null, Typeface.BOLD);
        heading.setTextColor(Color.BLACK);

        TextView question = new TextView(this);
        question.setText(
            "Translate into English:\n\nЯ студент."
        );
        question.setTextSize(20);
        question.setTextColor(Color.DKGRAY);
        question.setGravity(Gravity.CENTER);

        android.widget.EditText answer =
            new android.widget.EditText(this);
        answer.setHint("Your answer");
        answer.setSingleLine(true);

        Button check = new Button(this);
        check.setText("CHECK ANSWER");
        check.setBackgroundColor(
            Color.rgb(255, 140, 0)
        );
        check.setTextColor(Color.WHITE);

        check.setOnClickListener(v -> {
            String text = answer.getText()
                .toString().trim();

            if (text.equalsIgnoreCase("I am a student")
                    || text.equalsIgnoreCase("I'm a student")) {
                Toast.makeText(
                    this,
                    "Correct! Отлично!",
                    Toast.LENGTH_LONG
                ).show();
            } else {
                Toast.makeText(
                    this,
                    "Try again: I am a student.",
                    Toast.LENGTH_LONG
                ).show();
            }
        });

        Button back = new Button(this);
        back.setText("BACK TO HOME");
        back.setOnClickListener(v -> onCreate(null));

        lesson.addView(heading);
        lesson.addView(question);
        lesson.addView(answer);
        lesson.addView(check);
        lesson.addView(back);

        return lesson;
    }
          }
