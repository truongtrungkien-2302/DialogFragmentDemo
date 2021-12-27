package com.android45.dialogfragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android45.dialogfragment.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    final String[] strings = {"Android", "Kotlin", "Flutter", "IOS"};
    //    final boolean[] booleans = {false, false, true, true};
    final boolean[] booleans = new boolean[strings.length];
    String selecSingletItems = null;

    boolean[] checkedItemsStrings = new boolean[strings.length];
    ArrayList<Integer> itemsStrings = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.tvName.setText("Truong Trung Kien");
        activityMainBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getBaseContext(), AddActivity.class);
//                startActivity(intent);
            }
        });

        activityMainBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_bottom, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return menuOnClicked(item);
                    }
                });
            }
        });

        //Show dialog
        activityMainBinding.btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getString(R.string.dialog_title))
                        .setMessage(getString(R.string.dialog_content))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        //Show singer

        activityMainBinding.btnDialogSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecSingletItems = strings[0];
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getString(R.string.dialog_title))
                        .setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
//                                Toast.makeText(getBaseContext(), strings[i], Toast.LENGTH_SHORT).show();
                                selecSingletItems = strings[i];
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Toast.makeText(getBaseContext(), selecSingletItems, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        //Show Dialog Multi

        activityMainBinding.btnDialogMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getString(R.string.dialog_title))
                        .setMultiChoiceItems(strings, checkedItemsStrings, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                                if (isChecked) {
                                    if (!itemsStrings.contains(position)) {
                                        itemsStrings.add(position);
                                    }
                                } else if (itemsStrings.contains(position)) {
                                    itemsStrings.remove(position);
                                }
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String item = "";
                                for (int i = 0; i < itemsStrings.size(); i++) {
                                    item += strings[itemsStrings.get(i)] + " ";
                                }
                                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog.show();

            }
        });
    }

    private boolean menuOnClicked(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.mnBottomShow:
                Toast.makeText(getBaseContext(), "Show", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnBottomAttack:
                Toast.makeText(getBaseContext(), "Attack", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnDone:
                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnCancel:
                Toast.makeText(getBaseContext(), "Cancel", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}