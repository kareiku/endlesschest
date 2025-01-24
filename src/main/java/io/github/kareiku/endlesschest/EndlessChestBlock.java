package io.github.kareiku.endlesschest;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class EndlessChestBlock extends ChestBlock {
    private static final int CAPACITY = Integer.MAX_VALUE - 1;

    public EndlessChestBlock(Properties properties) {
        super(() -> BlockEntityType.CHEST, properties);
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return super.newBlockEntity(pos, state);
    }

    @Override
    protected void onRemove(@NotNull BlockState oldState, @NotNull Level level, @NotNull BlockPos pos, BlockState newState, boolean isMoving) {
        if (!oldState.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof Container container) {
                Containers.dropContents(level, pos, container);
            }
            super.onRemove(oldState, level, pos, newState, isMoving);
        }
    }
}
