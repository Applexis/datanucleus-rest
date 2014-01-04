/**********************************************************************
Copyright (c) 2006 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.samples.jpa.tutorial;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cn.edu.sjtu.se.dclab.cloud.dataaccessor.entityservice.EntityDataService;
import cn.edu.sjtu.se.dclab.cloud.sample.warrantydemo.mysql.User;
import cn.edu.sjtu.se.dclab.cloud.sample.warrantydemo.mysql.Warranty;

/**
 * Controlling application for the DataNucleus Tutorial using JPA.
 * Uses the "persistence-unit" called "Tutorial".
 */
public class Main
{
    public static void main(String args[])
    {
    	EntityDataService eds = new EntityDataService();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("ProductSerial", "sdfsdfsdf");
    	map.put("user.id", 1);
    	eds.insertByMap("warranty", map);
    	/*
        // Perform a retrieve of the Inventory and detach it (by closing the EM)
        em = emf.createEntityManager();
        tx = em.getTransaction();
        Inventory inv = null;
        try
        {
            tx.begin();
            System.out.println("Executing find() on Inventory");
            inv = em.find(Inventory.class, "My Inventory");
            System.out.println("Retrieved Inventory as " + inv);

            // Access Products field so it is loaded before detach
            // Note that you could alternately make it EAGER fetch, or use DN fetch groups
            inv.getProducts();

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close(); // This will detach all current managed objects
        }
        for (Product prod : inv.getProducts())
        {
            System.out.println(">> After Detach : Inventory has a product=" + prod);
        }
        System.out.println("");

        // Perform some query operations
        em = emf.createEntityManager();
        tx = em.getTransaction();
        try
        {
            tx.begin();
            System.out.println("Executing Query for Products with price below 150.00");
            Query q = em.createQuery("SELECT p FROM Product p WHERE p.price < 150.00 ORDER BY p.price");
            List results = q.getResultList();
            Iterator iter = results.iterator();
            while (iter.hasNext())
            {
                Object obj = iter.next();
                System.out.println(">  " + obj);

                // Give an example of an update
                if (obj instanceof Book)
                {
                    Book b = (Book)obj;
                    b.setDescription(b.getDescription() + " REDUCED");
                }
            }

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }
        System.out.println(""); 

        // Clean out the database
        em = emf.createEntityManager();
        tx = em.getTransaction();
        try
        {
            tx.begin();

            System.out.println("Deleting all products from persistence");
            inv = (Inventory)em.find(Inventory.class, "My Inventory");

            System.out.println("Clearing out Inventory");
            inv.getProducts().clear();
            em.flush();

            System.out.println("Deleting Inventory");
            em.remove(inv);

            System.out.println("Deleting all products from persistence");
            Query q = em.createQuery("SELECT FROM Product p");
            List<Product> products = q.getResultList();
            int numDeleted = 0;
            for (Product prod : products)
            {
                em.remove(prod);
                numDeleted++;
            }
            System.out.println("Deleted " + numDeleted + " products");

            tx.commit();
        }
		catch (Exception e)
		{
            System.out.println("Bulk delete encountered an error " + e.getMessage());
	    }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }

        System.out.println("");
        System.out.println("End of Tutorial");*/
    }
}