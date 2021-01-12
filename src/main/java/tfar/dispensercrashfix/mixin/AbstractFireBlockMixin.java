package tfar.dispensercrashfix.mixin;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
	@Inject(at = @At("HEAD"), method = "shouldLightPortal",cancellable = true)
	private static void init(World world, BlockPos pos, Direction directionIn, CallbackInfoReturnable<Boolean> cir) {
		if (directionIn == Direction.DOWN) {
			cir.setReturnValue(false);
		}
	}
}
