package com.example.forest.kidzphone;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private String numberDisplay;
    private Boolean isCalling;
    private Boolean contactsVisable;
    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                }
            }
        });


        final ArrayList<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Forest", "919-452-8196"));
        contacts.add(new Contact("Fran", "919-597-0772"));

        final ContactAdapter adapter = new ContactAdapter(this, contacts);
        // Attach the adapter to a ListView
        final ListView listView = (ListView) findViewById(R.id.contact_list_panel);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact item = adapter.getItemAtPosition(position);
                numberDisplay = item.getContactNumber();
                updateDisplay("");

            }
        });


        isCalling = false;
        contactsVisable = false;


        //Set OnClickListeners for each button
        Button zeroButton = (Button) findViewById(R.id.zero_button);
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("0");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("zero");
                } else {
                    ttsUnder20("zero");
                }

            }
        });


        Button oneButton = (Button) findViewById(R.id.one_button);
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("1");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("one");
                } else {
                    ttsUnder20("one");
                }
            }
        });
        Button twoButton = (Button) findViewById(R.id.two_button);
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("2");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("two");
                } else {
                    ttsUnder20("two");
                }
            }
        });
        Button threeButton = (Button) findViewById(R.id.three_button);
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("3");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("three");
                } else {
                    ttsUnder20("three");
                }
            }
        });
        Button fourButton = (Button) findViewById(R.id.four_button);
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("4");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("four");
                } else {
                    ttsUnder20("four");
                }
            }
        });
        Button fiveButton = (Button) findViewById(R.id.five_button);
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("5");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("five");
                } else {
                    ttsUnder20("five");
                }
            }
        });
        Button sixButton = (Button) findViewById(R.id.six_button);
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("6");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("six");
                } else {
                    ttsUnder20("six");
                }
            }
        });
        Button sevenButton = (Button) findViewById(R.id.seven_button);
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("7");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("seven");
                } else {
                    ttsUnder20("seven");
                }
            }
        });
        Button eightButton = (Button) findViewById(R.id.eight_button);
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("8");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("eight");
                } else {
                    ttsUnder20("eight");
                }
            }
        });
        Button nineButton = (Button) findViewById(R.id.nine_button);
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDisplay("9");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21("nine");
                } else {
                    ttsUnder20("nine");
                }
            }
        });

        //AUX BUTTONS

        Button clearButton = (Button) findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberDisplay = "";
                updateDisplay("");
            }
        });

        Button backSpaceButton = (Button) findViewById(R.id.back_button);
        backSpaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberDisplay.length() > 0) {
                    numberDisplay = numberDisplay.substring(0, numberDisplay.length() - 1);
                    updateDisplay("");
                } else {
                    updateDisplay("");
                }

            }
        });

        Button popContactView = (Button) findViewById(R.id.contact_button);
        popContactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout numberLayout = (LinearLayout) findViewById(R.id.number_buttons);
                ListView contactLayout = (ListView) findViewById(R.id.contact_list_panel);
                LinearLayout addContact = (LinearLayout) findViewById(R.id.add_Contact_button);
                LinearLayout callButton = (LinearLayout) findViewById(R.id.call_button);


                if (!contactsVisable) {
                    numberLayout.setVisibility(View.GONE);
                    contactLayout.setVisibility(View.VISIBLE);
                    addContact.setVisibility(View.VISIBLE);
                    callButton.setVisibility(View.GONE);


                    contactsVisable = true;
                } else {
                    numberLayout.setVisibility(View.VISIBLE);
                    contactLayout.setVisibility(View.GONE);
                    addContact.setVisibility(View.GONE);
                    callButton.setVisibility(View.VISIBLE);
                    contactsVisable = false;
                }


            }
        });

        Button popDialView = (Button) findViewById(R.id.dial_button);
        popDialView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout numberLayout = (LinearLayout) findViewById(R.id.number_buttons);
                ListView contactLayout = (ListView) findViewById(R.id.contact_list_panel);
                LinearLayout addContact = (LinearLayout) findViewById(R.id.add_Contact_button);
                LinearLayout callButton = (LinearLayout) findViewById(R.id.call_button);
                numberLayout.setVisibility(View.VISIBLE);
                contactLayout.setVisibility(View.GONE);
                addContact.setVisibility(View.GONE);
                callButton.setVisibility(View.VISIBLE);
                contactsVisable = false;

            }
        });

        //ADD CONTACT BUTTON


        final LinearLayout addContact = (LinearLayout) findViewById(R.id.add_Contact_button);
        final LinearLayout numberScreen = (LinearLayout) findViewById(R.id.number_screen);
        final LinearLayout addContactScreen = (LinearLayout) findViewById(R.id.add_contact_screen);
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact.setVisibility(View.VISIBLE);
                numberScreen.setVisibility(View.GONE);
                addContactScreen.setVisibility(View.VISIBLE);


            }
        });

        Button saveContactButton = (Button) findViewById(R.id.SAVE_NEW_CONTACT_BUTTON);
        final EditText nameInputText = (EditText) findViewById(R.id.name_text_input);
        final EditText numberInputText = (EditText) findViewById(R.id.number_text_input);
        saveContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newContactName = nameInputText.getText().toString();
                String newContactNumber = numberInputText.getText().toString();
                Contact contact = new Contact(newContactName, newContactNumber);
                contacts.add(contact);
                addContactScreen.setVisibility(View.GONE);
                numberScreen.setVisibility(View.VISIBLE);
                nameInputText.getText().clear();
                numberInputText.getText().clear();
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        //CALL and END BUTTONS

        final LinearLayout callButton = (LinearLayout) findViewById(R.id.call_button);
        final TextView callText = (TextView) findViewById(R.id.calling_text);
        callButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              if (!isCalling) {
                                                  callButton.setBackgroundColor(Color.RED);
                                                  callText.setText("HANG UP");
                                                  isCalling = true;

                                              } else {
                                                  callButton.setBackgroundColor(Color.GREEN);
                                                  isCalling = false;
                                                  callText.setText("CALL");
                                              }


                                          }
                                      }
        );


    }

    public void updateDisplay(String number) {
        if (numberDisplay == null || numberDisplay == "") {
            numberDisplay = number;
        } else {
            numberDisplay = numberDisplay + number;
        }
        TextView numDisplay = (TextView) findViewById(R.id.number_display);

        numDisplay.setText(numberDisplay);
    }

    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId = this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }


}








