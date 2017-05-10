/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eao;

import com.mycompany.entity.BackgroundCheck;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AnaCris
 */
@Local
public interface IBackgroundCheckManagerLocal {
    
    void create(BackgroundCheck backgroundCheck);

    void edit(BackgroundCheck backgroundCheck);

    void remove(BackgroundCheck backgroundCheck);

    List<BackgroundCheck> findRange(int[] range);

    int count();
    
    List<BackgroundCheck> findAllBackgroundChecks();
    
    BackgroundCheck findById(Integer id);
    
    BackgroundCheck findByStatus(String status);
    
    
    
    
    
}
