/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class Authentication {

    public boolean login(String user, String pass) throws IOException {
//EFFECTS: CHECKS IF LOG IN EXISTS AND IS CORRECT OR NOT
        //REQUIRES: FOR EXITING LOOP, REQUIRES CORRECT USER AND PASS, REQUIRES FILE STORING INFORMATION
        boolean r = false;
        String hold;
        try {
            BufferedReader br = new BufferedReader(new FileReader("./logindata.txt"));
            try {
                while ((hold = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(hold);
                    if (user.equals(st.nextElement())) {
                        if (pass.equals(st.nextElement())) {
                            System.out.println("YOU logged in : " + user);
                            r = true;
                            break;
                        } else {
                            System.out.println("password was wrong for " + user);
                            r = false;
                        }
                    } else {
                        r = false;
                    }
                }
            } catch (NullPointerException ef) {

            }
        } catch (IOException ex) {

        }
        return r;
    }

    public Authentication() {
        File file = new File("./logindata.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(file.getAbsoluteFile()); // COMMA TRUE TO APPEND MANAGER LOG IN DETAILS
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("test1");
            bw.write(" test2");
            bw.newLine();
            bw.write("test2");
            bw.write(" test3");
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}