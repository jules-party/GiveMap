package zoink.jule.givemap;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import zoink.jule.givemap.Commands.GMap;
import zoink.jule.givemap.Utils.Completer;
import zoink.jule.givemap.Utils.Permissions;

import java.util.Objects;

public final class GiveMap extends JavaPlugin {
    public static final MiniMessage MM = MiniMessage.miniMessage();

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("givemap")).setExecutor(new GMap());
        Objects.requireNonNull(this.getCommand("givemap")).setTabCompleter(new Completer());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static boolean checkPermissions(Player player) {
        if (!player.hasPermission(Permissions.GIVEMAP.permission)) {
            sendMessage(player, "<red>You do not have permissions to execute this command!</red>");
            return false;
        } else {
            return true;
        }
    }

    public static void sendMessage(Player player,final String msg) {
        player.sendMessage(MM.deserialize(msg));
    }
}
