package io.github.kareiku.endlesschest;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(EndlessChestCore.MOD_ID)
public class EndlessChestCore {
    public static final String MOD_ID = "endlesschest";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            MOD_ID
    );

    public static final DeferredBlock<Block> ENDLESS_CHEST_BLOCK = BLOCKS.registerSimpleBlock(
            "endless_chest",
            BlockBehaviour.Properties.of()
                    .destroyTime(2.5f)
                    .explosionResistance(3600000)
                    .mapColor(MapColor.COLOR_PURPLE)
                    .sound(SoundType.WOOD)
    );

    public static final DeferredItem<BlockItem> ENDLESS_CHEST_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(
            "endless_chest",
            ENDLESS_CHEST_BLOCK
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ENDLESS_CHEST_TAB = CREATIVE_MODE_TABS.register(
            "endless_chest_tab",
            () -> CreativeModeTab.builder()
                    .displayItems((parameters, output) -> output.accept(ENDLESS_CHEST_BLOCK_ITEM.get()))
                    .icon(() -> ENDLESS_CHEST_BLOCK_ITEM.get().getDefaultInstance())
                    .title(Component.translatable("itemGroup." + MOD_ID))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .build()
    );

    public EndlessChestCore(IEventBus modEventBus, ModContainer modContainer) {
        BLOCKS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
