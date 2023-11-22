
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class file {

    public static void writeFile(File file,ArrayList<int[]> data) throws FileNotFoundException{
        Formatter f = new Formatter(file);
        for (int[] is : data) {
            f.format("%d;%d\n", is[0], is[1]);
        }
        f.close();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //Create File
        File file = new File("src\\SettingVoucher.txt");

        ArrayList<int[]> diemTichLuy = new ArrayList<>();
        // file tồn tại -> đọc
        if (file.exists()){   
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()){
                String[] temp = sc.nextLine().split(";");
                diemTichLuy.add(new int[]{Integer.valueOf(temp[0]), Integer.valueOf(temp[1])});
            }
        }
        // file không tồn tại-> tạo
        else{
            Formatter createFile = new Formatter(file);
            //DATA TEMP
            ArrayList<int[]> data = new ArrayList<>();
            data.add(new int[]{1, 2});
            data.add(new int[]{1000, 3});
            data.add(new int[]{2000, 4});
            data.add(new int[]{3000, 5});
            
            
            writeFile(file, data);
            createFile.close();
        }

        for (int[] is : diemTichLuy) {
            System.out.println(is[0] + " " + is[1]);
        }
    }
    
    
}
