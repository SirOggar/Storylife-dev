package fr.siroggar.storylife.init;

import fr.siroggar.storylife.StoryLife;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;
import fr.siroggar.storylife.world.inventory.GuiwalletMenu;
import net.minecraftforge.registries.RegistryObject;

public class StoryLifeGuis {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, StoryLife.MOD_ID);
	public static final RegistryObject<MenuType<GuiwalletMenu>> GUIWALLET = REGISTRY.register("guiwallet", () -> IForgeMenuType.create(GuiwalletMenu::new));
}