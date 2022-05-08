/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import File.StudentFile;
import File.VaccineFile;
/**
 *
 * @author ACER
 */
public class Test {
/*
   #################################################################
#                             _`				#
#                          _ooOoo_				#
#                         o8888888o				#
#                         88" . "88				#
#                         (| -_- |)				#
#                         O\  =  /O				#
#                      ____/`---'\____				#
#                    .'  \\|     |//  `.			#
#                   /  \\|||  :  |||//  \			#
#                  /  _||||| -:- |||||_  \			#
#                  |   | \\\  -  /'| |   |			#
#                  | \_|  `\`---'//  |_/ |			#
#                  \  .-\__ `-. -'__/-.  /			#
#                ___`. .'  /--.--\  `. .'___			#
#             ."" '<  `.___\_<|>_/___.' _> \"".			#
#            | | :  `- \`. ;`. _/; .'/ /  .' ; |		#
#            \  \ `-.   \_\_`. _.'_/_/  -' _.' /		#
#=============`-.`___`-.__\ \___  /__.-'_.'_.-'=================#
                           `=--=-'                    

// Nam mô a di dà Phật, source code này chạy không bao giờ có bug // 

          _.-/`)
         // / / )
      .=// / / / )
     //`/ / / / /
    // /     ` /
   ||         /
    \\       /
     ))    .'
    //    /
         /
    
    */
    public static void main(String[] args) {
        StudentFile stu = new StudentFile();
        VaccineFile vc = new VaccineFile();
        stu.writeStudent();
        vc.writeVaccine();
        Injection_List list = new InjectionList(stu,vc);
        int choice;
        do {
            System.out.println("//=======MENU=======\\");
            System.out.println("0.Create Data!!");
            System.out.println("1.show");
            System.out.println("2. Add ");
            System.out.println("3. Update");
            System.out.println("4. delete");
            System.out.println("5. search");
            System.out.println("6. Store ");
            System.out.println("7.Quit!");
            choice = Utils.getInt("Input Your Choice: ", "TRY AGAIN!");
            switch (choice) {
                case 0:
                    list.createdata();
                    break;
                case 1:
                    list.show();
                    break;
                case 2:
                    list.add();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.delete();
                    break;
                case 5:
                    list.searchByStuID();
                    break;
                case 6: 
                    list.storeData();
                    break;
                case 7: 
                    System.out.println("THANKS FOR USING!");
                    break;
                default:
                    System.out.println("WRONG INPUT!");
                    break;
            }
        } while (choice != 7);
    }
        
    }
