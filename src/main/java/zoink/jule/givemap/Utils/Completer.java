package zoink.jule.givemap.Utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import zoink.jule.givemap.GiveMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Completer implements TabCompleter {
    @Override
    public List<String> onTabComplete(@NotNull CommandSender cmdSender, @NotNull Command cmd, @NotNull String label, String[] args) {
        return Arrays.asList("map", "frame");
    }
}
