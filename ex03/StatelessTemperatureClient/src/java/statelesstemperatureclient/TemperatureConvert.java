package statelesstemperatureclient;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mybean.StatelessTemperatureBeanRemote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class TemperatureConvert {

    StatelessTemperatureBeanRemote temperatureBean = lookupStatelessTemperatureBeanRemote();

    public void fToC() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter degree in Fahrenheit: ");
        double f = sc.nextDouble();
        double c = temperatureBean.fToC(f);
        System.out.println(f+" Fahrenheit = "+c+" Celsius");
        sc.close();
    }

    private StatelessTemperatureBeanRemote lookupStatelessTemperatureBeanRemote() {
        try {
            Context c = new InitialContext();
            return (StatelessTemperatureBeanRemote) c.lookup("java:comp/env/StatelessTemperatureBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
