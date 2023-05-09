package fr.siroggar.storylife.Items;

import fr.siroggar.storylife.StoryLife;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StoryLife.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StoryLifeCreativeModeTabs
{
    public static CreativeModeTab Moneys;
    public static CreativeModeTab Papers;
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        Moneys = event.registerCreativeModeTab(new ResourceLocation(StoryLife.MOD_ID, "moneys_tab"),
                builder -> builder.icon(() -> new ItemStack(StoryLifeItems.wallet.get()))
                        .title(Component.translatable("creativemodetab.moneys_tab")));

        Papers = event.registerCreativeModeTab(new ResourceLocation(StoryLife.MOD_ID, "papers_tab"),
                builder -> builder.icon(() -> new ItemStack(StoryLifeItems.id_card.get()))
                        .title(Component.translatable("creativemodetab.papers_tab")));
    }
}