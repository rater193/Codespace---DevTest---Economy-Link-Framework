
package com.rater193;

import com.rater193.economylink.EconLink;
import com.rater193.economylink.api.EconLinkAPI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        EconLink.Init();
        EconLinkAPI api = new EconLinkAPI();
        api.AddWallet("Test");
        api.AddMoney("Test", 5);
        System.out.println("Wallet Balance: " + api.GetWallet("Test"));
        api.AddMoney("Test", 22);
        System.out.println("Wallet Balance: " + api.GetWallet("Test"));
        api.RemoveMoney("Test", 5);
        System.out.println("Wallet Balance: " + api.GetWallet("Test"));
    }
}