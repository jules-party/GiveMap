package zoink.jule.givemap.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import zoink.jule.givemap.GiveMap;

import java.util.Arrays;
import java.util.List;

import static zoink.jule.givemap.GiveMap.checkPermissions;
import static zoink.jule.givemap.GiveMap.sendMessage;

public class GMap implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender cmdSender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(cmdSender instanceof Player))
            return true;

        Player player = (Player)cmdSender;

        if(!checkPermissions(player)) return false;

        List<String> valid_args = Arrays.asList("map","frame");
        List<Material> items = Arrays.asList(Material.MAP, Material.ITEM_FRAME);

        if(!valid_args.contains(args[0])) return false;
        int amount;
        try {
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sendMessage(player, "<red>Amount must be a number!</red>");
            return false;
        }
        player.getInventory().addItem(new ItemStack(items.get(valid_args.indexOf(args[0])), amount));


        return true;
    }
}
