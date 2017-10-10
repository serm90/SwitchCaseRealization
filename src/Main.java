

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
            FileReader myFile = null;
            BufferedReader buff = null;
            try {
                myFile=new FileReader("C://Users//serg-qa//Downloads/com.txt");
                buff = new BufferedReader(myFile);


                while (true) {
                    //считывается строка из файла com.txt
                    String line = buff.readLine();
                    if (line == null) break;

                    String[] splitResult = line.split (",");

                    for (int i = 0; i < splitResult.length; i++)

                    {

                        switch (splitResult[i]){

                            //операция над цифрами
                            case "sum":
                                 double s = Double.parseDouble(splitResult[i+1]) + Double.parseDouble(splitResult[i+2]);
                                System.out.println("sum = " + s);
                                break;
                            case "min":
                                double m = Double.parseDouble(splitResult[i+1]) - Double.parseDouble(splitResult[i+2]);
                                System.out.println("min = " + m);
                                break;
                            case "dub":
                                double d = Double.parseDouble(splitResult[i+1]) * Double.parseDouble(splitResult[i+2]);
                                System.out.println("dub = " + d);
                                break;
                            case "cut":
                                double c = Double.parseDouble(splitResult[i+1]) / Double.parseDouble(splitResult[i+2]);
                                System.out.println("cut = "+ c);
                                break;
                            case "squ":
                                double sq = Double.parseDouble(splitResult[i+1]) * Double.parseDouble(splitResult[i+1]);
                                System.out.println("squ = "+ sq);
                                break;

                            case "aba"://операция над строками
                                String a = splitResult[i+1].concat(" " + splitResult[i+2]);
                                System.out.println("aba = "+ a);
                                break;

                            case "obn"://опирация над файлами

                                File file1 = new File(splitResult[i+1]);
                                String string;
                                try {
                                    RandomAccessFile randomAccessFile = new RandomAccessFile(file1, "r");
                                    string = randomAccessFile.readLine();
                                    randomAccessFile.close();
                                    System.out.print(string);
                                } catch (FileNotFoundException ex) {}

                                File file2 = new File(splitResult[i+2]);
                                try {
                                    RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "r");
                                    string = randomAccessFile.readLine();
                                    randomAccessFile.close();
                                    System.out.print(string);
                                } catch (FileNotFoundException ex) {}

                                //Открываем 1-й файл для записи
                                BufferedOutputStream bufOut = new BufferedOutputStream(new FileOutputStream(file1, true)); // true - добавление в конец файла

                                //Открываем 2-й файл для считывания
                                BufferedInputStream bufRead = new BufferedInputStream(new FileInputStream(file2));
                                int n;
                                while((n = bufRead.read()) != -1) {
                                    bufOut.write(n);
                                }
                                bufOut.flush();      // Принудительно выталкиваем данные с буфера
                                bufOut.close();     // Закрываем соединения
                                bufRead.close();

                                System.out.println( "cut = " + "Данные с " + file1.getName() + " добавлены в " +file2.getName() );
                                break;

                            default:
                                if (splitResult[i]== null)

//                            case "splitResult[0]":

                                 System.out.println("команда не поддерживается ");

                               break;

                        }

                    }
//
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                try{
                    buff.close();
                    myFile.close();
                }
                catch(IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }

