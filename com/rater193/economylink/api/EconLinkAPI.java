
package com.rater193.economylink.api;

import com.rater193.economylink.events.EconEventList;
import com.rater193.economylink.events.EconEvents;
import java.util.HashMap;
import java.util.Map;

public class EconLinkAPI {
    private final Map<String, Float> economy = new HashMap<>();

    public EconLinkAPI() { }

    public void AddWallet(String walletName) {
        if(GetWallet(walletName) != null) {
            return;
        }
        EconEvents.Get().InvokeEvent(EconEventList.OnWalletCreate);
        economy.put(walletName, 0.0f);
    }

    public Float GetWallet(String walletName) {
        return economy.get(walletName);
    }

    public void RemoveWallet(String walletName) {
        EconEvents.Get().InvokeEvent(EconEventList.OnWalletDelete);
        economy.remove(walletName);
    }

    public Map<String, Float> ListWallets() {
        return economy;
    }

    public void TransferFunds(String fromWallet, String toWallet, double amount) {
        EconEvents.Get().InvokeEvent(EconEventList.OnMoneyTransfer);
        AddMoney(toWallet, amount);
        RemoveMoney(fromWallet, amount);
    }

    public void AddMoney(String walletName, double amount) {
        EconEvents.Get().InvokeEvent(EconEventList.OnMoneyAdd);
        if(GetWallet(walletName) == null) {
            return;
        }

        Float currentBalance = GetWallet(walletName);
        economy.put(walletName, currentBalance + (float) amount);
    }

    public void RemoveMoney(String walletName, double amount) {
        EconEvents.Get().InvokeEvent(EconEventList.OnMoneyRemove);
        if(GetWallet(walletName) == null) {
            return;
        }

        Float currentBalance = GetWallet(walletName);
        economy.put(walletName, currentBalance - (float) amount);
    }

    public void Save(String filepath) {
        EconEvents.Get().InvokeEvent(EconEventList.OnEconomySave);
    }

    public void Load(String filepath) {
        EconEvents.Get().InvokeEvent(EconEventList.OnEconomyLoad);
    }

    public Map<String, Float> getEconomy() {
        return economy;
    }
}