/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2ipc1.Swing.Damas.Users;

/**
 *
 * @author oliver
 */
public class ArrayUsers {
    
    private static int idAvailable=0;
    private Users[] list = new Users[20];
    
    
     private static int getIdAvailable(){
        return ArrayUsers.idAvailable++;
    }
     
     public void addUser(String name, String lastname){
         Users tmp = new Users(name, lastname, ArrayUsers.getIdAvailable());
         list[tmp.getId()] = tmp;
     }

    @Override
    public String toString() {
        String tmp = "";
        
        for(int i = 0; i < list.length ; i++){
            if (list[i]== null){
                break;
            }
            tmp = tmp + list[i].toString();
        }
        
        return tmp;
        
    }
    
    public Users getUser(int id){
        Users res = null;
        if (ArrayUsers.isValid(id)){
            return this.list[id];
        }
        
        return res;
    }
    
    public static boolean isValid(int id){
        return ((idAvailable>0)&&(id>=0)&&(id<idAvailable));
    }
    
    
}
