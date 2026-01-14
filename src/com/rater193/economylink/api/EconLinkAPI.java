import java.util.HashMap;
import java.util.Map;

public class EconLinkAPI {
    private final Map<String, Float> economy = new HashMap<>();

    public EconLinkAPI() { }

    public void AddWallet(String walletName) {
        if(GetWallet(walletName) == null) {
            return;
        }

        economy.put(walletName, 0.0f);
    }

    public Float GetWallet(String walletName) {
        return economy.get(walletName);
    }

    public void RemoveWallet(String walletName) {
        economy.remove(walletName);
    }

    public Map<String, Float> ListWallets() {
        return economy;
    }

    public void TransferFunds(String fromWallet, String toWallet, double amount) {
        AddMoney(toWallet, amount);
        RemoveMoney(fromWallet, amount);
    }

    public void AddMoney(String walletName, double amount) {
        if(GetWallet(walletName) == null) {
            return;
        }

        Float currentBalance = GetWallet(walletName);
        economy.put(walletName, currentBalance + (float) amount);
    }

    public void RemoveMoney(String walletName, double amount) {
        if(GetWallet(walletName) == null) {
            return;
        }

        Float currentBalance = GetWallet(walletName);
        economy.put(walletName, currentBalance - (float) amount);
    }

    public void Save(String filepath) {
        
    }

    public void Load(String filepath) {

    }

    public Map<String, Float> getEconomy() {
        return economy;
    }
}