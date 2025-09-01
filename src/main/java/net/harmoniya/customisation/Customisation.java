package net.harmoniya.customisation;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Customisation.MODID)
public class Customisation {

	// Define mod id in a common place for everything to reference
	public static final String MODID = "customisation";
	public static final Logger LOGGER = LogUtils.getLogger();

	public Customisation() {}


}

