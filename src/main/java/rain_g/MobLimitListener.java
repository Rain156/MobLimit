import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class MobLimitListener implements Listener {
    private int maxMobsPerChunk;
    
    public MobLimitListener(int maxMobsPerChunk) {
        this.maxMobsPerChunk = maxMobsPerChunk;
    }
    
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        Chunk chunk = event.getLocation().getChunk();

        int mobCount = 0;
        for (Entity entity : chunk.getEntities()) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                mobCount++;
            }
        }

        if (mobCount >= maxMobsPerChunk) {
            event.setCancelled(true);
        }
    }
}
