package fr.siroggar.storylife;

import com.mojang.logging.LogUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

import fr.siroggar.storylife.Items.StoryLifeItems;
import fr.siroggar.storylife.Items.StoryLifeCreativeModeTabs;
import fr.siroggar.storylife.init.StoryLifeGuis;
import fr.siroggar.storylife.client.gui.GuiwalletScreen;

@Mod(StoryLife.MOD_ID)
public class StoryLife {
    public static final String MOD_ID = "storylife";
    private static final Logger LOGGER = LogUtils.getLogger();

    public StoryLife() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        StoryLifeItems.register(bus);

        bus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        bus.addListener(this::addCreative);
        StoryLifeGuis.REGISTRY.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == StoryLifeCreativeModeTabs.Moneys) {
            event.accept(StoryLifeItems.wallet);
            event.accept(StoryLifeItems.credit_card);
            event.accept(StoryLifeItems.one_cent);
            event.accept(StoryLifeItems.two_cent);
            event.accept(StoryLifeItems.five_cent);
            event.accept(StoryLifeItems.ten_cent);
            event.accept(StoryLifeItems.twenty_cent);
            event.accept(StoryLifeItems.fifty_cent);
            event.accept(StoryLifeItems.one_euro);
            event.accept(StoryLifeItems.two_euro);
            event.accept(StoryLifeItems.five_euro);
            event.accept(StoryLifeItems.ten_euro);
            event.accept(StoryLifeItems.twenty_euro);
            event.accept(StoryLifeItems.fifty_euro);
            event.accept(StoryLifeItems.one_hundred_euro);
            event.accept(StoryLifeItems.two_hundred_euro);
            event.accept(StoryLifeItems.five_hundred_euro);
        }
        if (event.getTab() == StoryLifeCreativeModeTabs.Papers) {
            event.accept(StoryLifeItems.driver_license);
            event.accept(StoryLifeItems.agricultural_license);
            event.accept(StoryLifeItems.hunting_license);
            event.accept(StoryLifeItems.lumberjack_license);
            event.accept(StoryLifeItems.fishing_license);
            event.accept(StoryLifeItems.miner_license);
            event.accept(StoryLifeItems.gun_license);
            event.accept(StoryLifeItems.id_card);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class GuiwalletScreen {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MOD_ID, MOD_ID),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int messageID = 0;

    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder,
                                             Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue =
            new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry(action, tick));
    }
    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getKey().run());
            workQueue.removeAll(actions);
        }
    }
}