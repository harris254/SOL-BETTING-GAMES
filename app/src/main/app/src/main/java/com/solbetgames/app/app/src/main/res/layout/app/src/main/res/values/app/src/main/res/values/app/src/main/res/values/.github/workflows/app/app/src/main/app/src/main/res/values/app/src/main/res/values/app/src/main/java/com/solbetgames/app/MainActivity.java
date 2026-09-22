package com.solbetgames.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    int GOLD = Color.rgb(255, 193, 7);
    int BLACK = Color.rgb(7, 16, 22);
    int PANEL = Color.rgb(13, 27, 36);
    int WHITE = Color.WHITE;
    int MUTED = Color.rgb(154, 170, 181);
    int GREEN = Color.rgb(32, 201, 151);

    LinearLayout main;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setPadding(18, 12, 18, 12);
        return t;
    }

    GradientDrawable background(int color) {
        GradientDrawable g = new GradientDrawable();
        g.setColor(color);
        g.setCornerRadius(20);
        return g;
    }

    Button button(String value) {
        Button b = new Button(this);
        b.setText(value);
        b.setTextColor(Color.BLACK);
        b.setTextSize(14);
        b.setAllCaps(false);
        b.setBackground(background(GOLD));
        return b;
    }

    void setup(String title) {

        main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setBackgroundColor(BLACK);

        TextView header = text(title, 22, WHITE);
        header.setGravity(Gravity.CENTER_VERTICAL);
        header.setTypeface(null, 1);
        header.setPadding(20, 20, 20, 20);

        main.addView(
                header,
                new LinearLayout.LayoutParams(
                        -1,
                        70
                )
        );

        ScrollView scroll = new ScrollView(this);

        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(8, 8, 8, 20);

        scroll.addView(content);

        main.addView(
                scroll,
                new LinearLayout.LayoutParams(
                        -1,
                        0,
                        1
                )
        );

        LinearLayout nav = new LinearLayout(this);
        nav.setGravity(Gravity.CENTER);
        nav.setBackgroundColor(Color.rgb(5, 12, 17));

        addNav(nav, "HOME", new View.OnClickListener() {
            public void onClick(View v) {
                showHome();
            }
        });

        addNav(nav, "TIPS", new View.OnClickListener() {
            public void onClick(View v) {
                showTips();
            }
        });

        addNav(nav, "VIP", new View.OnClickListener() {
            public void onClick(View v) {
                showVip();
            }
        });

        addNav(nav, "GAMES", new View.OnClickListener() {
            public void onClick(View v) {
                showGames();
            }
        });

        addNav(nav, "RESULTS", new View.OnClickListener() {
            public void onClick(View v) {
                showResults();
            }
        });

        main.addView(
                nav,
                new LinearLayout.LayoutParams(
                        -1,
                        70
                )
        );

        setContentView(main);

        currentContent = content;
    }

    LinearLayout currentContent;

    void addNav(LinearLayout nav, String name, View.OnClickListener listener) {

        TextView item = text(name, 11, WHITE);
        item.setGravity(Gravity.CENTER);
        item.setOnClickListener(listener);

        nav.addView(
                item,
                new LinearLayout.LayoutParams(
                        0,
                        -1,
                        1
                )
        );
    }

    void addCard(String title, String details) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(16, 16, 16, 16);
        card.setBackground(background(PANEL));

        TextView a = text(title, 17, WHITE);
        a.setTypeface(null, 1);

        TextView b = text(details, 13, MUTED);

        card.addView(a);
        card.addView(b);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(-1, -2);

        p.setMargins(10, 8, 10, 8);

        currentContent.addView(card, p);
    }

    void showHome() {

        setup("SOL-BET GAMES");

        TextView welcome = text(
                "BET SMART • WIN BIG",
                25,
                WHITE
        );

        welcome.setTypeface(null, 1);

        currentContent.addView(welcome);

        currentContent.addView(
                text(
                        "Sports tips • VIP selections • Games coming soon",
                        14,
                        MUTED
                )
        );

        addCard(
                "⚽ NORMAL TIPS",
                "Free sports selections available to all users."
        );

        addCard(
                "👑 VIP TIPS",
                "Premium selections — KSh 1,000 for 30 days."
        );

        addCard(
                "🎮 GAMES",
                "Aviator, Crash, Slots and other games — Coming Soon."
        );

        addCard(
                "📊 RESULTS",
                "View published selections and their results."
        );
    }

    void showTips() {

        setup("NORMAL TIPS");

        currentContent.addView(
                text(
                        "Today's Sports Tips",
                        21,
                        WHITE
                )
        );

        addCard(
                "Man City vs Arsenal",
                "Premier League\nPrediction: 1X & Over 1.5\nOdds: 1.65"
        );

        addCard(
                "Real Madrid vs Barcelona",
                "La Liga\nPrediction: BTTS - Yes\nOdds: 1.72"
        );

        addCard(
                "Bayern Munich vs Dortmund",
                "Bundesliga\nPrediction: 1X & Over 1.5\nOdds: 1.70"
        );

        currentContent.addView(
                text(
                        "⚠ Betting involves risk. Tips are not guaranteed.",
                        12,
                        MUTED
                )
        );
    }

    void showVip() {

        setup("VIP TIPS");

        TextView title = text(
                "👑 VIP MEMBERS ONLY",
                23,
                GOLD
        );

        title.setTypeface(null, 1);

        currentContent.addView(title);

        currentContent.addView(
                text(
                        "Monthly subscription: KSh 1,000 / 30 days",
                        16,
                        WHITE
                )
        );

        TextView locked = text(
                "🔒 VIP CONTENT LOCKED\n\n" +
                "Subscribe for KSh 1,000 per month to access premium selections.\n\n" +
                "VIP access will automatically expire after the subscription period.",
                16,
                WHITE
        );

        currentContent.addView(locked);

        Button subscribe = button(
                "SUBSCRIBE — KSh 1,000 / MONTH"
        );

        subscribe.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        Toast.makeText(
                                MainActivity.this,
                                "Payment system will be connected later.",
                                Toast.LENGTH_LONG
                        ).show();

                    }
                }
        );

        currentContent.addView(
                subscribe,
                new LinearLayout.LayoutParams(
                        -1,
                        60
                )
        );
    }

    void showGames() {

        setup("GAMES");

        currentContent.addView(
                text(
                        "🎮 GAMES — COMING SOON",
                        23,
                        GOLD
                )
        );

        addCard(
                "✈ Aviator",
                "Coming Soon"
        );

        addCard(
                "🚀 Crash",
                "Coming Soon"
        );

        addCard(
                "🎰 Slots",
                "Coming Soon"
        );

        addCard(
                "🃏 Live Casino",
                "Coming Soon"
        );

        addCard(
                "🎲 Other Games",
                "More games can be added later."
        );
    }

    void showResults() {

        setup("RESULTS");

        currentContent.addView(
                text(
                        "📊 TIP RESULTS",
                        23,
                        WHITE
                )
        );

        addCard(
                "Man City vs Arsenal",
                "1X & Over 1.5 • Odds 1.65 • WON"
        );

        addCard(
                "Real Madrid vs Barcelona",
                "BTTS - Yes • Odds 1.72 • WON"
        );

        addCard(
                "AC Milan vs Inter",
                "Under 2.5 • Odds 1.60 • LOST"
        );

        currentContent.addView(
                text(
                        "Results should reflect all published selections.",
                        12,
                        MUTED
                )
        );
    }
          }
