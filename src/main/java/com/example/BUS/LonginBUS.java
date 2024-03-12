package com.example.BUS;

import com.example.DAO.userdao;
import com.example.DTO.AccountDTO;

public class LonginBUS {
    public static boolean login(AccountDTO account){
        System.out.println(account.getPassword());
        System.out.println(account.getUsername());
        userdao.login(account);
        return false;
        
    }
    {}
}
