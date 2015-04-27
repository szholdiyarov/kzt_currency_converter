package com.zholdiyarov.convertyourtenge.framents;

/**
 * Created by szholdiyarov on 4/21/15.
 */

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.zholdiyarov.convertyourtenge.R;


public class CalculatorFragment extends Fragment {

    private Button one, two, three, four, five, six, seven, eight, nine, zero, dot, rateTo, clear;
    private EditText et, et_from2, et_from1, et_to2;
    private TextView textViewResult, textViewResult2;
    View calc;
    private int currentRate;

    public int getCurrentRate() {
        return currentRate;
    }

    private void setCurrentRate(int pos) {
        currentRate = pos;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        calc = inflater.inflate(R.layout.fragment_calculator, container, false);

        /* Declaring variables */
        et = (EditText) calc.findViewById(R.id.editText2);
        et_from2 = (EditText) calc.findViewById(R.id.editText_from2);
        et_to2 = (EditText) calc.findViewById(R.id.editText_to);
        et_from1 = (EditText) calc.findViewById(R.id.editText_from1);
        textViewResult = (TextView) calc.findViewById(R.id.result);
        textViewResult2 = (TextView) calc.findViewById(R.id.result_2);
        et_to2.setKeyListener(null);
        et_from2.setKeyListener(null);
        et_from1.setKeyListener(null);

        one = (Button) calc.findViewById(R.id.one);
        two = (Button) calc.findViewById(R.id.two);
        three = (Button) calc.findViewById(R.id.three);
        four = (Button) calc.findViewById(R.id.four);
        five = (Button) calc.findViewById(R.id.five);
        six = (Button) calc.findViewById(R.id.six);
        seven = (Button) calc.findViewById(R.id.seven);
        eight = (Button) calc.findViewById(R.id.eight);
        nine = (Button) calc.findViewById(R.id.nine);
        zero = (Button) calc.findViewById(R.id.zero);
        dot = (Button) calc.findViewById(R.id.dot);
        rateTo = (Button) calc.findViewById(R.id.to_1);
        clear = (Button) calc.findViewById(R.id.clear);

        /* Call async task */
        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();
        return calc;
    }

    private class MyAsyncTask extends AsyncTask<String, Void, Void> {
        MainFragments main = new MainFragments();
        private final Dialog dialog = new Dialog(getActivity());
        private Button b1;
        private NumberPicker np;


        @Override
        protected Void doInBackground(String... params) {
            dialog.setTitle("Number Picker");
            dialog.setContentView(R.layout.dialog);
            et_from2.setText("USD");
            one.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("1");
                    doIt();
                }
            });

            two.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("2");
                    doIt();
                }
            });

            three.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("3");
                    doIt();
                }
            });

            four.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("5");
                    doIt();
                }
            });

            five.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("5");
                    doIt();
                }
            });

            six.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("6");
                    doIt();
                }
            });

            seven.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("7");
                    doIt();
                }
            });

            eight.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("8");
                    doIt();
                }
            });

            nine.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("9");
                    doIt();
                }
            });

            zero.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append("0");
                    doIt();
                }
            });

            dot.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    et.append(".");
                    doIt();
                }
            });
            rateTo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    b1 = (Button) dialog.findViewById(R.id.button1);
                    np = (NumberPicker) dialog.findViewById(R.id.numberPicker1);
                    np.setMaxValue(MainFragments.getItemName().length - 1); // max value 100
                    np.setMinValue(0);   // min value 0
                    np.setDisplayedValues(MainFragments.getItemName());
                    np.setWrapSelectorWheel(false);
                    dialog.show();

                    b1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            if (Integer.toString(np.getValue()).equals("0")) {
                                rateTo.setText("USD");
                                et_from2.setText("USD");
                                setCurrentRate(0);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("1")) {
                                rateTo.setText("EURO");
                                et_from2.setText("EUR");
                                setCurrentRate(1);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("2")) {
                                rateTo.setText("RUB");
                                et_from2.setText("RUB");
                                setCurrentRate(2);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("3")) {
                                rateTo.setText("GBP");
                                et_from2.setText("GBP");
                                setCurrentRate(3);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("4")) {
                                rateTo.setText("CNY");
                                et_from2.setText("CNY");
                                setCurrentRate(4);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("5")) {
                                rateTo.setText("AED");
                                et_from2.setText("AED");
                                setCurrentRate(5);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("6")) {
                                rateTo.setText("KGS");
                                et_from2.setText("KGS");
                                setCurrentRate(6);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("7")) {
                                rateTo.setText("UZS");
                                et_from2.setText("UZS");
                                setCurrentRate(7);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("8")) {
                                rateTo.setText("UAH");
                                et_from2.setText("UAH");
                                setCurrentRate(8);
                                doIt();
                            } else if (Integer.toString(np.getValue()).equals("9")) {
                                rateTo.setText("AUD");
                                et_from2.setText("AUD");
                                setCurrentRate(9);
                                doIt();
                            }
                            dialog.cancel();
                        }
                    });
                }
            });

            clear.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    int length = et.getText().length();
                    if (length > 0) {
                        et.getText().delete(length - 1, length);
                        doIt();
                    }
                }
            });
            return null;
        }

        private void doIt() {
            if (et.getText().toString().isEmpty()) {
                return;
            } else {
                calculate(getCurrentRate());
            }
        }

        public void calculate(int position) {
            double numbers = Double.parseDouble(et.getText().toString());
            double result, result2;
            result = numbers / Double.parseDouble(main.getElem(position));
            result2 = numbers * Double.parseDouble(main.getElem(position));
            String resultToPrint = String.format("%.2f", result);
            String resultToPrint2 = String.format("%.2f", result2);
            textViewResult.setText(resultToPrint);
            textViewResult2.setText(resultToPrint2);
        }
    }
}