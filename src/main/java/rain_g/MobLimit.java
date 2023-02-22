import org.bukkit.plugin.java.JavaPlugin;

public class MobLimit extends JavaPlugin {
    
    @Override
    public void onEnable() {
        saveDefaultConfig();
        
        int maxMobsPerChunk = getConfig().getInt("max_mobs_per_chunk");
        getLogger().info("Max mobs per chunk: " + maxMobsPerChunk);

        MobLimitListener mobLimitListener = new MobLimitListener(maxMobsPerChunk);
        getServer().getPluginManager().registerEvents(mobLimitListener, this);
    }
    
}
