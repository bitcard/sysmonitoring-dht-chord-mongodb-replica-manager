/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unict.ing.pds.dhtdb.datamanager;

import javax.ejb.Local;

/**
 *
 * @author aleskandro
 */
@Local
public interface LightSessionBeanLocal {

    public int getTreeHeight();

    public void setTreeHeight(int treeHeight);
}