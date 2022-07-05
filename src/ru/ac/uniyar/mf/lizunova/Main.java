package ru.ac.uniyar.mf.lizunova;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double num_1 = 0.0, num_2 = 0.0;
        double num_3 = 1.0, num_4 = 1.0;
        boolean done = false;
        Scanner in = new Scanner(System.in);
        String str = "";
        String[] parts = {};
        String[] fraction_1 = {};
        String[] fraction_2 = {};

        while(!done){
            try {
                System.out.println("Введите выражение в виде <число> <+,-,*,/> <число>: ");
                str = in.nextLine();
                parts = str.split(" ");

                if(parts.length == 3) {
                    if (parts[0].indexOf('/') != -1) {
                        fraction_1 = parts[0].split("/");
                        num_1 = Double.parseDouble(fraction_1[0]);
                        num_3 = Double.parseDouble(fraction_1[1]);
                        done = true;
                        if (num_3 == 0.0) {
                            done = false;
                            System.out.println("Вы пытаетесь делить на 0!");
                            continue;
                        }
                    } else {
                        num_1 = Double.parseDouble(parts[0]);
                        done = true;
                    }

                    if (parts[2].indexOf('/') != -1) {
                        fraction_2 = parts[2].split("/");
                        num_2 = Double.parseDouble(fraction_2[0]);
                        num_4 = Double.parseDouble(fraction_2[1]);
                        done = true;
                        if (num_4 == 0.0) {
                            done = false;
                            System.out.println("Вы пытаетесь делить на 0!");
                            continue;
                        }
                    } else {
                        num_2 = Double.parseDouble(parts[2]);
                        done = true;
                    }

                    if ((parts[0].indexOf('/') == -1) && (parts[2].indexOf('/') == -1)) {
                        num_1 = Double.parseDouble(parts[0]);
                        num_2 = Double.parseDouble(parts[2]);
                        done = true;
                    }

                    if (((num_1 == (int) num_1) && (num_2 == (int) num_2)) && ((num_3 == (int) num_3) && (num_4 == (int) num_4))) {
                        done = true;
                    } else {
                        done = false;
                        System.out.println("Вы ввели не целое число!");
                        continue;
                    }

                    if ((num_2 == 0.0) && ("/".equals(parts[1]))) {
                        done = false;
                        System.out.println("Вы пытаетесь делить на 0!");
                        continue;
                    }
                }
                else {
                    System.out.println("Неправильная форма записи выражения!");
                    done = false;
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число!");
                done = false;
                continue;
            }
        }

        double result = 0.0;
        if ((parts[0].indexOf('/') == -1) && (parts[2].indexOf('/') == -1)) {
            if ("+".equals(parts[1])) {
                result = num_1 + num_2;
            } else if ("-".equals(parts[1])) {
                result = num_1 - num_2;
            } else if ("*".equals(parts[1])) {
                result = num_1 * num_2;
            } else if ("/".equals(parts[1])) {
                result = num_1 / num_2;
            }

            if ("/".equals(parts[1])) {
                System.out.print(str + " = " + result);
            } else {
                System.out.print(str + " = " + (int) result);
            }
        }
        else {
            if ("+".equals(parts[1])) {
                if(num_3 != num_4){
                    result = num_1 * num_4 + num_2 * num_3;
                    if((int)(num_3 * num_4) != 1) {
                        System.out.print(str + " = " + (int)result + "/" + (int) (num_3 * num_4));
                    }
                    else {
                        System.out.print(str + " = " + (int)result);
                    }
                }
                else {
                    result = num_1 + num_2 ;
                    if((int)num_3 != 1) {
                        System.out.print(str + " = " + (int)result + "/" + (int)num_3);
                    }
                    else {
                        System.out.print(str + " = " + (int)result);
                    }
                }
            } else if ("-".equals(parts[1])) {
                if(num_3 != num_4){
                    result = num_1 * num_4 - num_2 * num_3;
                    System.out.print(str + " = " + (int)result + "/" + (int)(num_3 * num_4));
                }
                else {
                    result = num_1 - num_2 ;
                    if((int)num_3 != 1) {
                        System.out.print(str + " = " + (int)result + "/" + (int)num_3);
                    }
                    else {
                        System.out.print(str + " = " + (int)result);
                    }
                }
            } else if ("*".equals(parts[1])) {
                result = num_1 * num_2;
                if((int)(num_3 * num_4) != 1) {
                    System.out.print(str + " = " + (int)result + "/" + (int) (num_3 * num_4));
                }
                else {
                    System.out.print(str + " = " + (int)result);
                }
            } else if ("/".equals(parts[1])) {
                result = num_1 * num_4;
                if((int)(num_2 * num_3) != 1) {
                    System.out.print(str + " = " + (int)result + "/" + (int) (num_2 * num_3));
                }
                else {
                    System.out.print(str + " = " + (int)result);
                }
            }
        }
    }
}
