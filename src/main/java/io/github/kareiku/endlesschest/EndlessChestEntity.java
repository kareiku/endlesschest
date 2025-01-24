package io.github.kareiku.endlesschest;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class EndlessChestEntity extends ChestBlockEntity {
    public EndlessChestEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.CHEST, pos, state);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.endlesschestmod.endless_chest");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory) {
        return new ChestMenu(MenuType.GENERIC_9x4, id, inventory, this, 4);
    }
}
