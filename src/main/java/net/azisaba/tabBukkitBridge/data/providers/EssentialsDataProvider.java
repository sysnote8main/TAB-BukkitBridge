package net.azisaba.tabBukkitBridge.data.providers;

import com.earth2me.essentials.Essentials;
import net.azisaba.tabBukkitBridge.data.DataKey;
import net.azisaba.tabBukkitBridge.data.Skip;
import net.azisaba.tabBukkitBridge.util.Util;
import org.bukkit.Bukkit;

public class EssentialsDataProvider {
    public static void register() {
        DataKey.ESSENTIALS_VANISHED.register(Util.isPluginEnabledPredicate("Essentials"), Util.nonNullMapper(p -> {
            Essentials essentials = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
            if (essentials == null) throw Skip.SKIP;
            return essentials.getUser(p).isVanished();
        }), DataKey.VANISHED);
        DataKey.ESSENTIALS_AFK.register(Util.isPluginEnabledPredicate("Essentials"), Util.nonNullMapper(p -> {
            Essentials essentials = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
            if (essentials == null) throw Skip.SKIP;
            return essentials.getUser(p).isAfk();
        }), DataKey.AFK);
    }
}
