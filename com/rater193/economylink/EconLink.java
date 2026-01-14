
package com.rater193.economylink;

import com.rater193.economylink.events.EconEventList;
import com.rater193.economylink.events.EconEvents;

public class EconLink {
    public void EconLink() {}

    public void Init() {
        EconEvents events = new EconEvents();
        events.CreateEvent(EconEventList.OnWalletCreate);
        events.CreateEvent(EconEventList.OnWalletDelete);
        events.CreateEvent(EconEventList.OnMoneyAdd);
        events.CreateEvent(EconEventList.OnMoneyRemove);
        events.CreateEvent(EconEventList.OnMoneyTransfer);
        events.CreateEvent(EconEventList.OnEconomyLoad);
        events.CreateEvent(EconEventList.OnEconomySave);
    }
}