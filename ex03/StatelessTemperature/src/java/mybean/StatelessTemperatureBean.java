/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybean;

import javax.ejb.Stateless;

/**
 *
 * @author User
 */
@Stateless
public class StatelessTemperatureBean implements StatelessTemperatureBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public double fToC(double f) {
        double c = 0;
        c = (5.0 / 9.0) * (f - 32);
        return c;
    }

}
